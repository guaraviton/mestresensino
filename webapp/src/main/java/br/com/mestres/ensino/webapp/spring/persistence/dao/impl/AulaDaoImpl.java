package br.com.mestres.ensino.webapp.spring.persistence.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.mestres.ensino.webapp.spring.persistence.dao.AulaDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.helper.CrudDAOImpl;
import br.com.mestres.ensino.webapp.spring.persistence.model.Aula;

@Repository
public class AulaDaoImpl extends CrudDAOImpl<Aula> implements AulaDAO{
	
	@Override
	public Aula get(Integer id) {
		return template.get(Aula.class, id);
	}

	@Override
	public List<Aula> get(Integer idProfessor, Integer idSala) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Aula.class);
		
		if(idProfessor != null){
			criteria.add(Restrictions.eq("professor.id", idProfessor));
		}
		
		if(idSala != null){
			criteria.add(Restrictions.eq("sala.id", idSala));
		}
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
        return (List<Aula>) template.findByCriteria(criteria);
	}
}
