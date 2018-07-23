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

import com.stefanini.pessoa.entidades.Pessoa;
import com.stefanini.pessoa.repository.PessoaRepository;
import com.stefanini.pessoa.service.PessoaService;

@RestController
@RequestMapping("/stefa/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<Pessoa> salvar(@Valid @RequestBody Pessoa pessoa){
		
		Pessoa pessoaSalva =  pessoaRepository.save(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoaSalva.getId()).toUri();
		
		return ResponseEntity.created(uri).body(pessoaSalva);
		
	}
	
	@GetMapping
	public List<Pessoa> buscarTodas(){
		
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPeloId(@PathVariable Long id){
		Pessoa pessoa = pessoaService.buscarPeloId(id);
		
		return ResponseEntity.ok(pessoa);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id,@Valid @RequestBody Pessoa pessoa){
		Pessoa pessoaSalva = pessoaService.atualizarPessoa(id, pessoa);
		
		return ResponseEntity.ok(pessoaSalva);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletar (@PathVariable Long id) {
		pessoaRepository.delete(id);	
		
		
	}

}
