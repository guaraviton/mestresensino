package br.com.mestres.ensino.webapp.spring.persistence.model;

// Generated 05/08/2014 23:00:01 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Colegio generated by hbm2java
 */
@Entity
@Table(name = "colegio", catalog = "mestresensino")
public class Colegio extends BaseEntity{

	private String nome;
	private String endereco;
	
	@JsonIgnore
	private Set<Aluno> alunos = new HashSet<Aluno>(0);

	public Colegio() {
	}

	public Colegio(String nome, String endereco, Set<Aluno> alunos) {
		this.nome = nome;
		this.endereco = endereco;
		this.alunos = alunos;
	}

	@Column(name = "nome")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "endereco")
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colegio")
	public Set<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

}
