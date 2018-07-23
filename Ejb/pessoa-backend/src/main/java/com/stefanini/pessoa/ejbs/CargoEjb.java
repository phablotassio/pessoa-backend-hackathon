package com.stefanini.pessoa.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.stefanini.pessoa.ejbs.interfaces.CargoEjbLocal;
import com.stefanini.pessoa.entidades.Cargo;
import com.stefanini.pessoa.exception.NegocioException;

@Stateless
public class CargoEjb implements CargoEjbLocal{
	
	@PersistenceContext(unitName="cadastroDS")
	private EntityManager manager;

	@Override
	public Cargo cadastrar(Cargo cargo) {
		Cargo cargoSalvo = manager.merge(cargo);
		return cargoSalvo;
	}

	@Override
	public List<Cargo> buscarTodos() {
		List<Cargo> cargos = manager.createNamedQuery("Cargo.FindAll", Cargo.class).getResultList();
		return cargos;
	}

	@Override
	public Cargo buscarPeloId(Long id) throws NegocioException {
		Cargo cargo = manager.find(Cargo.class, id);
		if(cargo==null) {
			throw new NegocioException("Cargo não encontrado");
		}
		return cargo;
	}

	@Override
	public Cargo atualizar(Long id, Cargo cargo) throws NegocioException {
		Cargo cargoSalvo = buscarPeloId(id);
		cargoSalvo=cargo;
		cargoSalvo.setId(id);
		cargoSalvo = manager.merge(cargoSalvo);
		
		return cargoSalvo;
	}

	@Override
	public void deletar(Long id) throws NegocioException {
		Cargo cargo = buscarPeloId(id);
		manager.remove(cargo);
		manager.flush();
		
	}

}
