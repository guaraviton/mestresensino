package br.com.mestres.ensino.webapp.spring.service;

import java.util.Date;
import java.util.List;

import br.com.mestres.ensino.webapp.spring.persistence.model.Aula;


public interface AulaService extends CrudService<Aula>{

	Aula get(Integer idAula);

	List<Aula> get(Integer idProfessor, Integer idSala);
	
	boolean isHorarioIndisponivel(Integer idAula, Integer idAluno, Integer idProfessor, Integer idSala, Date dataAula, String horarioAula, Integer horas);

}
