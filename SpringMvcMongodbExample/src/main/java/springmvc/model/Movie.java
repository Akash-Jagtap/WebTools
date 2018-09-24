package springmvc.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {
	  
	private String movieID;
	private String title;
	private String listGenre;
	
	
	
	public Movie() {
		super();
	}

	public Movie(String movieID, String title, String listGenre) {
		super();
		this.movieID = movieID;
		this.title = title;
		this.listGenre = listGenre;
	}
	
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getListGenre() {
		return listGenre;
	}

	public void setListGenre(String listGenre) {
		this.listGenre = listGenre;
	}
	
	
	
	

}
