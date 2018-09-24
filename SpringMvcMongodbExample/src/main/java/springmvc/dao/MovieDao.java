package springmvc.dao;

import java.util.List;

import springmvc.model.Movie;

public interface MovieDao {
	
	public List<Movie> findMovieByMovieId(String id);
	
	public List<Movie> findMovieByTitle(String title);
	
	public List<Movie> findMovieByGenre(String gener);
	
	void add(Movie movie);
	
}
