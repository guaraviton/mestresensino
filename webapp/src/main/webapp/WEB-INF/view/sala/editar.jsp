<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.sala" /></h3>
	<form action="" method="post" id="salaForm">
		<input type="hidden" name="id" id="id" value="${sala.id}">

		<div class="formspacer">
			<div class="bloco">
				<label for="numero"><spring:message code="label.numero" /></label> 
				<input type="text" class="text big " id="numero" name="numero" value="${sala.numero}" tabindex="1" maxlength="3" style="width: 35px"> 
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="assentosDisponiveis"><spring:message code="label.assentos.disponiveis" /></label> 
				<input type="text" class="text big " id="assentosDisponiveis" name="assentosDisponiveis" value="${sala.assentosDisponiveis}" tabindex="2" maxlength="5" style="width: 50px"> 
			</div>
		</div>
		
		<div class="buttonspacer">
			<button id="buttonVoltar"><spring:message code="label.voltar" /></button>
			<button id="buttonSalvar"><spring:message code="label.salvar" /></button>
			<button id="buttonExcluir"><spring:message code="label.excluir" /></button>
		</div>
	</form>
</div>