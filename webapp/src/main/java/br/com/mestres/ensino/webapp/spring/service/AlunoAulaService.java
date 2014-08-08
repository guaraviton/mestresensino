package br.com.mestres.ensino.webapp.spring.service;

import java.util.Set;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoAula;


public interface AlunoAulaService extends CrudService<AlunoAula>{

	@Transactional(value=TxType.MANDATORY)
	void excluir(Set<AlunoAula> alunoAulas);

}
