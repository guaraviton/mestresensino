package br.com.mestres.ensino.webapp.spring.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mestres.ensino.webapp.spring.persistence.dao.AlunoAulaDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.CrudDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoAula;
import br.com.mestres.ensino.webapp.spring.service.AlunoAulaService;
import br.com.mestres.ensino.webapp.spring.service.helper.CrudServiceImpl;

@Service
public class AlunoAulaServiceImpl extends CrudServiceImpl<AlunoAula> implements AlunoAulaService{

	@Autowired
	private AlunoAulaDAO dao;
	
	@Override
	public CrudDAO<AlunoAula> getDAO() {
		return dao;
	}

	@Override
	public void excluir(Set<AlunoAula> alunoAulas) {
		if(alunoAulas != null){
			for(AlunoAula alunoAula : alunoAulas){
				dao.excluir(alunoAula);
			}
		}
	}
	
}
