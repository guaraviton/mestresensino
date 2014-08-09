app.dataTable = function(options){
	
	var params = app.montarParametrosUrl(options.params);
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