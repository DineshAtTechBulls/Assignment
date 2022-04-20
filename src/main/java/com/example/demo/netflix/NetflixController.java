package com.example.demo.netflix;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@Path("/")
public class NetflixController {
	
	@Autowired
	NetflixService netflixService;
	
	@GET
	@Produces("application/json")
	@Path("/{id}")
	public Response getNeflixMovies(@PathParam("id") Long id){
		return netflixService.getMoviesById(id);
	}
	
	@GET
	@Produces("application/json")
	@Path("/")
	public Response getAlMovies(){
		return netflixService.getAllMovies();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/")
	public Response createMovieObject(@RequestBody Netflix netflix) {
		System.out.println(netflix);
		return netflixService.createMovie(netflix);
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/{id}")
	public Response editMovie(@PathParam("id") Long id, @RequestBody Netflix netflix) {
		return netflixService.editMovie(id, netflix);
	}
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/{id}")
	public Response deleteMovie(@PathParam("id") Long id) {
		return netflixService.deleteMovieById(id);
	}
	
}
