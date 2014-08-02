<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.aluno" /></h3>
	<form action="" method="post" id="professorForm">
		<input type="hidden" name="id" id="id" value="${professor.id}">

		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.nome.completo" /></label> 
				<input type="text" class="text big " id="nome" name="nome" value="${professor.nome}" tabindex="1" maxlength="255">
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="email"><spring:message code="label.email" /></label> 
				<input type="text" class="text big " id="email" name="email" value="${professor.email}" tabindex="4" maxlength="45"> 
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
					<label for="endereco"><spring:message code="label.endereco" /></label> 
					<input type="text" class="text big " id="endereco" name="endereco" value="${professor.endereco}" tabindex="6" maxlength="255">
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
					<label for="telefone"><spring:message code="label.telefone" /></label> 
					<input type="text" class="text big " id="telefone" name="telefone" value="${professor.telefone}" tabindex="8" maxlength="10" style="width: 155px">
			</div>
		</div>
		
		<div class="buttonspacer">
			<button id="buttonVoltar"><spring:message code="label.voltar" /></button>
			<button id="buttonSalvar"><spring:message code="label.salvar" /></button>
		</div>
	</form>
</div>