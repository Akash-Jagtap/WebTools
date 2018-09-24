package springmvc.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.Movie;
import springmvc.model.Rating;
import springmvc.model.Tag;
import springmvc.service.MovieServiceImpl;
import springmvc.service.RatingServiceImpl;
import springmvc.service.TagServiceImpl;

@Controller
public class GeneralController {
	@Autowired
	MovieServiceImpl movieService;
	@Autowired
    RatingServiceImpl ratingService;
	@Autowired
    TagServiceImpl tagService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insertData() {
		try {
			Resource resource = new ClassPathResource("movies.dat");
			BufferedReader in = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				String[] tokens = line.split("::");
				String movieID = tokens[0];
				String title = tokens[1];
				String listGenre = tokens[2];
				Movie obj = new Movie();
				obj.setMovieID(movieID);
				obj.setTitle(title);
				obj.setListGenre(listGenre);
				movieService.add(obj);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Resource resource = new ClassPathResource("ratings.dat");
			BufferedReader in = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				String[] tokens = line.split("::");
				Rating obj = new Rating(tokens[0],tokens[1],Float.parseFloat(tokens[2]),tokens[3]);
				ratingService.add(obj);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {

			Resource resource = new ClassPathResource("tags.dat");
			BufferedReader in = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				String[] tokens = line.split("::");
				Tag obj = new Tag(tokens[0],tokens[1],tokens[2],tokens[3]);
				tagService.add(obj);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("search");
	}

	@RequestMapping(value = "/search",method = RequestMethod.GET)
	public ModelAndView searchData() {
		ModelAndView model = new ModelAndView("search");
		return model;
	}
}
