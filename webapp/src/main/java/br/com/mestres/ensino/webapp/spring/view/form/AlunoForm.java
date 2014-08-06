package br.com.mestres.ensino.webapp.spring.view.form;

import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.mestres.ensino.webapp.spring.config.json.serializer.CustomDateDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class AlunoForm {

	
	private Integer id;
	
	@NotEmpty
	private String nome;
	
	private String nomePai;
	
	private String nomeMae;
	
	@NotEmpty
	@Email
	private String email;
	
	private Date dataNascimento;
	
	@NotEmpty
	private String sexo;
	
	private String endereco;
	
	private String cep;
	
	@NotEmpty
	private String telefone;
	
	private Integer idColegio;
	
	private String quantidadeHorasCompradas;
	
	
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
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setDataNascimento(Date dataNascimento) {
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
	public String getQuantidadeHorasCompradas() {
		return quantidadeHorasCompradas;
	}
	public void setQuantidadeHorasCompradas(String quantidadeHorasCompradas) {
		this.quantidadeHorasCompradas = quantidadeHorasCompradas;
	}

}
