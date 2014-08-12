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
import br.com.mestres.ensino.webapp.spring.persistence.model.Professor;
import br.com.mestres.ensino.webapp.spring.service.ProfessorService;
import br.com.mestres.ensino.webapp.spring.util.AppBeanProperties;
import br.com.mestres.ensino.webapp.spring.view.form.ProfessorForm;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;
	
	@RequestMapping(value="/editar.html",method = RequestMethod.GET)
    public String editar(Model model) {
        return "professor.editar";
    }
	
	@RequestMapping(value="/index.html",method = RequestMethod.GET)
    public String consultar(Model model) {
        return "professor.consultar";
    }
	
	@RequestMapping(value="/{idProfessor}", method = RequestMethod.GET)
    public String get(@PathVariable Integer idProfessor, Model model) {
		Professor professor = professorService.get(idProfessor);
		model.addAttribute(professor);
        return "professor.editar";
    }
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
    public DataTableWrapperDTO get(@RequestParam(required=false, defaultValue="") String nome) {
        return new DataTableWrapperDTO(professorService.get(nome));
    }
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
    public Integer salvar(@Valid @RequestBody ProfessorForm form) {
		Professor professor = professorService.get(form.getId());
		if(professor == null){
			professor = new Professor();
		}
		AppBeanProperties.copyProperties(professor, form);
		professorService.salvar(professor);
		return professor.getId();
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
    public void excluir(@Valid @RequestBody ProfessorForm form) {
		Professor professor = professorService.get(form.getId());
		professorService.excluir(professor);
	}
}
