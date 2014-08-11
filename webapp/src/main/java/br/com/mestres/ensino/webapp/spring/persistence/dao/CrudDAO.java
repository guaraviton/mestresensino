package br.com.mestres.ensino.webapp.spring.persistence.dao;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO<T extends Serializable> {

	void salvar(T entidade);
	
	void excluir(T entidade);
	
	List<T> get();
	
	T get(Integer id);
}
