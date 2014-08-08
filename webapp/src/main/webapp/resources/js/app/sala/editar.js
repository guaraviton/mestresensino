$(function() {
	$('#numero').mask('000');
	$('#assentosDisponiveis').mask('000');
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
	app.ajax({url: '/api/sala', type : 'POST', formId : 'salaForm', setId : true});
};

var excluir = function() {
	app.ajax({url: '/api/sala', type : 'DELETE', formId : 'salaForm', tipoSubmit : app.SUBMIT_AJAX_EXCLUIR});
};