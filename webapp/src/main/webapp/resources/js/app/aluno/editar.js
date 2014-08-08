$(function() {
	$('#cep').mask('00000-000');
	$('#telefone').mask('(00) 00000-0000');
	$("#dataNascimento").datepicker({dateFormat: 'dd/mm/yy'});
	$('#dataNascimento').mask('00/00/0000');
	$( "button").button();
	$('#quantidadeHorasCompradas').mask('000');

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
	
	$("#idColegio").chosen({
		no_results_text: 'Colegio inexistente'
	});
	
});


var salvar = function() {
	app.ajax({url: '/api/aluno', type : 'POST', formId : 'alunoForm', setId : true, success : appSuccess});
};

var excluir = function() {
	app.ajax({url: '/api/aluno', type : 'DELETE', formId : 'alunoForm', tipoSubmit : app.SUBMIT_AJAX_EXCLUIR});
};

var appSuccess = function(data, textStatus, jqXHR, setId) {
	defaultSucessFunction(data, textStatus, jqXHR, options.setId, options.tipoSubmit);
	$("#labelQuantidadeHorasCompradas").text('Quantidade horas disponiveis');
	$("#quantidadeHorasCompradas").prop("readonly",true);
}