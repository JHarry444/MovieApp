package service;

import javax.inject.Inject;

import persistence.repo.MovieRepository;

public class MovieService {
	@Inject
	private MovieRepository repo;

	public String getAllMovies() {
		return this.repo.getAllMovies();
	}

	public String updateMovie(long id, String movie) {
		return this.repo.updateMovie(id, movie);
	}

	public String deleteMovie(long id) {
		return this.repo.deleteMovie(id);
	}

	public String createMovie(String movie) {
		return this.repo.createMovie(movie);
	}
}
