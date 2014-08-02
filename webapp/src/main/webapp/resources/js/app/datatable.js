app.dataTable = function(options){
	
	var params = montarParametrosUrl(options.params);
	var urlCompleta = app.APP_PROPERTIES.CONTEXO + options.url + (params ? '?' + params : '');
	
	$('#'+options.tableId).dataTable( {
	    "ajax": urlCompleta,
	    "columns": options.columns,
	     "searching": false,
	     "destroy": true,
	     "aoColumnDefs": options.columnDefs ? options.columnDefs : ''
    } );
	
	$('#'+options.tableId).css( "visibility", "visible" );
	 
}

var montarParametrosUrl = function(params){
	var parametros = '';
	$.each(params, function(index) {
		 nomeParametro = this.nome;
		 valorParametro = this.valor;
		 if(parametros != '' && (valorParametro && valorParametro != '' || index != (params.length - 1))){
			 parametros += '&';
		 }
		 if(valorParametro && valorParametro != ''){
			 parametros += nomeParametro + '=' + valorParametro;
		 }
	});
	return parametros;
}