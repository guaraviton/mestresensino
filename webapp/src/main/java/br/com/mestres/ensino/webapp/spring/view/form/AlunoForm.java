package br.com.mestres.ensino.webapp.spring.view.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class AlunoForm {

	
	private Integer id;
	
	@NotEmpty
	private String nome;
	
	private String nomePai;
	
	private String nomeMae;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=10,max=10)
	private String dataNascimento;
	
	private String sexo;
	
	private String endereco;
	
	private String cep;
	
	@NotEmpty
	private String telefone;
	
	private Integer idColegio;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdColegio() {
		return idColegio;
	}
	public void setIdColegio(Integer idColegio) {
		this.idColegio = idColegio;
	}
}
