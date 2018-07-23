package com.stefanini.pessoa.ejbs.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.stefanini.pessoa.entidades.Profissao;
import com.stefanini.pessoa.exception.NegocioException;

@Local
public interface ProfissaoEjbLocal {
	
	public List<Profissao> buscarTodos();
	public Profissao buscarPeloId(Long id)throws NegocioException;
	public void deletarPessoa(Long id)throws NegocioException;
	public Profissao atualizar(Long id,Profissao profissao) throws NegocioException;
	public Profissao cadastrar(Profissao profissao);

}
