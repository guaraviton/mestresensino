package br.com.mestres.ensino.webapp.spring.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

public interface CrudService<T extends Serializable> {

	@Transactional
	void salvar(T entidade);
	
	@Transactional
	void excluir(T entidade);
	
	List<T> get();
	
	T get(Integer id);
}
