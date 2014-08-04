package br.com.mestres.ensino.webapp.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mestres.ensino.webapp.spring.persistence.dao.ProfessorDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.Professor;
import br.com.mestres.ensino.webapp.spring.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{

	@Autowired
	private ProfessorDAO dao;
	
	@Override
	public void salvar(Professor professor) {
		dao.salvar(professor);
	}


	@Override
	public List<Professor> get(String nome) {
		return dao.get(nome);
	}


	@Override
	public Professor get(Integer id) {
		return dao.get(id);
	}


	@Override
	public List<Professor> get() {
		return dao.get();
	}

}
