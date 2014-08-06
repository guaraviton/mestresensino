<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.aula" /></h3>
	<form action="" method="post" id="colegioForm">

		<div class="formspacer">
			<div class="bloco">
				<label for="idProfessor"><spring:message code="label.professor" /></label> 
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
				<label for="idSala"><spring:message code="label.sala" /></label> 
				<select id="idSala" name="idSala">
					<option value=""><spring:message code="label.selecione" /></option>
					<c:forEach items="${salas}" var="sala">
				       <option value="${sala.id}">${sala.numero}</option>
				   	</c:forEach>
				</select>
			</div>
		</div>

		<div class="buttonspacer">
			<button id="buttonConsultar"><spring:message code="label.consultar" /></button>
			<button id="buttonIncluir"><spring:message code="label.incluir" /></button>
		</div>
		
		<div class="formspacer">
			<table id="aulas" class="display appDataTable" cellspacing="0" width="100%">
			    <thead>
			        <tr>
			            <th><spring:message code="label.professor" /></th>
			            <th><spring:message code="label.sala" /></th>
			            <th><spring:message code="label.data" /></th>
			            <th><spring:message code="label.horario" /></th>
			        </tr>
			    </thead>
			 
			    <tfoot>
			        <tr>
			           <th><spring:message code="label.professor" /></th>
			            <th><spring:message code="label.sala" /></th>
			            <th><spring:message code="label.data" /></th>
			            <th><spring:message code="label.horario" /></th>
			        </tr>
			    </tfoot>
			</table>
		</div>
	</form>
</div>