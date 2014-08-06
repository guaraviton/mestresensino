$(function() {
	$('#cep').mask('00000-000');
	$('#telefone').mask('(00) 00000-0000');
	$('#dataNascimento').mask('00/00/0000');
	$( "button").button();
	$('#quantidadeHorasCompradas').mask('0.000');
	$('#quantidadeHorasDisponivel').mask('0.000');

	$("#buttonSalvar").click(function( event ) {
		salvar();
    	event.preventDefault();
    });
	
	$("#buttonVoltar").click(function( event ) {
		location.href = "index.html";
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


var salvar = function() {
	app.ajax({url: '/api/aluno', type : 'POST', formId : 'alunoForm', setId : true, success : appSuccess});
};

var appSuccess = function(data, textStatus, jqXHR, setId) {
	defaultSucessFunction(data, textStatus, jqXHR, options.setId);
	$("#labelQuantidadeHorasCompradas").text('Quantidade horas disponiveis');
	$("#quantidadeHorasCompradas").prop("readonly",true);
}