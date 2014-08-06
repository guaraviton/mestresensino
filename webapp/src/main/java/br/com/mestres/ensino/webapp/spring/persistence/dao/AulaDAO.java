package br.com.mestres.ensino.webapp.spring.persistence.dao;

import java.util.List;

import br.com.mestres.ensino.webapp.spring.persistence.model.Aula;

public interface AulaDAO extends CrudDAO<Aula>{

	Aula get(Integer id);

	List<Aula> get(Integer idProfessor, Integer idSala);

}
