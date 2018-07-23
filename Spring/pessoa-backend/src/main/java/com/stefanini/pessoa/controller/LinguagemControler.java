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

import com.stefanini.pessoa.entidades.Linguagem;
import com.stefanini.pessoa.repository.LinguagemRepository;
import com.stefanini.pessoa.service.LinguagemService;

@RestController
@RequestMapping("stefa/linguagem")
public class LinguagemControler {
	
	@Autowired
	private LinguagemRepository linguagemRepository;
	
	@Autowired
	private LinguagemService linguagemService;
	
	@PostMapping
	public ResponseEntity<Linguagem> cadastrar(@Valid @RequestBody Linguagem linguagem){
		Linguagem linguagemSalva = linguagemRepository.save(linguagem);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(linguagemSalva.getId()).toUri();
		
		
		return ResponseEntity.created(uri).body(linguagemSalva);
	}

	@GetMapping
	public List<Linguagem> buscarTodas(){
		
		return linguagemRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Linguagem> buscarPeloId(@PathVariable Long id){
		Linguagem linguagem = linguagemService.buscarPeloId(id);
		
		return ResponseEntity.ok(linguagem);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Linguagem> atualizar (@PathVariable Long id,@Valid @RequestBody Linguagem linguagem){
		Linguagem linguagemSalva = linguagemService.atualizar(id,linguagem);
		
		return ResponseEntity.ok(linguagemSalva);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		linguagemRepository.delete(id);
	}
	
}
