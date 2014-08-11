package br.com.mestres.ensino.webapp.spring.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mestres.ensino.webapp.spring.exception.AppBusinessException;
import br.com.mestres.ensino.webapp.spring.persistence.dao.AulaDAO;
import br.com.mestres.ensino.webapp.spring.persistence.dao.CrudDAO;
import br.com.mestres.ensino.webapp.spring.persistence.model.Aluno;
import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoAula;
import br.com.mestres.ensino.webapp.spring.persistence.model.Aula;
import br.com.mestres.ensino.webapp.spring.service.AlunoHoraService;
import br.com.mestres.ensino.webapp.spring.service.AlunoService;
import br.com.mestres.ensino.webapp.spring.service.AulaService;
import br.com.mestres.ensino.webapp.spring.service.helper.CrudServiceImpl;
import br.com.mestres.ensino.webapp.spring.util.message.AppMessageUtils;

@Service
public class AulaServiceImpl extends CrudServiceImpl<Aula> implements AulaService{

	@Autowired
	private AulaDAO dao;
	
	@Autowired
	private AlunoHoraService alunoHoraService;
	
	@Autowired
	private AlunoService alunoService;
	
	@Override
	public CrudDAO<Aula> getDAO() {
		return dao;
	}

	@Override
	public List<Aula> get(Integer idProfessor, Integer idSala) {
		return dao.get(idProfessor, idSala);
	}
	
	@Override
	public void salvar(Aula aula) {
		
		verificarHorasDisponiveisAluno(aula);
		
		verificarDisponibilidadeProfessor(aula);
		
		verificarDisponibilidadeSala(aula);
		
		verificarDisponibilidadeAluno(aula);
		
		super.salvar(aula);
	}

	private void verificarDisponibilidadeAluno(Aula aula) {
		StringBuilder sb = new StringBuilder("");
		boolean plural = false;
		int i = 1;
		for(AlunoAula alunoAula : aula.getAlunoAulas()){
			if(!isHorarioIndisponivel(aula.getId(), alunoAula.getAluno().getId(), null, null, aula.getData(), aula.getHorario(), aula.getHoras())){
				if(!sb.toString().equals("")){
					plural = true;
					if(i == aula.getAlunoAulas().size()){
						sb.append(" " + AppMessageUtils.get("label.e") + " ");
					}else{
						sb.append(", ");
					}
				}
				
				sb.append(alunoAula.getAluno().getNome());
				
				i++;
			}
		}
		if(!sb.toString().equals("")){
			String key;
			if(plural){
				key = "alunos.nao.possuem.disponibilidade";
			}else{
				key = "aluno.nao.possui.disponibilidade";
			}
			throw new AppBusinessException(AppMessageUtils.get(key, sb.toString()));
		}
	}
	
	private void verificarDisponibilidadeProfessor(Aula aula) {
		if(!isHorarioIndisponivel(aula.getId(), null, aula.getProfessor().getId(), null, aula.getData(), aula.getHorario(), aula.getHoras())){
			throw new AppBusinessException(AppMessageUtils.get("professor.nao.possui.disponibilidade"));
		}
	}
	
	private void verificarDisponibilidadeSala(Aula aula) {
		if(!isHorarioIndisponivel(aula.getId(), null, null, aula.getSala().getId(), aula.getData(), aula.getHorario(), aula.getHoras())){
			throw new AppBusinessException(AppMessageUtils.get("sala.nao.possui.disponibilidade"));
		}
	}

	private void verificarHorasDisponiveisAluno(Aula aula) {
		StringBuilder sb = new StringBuilder("");
		int i = 1;
		boolean plural = false;
		for(AlunoAula alunoAulas : aula.getAlunoAulas()){
			if(!isSaldoHorasSuficiente(alunoAulas.getAluno(), aula.getHoras())){
				if(!sb.toString().equals("")){
					if(i == aula.getAlunoAulas().size()){
						sb.append(" " + AppMessageUtils.get("label.e") + " ");
					}else{
						sb.append(", ");
					}
				}
				sb.append(alunoService.get(alunoAulas.getAluno().getId()).getNome());
				if(i > 1){
					plural = true;
				}
			}
			i++;
		}
		
		if(!sb.toString().equals("")){
			String key;
			if(plural){
				key = "alunos.nao.possuem.horas.suficientes";
			}else{
				key = "aluno.nao.possui.horas.suficientes";
			}
			throw new AppBusinessException(AppMessageUtils.get(key, sb.toString()));
		}
	}

	private boolean isSaldoHorasSuficiente(Aluno aluno, Integer horas) {
		if(alunoHoraService.getHorasDisponiveis(aluno.getId()) < horas){
			return false;
		}
		return true;
	}

	@Override
	public boolean isHorarioIndisponivel(Integer idAula, Integer idAluno,
			Integer idProfessor, Integer idSala, Date dataAula, String horarioAula, Integer horas) {
		return dao.isHorarioIndisponivel(idAula, idAluno, idProfessor, idSala, dataAula, horarioAula, horas);
	}
}
