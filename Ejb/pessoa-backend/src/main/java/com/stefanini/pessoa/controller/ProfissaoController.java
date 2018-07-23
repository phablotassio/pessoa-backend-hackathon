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
import com.stefanini.pessoa.ejbs.interfaces.ProfissaoEjbLocal;
import com.stefanini.pessoa.entidades.Profissao;
import com.stefanini.pessoa.exception.NegocioException;

@Stateless
@Path("/profissao")
public class ProfissaoController {

	@EJB
	private ProfissaoEjbLocal profissaoEjbLocal;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {

		return Response.ok().entity(profissaoEjbLocal.buscarTodos()).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Profissao profissao) {
		
		return Response.ok().entity(profissaoEjbLocal.cadastrar(profissao)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response buscarPeloId(@PathParam("id")Long id) {
		
		
		try {
			return Response.ok().entity(profissaoEjbLocal.buscarPeloId(id)).build();
			
		}catch (Exception e) {
			
			NegocioExceptionDto negocioDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioDto).build();
		}
		
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("/{id}")
	public Response deletar (@PathParam("id") Long id) {
		try {
			profissaoEjbLocal.deletarPessoa(id);
			return Response.status(Status.NO_CONTENT).build();
		}catch (NegocioException e) {
			NegocioExceptionDto negocioExceptionDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioExceptionDto).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(@PathParam("id") Long id, Profissao profissao) {
		try {
			return Response.ok().entity(profissaoEjbLocal.atualizar(id, profissao)).build();
		}catch (NegocioException e) {
			NegocioExceptionDto negocioExceptionDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioExceptionDto).build();
		}
	}
	

}
