package br.com.mestres.ensino.webapp.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import br.com.mestres.ensino.webapp.spring.persistence.model.Aluno;


public interface AlunoService {

	@Transactional
	void salvar(Aluno aluno);
	
	List<Aluno> get(String nome, Integer idColegio);

	Aluno get(Integer id);
	
}
