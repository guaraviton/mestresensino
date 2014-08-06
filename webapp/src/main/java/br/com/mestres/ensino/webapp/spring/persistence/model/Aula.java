package br.com.mestres.ensino.webapp.spring.persistence.model;

// Generated 05/08/2014 23:00:01 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Aula generated by hbm2java
 */
@Entity
@Table(name = "aula", catalog = "mestresensino")
public class Aula implements java.io.Serializable {

	private Integer id;
	private Sala sala;
	private Professor professor;
	private Date inicio;
	private Date fim;
	private Date horarioInicio;
	private Date horarioFim;
	private Set<AlunoAula> alunoAulas = new HashSet<AlunoAula>(0);

	public Aula() {
	}

	public Aula(Sala sala, Professor professor, Date inicio, Date fim,
			Date horarioInicio, Date horarioFim) {
		this.sala = sala;
		this.professor = professor;
		this.inicio = inicio;
		this.fim = fim;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
	}

	public Aula(Sala sala, Professor professor, Date inicio, Date fim,
			Date horarioInicio, Date horarioFim, Set<AlunoAula> alunoAulas) {
		this.sala = sala;
		this.professor = professor;
		this.inicio = inicio;
		this.fim = fim;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sala_id", nullable = false)
	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professor_id", nullable = false)
	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "inicio", nullable = false, length = 10)
	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fim", nullable = false, length = 10)
	public Date getFim() {
		return this.fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "horario_inicio", nullable = false, length = 19)
	public Date getHorarioInicio() {
		return this.horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "horario_fim", nullable = false, length = 19)
	public Date getHorarioFim() {
		return this.horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aula")
	public Set<AlunoAula> getAlunoAulas() {
		return this.alunoAulas;
	}

	public void setAlunoAulas(Set<AlunoAula> alunoAulas) {
		this.alunoAulas = alunoAulas;
	}

}
