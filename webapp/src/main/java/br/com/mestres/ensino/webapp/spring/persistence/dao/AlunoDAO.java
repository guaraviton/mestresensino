package br.com.mestres.ensino.webapp.spring.persistence.dao;

import java.util.List;

import br.com.mestres.ensino.webapp.spring.persistence.model.Aluno;

public interface AlunoDAO {

	void salvar(Aluno aluno);
	
	List<Aluno> get(String nome, Integer idColegio);

	Aluno get(Integer id);

}
