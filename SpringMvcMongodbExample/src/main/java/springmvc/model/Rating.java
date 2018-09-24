package springmvc.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Rating {

	private String userID;
	private String movieID;
	private float rating;
	private String timeStamp;
	
	public Rating() {
		super();
	}

	
	
	public Rating(String userID, String movieID, float rating, String timeStamp) {
		super();
		this.userID = userID;
		this.movieID = movieID;
		this.rating = rating;
		this.timeStamp = timeStamp;
	}



	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getMovieID() {
		return movieID;
	}

	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	
}
