package br.com.mestres.ensino.webapp.spring.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.mestres.ensino.webapp.spring.persistence.dao.AlunoAulaDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.helper.CrudDAOImpl;
import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoAula;

@Repository
public class AlunoAulaDaoImpl extends CrudDAOImpl<AlunoAula> implements AlunoAulaDAO{
	
	@Override
	public AlunoAula get(Integer id) {
		return template.get(AlunoAula.class, id);
	}
}
