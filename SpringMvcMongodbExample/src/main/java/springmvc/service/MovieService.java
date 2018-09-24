package springmvc.service;

import java.util.List;

import springmvc.model.Movie;

public interface MovieService {

	public List<Movie> findMovieByMovieId(String id);

	public List<Movie> findMovieByTitle(String title);

	public List<Movie> findMovieByGenre(String gener);
	
	public void add(Movie movie);

}
