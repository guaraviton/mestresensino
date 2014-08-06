package br.com.mestres.ensino.webapp.spring.persistence.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.mestres.ensino.webapp.spring.persistence.dao.SalaDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.helper.CrudDAOImpl;
import br.com.mestres.ensino.webapp.spring.persistence.model.Sala;

@Repository
public class SalaDaoImpl extends CrudDAOImpl<Sala> implements SalaDAO{
	
	@Override
	public Sala get(Integer id) {
		return template.get(Sala.class, id);
	}

	@Override
	public List<Sala> getSalas(Integer numero) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Sala.class);
		
		if(numero != null){
			criteria.add(Restrictions.eq("numero", numero));
		}
		
        return (List<Sala>) template.findByCriteria(criteria);
	}

	@Override
	public List<Sala> get() {
		return (List<Sala>) template.find("from Sala");
	}
}
