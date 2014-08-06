package br.com.mestres.ensino.webapp.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mestres.ensino.webapp.spring.persistence.dao.CrudDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.SalaDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.Sala;
import br.com.mestres.ensino.webapp.spring.service.SalaService;
import br.com.mestres.ensino.webapp.spring.service.helper.CrudServiceImpl;

@Service
public class SalaServiceImpl extends CrudServiceImpl<Sala> implements SalaService{

	@Autowired
	private SalaDAO dao;
	
	@Override
	public List<Sala> getSalas(Integer numero) {
		return dao.getSalas(numero);
	}

	@Override
	public CrudDAO<Sala> getDAO() {
		return dao;
	}

	@Override
	public Sala get(Integer id) {
		return dao.get(id);
	}

	@Override
	public List<Sala> get() {
		return dao.get();
	}
}
