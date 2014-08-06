$(function() {
	$('#numero').mask('000');
	$('#assentosDisponiveis').mask('0.000');
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
	app.ajax({url: '/api/sala', type : 'POST', formId : 'salaForm', setId : true});
};