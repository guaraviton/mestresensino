$(function() {
	$('#cep').mask('00000-000');
	$('#telefone').mask('(00) 00000-0000');
	$('#dataNascimento').mask('00/00/0000');
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
	app.ajax({url: '/api/aluno', type : 'POST', formId : 'alunoForm', setId : true});
};