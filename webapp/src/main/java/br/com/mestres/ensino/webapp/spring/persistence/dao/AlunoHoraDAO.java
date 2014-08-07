package br.com.mestres.ensino.webapp.spring.persistence.dao;

import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoHora;

public interface AlunoHoraDAO extends CrudDAO<AlunoHora>{
	
	Integer getHorasCompradas(Integer id);
	
	Integer getHorasUtilizadas(Integer id);
	
}
