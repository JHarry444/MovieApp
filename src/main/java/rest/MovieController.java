package rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import service.MovieService;

@Path("/movie")
public class MovieController {

	@Inject
	private MovieService service;

	@GET
	@Path("/getAll")
	public String getAllMovies() {
		return this.service.getAllMovies();
	}

	@POST
	@Path("/update/{id}")
	public String updateMovie(@PathParam("id") long id, String movie) {
		return this.service.updateMovie(id, movie);
	}

	@DELETE
	@Path("/delete/{id}")
	public String deleteMovie(@PathParam("id") long id) {
		return this.service.deleteMovie(id);
	}

	@POST
	@Path("/create")
	public String createMovie(String movie) {
		return this.service.createMovie(movie);
	}
}
