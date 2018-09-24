package springmvc.service;

import java.util.List;

import springmvc.model.Rating;

public interface RatingService {

public List<Rating> findRatingByUserId(String id);
	
	public List<Rating> findRatingByMovieId(String id);
	
	public List<Rating> findRatingByRating(float rating);
	
	public List<Rating> findRatingByTimeStamp(String timest);
	
	void add(Rating rating);

}
