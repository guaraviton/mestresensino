$(function() {
	$('#telefone').mask('(00) 00000-0000');
	$( "button").button();

	$("#buttonSalvar").click(function( event ) {
		salvar();
    	event.preventDefault();
    });
	
	$("#buttonVoltar").click(function( event ) {
		location.href = "index.html";
    	event.preventDefault();
    });
	
});


var salvar = function() {
	app.ajax({url: '/api/professor', type : 'POST', formId : 'professorForm', setId : true});
};