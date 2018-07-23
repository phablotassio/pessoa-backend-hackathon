package com.stefanini.pessoa.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.stefanini.pessoa.ejbs.interfaces.PessoaEjbLocal;
import com.stefanini.pessoa.entidades.Pessoa;
import com.stefanini.pessoa.exception.NegocioException;

@Stateless
public class PessoaEjb implements PessoaEjbLocal {
	
	@PersistenceContext(unitName="cadastroDS")
	private EntityManager manager;

	@Override
	public List<Pessoa> buscarTodos() {
		
		return manager.createNamedQuery("Pessoa.findAll", Pessoa.class).getResultList();
	}

	@Override
	public Pessoa buscarPeloId(Long id) throws NegocioException {
		Pessoa pessoaSalva = manager.find(Pessoa.class,id);
		if(pessoaSalva == null) {
			throw new NegocioException("Recurso Não Encontrado");
		}
		
		
		return pessoaSalva;
	}

	@Override
	public void deletarPessoa(Long id) throws NegocioException {
		Pessoa pessoaSalva = buscarPeloId(id);
		manager.remove(pessoaSalva);
		manager.flush();
		
	}

	@Override
	public Pessoa atualizar(Long id,Pessoa pessoa) throws NegocioException {
		
		Pessoa pessoaSalva = buscarPeloId(id);
		pessoaSalva = pessoa;
		pessoaSalva.setId(id);
		pessoaSalva = manager.merge(pessoaSalva);
		
		return pessoaSalva;
	}

	@Override
	public Pessoa cadastrar(Pessoa pessoa) {
		Pessoa pessoaSalva = manager.merge(pessoa);
		return pessoaSalva;
	}
	
	
	
	

}
