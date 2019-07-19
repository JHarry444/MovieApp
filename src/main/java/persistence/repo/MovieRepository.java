package persistence.repo;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import persistence.domain.Movie;
import util.JSONUtil;

@Transactional(value = TxType.SUPPORTS)
public class MovieRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil gson;

	public String getAllMovies() {
		TypedQuery<Movie> query = this.manager.createQuery("SELECT m FROM Movie m", Movie.class);
		return this.gson.getJSONForObject(query.getResultList());
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateMovie(long id, String movie) {
		Movie current = this.manager.find(Movie.class, id);
		Movie newMovie = this.gson.getObjectForJSON(movie, Movie.class);
		current.setTitle(newMovie.getTitle());
		this.manager.persist(current);
		return "Success";
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteMovie(long id) {
		this.manager.remove(this.manager.find(Movie.class, id));
		return "Success";
	}

	@Transactional(value = TxType.REQUIRED)
	public String createMovie(String movie) {
		this.manager.persist(this.gson.getObjectForJSON(movie, Movie.class));
		return "Success";
	}

}
