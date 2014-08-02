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
	              {nome : 'nome' , valor : $('#nome').val()},
	              {nome : 'idColegio' , valor : $('#idColegio').val()}
	];
	
	var columns = [
	               { "data": "nome" },
	               { "data": "telefone" },
	               { "data": "colegio.nome" }
	];
	
	var columnDefs = [{
	            	   "render": function ( data, type, row ) {
	    					return '<a href="' + row.id + '">' + data + '</a>';
	    				},
	    				"targets": [0]
	}];
	
	app.dataTable({tableId: 'alunos', url: '/api/aluno', params : params, columns : columns, columnDefs : columnDefs});
};


