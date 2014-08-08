

var app = {
	
	DIALOG_CHECK : 'dialog_check',
	DIALOG_INFO : 'dialog_info',
	DIALOG_ERROR : 'dialog_error',
	SUBMIT_AJAX_SALVAR : 'submit_ajax_salvar',
	SUBMIT_AJAX_EXCLUIR : 'submit_ajax_excluir',
		
	APP_PROPERTIES : {
			"CONTEXO" : "/webapp"
	}
}

app.tabIndexKeypress = function(e) {
	var skip_key = [ 8, 9, 16, 37, 38, 39, 40 ], is_key = false;
	$.each(skip_key, function(i, key) {
		if (key == e.keyCode) {
			is_key = true
		}
	});
	if (is_key) {
		return false
	}
	var target = $(e.target), val = target.val(), max = parseInt(target
			.attr("maxlength"), 10);
	next = target.next(), reg = /[^0-9]/g;
	val = val.replace(reg, "");
	target.val(val);
	if (val.length >= max) {
		next.focus()
	}
};

app.voltar = function() {
	history.back();
}