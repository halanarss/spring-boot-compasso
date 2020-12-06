package br.com.hrss.springbootcompasso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hrss.springbootcompasso.data.entity.Cidade;
import br.com.hrss.springbootcompasso.data.vo.CidadeVO;
import br.com.hrss.springbootcompasso.services.CidadeServices;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private CidadeServices service;

	@GetMapping
	public List<CidadeVO> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public CidadeVO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@PostMapping
	public CidadeVO create(@RequestBody Cidade cidade) {
		return service.create(cidade);
	}

	@GetMapping(value = "/findCityByName/{nomeCidade}")
	public CidadeVO findCityByName(@PathVariable("nomeCidade") String nomeCidade) {
		return service.findCityByName(nomeCidade);

	}
	
	@GetMapping(value = "/findCityByState/{estado}")
	public CidadeVO findCityByState(@PathVariable("estado") String estado) {
		return service.findCityByState(estado);

	}

}
