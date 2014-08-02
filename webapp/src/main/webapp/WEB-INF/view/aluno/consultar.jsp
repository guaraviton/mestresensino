<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.aluno" /></h3>
	<form action="" method="post" id="alunoForm">

		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.nome" /></label> 
				<input type="text" class="big" id="nome" name="nome" value="" tabindex="1" maxlength="255">
			</div>
		</div>
		<div class="formspacer">
			<div class="bloco">
				<label for="idColegio"><spring:message code="label.colegio" /></label> 
				<select id="idColegio" name="idColegio">
					<option value=""><spring:message code="label.selecione" /></option>
					<c:forEach items="${colegios}" var="colegio">
				       <option value="${colegio.id}">${colegio.nome}</option>
				   	</c:forEach>
				</select>
			</div>
		</div>
		

		<div class="buttonspacer">
			<button id="buttonConsultar"><spring:message code="label.consultar" /></button>
			<button id="buttonIncluir"><spring:message code="label.incluir" /></button>
		</div>
		
		<div class="formspacer">
			<table id="alunos" class="display appDataTable" cellspacing="0" width="100%">
			    <thead>
			        <tr>
			            <th><spring:message code="label.nome" /></th>
			            <th><spring:message code="label.telefone" /></th>
			            <th><spring:message code="label.colegio" /></th>
			        </tr>
			    </thead>
			 
			    <tfoot>
			        <tr>
			           <th><spring:message code="label.nome" /></th>
			            <th><spring:message code="label.telefone" /></th>
			            <th><spring:message code="label.colegio" /></th>
			        </tr>
			    </tfoot>
			</table>
		</div>
	</form>
</div>