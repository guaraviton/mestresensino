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
	              {nome : 'numero' , valor : $('#numero').val()}
	];
	
	var columns = [
	               { "data": "numero" },
	               { "data": "assentosDisponiveis" }
	];
	
	var columnDefs = [{
	            	   "render": function ( data, type, row ) {
	    					return '<a href="' + row.id + '">' + data + '</a>';
	    				},
	    				"targets": [0]
	}];
	
	app.dataTable({tableId: 'salas', url: '/api/sala', params : params, columns : columns, columnDefs : columnDefs});
};


