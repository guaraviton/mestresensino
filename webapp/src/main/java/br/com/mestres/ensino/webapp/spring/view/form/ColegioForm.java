package br.com.mestres.ensino.webapp.spring.view.form;

import org.hibernate.validator.constraints.NotEmpty;

public class ColegioForm {

	private Integer id;
	
	@NotEmpty
	private String nome;
	
	private String endereco;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
