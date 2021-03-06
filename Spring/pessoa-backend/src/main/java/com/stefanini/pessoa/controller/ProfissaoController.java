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

import com.stefanini.pessoa.entidades.Profissao;
import com.stefanini.pessoa.repository.ProfissaoRepository;
import com.stefanini.pessoa.service.ProfissaoService;

@RestController
@RequestMapping("/stefa/profissao")
public class ProfissaoController {
	
	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	@Autowired
	private ProfissaoService profissaoService;
	
	@PostMapping
	public ResponseEntity<Profissao> cadastrar(@Valid @RequestBody Profissao profissao){
		Profissao profissaoSalva = profissaoRepository.save(profissao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(profissaoSalva.getId()).toUri();
		
		return ResponseEntity.created(uri).body(profissaoSalva);
	}
	
	@GetMapping
	public List<Profissao> buscarTodas(){
		List<Profissao> profissoes = profissaoRepository.findAll();
		
		return profissoes;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Profissao> buscarPeloId(@PathVariable Long id){
		Profissao profissao = profissaoService.buscarPeloId(id);
		
		return ResponseEntity.ok(profissao);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Profissao> atualizar(@PathVariable Long id, @Valid @RequestBody Profissao profissao){
		Profissao profissaoSalva = profissaoService.atualizar(id,profissao);
		
		return ResponseEntity.ok(profissaoSalva);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		profissaoRepository.delete(id);
	}
	

}
