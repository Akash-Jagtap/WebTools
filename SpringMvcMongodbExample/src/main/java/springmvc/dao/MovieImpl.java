package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import springmvc.model.Movie;

@Repository
public class MovieImpl implements MovieDao {

	@Autowired
	MongoTemplate mongoTemplate;

	private static final String COLLECTION_NAME = "movie";

	@Override
	public List<Movie> findMovieByMovieId(String id) {
		Query q= new Query();
		q.addCriteria(Criteria.where("movieID").is(id));
		return mongoTemplate.find(q, Movie.class);
	}

	@Override
	public void add(Movie movie) {
		if (!mongoTemplate.collectionExists(Movie.class)) {
			mongoTemplate.createCollection(Movie.class);
		}
		mongoTemplate.insert(movie, COLLECTION_NAME);
	}

	@Override
	public List<Movie> findMovieByTitle(String title) {
		Query q= new Query();
		q.addCriteria(Criteria.where("title").regex(title));
		return mongoTemplate.find(q, Movie.class);
	}

	@Override
	public List<Movie> findMovieByGenre(String genre) {
		Query q= new Query();
		q.addCriteria(Criteria.where("listGenre").regex(genre));
		System.out.println(mongoTemplate.find(q, Movie.class));
		return mongoTemplate.find(q, Movie.class);
	}

}
