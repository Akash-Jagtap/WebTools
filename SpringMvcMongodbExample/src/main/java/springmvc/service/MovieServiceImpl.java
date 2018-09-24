package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.MovieDao;
import springmvc.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao movieDao;

	@Override
	public List<Movie> findMovieByMovieId(String id) {
		// TODO Auto-generated method stub
		return movieDao.findMovieByMovieId(id);
	}

	@Override
	public List<Movie> findMovieByTitle(String title) {
		// TODO Auto-generated method stub
		return movieDao.findMovieByTitle(title);
	}

	@Override
	public List<Movie> findMovieByGenre(String gener) {
		// TODO Auto-generated method stub
		return movieDao.findMovieByGenre(gener);
	}

	public void add(Movie movie) {
		movieDao.add(movie);
	}

}
