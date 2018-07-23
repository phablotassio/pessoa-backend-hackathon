package com.stefanini.pessoa.ejbs.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.stefanini.pessoa.entidades.Cargo;
import com.stefanini.pessoa.exception.NegocioException;

@Local
public interface CargoEjbLocal {
	
	public Cargo cadastrar(Cargo cargo);
	public List<Cargo> buscarTodos();
	public Cargo buscarPeloId(Long id) throws NegocioException;
	public Cargo atualizar(Long id,Cargo cargo) throws NegocioException;
	public void deletar(Long id) throws NegocioException;
	

}
