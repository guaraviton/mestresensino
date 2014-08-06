package br.com.mestres.ensino.webapp.spring.persistence.dao;

import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoAula;

public interface AlunoAulaDAO extends CrudDAO<AlunoAula>{

	AlunoAula get(Integer id);

}
