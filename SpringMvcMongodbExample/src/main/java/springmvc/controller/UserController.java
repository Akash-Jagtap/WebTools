package springmvc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;
import springmvc.service.UserServiceImpl;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView showWelcomePage()
	{
		ModelAndView model = new ModelAndView("welcome");
		return model;
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list()
	{
		ModelAndView model = new ModelAndView("list");
		//java.lang.reflect.Field[] list =User.class.getDeclaredFields();
//		for(Field obj : list)
//		{
//			System.out.println("--=--=-data-=-=::"+obj.getName());
//		}
		model.addObject("listUser"	,  userService.listUser());
		return model;
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView add()
	{
		ModelAndView model = new ModelAndView("user/form");
		//model.addObject("userForm", new User());
		return model;
	}
	@RequestMapping(value="/upade/{id}",method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") String id)
	{
		ModelAndView model=new ModelAndView("user/form");
		model.addObject("userForm", userService.findUserById(id));
		return model;
	}
	@RequestMapping(value="/upade/{id}",method=RequestMethod.POST)
	public String save(@ModelAttribute("userForm") User user)
	{
		if(user.getId()!=null && !user.getId().trim().equals(""))
		{
			userService.update(user);
		}
		else
			userService.add(user);
		
		return "redirect:user/list";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public String delete(@PathVariable("id") String id)
	{
		User user=userService.findUserById(id);
		userService.delete(user);
		
		return "redirect:user/list";
	}
}
