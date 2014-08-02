package br.com.mestres.ensino.webapp.spring.persistence.model;

// Generated 01/08/2014 01:15:09 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Aluno generated by hbm2java
 */
@Entity
@Table(name = "aluno", catalog = "mestresensino")
public class Aluno implements java.io.Serializable {

	private Integer id;
	private Colegio colegio;
	private String nome;
	private String nomePai;
	private String nomeMae;
	private String email;
	private String dataNascimento;
	private String sexo;
	private String telefone;
	private String endereco;
	private String cep;
	
	@JsonIgnore
	private Set<AlunoAula> alunoAulas = new HashSet<AlunoAula>(0);

	public Aluno() {
	}

	public Aluno(Colegio colegio, String nome, String dataNascimento, String sexo) {
		this.colegio = colegio;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}

	public Aluno(Colegio colegio, String nome, String nomePai, String nomeMae,
			String email, String dataNascimento, String sexo, String telefone,
			String endereco, String cep, Set<AlunoAula> alunoAulas) {
		this.colegio = colegio;
		this.nome = nome;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cep = cep;
		this.alunoAulas = alunoAulas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "colegio_id", nullable = true)
	public Colegio getColegio() {
		return this.colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	@Column(name = "nome", nullable = false)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "nomePai")
	public String getNomePai() {
		return this.nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	@Column(name = "nomeMae")
	public String getNomeMae() {
		return this.nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "dataNascimento", nullable = false, length = 10)
	public String getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "sexo", nullable = false, length = 1)
	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(name = "telefone", length = 20)
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "endereco")
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "cep", length = 9)
	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno")
	public Set<AlunoAula> getAlunoAulas() {
		return this.alunoAulas;
	}

	public void setAlunoAulas(Set<AlunoAula> alunoAulas) {
		this.alunoAulas = alunoAulas;
	}

}
