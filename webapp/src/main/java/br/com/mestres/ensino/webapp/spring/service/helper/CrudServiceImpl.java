package br.com.mestres.ensino.webapp.spring.service.helper;

import java.io.Serializable;

import javax.transaction.Transactional;

import br.com.mestres.ensino.webapp.spring.persistence.dao.CrudDAO;

public abstract class CrudServiceImpl<T extends Serializable> {

	public abstract CrudDAO<T> getDAO();
	
	@Transactional
	public void salvar(T entidade) {
		getDAO().salvar(entidade);
	}
}
