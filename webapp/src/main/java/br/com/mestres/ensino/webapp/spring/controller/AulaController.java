package br.com.mestres.ensino.webapp.spring.controller;

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
import br.com.mestres.ensino.webapp.spring.service.AlunoService;
import br.com.mestres.ensino.webapp.spring.service.ProfessorService;
import br.com.mestres.ensino.webapp.spring.service.SalaService;
import br.com.mestres.ensino.webapp.spring.view.form.ColegioForm;

@Controller
@RequestMapping("/aula")
public class AulaController {

	@Autowired
	ProfessorService professorService;
	
	@Autowired
	SalaService salaService;
	
	@Autowired
	AlunoService alunoService;
	
	@RequestMapping(value="/editar.html",method = RequestMethod.GET)
    public String editar(Model model) {
		model.addAttribute("professores", professorService.get());
		model.addAttribute("salas", salaService.get());
		model.addAttribute("alunos", alunoService.get(null, null));
        return "aula.editar";
    }
	
	@RequestMapping(value="/index.html",method = RequestMethod.GET)
    public String consultar(Model model) {
        return "aula.consultar";
    }
	
	@RequestMapping(value="/{idColegio}", method = RequestMethod.GET)
    public String get(@PathVariable Integer idColegio, Model model) {
        return "aula.editar";
    }
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
    public DataTableWrapperDTO get(@RequestParam(required=false, defaultValue="") String nome) {
        return new DataTableWrapperDTO(null);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
    public Integer salvar(@Valid @RequestBody ColegioForm form) {
		return null;
    }
}
