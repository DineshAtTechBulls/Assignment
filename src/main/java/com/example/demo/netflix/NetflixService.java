package com.example.demo.netflix;

import java.util.Optional;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetflixService {

	@Autowired
	NetflixRepos netflixRepos;

	public Response getMoviesById(Long id) {
		Optional<Response> response;
		try {
			response = Optional.of(Responser.getResponse(Status.ACCEPTED, netflixRepos.findById(id)));
		} catch (Exception e) {
			response = Optional.of(Responser.getResponse(Status.BAD_REQUEST, e.getMessage()));
		}
		return response.get();
	}

	public Response createMovie(Netflix netflix) {
		Optional<Response> response;
		try {
			response = Optional.of(Responser.getResponse(Status.CREATED, netflixRepos.save(netflix)));
		} catch (Exception e) {
			response = Optional.of(Responser.getResponse(Status.BAD_REQUEST, e.getMessage()));
		}
		return response.get();
	}

	public Response editMovie(Long id, Netflix netflix) {
		Optional<Response> response;
		try {
			Netflix data = netflixRepos.findById(id).get();
			data.setMovieName(netflix.getMovieName());
			data.setCreator(netflix.getCreator());
			data.setGenre(netflix.getGenre());
			data.setRating(netflix.getRating());
			response = Optional.of(Responser.getResponse(Status.ACCEPTED, netflixRepos.save(data)));
		} catch (Exception e) {
			response = Optional.of(Responser.getResponse(Status.BAD_REQUEST, e.getMessage()));
		}
		return response.get();
	}

	public Response deleteMovieById(Long id) {
		Optional<Response> response;
		try {
			netflixRepos.deleteById(id);
			response = Optional.of(Responser.getResponse(Status.ACCEPTED,netflixRepos.existsById(id) ? "deleted" : "Not deleted"));	
		}catch(Exception e) {
			response = Optional.of(Responser.getResponse(Status.BAD_REQUEST, e.getMessage()));
		}
		return response.get();
	}

	public Response getAllMovies() {
		Optional<Response> response;
		try {
			response = Optional.of(Responser.getResponse(Status.ACCEPTED,netflixRepos.findAll()));	
		}catch(Exception e) {
			response = Optional.of(Responser.getResponse(Status.BAD_REQUEST, e.getMessage()));
		}
		return response.get();
		
	}

}
