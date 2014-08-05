<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.aula" /></h3>
	<form action="" method="post" id="colegioForm">
		<input type="hidden" name="id" id="id" value="${aula.id}">

		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.professor" /></label> 
				<select id="idProfessor" name="idProfessor">
					<option value=""><spring:message code="label.selecione" /></option>
					<c:forEach items="${professores}" var="professor">
			       		<option value="${professor.id}">${professor.nome}</option>
			   		</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.sala" /></label> 
				<select id="idSala" name="idSala">
					<option value=""><spring:message code="label.selecione" /></option>
					<c:forEach items="${salas}" var="sala">
			       		<option value="${sala.id}">${sala.numero}</option>
			   		</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="idAlunos"><spring:message code="label.alunos" /></label> 
				<select id="idAlunos" multiple>
					<c:forEach items="${alunos}" var="aluno">
			       		<option value="${aluno.id}">${aluno.nome}</option>
			   		</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="dataInicio"><spring:message code="label.data.inicio" /></label> 
				<input type="text" id="dataInicio">
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="dataFim"><spring:message code="label.data.fim" /></label> 
				<input type="text" id="dataFim">
			</div>
		</div>
		
		<div class="buttonspacer">
			<button id="buttonVoltar"><spring:message code="label.voltar" /></button>
			<button id="buttonSalvar"><spring:message code="label.salvar" /></button>
		</div>
	</form>
</div>