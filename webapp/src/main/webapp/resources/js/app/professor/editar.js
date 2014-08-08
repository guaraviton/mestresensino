$(function() {
	$('#telefone').mask('(00) 00000-0000');
	$( "button").button();

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
	
});


var salvar = function() {
	app.ajax({url: '/api/professor', type : 'POST', formId : 'professorForm', setId : true});
};

var excluir = function() {
	app.ajax({url: '/api/professor', type : 'DELETE', formId : 'professorForm', tipoSubmit : app.SUBMIT_AJAX_EXCLUIR});
};