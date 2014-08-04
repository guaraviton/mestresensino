package br.com.mestres.ensino.webapp.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import br.com.mestres.ensino.webapp.spring.persistence.model.Colegio;
import br.com.mestres.ensino.webapp.spring.persistence.model.Professor;


public interface ProfessorService {
	
	List<Professor> get();
	
	@Transactional
	void salvar(Professor aluno);
	
	List<Professor> get(String nome);

	Professor get(Integer id);
	
}
