<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="container cadastro">

	<h3 class="tituloaplicacao"><spring:message code="label.aluno" /></h3>
	<form action="" method="post" id="alunoForm">
		<input type="hidden" name="id" id="id" value="${aluno.id}">

		<div class="formspacer">
			<div class="bloco">
				<label for="nome"><spring:message code="label.nome.completo" /></label> 
				<input type="text" class="text big " id="nome" name="nome" value="${aluno.nome}" tabindex="1" maxlength="255">
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="nomePai"><spring:message code="label.nome.pai" /></label> 
				<input type="text" class="text big " id="nomePai" name="nomePai" value="${aluno.nomePai}" tabindex="2" maxlength="255">
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="nomeMae"><spring:message code="label.nome.mae" /></label> 
				<input type="text" class="text big " id="nomeMae" name="nomeMae" value="${aluno.nomeMae}" tabindex="3" maxlength="255">
			</div>
		</div>

		<div class="formspacer">
			<div class="bloco">
				<label for="email"><spring:message code="label.email" /></label> 
				<input type="text" class="text big " id="email" name="email" value="${aluno.email}" tabindex="4" maxlength="45"> 
			</div>
		</div>

		
		<div class="formspacer">
			<div class="bloco">
					<label for="dataNascimento"><spring:message code="label.data.nascimento" /></label> 
					<input type="text" class="text big " id="dataNascimento" name="dataNascimento" value="${aluno.dataNascimento}" tabindex="5" maxlength="10" style="width: 105px"> 
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
					<label for="endereco"><spring:message code="label.endereco" /></label> 
					<input type="text" class="text big " id="endereco" name="endereco" value="${aluno.endereco}" tabindex="6" maxlength="255">
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
					<label for="cep"><spring:message code="label.cep" /></label> 
					<input type="text" class="text big " id="cep" name="cep" value="${aluno.cep}" tabindex="7" maxlength="9" style="width: 105px"> 
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
					<label for="telefone"><spring:message code="label.telefone" /></label> 
					<input type="text" class="text big " id="telefone" name="telefone" value="${aluno.telefone}" tabindex="8" maxlength="10" style="width: 155px">
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<div id="sexo">
					<label>Sexo</label> <label class="radiocheck">
						<input type="radio" name="sexo" value="F" ${aluno.sexo == 'F' ? 'checked' : ''} tabindex="9"> 
						<spring:message code="label.feminino" />
					</label> 
					<label class="radiocheck">
						<input type="radio" name="sexo" value="M" ${aluno.sexo == 'M' ? 'checked' : ''} tabindex="10">
						<spring:message code="label.masculino" />
					</label>
				</div>
			</div>
		</div>
		
		<div class="formspacer">
			<div class="bloco">
				<label for="idColegio"><spring:message code="label.colegio" /></label> 
				<select id="idColegio" name="idColegio">
					<option value=""><spring:message code="label.selecione" /></option>
					<c:forEach items="${colegios}" var="colegio">
				       <option value="${colegio.id}" ${colegio.id == aluno.colegio.id ? 'selected' : ''}>${colegio.nome}</option>
				   	</c:forEach>
				</select>
			</div>
		</div>

		<div class="buttonspacer">
			<button id="buttonVoltar"><spring:message code="label.voltar" /></button>
			<button id="buttonSalvar"><spring:message code="label.salvar" /></button>
		</div>
	</form>
</div>