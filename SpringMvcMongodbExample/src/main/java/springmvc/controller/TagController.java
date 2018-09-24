package springmvc.controller;


import java.lang.reflect.Field;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import springmvc.model.Tag;
import springmvc.service.TagServiceImpl;

@Controller
public class TagController {

	@Autowired
	TagServiceImpl tagService;
	
	static Field[] list =Tag.class.getDeclaredFields();

	@RequestMapping(value = "/searchTagsubmit", method = RequestMethod.POST)
	public ModelAndView submitSearchData(@RequestParam("searchField") String searchField,@RequestParam("selectedRecord") String selectedRecord) {
		ModelAndView model = new ModelAndView("tagSearch");
		model.addObject("tagFields", list);
		if(selectedRecord.equals("movieID"))
		{
			System.out.println("yeeeeeeeessssssssssssssssssssss"+selectedRecord+"+++field:"+searchField+"*****");
			
			model.addObject("listTags", tagService.findTagByMovieId(searchField));
			
		}
		else if (selectedRecord.equals("userID"))
		{
			model.addObject("listTags"	,  tagService.findTagByUserId(searchField));
		}
		else if (selectedRecord.equals("tag"))
		{
			model.addObject("listTags"	,  tagService.findTagByTag(searchField));
		}
		else if (selectedRecord.equals("timeStamp"))
		{
			model.addObject("listTags"	,  tagService.findTagByTimeStamp(searchField));
		}
		return model;
	}

	@RequestMapping(value = "/searchTags")
	public ModelAndView searchMovie() {
		
		ModelAndView model = new ModelAndView("tagSearch");
		model.addObject("tagFields", list);
		return model;
	}
	
	

}
