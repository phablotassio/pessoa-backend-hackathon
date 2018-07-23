package com.stefanini.pessoa.ejbs.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.stefanini.pessoa.entidades.Linguagem;
import com.stefanini.pessoa.exception.NegocioException;

@Local
public interface LinguagemEJbLocal {
	
	public Linguagem cadastrar(Linguagem linguagem);
	public List<Linguagem> buscarTodos();
	public Linguagem buscarPeloId(Long id) throws NegocioException;
	public Linguagem atualizar(Long id, Linguagem linguagem) throws NegocioException;
	public void deletar(Long id) throws NegocioException;

}
