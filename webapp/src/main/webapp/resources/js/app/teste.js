var time_email = setTimeout(function() {
}, 1000);
var original_alternate = "";
$(function() {
	$("#form_cadastro").bind("submit", valida_form);
	$("#natal_dia").bind("keyup", date_keypress);
	$("#natal_mes").bind("keyup", date_keypress);
	$("#natal_ano").bind("keyup", date_keypress);
	$("#celular_ddd").bind("keyup", date_keypress);
	$("#celular_numero").bind("keyup", date_keypress);
	var firsterror = $(".errorblock:not(:empty):first");
	if (firsterror.length > 0) {
		$("html, body").animate({
			scrollTop : firsterror.offset().top - 100
		}, "slow")
	}
	$("#modal, #modal .bloco .close").bind("click", close_modal);
	$("#modal .bloco").bind("click", function(e) {
		event.stopPropagation()
	});
	$("#modal .bloco a").bind("click", function(e) {
		event.stopPropagation()
	});
	$("#resend_email").bind("click", send_alternate_email);
	original_alternate = $("#email_alternativo").val();
	$("#email_alternativo").bind("keyup", function() {
		if ($("#email_alternativo").val() == original_alternate) {
			$("#notconfirmed").slideDown()
		} else {
			$("#notconfirmed").slideUp()
		}
	})
});
var date_keypress = function(e) {
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
function open_modal(conteudo) {
	if (!conteudo) {
		var conteudo = ""
	}
	$("#modal").find(".conteudo").html(conteudo);
	$("#modal").fadeIn();
	return false
}
function close_modal() {
	$("#modal").fadeOut();
	return false
}
function send_alternate_email() {
	$
			.ajax({
				url : "/profile/send-confirmation-email",
				dataType : "json",
				type : "POST",
				success : function(data) {
					if (data.status && data.status == "success") {
						var conteudo = '<p>Confirma\u00e7\u00e3o de email alternativo enviado para:</p><p class="especial">'
								+ $("#email_alternativo").val()
								+ '</p><div class="botao">\t<a href="javascript:close_modal()" class="btPadrao1">OK</a></div>';
						open_modal(conteudo);
						$("#notconfirmed").remove()
					} else {
						send_alternate_email_error()
					}
				},
				error : send_alternate_email_error
			});
	return false
}
function send_alternate_email_error() {
	var conteudo = '<p class="especial">Ocorreu um erro</p><p>N\u00e3o foi poss\u00edvel enviar uma confirma\u00e7\u00e3o de email alternativo</p>';
	open_modal(conteudo)
}
function verifica_email() {
	clearTimeout(time_email);
	if ($("#novo_email").val().length != 0) {
		time_email = setTimeout(
				function() {
					$("#novo_email").parent().parent().find(".successblock")
							.remove();
					$("#novo_email").parent().parent().find(".errorblock")
							.remove();
					$("#novo_email").parent().parent().find(".loadingblock")
							.remove();
					$("#novo_email").removeClass("error");
					$("#novo_email").parent().after(
							'<span class="loadingblock">Carregando</span>');
					var now = new Date;
					$
							.ajax({
								url : "verifica_email.js",
								dataType : "json",
								data : {
									nome : $("nome_completo").val(),
									email : $("novo_email").val(),
									time : now.getTime()
								},
								type : "POST",
								success : function(data) {
									$("#novo_email").parent().parent().find(
											".loadingblock").remove();
									if (data.status) {
										if (data.status == "unavailable") {
											$("#novo_email").addClass("error");
											$("#novo_email")
													.parent()
													.after(
															'<span class="errorblock">Nome de usu\u00e1rio j\u00e1 existe</span>')
										} else {
											if (data.status == "available") {
												$("#novo_email")
														.parent()
														.after(
																'<span class="successblock"></span>')
											} else {
												if (data.status == "invalid") {
													$("#novo_email").addClass(
															"error");
													$("#novo_email")
															.parent()
															.after(
																	'<span class="errorblock">Email inv\u00e1lido</span>')
												}
											}
										}
									}
								}
							})
				}, 1000)
	} else {
		$("#novo_email").parent().parent().find(".successblock").remove();
		$("#novo_email").parent().parent().find(".errorblock").remove();
		$("#novo_email").parent().parent().find(".loadingblock").remove();
		$("#novo_email").removeClass("error")
	}
}
function valida_form() {
	var erros = [];
	var senha_obg = true;
	var regnewmail = /[^a-z0-9_.-]/g;
	var regmail = /^[a-z]{1}([a-z0-9_\-\.\+])+\@([A-Za-z0-9_\-\.])+\..*$/;
	var err_tip = '<span class="errorblock">[[ERR]]</span>';
	$("input").removeClass("error");
	$(".errorblock").remove();
	if ($("#nome_completo").length != 0) {
		if ($("#nome_completo").val().length < 2) {
			erros.push($("#nome_completo"));
			$("#nome_completo").addClass("error");
			$("#nome_completo").parent().after(
					err_tip.replace("[[ERR]]",
							"Favor digitar seu nome completo"))
		}
	}
	if ($("#novo_email").length != 0) {
		if ($("#novo_email").val().length < 1) {
			erros.push($("#novo_email"));
			$("#novo_email").addClass("error");
			$("#novo_email").parent().after(
					err_tip.replace("[[ERR]]",
							"Favor digitar um nome de usu\u00e1rio"));
			$("#novo_email").parent().find(".successblock").remove();
			$("#novo_email").parent().find(".loadingblock").remove()
		} else {
			if ($("#novo_email").val().length < 6) {
				erros.push($("#novo_email"));
				$("#novo_email").addClass("error");
				$("#novo_email")
						.parent()
						.after(
								err_tip
										.replace("[[ERR]]",
												"Usu\u00e1rio precisa ter ao menos 6 caracteres"));
				$("#novo_email").parent().find(".successblock").remove();
				$("#novo_email").parent().find(".loadingblock").remove()
			} else {
				if ($("#novo_email").val().indexOf("@") != -1) {
					erros.push($("#novo_email"));
					$("#novo_email").addClass("error");
					$("#novo_email")
							.parent()
							.after(
									err_tip
											.replace("[[ERR]]",
													"Voc\u00ea n\u00e3o pode digitar um email no nome do usu\u00e1rio"));
					$("#novo_email").parent().find(".successblock").remove();
					$("#novo_email").parent().find(".loadingblock").remove()
				} else {
					if (regnewmail.test($("#novo_email").val())) {
						erros.push($("#novo_email"));
						$("#novo_email").addClass("error");
						$("#novo_email")
								.parent()
								.after(
										err_tip
												.replace("[[ERR]]",
														"Caracteres permitidos: Letras min\u00fasculas, '_', '-' e '.'"));
						$("#novo_email").parent().find(".successblock")
								.remove();
						$("#novo_email").parent().find(".loadingblock")
								.remove()
					} else {
						if ($("#novo_email").hasClass("error")) {
							erros.push($("#novo_email"))
						}
					}
				}
			}
		}
	}
	if ($("#senha_atual").length != 0 && $("#nova_senha").length != 0) {
		if ($("#senha_atual").hasClass("opcional")
				|| $("#nova_senha").hasClass("opcional")) {
			senha_obg = false;
			if ($("#senha_atual").val().length != 0
					|| $("#nova_senha").val().length != 0) {
				senha_obg = true
			}
		} else {
			senha_obg = true
		}
	}
	if ($("#nova_senha").length != 0 && senha_obg) {
		if ($("#nova_senha").val().length < 1) {
			erros.push($("#nova_senha"));
			$("#nova_senha").addClass("error");
			$("#nova_senha_re").addClass("error");
			$("#nova_senha_re").parent().after(
					err_tip.replace("[[ERR]]", "Favor digitar uma senha"))
		} else {
			if ($("#nova_senha").hasClass("fraco")) {
				erros.push($("#nova_senha"));
				$("#nova_senha").addClass("error");
				$("#nova_senha_re").addClass("error");
				$("#nova_senha_re")
						.parent()
						.after(
								err_tip
										.replace("[[ERR]]",
												"Senha muito fraca. Consulte as dicas de senha"))
			} else {
				if ($("#nova_senha").val() != $("#nova_senha_re").val()) {
					erros.push($("#nova_senha"));
					$("#nova_senha").addClass("error");
					$("#nova_senha_re").addClass("error");
					$("#nova_senha_re")
							.parent()
							.after(
									err_tip
											.replace("[[ERR]]",
													"Sua senha e confirma\u00e7\u00e3o de senha precisam ser iguais"))
				}
			}
		}
	}
	if ($("#senha_atual").length != 0 && senha_obg) {
		if ($("#senha_atual").val().length < 1) {
			erros.push($("#senha_atual"));
			$("#senha_atual").addClass("error");
			$("#senha_atual").parent().after(
					err_tip.replace("[[ERR]]", "Digite sua senha atual"))
		}
	}
	if ($("#natal_dia").length != 0) {
		var dia = parseInt($("#natal_dia").val(), 10), mes = parseInt($(
				"#natal_mes").val(), 10), ano = parseInt($("#natal_ano").val(),
				10);
		var hoje = new Date;
		var data = new Date;
		data.setFullYear(ano, mes - 1, dia);
		if ($("#natal_dia").val().length < 1
				|| $("#natal_dia").val().length > 2
				|| $("#natal_mes").val().length < 1
				|| $("#natal_mes").val().length > 2
				|| $("#natal_ano").val().length != 4) {
			erros.push($("#natal_dia"));
			$("#natal_dia").addClass("error");
			$("#natal_mes").addClass("error");
			$("#natal_ano").addClass("error");
			$("#natal_dia").parent().parent().after(
					err_tip.replace("[[ERR]]",
							"Data de nascimento inv\u00e1lida"))
		} else {
			if (data.getDate() != dia || data.getMonth() != mes - 1
					|| data.getFullYear() != ano) {
				erros.push($("#natal_dia"));
				$("#natal_dia").addClass("error");
				$("#natal_mes").addClass("error");
				$("#natal_ano").addClass("error");
				$("#natal_dia").parent().parent().after(
						err_tip.replace("[[ERR]]",
								"Data de nascimento inv\u00e1lida"))
			} else {
				if (hoje <= data) {
					erros.push($("#natal_dia"));
					$("#natal_dia").addClass("error");
					$("#natal_mes").addClass("error");
					$("#natal_ano").addClass("error");
					$("#natal_dia").parent().parent().after(
							err_tip.replace("[[ERR]]",
									"Data de nascimento inv\u00e1lida"))
				}
			}
		}
	}
	var recuperacaoSenhaPreenchido = 0;
	if ($("#lembrete").length != 0) {
		if ($.trim($("#lembrete").val()).length > 0) {
			recuperacaoSenhaPreenchido++;
			if ($("#nova_senha").length > 0) {
				var novasenha = $.trim($("#nova_senha").val()).toLowerCase();
				var lembrete = $.trim($("#lembrete").val()).toLowerCase();
				if (novasenha.length > 0) {
					if (lembrete.indexOf(novasenha) != -1) {
						erros.push($("#lembrete"));
						$("#lembrete").addClass("error");
						$("#lembrete")
								.parent()
								.after(
										err_tip
												.replace("[[ERR]]",
														"Voc\u00ea n\u00e3o pode digitar sua senha no lembrete de senha"))
					}
				}
			}
		}
	}
	if ($("#email_alternativo").val().length > 0) {
		recuperacaoSenhaPreenchido++;
		if (!regmail.test($("#email_alternativo").val())) {
			erros.push($("#email_alternativo"));
			$("#email_alternativo").addClass("error");
			$("#email_alternativo").parent().after(
					err_tip.replace("[[ERR]]",
							"N\u00e3o \u00e9 um email v\u00e1lido"))
		}
	}
	if ($("#celular_ddd").length != 0
			&& ($("#celular_ddd").val().length != 0 || $("#celular_numero")
					.val().length != 0)) {
		recuperacaoSenhaPreenchido++;
		var regddd = /^[0-9]{2}$/;
		var regcel = /^[0-9]{7,9}$/;
		$("#celular_numero").val(
				$("#celular_numero").val().replace(/[^0-9]/g, ""));
		if (!regddd.test($("#celular_ddd").val())
				|| !regcel.test($("#celular_numero").val())) {
			erros.push($("#celular_ddd"));
			$("#celular_ddd").addClass("error");
			$("#celular_numero").addClass("error");
			$("#celular_numero").parent().after(
					err_tip.replace("[[ERR]]",
							"N\u00famero de celular inv\u00e1lido"))
		}
	}
	if (recuperacaoSenhaPreenchido < 2) {
		erros.push($("#recuperacao_senha"));
		$("#recuperacao_senha")
				.html(
						err_tip
								.replace("[[ERR]]",
										"Voc\u00ea precisa preencher pelo menos 2 maneiras de recuperar sua senha"))
	}
	if (erros.length > 0) {
		var offset = erros[0].offset();
		$("html, body").animate({
			scrollTop : offset.top - 30
		}, "slow");
		return false
	}
};
a