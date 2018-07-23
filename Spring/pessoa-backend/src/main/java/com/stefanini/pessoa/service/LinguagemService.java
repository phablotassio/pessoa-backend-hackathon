package com.stefanini.pessoa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stefanini.pessoa.entidades.Linguagem;
import com.stefanini.pessoa.repository.LinguagemRepository;

@Service
public class LinguagemService {
	
	@Autowired
	private LinguagemRepository linguagemRepository;

	
	public Linguagem atualizar(Long id, Linguagem linguagem) {
		Linguagem linguagemSalva = buscarPeloId(id);
		BeanUtils.copyProperties(linguagem, linguagemSalva, "id");
		return linguagemRepository.save(linguagemSalva);
	}
	
	
	
	public Linguagem buscarPeloId(Long id) {
		Linguagem linguagem = linguagemRepository.findOne(id);
		
		if(linguagem==null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return linguagem;
	}


	
	

}
