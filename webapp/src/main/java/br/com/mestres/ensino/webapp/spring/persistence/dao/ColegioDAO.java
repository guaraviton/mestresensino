package br.com.mestres.ensino.webapp.spring.persistence.dao;

import java.util.List;

import br.com.mestres.ensino.webapp.spring.persistence.model.Colegio;

public interface ColegioDAO {

	List<Colegio> get();

	Colegio get(Integer id);

	List<Colegio> get(String nome);

	void salvar(Colegio colegio);
}
