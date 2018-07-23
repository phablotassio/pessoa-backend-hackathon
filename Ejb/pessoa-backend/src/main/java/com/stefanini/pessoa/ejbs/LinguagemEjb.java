package com.stefanini.pessoa.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.stefanini.pessoa.ejbs.interfaces.LinguagemEJbLocal;
import com.stefanini.pessoa.entidades.Linguagem;
import com.stefanini.pessoa.exception.NegocioException;

@Stateless
public class LinguagemEjb implements LinguagemEJbLocal{

	@PersistenceContext(unitName="cadastroDS")
	private EntityManager manager ;
	
	@Override
	public Linguagem cadastrar(Linguagem linguagem) {
		Linguagem linguagemSalva = manager.merge(linguagem);
		return linguagemSalva;
	}

	@Override
	public List<Linguagem> buscarTodos() {
		List<Linguagem> linguagens = manager.createQuery("From Linguagem",Linguagem.class).getResultList();
		return linguagens;
	}

	@Override
	public Linguagem buscarPeloId(Long id) throws NegocioException {
		Linguagem linguagem = manager.find(Linguagem.class, id);
		if(linguagem==null) {
			throw new NegocioException("Linguagem não encotrada");
		}
		return linguagem;
	}

	@Override
	public Linguagem atualizar(Long id, Linguagem linguagem) throws NegocioException {
		Linguagem linguagemSalva = buscarPeloId(id);
		linguagemSalva=linguagem;
		linguagemSalva.setId(id);
		linguagemSalva=manager.merge(linguagemSalva);
		return linguagemSalva;
	}

	@Override
	public void deletar(Long id) throws NegocioException {
		Linguagem linguagemSalva = buscarPeloId(id);
		manager.remove(linguagemSalva);
		manager.flush();
	}

}
