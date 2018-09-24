package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.RatingDao;
import springmvc.model.Rating;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingDao ratingDao;

	@Override
	public List<Rating> findRatingByUserId(String id) {
		// TODO Auto-generated method stub
		return ratingDao.findRatingByUserId(id);
	}

	@Override
	public List<Rating> findRatingByMovieId(String id) {
		// TODO Auto-generated method stub
		return ratingDao.findRatingByMovieId(id);
	}

	@Override
	public List<Rating> findRatingByRating(float rating) {
		// TODO Auto-generated method stub
		return ratingDao.findRatingByRating(rating);
	}

	@Override
	public List<Rating> findRatingByTimeStamp(String timest) {
		// TODO Auto-generated method stub
		return ratingDao.findRatingByTimeStamp(timest);
	}

	@Override
	public void add(Rating rating) {
		// TODO Auto-generated method stub
		ratingDao.add(rating);
	}
		
}
