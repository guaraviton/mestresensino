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
import br.com.mestres.ensino.webapp.spring.persistence.model.Colegio;
import br.com.mestres.ensino.webapp.spring.service.ColegioService;
import br.com.mestres.ensino.webapp.spring.util.AppBeanProperties;
import br.com.mestres.ensino.webapp.spring.view.form.ColegioForm;

@Controller
@RequestMapping("/colegio")
public class ColegioController {

	@Autowired
	ColegioService colegioService;
	
	@RequestMapping(value="/editar.html",method = RequestMethod.GET)
    public String editar(Model model) {
        return "colegio.editar";
    }
	
	@RequestMapping(value="/index.html",method = RequestMethod.GET)
    public String consultar(Model model) {
        return "colegio.consultar";
    }
	
	@RequestMapping(value="/{idColegio}", method = RequestMethod.GET)
    public String get(@PathVariable Integer idColegio, Model model) {
		Colegio colegio = colegioService.get(idColegio);
		model.addAttribute(colegio);
        return "colegio.editar";
    }
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
    public DataTableWrapperDTO get(@RequestParam(required=false, defaultValue="") String nome) {
        return new DataTableWrapperDTO(colegioService.get(nome));
    }
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
    public Integer salvar(@Valid @RequestBody ColegioForm form) {
		Colegio colegio = new Colegio();
		AppBeanProperties.copyProperties(colegio, form);
		colegioService.salvar(colegio);
		return colegio.getId();
    }
}
