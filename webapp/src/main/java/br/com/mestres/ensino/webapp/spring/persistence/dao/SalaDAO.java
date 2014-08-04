package br.com.mestres.ensino.webapp.spring.persistence.dao;

import java.util.List;

import br.com.mestres.ensino.webapp.spring.persistence.model.Sala;

public interface SalaDAO {

	void salvar(Sala sala);
	
	List<Sala> get();

}
