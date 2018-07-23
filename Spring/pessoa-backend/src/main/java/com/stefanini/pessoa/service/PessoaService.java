package com.stefanini.pessoa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stefanini.pessoa.entidades.Pessoa;
import com.stefanini.pessoa.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPeloId(id);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		
		return pessoaRepository.save(pessoaSalva);
	}
	
	public Pessoa buscarPeloId(Long id) {
		
		Pessoa pessoa = pessoaRepository.findOne(id);
		if(pessoa==null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoa;
	}

}
