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
import br.com.mestres.ensino.webapp.spring.persistence.model.Sala;
import br.com.mestres.ensino.webapp.spring.service.SalaService;
import br.com.mestres.ensino.webapp.spring.util.AppBeanProperties;
import br.com.mestres.ensino.webapp.spring.util.AppNumberUtils;
import br.com.mestres.ensino.webapp.spring.view.form.SalaForm;

@Controller
@RequestMapping("/sala")
public class SalaController {

	@Autowired
	SalaService salaService;
	
	@RequestMapping(value="/editar.html",method = RequestMethod.GET)
    public String editar(Model model) {
        return "sala.editar";
    }
	
	@RequestMapping(value="/index.html",method = RequestMethod.GET)
    public String consultar(Model model) {
        return "sala.consultar";
    }
	
	@RequestMapping(value="/{idSala}", method = RequestMethod.GET)
    public String get(@PathVariable Integer idSala, Model model) {
		Sala sala = salaService.get(idSala);
		model.addAttribute(sala);
        return "sala.editar";
    }
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
    public DataTableWrapperDTO get(@RequestParam(required=false) Integer numero) {
        return new DataTableWrapperDTO(salaService.getSalas(numero));
    }
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
    public Integer salvar(@Valid @RequestBody SalaForm form) {
		Sala sala = new Sala();
		AppBeanProperties.copyProperties(sala, form);
		sala.setAssentosDisponiveis(AppNumberUtils.converte(form.getAssentosDisponiveis()));
		salaService.salvar(sala);
		return sala.getId();
    }
}
