package springmvc.controller;


import java.lang.reflect.Field;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.Rating;
import springmvc.service.RatingServiceImpl;

@Controller
public class RatingController {

	@Autowired
	RatingServiceImpl ratingService;
	
	static Field[] list =Rating.class.getDeclaredFields();

	@RequestMapping(value = "/searchRatingsubmit", method = RequestMethod.POST)
	public ModelAndView submitSearchData(@RequestParam("searchField") String searchField,@RequestParam("selectedRecord") String selectedRecord) {
		ModelAndView model = new ModelAndView("ratingSearch");
		model.addObject("ratingFields", list);
		if(selectedRecord.equals("movieID"))
		{
			System.out.println("yeeeeeeeessssssssssssssssssssss"+selectedRecord+"+++field:"+searchField+"*****");
			
			model.addObject("listRatings", ratingService.findRatingByMovieId(searchField));
			
		}
		else if (selectedRecord.equals("userID"))
		{
			model.addObject("listRatings"	,  ratingService.findRatingByUserId(searchField));
		}
		else if (selectedRecord.equals("rating"))
		{
			model.addObject("listRatings"	,  ratingService.findRatingByRating(Float.parseFloat(searchField)));
		}
		else if (selectedRecord.equals("timeStamp"))
		{
			model.addObject("listRatings"	,  ratingService.findRatingByTimeStamp(searchField));
		}
		return model;
	}

	@RequestMapping(value = "/searchRatings")
	public ModelAndView searchMovie() {
		
		ModelAndView model = new ModelAndView("ratingSearch");
		//Field[] list =Rating.class.getDeclaredFields();
		model.addObject("ratingFields", list);
		return model;
	}
	
	

}
