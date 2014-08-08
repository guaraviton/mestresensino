$(function() {
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
	app.ajax({url: '/api/colegio', type : 'POST', formId : 'colegioForm', setId : true});
};

var excluir = function() {
	app.ajax({url: '/api/colegio', type : 'DELETE', formId : 'colegioForm', tipoSubmit : app.SUBMIT_AJAX_EXCLUIR});
};