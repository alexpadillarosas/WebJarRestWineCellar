package com.blueradix.examples.wines.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.blueradix.examples.wines.entity.Wine;

@Path("/wines")
public class WineResource {

	@Inject
	WineService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll(){
		List<Wine> wines = service.findAll();
		return Response.ok(wines).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response findOne(@PathParam("id") int id) {
		Response response;
		Wine wine = service.findById(id);
		if(null == wine) {
			response = Response.status(Response.Status.NOT_FOUND).build();
		}
		else {
			response = Response.ok(wine).build();		
		}
		return response;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search/{query}")
	public Response findByName(@PathParam("query") String name) {
		
		List<Wine> list = service.findByName(name);
		
		return Response.ok(list).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Wine wine) {
		Response response;
		Wine addedWine = service.addWine(wine);
		if(null == addedWine) {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		else {
			response = Response.ok(addedWine).build();
		}
		return response;
		
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Wine wine) {
		Wine updatedWine = service.update(wine);
		Response response;
		if(updatedWine.equals(wine))
			response = Response.ok(updatedWine).build();
		else
			response = Response.notModified().entity(updatedWine).build();
		return response;
	}

	@DELETE
	@Path("{id}")
	public Response remove(@PathParam("id")int id) {
		service.remove(id);
		return Response.ok().build();
	}
	
}
