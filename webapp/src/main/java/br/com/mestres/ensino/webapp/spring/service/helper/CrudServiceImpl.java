package br.com.mestres.ensino.webapp.spring.service.helper;

import java.util.List;

import javax.transaction.Transactional;

import br.com.mestres.ensino.webapp.spring.persistence.dao.CrudDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.BaseEntity;
import br.com.mestres.ensino.webapp.spring.service.CrudService;

public abstract class CrudServiceImpl<T extends BaseEntity> implements CrudService<T>{

	public abstract CrudDAO<T> getDAO();
	
	@Transactional
	public void salvar(T entidade) {
		getDAO().salvar(entidade);
	}
	
	@Transactional
	public void excluir(T entidade) {
		getDAO().excluir(entidade);
	}
	
	@Override
	public List<T> get() {
		return getDAO().get();
    }
	
	@Override
	public T get(Integer id) {
		return getDAO().get(id);
	}
}
