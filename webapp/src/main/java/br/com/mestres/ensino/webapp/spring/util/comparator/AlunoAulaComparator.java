package br.com.mestres.ensino.webapp.spring.util.comparator;

import java.util.Comparator;

import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoAula;

public class AlunoAulaComparator implements Comparator<AlunoAula>{

	@Override
	public int compare(AlunoAula o1, AlunoAula o2) {
		if(o1.getAluno().getNome() == null || o2.getAluno().getNome() == null){
			return 1;
		}
		return o1.getAluno().getNome().compareTo(o2.getAluno().getNome());
	}
	
}
