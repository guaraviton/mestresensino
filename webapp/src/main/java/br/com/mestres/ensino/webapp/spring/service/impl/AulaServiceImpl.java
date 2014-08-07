package br.com.mestres.ensino.webapp.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mestres.ensino.webapp.spring.persistence.dao.AulaDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.CrudDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.Aula;
import br.com.mestres.ensino.webapp.spring.service.AlunoAulaService;
import br.com.mestres.ensino.webapp.spring.service.AulaService;
import br.com.mestres.ensino.webapp.spring.service.helper.CrudServiceImpl;

@Service
public class AulaServiceImpl extends CrudServiceImpl<Aula> implements AulaService{

	@Autowired
	private AulaDAO dao;
	
	@Autowired
	private AlunoAulaService alunoAulaService;
	
	@Override
	public CrudDAO<Aula> getDAO() {
		return dao;
	}

	@Override
	public Aula get(Integer id) {
		return dao.get(id);
	}

	@Override
	public List<Aula> get(Integer idProfessor, Integer idSala) {
		return dao.get(idProfessor, idSala);
	}
}
