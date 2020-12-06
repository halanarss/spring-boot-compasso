package br.com.hrss.springbootcompasso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hrss.springbootcompasso.data.entity.Cliente;
import br.com.hrss.springbootcompasso.data.vo.ClienteVO;
import br.com.hrss.springbootcompasso.services.ClienteServices;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteServices service;

	@GetMapping
	public List<ClienteVO> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ClienteVO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping(value = "/findClientByName/{nomeCompleto}")
	public ClienteVO findClientByName(@PathVariable("nomeCompleto") String nomeCompleto) {
		return service.findClientByName(nomeCompleto);

	}

	@PostMapping
	public ClienteVO create(@RequestBody Cliente cliente) {
		return service.create(cliente);
	}

	@PutMapping
	public ClienteVO updateNameClient(@RequestBody ClienteVO cliente) {
		return service.updateNameClient(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
		
}
