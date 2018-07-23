package com.stefanini.pessoa.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.stefanini.pessoa.dtos.NegocioExceptionDto;
import com.stefanini.pessoa.ejbs.interfaces.PessoaEjbLocal;
import com.stefanini.pessoa.entidades.Pessoa;

@Stateless
@Path("/pessoa")
public class PessoaController {
	
	@EJB
	private PessoaEjbLocal pessoaEjbLocal;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
			
		return Response.ok().entity(pessoaEjbLocal.buscarTodos()).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Pessoa pessoa) {
		
		return Response.ok().entity(pessoaEjbLocal.cadastrar(pessoa)).build();
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar (@PathParam("id") Long id,Pessoa pessoa) {
		try {
			return Response.ok(pessoaEjbLocal.atualizar(id,pessoa)).build();
		}catch (Exception e) {
			NegocioExceptionDto negocioDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioDto).build();
			
		}
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPeloId(@PathParam("id") Long id) {
		try {
			return Response.ok().entity(pessoaEjbLocal.buscarPeloId(id)).build();
		}catch (Exception e) {
			NegocioExceptionDto negocioDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioDto).build();
			
		}
		
		
	}
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar (@PathParam("id") Long id) {
		
		try {
			pessoaEjbLocal.deletarPessoa(id);
			return Response.noContent().build();
		}catch (Exception e) {
			
			NegocioExceptionDto negocioDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioDto).build();
			
		}
	
		
	}
	
	

}
