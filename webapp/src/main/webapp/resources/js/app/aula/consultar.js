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
	
	$("#idProfessor").chosen({
		no_results_text: 'Professor inexistente'
	});
	
	$("#idSala").chosen({
		no_results_text: 'Sala inexistente'
	});
	
});

var consultar = function() {
	var params = [
	              {nome : 'idProfessor' , valor : $('#idProfessor').val()},
	              {nome : 'idSala' , valor : $('#idSala').val()}
	];
	
	var columns = [
	               { "data": "professor.nome" },
	               { "data": "sala.numero" },
	               { "data": "data"},
	               { "data": "horario"}
	];
	
	var columnDefs = [{
	            	   "render": function ( data, type, row ) {
	    					return '<a href="' + row.id + '">' + data + '</a>';
	    				},
	    				"targets": [0]
	}];
	
	app.dataTable({tableId: 'aulas', url: '/api/aula', params : params, columns : columns, columnDefs : columnDefs});
};


