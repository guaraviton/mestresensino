<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.aula" /></h3>
	<form action="" method="post" id="colegioForm">
		<input type="hidden" name="id" id="id" value="${aula.id}">

		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.professor" /></label> 
				<input type="text" class="text big " id="nome" name="nome" value="${colegio.nome}" tabindex="1" maxlength="255">
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.sala" /></label> 
				<input type="text" class="text big " id="sala" name="sala" value="${colegio.nome}" tabindex="1" maxlength="255">
			</div>
		</div>
		
		<div class="formspacer"  style="overflow: initial;">
			<div class="bloco">
					<label for="endereco"><spring:message code="label.alunos" /></label> 
					<select id="jacComplete" title="List of Movies" size=30 multiple style="width: 484px; display: block; height: 100%;">
					</select>
			</div>
		</div>
		
		<div class="buttonspacer">
			<button id="buttonVoltar"><spring:message code="label.voltar" /></button>
			<button id="buttonSalvar"><spring:message code="label.salvar" /></button>
		</div>
	</form>
</div>