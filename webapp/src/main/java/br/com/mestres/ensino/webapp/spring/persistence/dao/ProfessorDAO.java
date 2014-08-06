package br.com.mestres.ensino.webapp.spring.persistence.dao;

import java.util.List;

import br.com.mestres.ensino.webapp.spring.persistence.model.Professor;

public interface ProfessorDAO extends CrudDAO<Professor>{

	List<Professor> get(String nome);

	Professor get(Integer id);

	List<Professor> get();
}
