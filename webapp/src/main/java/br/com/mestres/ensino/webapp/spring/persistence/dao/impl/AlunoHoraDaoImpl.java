package br.com.mestres.ensino.webapp.spring.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.mestres.ensino.webapp.spring.persistence.dao.AlunoHoraDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.helper.CrudDAOImpl;
import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoHora;

@Repository
public class AlunoHoraDaoImpl extends CrudDAOImpl<AlunoHora> implements AlunoHoraDAO{
	
}
