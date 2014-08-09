app.ajax = function(options_){
	
	if(!options_){
		options_ = {};
	}
	
	var params = app.montarParametrosUrl(options_.params);
	var urlCompleta = app.APP_PROPERTIES.CONTEXO + options_.url + (params ? '?' + params : '');
	
	options = {
		url : urlCompleta,
		type : options_.type ? options_.type : 'GET',
		formId : options_.formId ? options_.formId : '',
		beforeSend : options_.beforeSend ? options_.beforeSend : defaultBeforeSendFunction,
		success : options_.success ? options_.success : defaultSucessFunction,
		setId : options_.setId ? options_.setId : null,
		error : options_.error ? options_.error : defaultErrorFunction,
		complete : options_.complete ? options_.complete : defaultCompleteFunction,
		tipoSubmit : options_.tipoSubmit ? options_.tipoSubmit : app.SUBMIT_AJAX_SALVAR 
	};
	
	if(options.tipoSubmit == app.SUBMIT_AJAX_EXCLUIR){
		optionsDialog = {
				tipoDialog : app.DIALOG_INFO,
				mensagem : 'Deseja excluir os dados?',
				id : 'excluirDialog',
				buttons : {
					'Sim': function() {
						$( this ).dialog( "close" );
						enviar(options);
					},
			        Cancel: function() {
			        	$( this ).dialog( "close" );
			        }
				}
		}
		app.dialog(optionsDialog);
	}else{
		enviar(options);
	}
}

var enviar = function(options){
	$.ajax({
		url : options.url,
		dataType : 'json',
		type : options.type,
		contentType : 'application/json',
		cache : false,
		data: JSON.stringify($('#' + options.formId).serializeObject()),
		beforeSend : function(jqXHR, settings) {
			options.beforeSend(jqXHR, settings);
		},
		success : function(data, textStatus, jqXHR, setId) {
			options.success(data, textStatus, jqXHR, options.setId, options.tipoSubmit);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			options.error(jqXHR, textStatus, errorThrown);
		},
		complete : function(jqXHR, textStatus) {
			options.complete(jqXHR, textStatus);
		},
		converters: { "text json": function (json_string) {
	            if ( typeof json_string != 'string' || !$.trim(json_string).length ) {
	                return {};
	            } else {
	                return jQuery.parseJSON( json_string );
	            }
        	} 
		}
	});
}

$.fn.serializeObject = function() {
    var o = {};
    //var a = this.serializeArray();
    $(this).find('input[type="hidden"], input[type="text"], input[type="password"], input[type="checkbox"]:checked, input[type="radio"]:checked, select').each(function() {
    	if ($(this).attr('type') == 'hidden') { //if checkbox is checked do not take the hidden field
    		var $parent = $(this).parent();
    		var $chb = $parent.find('input[type="checkbox"][name="' + this.name.replace(/\[/g, '\[').replace(/\]/g, '\]') + '"]');
    		if ($chb != null) {
    			if ($chb.prop('checked')) return;
    		}
    	}
    	if (this.name === null || this.name === undefined || this.name === '') return;
    	var elemValue = null;
    	if ($(this).is('select')){
    		if($(this).prop('multiple')){
    			elemValue = $(this).val();
    		}else{
    			elemValue = $(this).find('option:selected').val();
    		}
    	}else{
    		elemValue = this.value;
    	}
    	if (o[this.name] !== undefined) {
    		if (!o[this.name].push) {
    			o[this.name] = [o[this.name]];
    		}
	    o[this.name].push(elemValue || '');
    	} else {
    		o[this.name] = elemValue || '';
    	}
    });
    return o;
}

var idInfoDialog = 'infoDialog';

var defaultBeforeSendFunction = function(jqXHR, settings){
	optionsDialog = {
			tipoDialog : app.DIALOG_INFO,
			mensagem : 'Aguarde...',
			id : idInfoDialog
	}
	app.dialog(optionsDialog);
	$('.errorblock').remove();
	//$("input").removeClass("error");
}

var defaultSucessFunction = function(data, textStatus, jqXHR, setId, tipoSubmit){
	
	optionsDialog = {
			tipoDialog : app.DIALOG_CHECK,
			mensagem : tipoSubmit == app.SUBMIT_AJAX_SALVAR ? 'Dados gravados com sucesso.' : 'Dados excluidos com sucesso',
			buttons : {
				Ok: function() {
					if(tipoSubmit == app.SUBMIT_AJAX_SALVAR){
						$( this ).dialog( "close" );
					}else{
						app.voltar();
					}
				}
			}
	}
	app.dialog(optionsDialog);
	
	if(setId){
		$("#id").val(data);
	}
}

var defaultErrorFunction = function(jqXHR, textStatus, errorThrown){
	if(isMensagemValidacao(jqXHR)){
		tratarMensagensValidacao(jqXHR);
	}else{
		optionsDialog = {
			tipoDialog : app.DIALOG_ERROR,
			mensagem : 'Erro no processamento da sua requisição. <br>Mensagem: ' + errorThrown,
			buttons : {
				Ok: function() {
			         $( this ).dialog( "close" )
				}
			}
		}
		app.dialog(optionsDialog);
	}
}

var defaultCompleteFunction = function(jqXHR, textStatus){
	app.closeDialog(idInfoDialog);
}

var isMensagemValidacao = function(jqXHR){
	return jqXHR.responseText.indexOf("fieldErrors") >= 0;
}

var tratarMensagensValidacao = function(jqXHR){
	var jsonErrors = jQuery.parseJSON(jqXHR.responseText);
	$.each(jsonErrors, function() {
		$.each(this, function(name, value) {
			 var campo = $("#"+value.field);
			 if(!value.field){
				 
				 optionsDialog = {
							tipoDialog : app.DIALOG_ERROR,
							mensagem : value.message,
							buttons : {
								Ok: function() {
							         $( this ).dialog( "close" )
								}
							}
					}
				 
				 app.dialog(optionsDialog);
			 }else if ($("#mensagemErro_"+value.field).length <= 0){
				 campo.parent().after('<span class="errorblock" id="mensagemErro_'+value.field+'">'+value.message+'</span>')
				 //campo.addClass("error");
			 }
			 
		});
	});
}