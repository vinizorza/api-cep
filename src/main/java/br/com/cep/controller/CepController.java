package br.com.cep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@RestController
public class CepController{
  
  @GetMapping("/helloworld")
  public String findCep() throws NotFoundException{
	 
    return "Olá mundo!";
  }


}
