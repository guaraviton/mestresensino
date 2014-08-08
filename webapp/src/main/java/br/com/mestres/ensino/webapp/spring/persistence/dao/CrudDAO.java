package br.com.mestres.ensino.webapp.spring.persistence.dao;

import java.io.Serializable;

public interface CrudDAO<T extends Serializable> {

	void salvar(T entidade);
	
	void excluir(T entidade);
}
