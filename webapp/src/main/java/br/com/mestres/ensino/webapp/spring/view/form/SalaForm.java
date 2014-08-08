package br.com.mestres.ensino.webapp.spring.view.form;

import javax.validation.constraints.NotNull;

public class SalaForm {

	private Integer id;
	
	@NotNull
	private Integer numero;
	
	@NotNull
	private Integer assentosDisponiveis;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getAssentosDisponiveis() {
		return assentosDisponiveis;
	}

	public void setAssentosDisponiveis(Integer assentosDisponiveis) {
		this.assentosDisponiveis = assentosDisponiveis;
	}
	

}
