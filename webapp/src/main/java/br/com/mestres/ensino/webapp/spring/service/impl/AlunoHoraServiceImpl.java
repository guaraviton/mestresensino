package br.com.mestres.ensino.webapp.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mestres.ensino.webapp.spring.persistence.dao.AlunoHoraDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.CrudDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoHora;
import br.com.mestres.ensino.webapp.spring.service.AlunoHoraService;
import br.com.mestres.ensino.webapp.spring.service.helper.CrudServiceImpl;

@Service
public class AlunoHoraServiceImpl extends CrudServiceImpl<AlunoHora> implements AlunoHoraService{

	@Autowired
	private AlunoHoraDAO dao;
	
	@Override
	public CrudDAO<AlunoHora> getDAO() {
		return dao;
	}

	@Override
	public Integer getHorasCompradas(Integer id) {
		return dao.getHorasCompradas(id);
	}

	@Override
	public Integer getHorasUtilizadas(Integer id) {
		return dao.getHorasUtilizadas(id);
	}
}
