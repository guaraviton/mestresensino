<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.sala" /></h3>
	<form action="" method="post" id="salaForm">

		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.numero" /></label> 
				<input type="text" class="big" id="numero" name="numero" value="" tabindex="1" maxlength="3" style="width: 35px">
			</div>
		</div>

		<div class="buttonspacer">
			<button id="buttonConsultar"><spring:message code="label.consultar" /></button>
			<button id="buttonIncluir"><spring:message code="label.incluir" /></button>
		</div>
		
		<div class="formspacer">
			<table id="salas" class="display appDataTable" cellspacing="0" width="100%">
			    <thead>
			        <tr>
			            <th><spring:message code="label.numero" /></th>
			            <th><spring:message code="label.assentos.disponiveis" /></th>
			        </tr>
			    </thead>
			 
			    <tfoot>
			        <tr>
			           <th><spring:message code="label.numero" /></th>
			            <th><spring:message code="label.assentos.disponiveis" /></th>
			        </tr>
			    </tfoot>
			</table>
		</div>
	</form>
</div>