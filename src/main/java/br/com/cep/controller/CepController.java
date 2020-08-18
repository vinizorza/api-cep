package br.com.cep.controller;

import br.com.cep.dto.CepDTO;
import br.com.cep.model.Cep;
import br.com.cep.repository.CepRepositorio;
import br.com.cep.repository.ViacepClient;
import br.com.cep.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CepController {

	@Autowired
	CepRepositorio cepRepositorio;

	@Autowired
	ViacepClient viacepClient;

	@GetMapping("/cep/{cep}")
	public CepDTO findCep(@PathVariable("cep") String id) {
		Cep cep = cepRepositorio.findById(id).orElse(null);
		if(cep == null){
			cep = viacepClient.findCep(id);
			cep = cepRepositorio.save(cep);
		}
		return Converter.convertFromEntity(cep);
	}

	@GetMapping("/ceps")
	public List<CepDTO> listCepByCidade(@RequestParam String ibge,
									 @RequestParam String uf){
		return Converter.convertFromEntity(cepRepositorio.listByCidade(ibge, uf));
	}

}
