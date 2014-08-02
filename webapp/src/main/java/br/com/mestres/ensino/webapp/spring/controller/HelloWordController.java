package br.com.mestres.ensino.webapp.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWordController {

	@RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "Hello Word";
    }
	
}
