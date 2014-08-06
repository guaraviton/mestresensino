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
	
	$("#idColegio").chosen({
		no_results_text: 'Colegio inexistente'
	}).change(function() {
		// you can see the IDs in console off all items in autocomplete and
		// deal with them
		console.log($("#idColegio").val());
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
	               { "data": "colegio.nome", "defaultContent" : ""}
	];
	
	var columnDefs = [{
	            	   "render": function ( data, type, row ) {
	    					return '<a href="' + row.id + '">' + data + '</a>';
	    				},
	    				"targets": [0]
	}];
	
	app.dataTable({tableId: 'alunos', url: '/api/aluno', params : params, columns : columns, columnDefs : columnDefs});
};


