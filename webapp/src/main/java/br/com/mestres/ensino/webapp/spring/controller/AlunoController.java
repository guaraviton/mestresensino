package br.com.mestres.ensino.webapp.spring.controller;

import java.util.Calendar;

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
import br.com.mestres.ensino.webapp.spring.persistence.model.Aluno;
import br.com.mestres.ensino.webapp.spring.persistence.model.AlunoHora;
import br.com.mestres.ensino.webapp.spring.persistence.model.Colegio;
import br.com.mestres.ensino.webapp.spring.service.AlunoAulaService;
import br.com.mestres.ensino.webapp.spring.service.AlunoHoraService;
import br.com.mestres.ensino.webapp.spring.service.AlunoService;
import br.com.mestres.ensino.webapp.spring.service.ColegioService;
import br.com.mestres.ensino.webapp.spring.util.AppBeanProperties;
import br.com.mestres.ensino.webapp.spring.view.form.AlunoForm;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	AlunoAulaService alunoAulaService;
	
	@Autowired
	AlunoHoraService alunoHoraService;
	
	@Autowired
	ColegioService colegioService;
	
	@RequestMapping(value="/{idAluno}/horas",method = RequestMethod.POST)
	@ResponseBody
    public Integer incluirHoras(@PathVariable Integer idAluno,@RequestParam(required=false) Integer quantidade) {
		Aluno aluno = alunoService.get(idAluno);
		AlunoHora alunoHora = new AlunoHora(aluno, quantidade, Calendar.getInstance().getTime());
		alunoHoraService.salvar(alunoHora);
		return alunoHoraService.getHorasDisponiveis(idAluno);
    }
	
	@RequestMapping(value="/editar.html",method = RequestMethod.GET)
    public String editar(Model model) {
		model.addAttribute("colegios", colegioService.get());
        return "aluno.editar";
    }
	
	@RequestMapping(value="/index.html",method = RequestMethod.GET)
    public String consultar(Model model) {
		model.addAttribute("colegios", colegioService.get());
        return "aluno.consultar";
    }
	
	@RequestMapping(value="/{idAluno}", method = RequestMethod.GET)
    public String get(@PathVariable Integer idAluno, Model model) {
		Aluno aluno = alunoService.get(idAluno);
		model.addAttribute(aluno);
		model.addAttribute("colegios", colegioService.get());
		model.addAttribute("quantidadeHorasDisponiveis", alunoHoraService.getHorasDisponiveis(idAluno));
        return "aluno.editar";
    }
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
    public DataTableWrapperDTO get(@RequestParam(required=false, defaultValue="") String nome, @RequestParam(required=false) Integer idColegio) {
        return new DataTableWrapperDTO(alunoService.get(nome, idColegio));
    }
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
    public Integer salvar(@Valid @RequestBody AlunoForm form) {
		Aluno aluno = new Aluno();
		AppBeanProperties.copyProperties(aluno, form);
		
		if(form.getIdColegio() == null){
			aluno.setColegio(null);
		}else{
			Colegio colegio = new Colegio();
			colegio.setId(form.getIdColegio());
			aluno.setColegio(colegio);
		}
		
		if(form.getId() == null && form.getQuantidadeHorasCompradas() != null){
			AlunoHora alunoHora = new AlunoHora(aluno, form.getQuantidadeHorasCompradas(), Calendar.getInstance().getTime());
			aluno.getAlunoHoras().add(alunoHora);
		}
		
		alunoService.salvar(aluno);
		
		return aluno.getId();
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
    public void excluir(@Valid @RequestBody AlunoForm form) {
		Aluno aluno = alunoService.get(form.getId());
		alunoService.excluir(aluno);
	}
}
