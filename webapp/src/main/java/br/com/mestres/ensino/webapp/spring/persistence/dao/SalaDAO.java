package br.com.mestres.ensino.webapp.spring.persistence.dao;

import java.util.List;

import br.com.mestres.ensino.webapp.spring.persistence.model.Sala;

public interface SalaDAO extends CrudDAO<Sala>{

	Sala get(Integer id);

	List<Sala> getSalas(Integer numero);

	List<Sala> get();

}
