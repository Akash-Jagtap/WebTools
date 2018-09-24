package springmvc.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tag {

	private String userID;
	private String movieID;
	private String tag;
	private String timeStamp;
	
	public Tag() {
		super();
	}


	public Tag(String userID, String movieID, String tag, String timeStamp) {
		super();
		this.userID = userID;
		this.movieID = movieID;
		this.tag = tag;
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	
}
