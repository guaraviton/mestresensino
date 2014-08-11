package br.com.mestres.ensino.webapp.spring.persistence.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.mestres.ensino.webapp.spring.persistence.dao.AulaDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.helper.CrudDAOImpl;
import br.com.mestres.ensino.webapp.spring.persistence.model.Aula;
import br.com.mestres.ensino.webapp.spring.util.AppDateUtils;

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

	@Override
	public boolean isHorarioIndisponivel(Integer idAula, Integer idAluno, Integer idProfessor,
			Integer idSala, Date dataAula, String horarioAula, Integer horas) {
		
		List<Object> parametros = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder("");
		sql.append(" select 1")
		.append(" from Aula aul")
		.append(" join aul.alunoAulas ala ")
		.append(" where ");
		
		if(idAluno != null){
			parametros.add(idAluno);
			sql.append(" ala.aluno.id = ? ");
		}
		
		if(idSala != null){
			parametros.add(idSala);
			sql.append(" aul.sala.id = ?");
		}
		
		if(idProfessor != null){
			parametros.add(idProfessor);
			sql.append(" aul.professor.id = ? ");
		}
		
		if(idAula != null){
			parametros.add(idAula);
			sql.append(" and aul.id <> ? ");
		}
		
		sql.append(" and ((STR_TO_DATE('"+AppDateUtils.format(dataAula)+horarioAula+"','%d/%m/%Y%H:%i')")
		.append(" between STR_TO_DATE(concat(aul.data, aul.horario),'%Y-%m-%d%H:%i')")
		.append(" and")
		.append(" addTime(STR_TO_DATE(concat(aul.data, aul.horario),'%Y-%m-%d%H:%i'), concat(aul.horas, ':0:0')))")
		.append(" or (addTime(STR_TO_DATE('"+AppDateUtils.format(dataAula)+horarioAula+"','%d/%m/%Y%H:%i'), concat("+horas+", ':0:0'))")
		.append(" between STR_TO_DATE(concat(aul.data, aul.horario),'%Y-%m-%d%H:%i')")
		.append(" and")
		.append(" addTime(STR_TO_DATE(concat(aul.data, aul.horario),'%Y-%m-%d%H:%i'), concat(aul.horas, ':0:0'))))");
		
		return template.find(sql.toString(), parametros.toArray()).isEmpty();
	}
}
