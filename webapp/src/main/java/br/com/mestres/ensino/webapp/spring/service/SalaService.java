package br.com.mestres.ensino.webapp.spring.service;

import java.util.List;

import br.com.mestres.ensino.webapp.spring.persistence.model.Sala;


public interface SalaService extends CrudService<Sala>{
	
	List<Sala> getSalas(Integer numero);
	
	Sala get(Integer id);
	
	List<Sala> get();
}
