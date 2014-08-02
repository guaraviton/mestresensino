package br.com.mestres.ensino.webapp.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mestres.ensino.webapp.spring.persistence.dao.AlunoDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.Aluno;
import br.com.mestres.ensino.webapp.spring.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{

	@Autowired
	private AlunoDAO dao;
	
	@Override
	public void salvar(Aluno aluno) {
		dao.salvar(aluno);
	}

	@Override
	public List<Aluno> get(String nome, Integer idColegio) {
		return dao.get(nome, idColegio);
	}


	@Override
	public Aluno get(Integer id) {
		return dao.get(id);
	}

}
