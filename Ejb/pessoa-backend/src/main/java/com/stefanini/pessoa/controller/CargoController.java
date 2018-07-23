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
import com.stefanini.pessoa.ejbs.interfaces.CargoEjbLocal;
import com.stefanini.pessoa.entidades.Cargo;
import com.stefanini.pessoa.exception.NegocioException;

@Stateless
@Path("/cargo")
public class CargoController {
	
	@EJB 
	private CargoEjbLocal cargoEjbLocal;
	
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response cadastrar(Cargo cargo) {
		return Response.ok().entity(cargoEjbLocal.cadastrar(cargo)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTodos() {
		return Response.ok().entity(cargoEjbLocal.buscarTodos()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarpeloId(@PathParam("id") Long id) {
		try {
			return Response.ok().entity(cargoEjbLocal.buscarPeloId(id)).build();
		}catch (NegocioException  e) {
			NegocioExceptionDto negocioExceptionDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioExceptionDto).build();
		}
	}
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Long id,Cargo cargo) {
		try {
			return Response.ok().entity(cargoEjbLocal.atualizar(id, cargo)).build();
		}
		catch (NegocioException  e) {
			NegocioExceptionDto negocioExceptionDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioExceptionDto).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam ("id") Long id) {
		try {
			cargoEjbLocal.deletar(id);
			return Response.noContent().build();
			
		}catch (NegocioException  e) {
			NegocioExceptionDto negocioDto = new NegocioExceptionDto(e.getMessage());
			return Response.status(Status.NOT_FOUND).entity(negocioDto).build();
		}
	}
	
	
}
