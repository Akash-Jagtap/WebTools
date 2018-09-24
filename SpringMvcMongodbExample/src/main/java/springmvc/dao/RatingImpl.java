package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import springmvc.model.Rating;

@Repository
public class RatingImpl implements RatingDao{

	@Autowired
	MongoTemplate mongoTemplate;

	private static final String COLLECTION_NAME = "rating";

	
	@Override
	public void add(Rating rating) {
		if (!mongoTemplate.collectionExists(Rating.class)) {
			mongoTemplate.createCollection(Rating.class);
		}
		mongoTemplate.insert(rating, COLLECTION_NAME);
	}


	@Override
	public List<Rating> findRatingByUserId(String id) {
		Query q= new Query();
		q.addCriteria(Criteria.where("userID").is(id));
		return mongoTemplate.find(q, Rating.class);
	}


	@Override
	public List<Rating> findRatingByMovieId(String id) {
		Query q= new Query();
		q.addCriteria(Criteria.where("movieID").is(id));
		return mongoTemplate.find(q, Rating.class);
	}


	@Override
	public List<Rating> findRatingByRating(float rating) {
		Query q= new Query();
		q.addCriteria(Criteria.where("rating").is(rating));
		return mongoTemplate.find(q, Rating.class);
	}


	@Override
	public List<Rating> findRatingByTimeStamp(String timest) {
		Query q= new Query();
		q.addCriteria(Criteria.where("timeStamp").is(timest));
		return mongoTemplate.find(q, Rating.class);
	}

	
}
