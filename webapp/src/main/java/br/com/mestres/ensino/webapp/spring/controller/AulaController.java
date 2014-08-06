package br.com.mestres.ensino.webapp.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.mestres.ensino.webapp.spring.dto.DataTableWrapperDTO;
import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoAula;
import br.com.mestres.ensino.webapp.spring.persistence.model.Aula;
import br.com.mestres.ensino.webapp.spring.persistence.model.Professor;
import br.com.mestres.ensino.webapp.spring.persistence.model.Sala;
import br.com.mestres.ensino.webapp.spring.service.AlunoService;
import br.com.mestres.ensino.webapp.spring.service.AulaService;
import br.com.mestres.ensino.webapp.spring.service.ProfessorService;
import br.com.mestres.ensino.webapp.spring.service.SalaService;
import br.com.mestres.ensino.webapp.spring.util.AppBeanProperties;
import br.com.mestres.ensino.webapp.spring.view.form.AulaForm;

@Controller
@RequestMapping("/aula")
public class AulaController {

	@Autowired
	ProfessorService professorService;
	
	@Autowired
	SalaService salaService;
	
	@Autowired
	AlunoService alunoService;
	
	@Autowired
	AulaService aulaService;
	
	@RequestMapping(value="/editar.html",method = RequestMethod.GET)
    public String editar(Model model) {
		model.addAttribute("professores", professorService.get());
		model.addAttribute("salas", salaService.get());
		model.addAttribute("alunos", alunoService.get(null, null));
        return "aula.editar";
    }
	
	@RequestMapping(value="/index.html",method = RequestMethod.GET)
    public String consultar(Model model) {
		model.addAttribute("professores", professorService.get());
		model.addAttribute("salas", salaService.get());
        return "aula.consultar";
    }
	
	@RequestMapping(value="/{idAula}", method = RequestMethod.GET)
    public String get(@PathVariable Integer idAula, Model model) {
		Aula aula = aulaService.get(idAula);
		model.addAttribute(aula);
		model.addAttribute("professores", professorService.get());
		model.addAttribute("salas", salaService.get());
		model.addAttribute("alunos", alunoService.get(null, null));
		model.addAttribute("alunosSelecionados", getAlunosSelecionados(aula.getAlunoAulas()));
        return "aula.editar";
    }
	
	private List<Integer> getAlunosSelecionados(Set<AlunoAula> alunoAulas) {
		List<Integer> alunosSelecionados = new ArrayList<Integer>();
		for(AlunoAula alunoAula : alunoAulas){
			alunosSelecionados.add(alunoAula.getAluno().getId());
		}
		return alunosSelecionados;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
    public DataTableWrapperDTO get(@RequestParam(required=false) Integer idProfessor,
    		@RequestParam(required=false) Integer idSala) {
        return new DataTableWrapperDTO(aulaService.get(idProfessor, idSala));
    }
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
    public Integer salvar(@Valid @RequestBody AulaForm form) {
		Aula aula = new Aula();
		AppBeanProperties.copyProperties(aula, form);
		
		Professor professor = new Professor();
		professor.setId(form.getIdProfessor());
		aula.setProfessor(professor);
		
		Sala sala = new Sala();
		sala.setId(form.getIdSala());
		aula.setSala(sala);
		
		aulaService.salvar(aula, form.getIdAlunos());
		return aula.getId();
    }
}
