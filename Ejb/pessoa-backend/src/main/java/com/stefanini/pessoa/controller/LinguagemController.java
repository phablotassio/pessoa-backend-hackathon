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
import com.stefanini.pessoa.ejbs.interfaces.LinguagemEJbLocal;
import com.stefanini.pessoa.entidades.Linguagem;
import com.stefanini.pessoa.exception.NegocioException;

@Stateless
@Path("/linguagem")
public class LinguagemController {
	
	@EJB
	private LinguagemEJbLocal linguagemEJbLocal;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Linguagem linguagem) {
		return Response.ok().entity(linguagemEJbLocal.cadastrar(linguagem)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTodos() {
		return Response.ok(linguagemEJbLocal.buscarTodos()).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response buscarPeloId(@PathParam("id")Long id) {
		try {
			return Response.ok(linguagemEJbLocal.buscarPeloId(id)).build();
		}catch (NegocioException  e) {
			NegocioExceptionDto negocioDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioDto).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response atualizar(@PathParam("id")Long id,Linguagem linguagem) {
		try {
			return Response.ok(linguagemEJbLocal.atualizar(id, linguagem)).build();
		}catch (NegocioException  e) {
			NegocioExceptionDto negocioDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioDto).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam ("id") Long id) {
		try {
			linguagemEJbLocal.deletar(id);
			return Response.noContent().build();
			
		}catch (NegocioException  e) {
			NegocioExceptionDto negocioDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioDto).build();
		}
	}
	
}
