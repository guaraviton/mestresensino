package br.com.mestres.ensino.webapp.spring.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.mestres.ensino.webapp.spring.persistence.dao.AlunoHoraDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.helper.CrudDAOImpl;
import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoHora;

@Repository
public class AlunoHoraDaoImpl extends CrudDAOImpl<AlunoHora> implements AlunoHoraDAO{

	@Override
	public Integer getHorasCompradas(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select sum(alh.quantidade) ")
		.append(" from Aluno alu")
		
		.append(" join alu.alunoHoras alh ")
		.append(" where alu.id = ? ")
		.append(" group by alu.id"); 
		
		List<Long> resultado = (List<Long>) template.find(sql.toString(), id);
		return resultado.isEmpty() ? 0 : Integer.parseInt(resultado.iterator().next().toString());
	}
	
	@Override
	public Integer getHorasUtilizadas(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select sum(aul.horas) ")
		.append(" from Aluno alu")
		.append(" join alu.alunoAulas ala ")
		.append(" join ala.aula aul")
		.append(" where alu.id = ? ")
		.append(" group by alu.id"); 
		
		List<Long> resultado = (List<Long>) template.find(sql.toString(), id);
		return resultado.isEmpty() ? 0 : Integer.parseInt(resultado.iterator().next().toString());
	}
	
}
