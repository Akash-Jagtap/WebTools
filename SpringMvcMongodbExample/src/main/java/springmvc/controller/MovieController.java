package springmvc.controller;

import java.lang.reflect.Field;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.Movie;
import springmvc.service.MovieServiceImpl;

@Controller
public class MovieController {

	@Autowired
	MovieServiceImpl movieService;

	static Field[] list =Movie.class.getDeclaredFields();
	
	@RequestMapping(value = "/searchsubmit", method = RequestMethod.POST)
	public ModelAndView submitSearchData(@RequestParam("searchField") String searchField,@RequestParam("selectedRecord") String selectedRecord) {
		
		ModelAndView model = new ModelAndView("movieSearch");
		model.addObject("movieFields", list);
		if(selectedRecord.equals("movieID"))
		{
			model.addObject("listMovies", movieService.findMovieByMovieId(searchField));
		}
		else if (selectedRecord.equals("title"))
		{
			model.addObject("listMovies"	,  movieService.findMovieByTitle(searchField));
		}
		else if (selectedRecord.equals("listGenre"))
		{
			model.addObject("listMovies"	,  movieService.findMovieByGenre(searchField));
		}
		return model;
	}

	@RequestMapping(value = "/searchMovie")
	public ModelAndView searchMovie() {
		
		ModelAndView model = new ModelAndView("movieSearch");
		model.addObject("movieFields", list);
		return model;
	}
	
	

}
