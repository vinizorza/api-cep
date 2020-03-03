package br.com.cep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepController {

	@GetMapping("/helloworld")
	public String findCep() {
		return "Olá mundo!";
	}

}
