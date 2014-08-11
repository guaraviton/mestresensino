<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.aula" /></h3>
	<form action="" method="post" id="aulaForm">
		<input type="hidden" name="id" id="id" value="${aula.id}">

		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.professor" /></label> 
				<select id="idProfessor" name="idProfessor">
					<option value=""><spring:message code="label.selecione" /></option>
					<c:forEach items="${professores}" var="professor">
			       		<option value="${professor.id}" ${professor.id == aula.professor.id ? 'selected' : ''}>${professor.nome}</option>
			   		</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.sala" /></label> 
				<select id="idSala" name="idSala" style="width: 120px"> 
					<option value=""><spring:message code="label.selecione" /></option>
					<c:forEach items="${salas}" var="sala">
			       		<option value="${sala.id}" ${sala.id == aula.sala.id ? 'selected' : ''}>${sala.numero}</option>
			   		</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="idAlunos"><spring:message code="label.alunos" /></label> 
				<select id="idAlunos" multiple name="idAlunos">
			   		
			   		<c:set var="alunosSelecionados" value="" />
			   		<c:forEach items="${aula.alunoAulas}" var="alunoAula">
			   			<option value="${alunoAula.aluno.id}-${alunoAula.id}" selected>${alunoAula.aluno.nome}</option>
			   			<c:set var="alunosSelecionados" value="${alunosSelecionados},${alunoAula.aluno.id}" />
			   		</c:forEach>
			   		
			   		<c:set var="alunosSelecionados" value="${alunosSelecionados}," />
			   		
			   		<c:forEach items="${alunos}" var="aluno" varStatus="x">
			   			<c:if test="${not alunosSelecionados.contains(','.concat(aluno.id.toString()).concat(','))}">
			   				<option value="${aluno.id}">${aluno.nome}</option>
			   			</c:if>
			   		</c:forEach>
			   		
				</select>
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="data"><spring:message code="label.data" /></label> 
				<input type="text" id="data" name="data" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aula.data}" />">
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="horario"><spring:message code="label.horario" /></label> 
				<input type="text" id="horario" name="horario" style="width: 55px" value="${aula.horario}">
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="horas"><spring:message code="label.horas" /></label> 
				<input type="text" id="horas" name="horas" style="width: 35px" value="${aula.horas}">
			</div>
		</div>
		
		<div class="buttonspacer">
			<button id="buttonVoltar"><spring:message code="label.voltar" /></button>
			<button id="buttonSalvar"><spring:message code="label.salvar" /></button>
			<button id="buttonExcluir"><spring:message code="label.excluir" /></button>
		</div>
	</form>
</div>