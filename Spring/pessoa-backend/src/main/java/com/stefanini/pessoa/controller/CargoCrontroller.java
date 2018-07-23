package com.stefanini.pessoa.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stefanini.pessoa.entidades.Cargo;
import com.stefanini.pessoa.repository.CargoRepository;
import com.stefanini.pessoa.service.CargoService;

@RestController
@RequestMapping("/stefa/cargo")
public class CargoCrontroller {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private CargoService cargoService;
	
	@PostMapping
	public ResponseEntity<Cargo> cadastrar(@Valid @RequestBody Cargo cargo){
		Cargo cargoSalvo = cargoRepository.save(cargo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(cargoSalvo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(cargoSalvo);
	}
	
	@GetMapping
	public List<Cargo> buscarTodos(){
		
		return cargoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cargo> buscarPeloId(@PathVariable Long id){
		Cargo cargo = cargoService.buscarPeloId(id);
		
		return ResponseEntity.ok(cargo);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cargo> atualizar (@PathVariable Long id, @Valid @RequestBody Cargo cargo){
		
		Cargo cargoSalvo = cargoService.atualizar(id,cargo);
		
		return  ResponseEntity.ok(cargoSalvo);
		
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletar (@PathVariable Long id) {
		cargoRepository.delete(id);
	}
	

}
