<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.colegio" /></h3>
	<form action="" method="post" id="colegioForm">
		<input type="hidden" name="id" id="id" value="${colegio.id}">

		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.nome.completo" /></label> 
				<input type="text" class="text big " id="nome" name="nome" value="${colegio.nome}" tabindex="1" maxlength="255">
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
					<label for="endereco"><spring:message code="label.endereco" /></label> 
					<input type="text" class="text big " id="endereco" name="endereco" value="${colegio.endereco}" tabindex="6" maxlength="255">
			</div>
		</div>
		
		<div class="buttonspacer">
			<button id="buttonVoltar"><spring:message code="label.voltar" /></button>
			<button id="buttonSalvar"><spring:message code="label.salvar" /></button>
			<button id="buttonExcluir"><spring:message code="label.excluir" /></button>
		</div>
	</form>
</div>