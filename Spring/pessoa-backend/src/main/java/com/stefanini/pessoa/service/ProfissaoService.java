package com.stefanini.pessoa.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.stefanini.pessoa.entidades.Profissao;
import com.stefanini.pessoa.repository.ProfissaoRepository;

@Service
public class ProfissaoService {
	
	@Autowired
	private ProfissaoRepository profissaoRepository;

	
	public Profissao buscarPeloId(Long id) {
		Profissao profissao = profissaoRepository.findOne(id);
		if(profissao==null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return profissao;
	}


	public Profissao atualizar(Long id, Profissao profissao) {
		Profissao profissaoSalva = buscarPeloId(id);
		BeanUtils.copyProperties(profissao, profissaoSalva, "id");
		
		return profissaoRepository.save(profissaoSalva);
	}

}
