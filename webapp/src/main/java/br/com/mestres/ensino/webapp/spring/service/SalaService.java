package br.com.mestres.ensino.webapp.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import br.com.mestres.ensino.webapp.spring.persistence.model.Sala;


public interface SalaService {
	
	List<Sala> get();
	
	@Transactional
	void salvar(Sala sala);
	
}
