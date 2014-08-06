package br.com.mestres.ensino.webapp.spring.persistence.model;

// Generated 05/08/2014 23:00:01 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AlunoAula generated by hbm2java
 */
@Entity
@Table(name = "aluno_aula", catalog = "mestresensino")
public class AlunoAula implements java.io.Serializable {

	private Integer id;
	private Aluno aluno;
	private Aula aula;

	public AlunoAula() {
	}

	public AlunoAula(Aluno aluno, Aula aula) {
		this.aluno = aluno;
		this.aula = aula;
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
	@JoinColumn(name = "aluno_id", nullable = false)
	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "aula_id", nullable = false)
	public Aula getAula() {
		return this.aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

}
