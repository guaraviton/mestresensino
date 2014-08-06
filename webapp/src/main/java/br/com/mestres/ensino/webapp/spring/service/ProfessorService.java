package br.com.mestres.ensino.webapp.spring.service;

import java.util.List;

import br.com.mestres.ensino.webapp.spring.persistence.model.Professor;


public interface ProfessorService extends CrudService<Professor>{
	
	List<Professor> get();
	
	List<Professor> get(String nome);

	Professor get(Integer id);
	
}
