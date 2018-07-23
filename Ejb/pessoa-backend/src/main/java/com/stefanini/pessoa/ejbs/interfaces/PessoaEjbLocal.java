package com.stefanini.pessoa.ejbs.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.stefanini.pessoa.entidades.Pessoa;
import com.stefanini.pessoa.exception.NegocioException;

@Local
public interface PessoaEjbLocal {
	
	public List<Pessoa> buscarTodos();
	public Pessoa buscarPeloId(Long id)throws NegocioException;
	public void deletarPessoa(Long id)throws NegocioException;
	public Pessoa atualizar(Long id,Pessoa pessoa) throws NegocioException;
	public Pessoa cadastrar(Pessoa pessoa);

}
