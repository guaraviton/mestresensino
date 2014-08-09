$(function() {
	$('#cep').mask('00000-000');
	$('#telefone').mask('(00) 00000-0000');
	$("#dataNascimento").datepicker({dateFormat: 'dd/mm/yy'});
	$('#dataNascimento').mask('00/00/0000');
	$( "button").button();
	$('#quantidadeHorasCompradas').mask('000');
	$('#quantidade').mask('000');
	
	if($("#id").val() == ''){
		$('#buttonInserirHoras').hide();
	}

	$("#buttonSalvar").click(function( event ) {
		salvar();
    	event.preventDefault();
    });
	
	$("#buttonVoltar").click(function( event ) {
		app.voltar();
    	event.preventDefault();
    });
	
	$("#buttonExcluir").click(function( event ) {
		excluir();
    	event.preventDefault();
    });
	
	$("#buttonInserirHoras").click(function( event ) {
	
		dialog = $("#dialog-form").dialog({
		      autoOpen: false,
		      height: 220,
		      width: 192,
		      modal: true,
		      buttons: {
		        "Incluir": incluirHoras,
		        Cancel: function() {
		          dialog.dialog( "close" );
		        }
		      },
		      close: function() {
		        $("#quantidade").val('');
		      }
		    });
		
		dialog.dialog( "open" );
		event.preventDefault();
	});
	
	$("#idColegio").chosen({
		no_results_text: 'Colegio inexistente'
	});
	
});


var salvar = function() {
	app.ajax({url: '/api/aluno', type : 'POST', formId : 'alunoForm', setId : true, success : appSuccess});
};

var excluir = function() {
	app.ajax({url: '/api/aluno', type : 'DELETE', formId : 'alunoForm', tipoSubmit : app.SUBMIT_AJAX_EXCLUIR});
};

var appSuccess = function(data, textStatus, jqXHR, setId) {
	defaultSucessFunction(data, textStatus, jqXHR, options.setId, options.tipoSubmit);
	$("#labelQuantidadeHorasCompradas").text('Quantidade horas disponiveis');
	$("#quantidadeHorasCompradas").prop("readonly",true);
	$('#buttonInserirHoras').show();
}

var appHorasSuccess = function(data, textStatus, jqXHR, setId) {
	defaultSucessFunction(data, textStatus, jqXHR, options.setId, options.tipoSubmit);
	$("#quantidadeHorasDisponivel").val(data);
}

var incluirHoras = function() {
	
	var params = [
	              {nome : 'quantidade' , valor : $('#quantidade').val()}
	];
	
	app.ajax({url: '/api/aluno/'+$("#id").val()+'/horas', type : 'POST', formId : 'horasForm', tipoSubmit : app.SUBMIT_AJAX_SALVAR, params : params, success : appHorasSuccess});
    dialog.dialog( "close" );
  }