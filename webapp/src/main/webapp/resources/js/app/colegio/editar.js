$(function() {
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
	app.ajax({url: '/api/colegio', type : 'POST', formId : 'colegioForm', setId : true});
};