$(function() {
	$("#jacComplete").ajaxChosen({
		type : 'GET',
		url : '/webapp/api/aluno',
		dataType : 'json',
		minTermLength : "3",
		keepTypingMsg : "Continue teclando",
		lookingForMsg : "Procurando por",
		jsonTermKey : "nome",
		placeholder_text : "TESTE"
	}, function(data) {
		var terms = {};
		$.each(data, function(i, val) {
			$.each(this, function(index, value) {
				terms[value.id] = value.nome;
			});
		});
		return terms;
	},
	{
		placeholder_text: 'Selecione os alunos para a aula',
		no_results_text: 'Aluno inexistente',
		width: "95%"
	}).change(function() {
		// you can see the IDs in console off all items in autocomplete and
		// deal with them
		console.log($("#jacComplete").val());
	});
});
