package com.stefanini.pessoa.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.stefanini.pessoa.ejbs.interfaces.ProfissaoEjbLocal;
import com.stefanini.pessoa.entidades.Profissao;
import com.stefanini.pessoa.exception.NegocioException;

@Stateless
public class ProfissaoEjb implements ProfissaoEjbLocal{
	
	@PersistenceContext(unitName="cadastroDS")
	private EntityManager manager;
	
	@Override
	public List<Profissao> buscarTodos() {

		return manager.createNamedQuery("Profissao.findAll",Profissao.class).getResultList();
	}

	@Override
	public Profissao buscarPeloId(Long id) throws NegocioException {
		Profissao profissao = manager.find(Profissao.class, id);
		if(profissao == null) {
			throw new NegocioException("Profissao não encontrada");
		}
		return profissao;
	}

	@Override
	public void deletarPessoa(Long id) throws NegocioException {
		Profissao profissao = buscarPeloId(id);
		manager.remove(profissao);
		manager.flush();
		
	}

	@Override
	public Profissao atualizar(Long id, Profissao profissao) throws NegocioException {
		
		Profissao profissaoSalva = buscarPeloId(id);
		profissaoSalva=profissao;
		profissaoSalva.setId(id);
		profissaoSalva = manager.merge(profissaoSalva);
		
		return profissaoSalva;
	}

	@Override
	public Profissao cadastrar(Profissao profissao) {
		Profissao profissaoSalva = manager.merge(profissao);
		return profissaoSalva;
	}


}
