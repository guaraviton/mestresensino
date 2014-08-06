package br.com.mestres.ensino.webapp.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mestres.ensino.webapp.spring.persistence.dao.ColegioDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.CrudDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.Aluno;
import br.com.mestres.ensino.webapp.spring.persistence.model.Colegio;
import br.com.mestres.ensino.webapp.spring.service.ColegioService;
import br.com.mestres.ensino.webapp.spring.service.helper.CrudServiceImpl;

@Service
public class ColegioServiceImpl extends CrudServiceImpl<Colegio> implements ColegioService{

	@Autowired
	private ColegioDAO dao;
	
	@Override
	public List<Colegio> get() {
		return dao.get();
	}
	
	@Override
	public List<Colegio> get(String nome) {
		return dao.get(nome);
	}
	
	@Override
	public Colegio get(Integer id) {
		return dao.get(id);
	}

	@Override
	public CrudDAO<Colegio> getDAO() {
		return dao;
	}

}
