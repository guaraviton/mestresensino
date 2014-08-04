package br.com.mestres.ensino.webapp.spring.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.mestres.ensino.webapp.spring.persistence.dao.SalaDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.helper.DAOTemplate;
import br.com.mestres.ensino.webapp.spring.persistence.model.Sala;

@Repository
public class SalaDaoImpl extends DAOTemplate implements SalaDAO{
	
	@Override
	public void salvar(Sala sala) {
		template.saveOrUpdate(sala);
	}
	
	public List<Sala> get() {
		return (List<Sala>) template.find("from Sala");
	}
}
