$(function() {
	
	$( "button").button();
	
	$("#buttonConsultar").click(function( event ) {
		consultar();
		event.preventDefault();
    });
	
	$("#buttonIncluir").click(function( event ) {
		location.href = "editar.html";
		event.preventDefault();
    });
	
});

var consultar = function() {
	var params = [
	              {nome : 'nome' , valor : $('#nome').val()}
	];
	
	var columns = [
	               { "data": "nome" }
	];
	
	var columnDefs = [{
	            	   "render": function ( data, type, row ) {
	    					return '<a href="' + row.id + '">' + data + '</a>';
	    				},
	    				"targets": [0]
	}];
	
	app.dataTable({tableId: 'colegios', url: '/api/colegio', params : params, columns : columns, columnDefs : columnDefs});
};


