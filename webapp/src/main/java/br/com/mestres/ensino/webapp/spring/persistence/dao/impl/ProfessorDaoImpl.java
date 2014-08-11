package br.com.mestres.ensino.webapp.spring.persistence.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.mestres.ensino.webapp.spring.persistence.dao.ProfessorDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.helper.CrudDAOImpl;
import br.com.mestres.ensino.webapp.spring.persistence.model.Professor;
import br.com.mestres.ensino.webapp.spring.util.AppStringUtils;

@Repository
public class ProfessorDaoImpl extends CrudDAOImpl<Professor> implements ProfessorDAO{
	
	public List<Professor> get(String nome) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Professor.class);
		
		if(AppStringUtils.isNotBlank(nome)){
			criteria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
		}
		
        return (List<Professor>) template.findByCriteria(criteria);
    }
}
