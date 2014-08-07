package br.com.mestres.ensino.webapp.spring.view.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.mestres.ensino.webapp.spring.config.json.serializer.CustomDateDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class AulaForm {

	private Integer id;
	
	@NotNull
	private Integer idProfessor;
	
	@NotNull
	private Integer idSala;
	
	@NotNull
	private String[] idAlunos;
	
	@NotNull
	private Date data;
	
	@NotEmpty
	private String horario;
	
	@NotNull
	private Integer horas;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Integer getIdSala() {
		return idSala;
	}

	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}

	public String[] getIdAlunos() {
		return idAlunos;
	}

	public void setIdAlunos(String[] idAlunos) {
		this.idAlunos = idAlunos;
	}

	public Date getData() {
		return data;
	}
	
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setData(Date data) {
		this.data = data;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
}
