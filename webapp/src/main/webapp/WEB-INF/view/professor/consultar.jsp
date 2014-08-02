<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.professor" /></h3>
	<form action="" method="post" id="professorForm">

		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.nome" /></label> 
				<input type="text" class="big" id="nome" name="nome" value="" tabindex="1" maxlength="255">
			</div>
		</div>

		<div class="buttonspacer">
			<button id="buttonConsultar"><spring:message code="label.consultar" /></button>
			<button id="buttonIncluir"><spring:message code="label.incluir" /></button>
		</div>
		
		<div class="formspacer">
			<table id="professores" class="display appDataTable" cellspacing="0" width="100%">
			    <thead>
			        <tr>
			            <th><spring:message code="label.nome" /></th>
			            <th><spring:message code="label.telefone" /></th>
			        </tr>
			    </thead>
			 
			    <tfoot>
			        <tr>
			           <th><spring:message code="label.nome" /></th>
			            <th><spring:message code="label.telefone" /></th>
			        </tr>
			    </tfoot>
			</table>
		</div>
	</form>
</div>