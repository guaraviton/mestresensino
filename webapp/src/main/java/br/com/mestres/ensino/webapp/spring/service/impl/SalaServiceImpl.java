package br.com.mestres.ensino.webapp.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mestres.ensino.webapp.spring.persistence.dao.SalaDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.Sala;
import br.com.mestres.ensino.webapp.spring.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService{

	@Autowired
	private SalaDAO dao;
	
	@Override
	public void salvar(Sala sala) {
		dao.salvar(sala);
	}

	@Override
	public List<Sala> get() {
		return dao.get();
	}



}
