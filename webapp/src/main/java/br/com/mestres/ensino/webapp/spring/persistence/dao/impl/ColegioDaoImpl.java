package br.com.mestres.ensino.webapp.spring.persistence.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.mestres.ensino.webapp.spring.persistence.dao.ColegioDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.helper.CrudDAOImpl;
import br.com.mestres.ensino.webapp.spring.persistence.model.Colegio;
import br.com.mestres.ensino.webapp.spring.util.AppStringUtils;

@Repository
public class ColegioDaoImpl extends CrudDAOImpl<Colegio> implements ColegioDAO{
	
	@Override
	public List<Colegio> get(String nome) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Colegio.class);
		
		if(AppStringUtils.isNotBlank(nome)){
			criteria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
		}
		
        return (List<Colegio>) template.findByCriteria(criteria);
	}
}
