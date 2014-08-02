package br.com.mestres.ensino.webapp.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import br.com.mestres.ensino.webapp.spring.persistence.model.Colegio;


public interface ColegioService {

	List<Colegio> get();

	List<Colegio> get(String nome);

	Colegio get(Integer id);

	@Transactional
	void salvar(Colegio colegio);
	
}
