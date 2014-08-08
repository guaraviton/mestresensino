package br.com.mestres.ensino.webapp.spring.service;

import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoHora;


public interface AlunoHoraService extends CrudService<AlunoHora>{

	Integer getHorasCompradas(Integer id);
	Integer getHorasUtilizadas(Integer id);
	Integer getHorasDisponiveis(Integer id);
}
