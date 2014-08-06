package br.com.mestres.ensino.webapp.spring.service;

import java.io.Serializable;

import javax.transaction.Transactional;

public interface CrudService<T extends Serializable> {

	@Transactional
	void salvar(T entidade);
}
