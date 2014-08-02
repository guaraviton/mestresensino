<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.colegio" /></h3>
	<form action="" method="post" id="colegioForm">

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
			<table id="colegios" class="display appDataTable" cellspacing="0" width="100%">
			    <thead>
			        <tr>
			            <th><spring:message code="label.nome" /></th>
			        </tr>
			    </thead>
			 
			    <tfoot>
			        <tr>
			           <th><spring:message code="label.nome" /></th>
			        </tr>
			    </tfoot>
			</table>
		</div>
	</form>
</div>