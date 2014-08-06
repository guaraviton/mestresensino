package br.com.mestres.ensino.webapp.spring.service;

import java.util.List;

import br.com.mestres.ensino.webapp.spring.persistence.model.Colegio;


public interface ColegioService extends CrudService<Colegio>{

	List<Colegio> get();

	List<Colegio> get(String nome);

	Colegio get(Integer id);

}
