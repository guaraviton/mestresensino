package br.com.mestres.ensino.webapp.spring.service;

import java.util.List;

import br.com.mestres.ensino.webapp.spring.persistence.model.Aluno;


public interface AlunoService extends CrudService<Aluno>{

	List<Aluno> get(String nome, Integer idColegio);

	Aluno get(Integer id);

}
