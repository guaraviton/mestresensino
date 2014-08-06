package br.com.mestres.ensino.webapp.spring.persistence.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.mestres.ensino.webapp.spring.persistence.dao.AlunoDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.helper.CrudDAOImpl;
import br.com.mestres.ensino.webapp.spring.persistence.model.Aluno;
import br.com.mestres.ensino.webapp.spring.util.AppStringUtils;

@Repository
public class AlunoDaoImpl extends CrudDAOImpl<Aluno> implements AlunoDAO{
	
	public List<Aluno> get(String nome, Integer idColegio) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Aluno.class);
		
		if(AppStringUtils.isNotBlank(nome)){
			criteria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
		}
		
		if(idColegio != null){
			criteria.add(Restrictions.eq("colegio.id", idColegio));
		}
		
        return (List<Aluno>) template.findByCriteria(criteria);
    }

	@Override
	public Aluno get(Integer id) {
		return template.get(Aluno.class, id);
	}
}
