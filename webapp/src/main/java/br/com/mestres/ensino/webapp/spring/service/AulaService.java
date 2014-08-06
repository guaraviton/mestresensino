package br.com.mestres.ensino.webapp.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import br.com.mestres.ensino.webapp.spring.persistence.model.Aula;


public interface AulaService extends CrudService<Aula>{

	@Transactional
	void salvar(Aula aula, Integer[] idAlunos);

	Aula get(Integer idAula);

	List<Aula> get(Integer idProfessor, Integer idSala);

}
