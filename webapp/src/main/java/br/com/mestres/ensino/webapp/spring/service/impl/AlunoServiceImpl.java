package br.com.mestres.ensino.webapp.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mestres.ensino.webapp.spring.persistence.dao.AlunoDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.CrudDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.Aluno;
import br.com.mestres.ensino.webapp.spring.service.AlunoAulaService;
import br.com.mestres.ensino.webapp.spring.service.AlunoHoraService;
import br.com.mestres.ensino.webapp.spring.service.AlunoService;
import br.com.mestres.ensino.webapp.spring.service.helper.CrudServiceImpl;

@Service
public class AlunoServiceImpl extends CrudServiceImpl<Aluno> implements AlunoService{

	@Autowired
	AlunoHoraService alunoHoraService;
	
	@Autowired
	AlunoAulaService alunoAulaService;
	
	@Autowired
	private AlunoDAO dao;
	
	@Override
	public List<Aluno> get(String nome, Integer idColegio) {
		return dao.get(nome, idColegio);
	}

	@Override
	public Aluno get(Integer id) {
		return dao.get(id);
	}

	@Override
	public CrudDAO<Aluno> getDAO() {
		return dao;
	}
	
	@Override
	public void excluir(Aluno aluno) {
		//para evitar deleted object would be re-saved by cascade 
		alunoAulaService.excluir(aluno.getAlunoAulas());
		aluno.setAlunoAulas(null);
		super.excluir(aluno);
	}
}
