package snorri1986.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.SubscriberModel;

/**
 * @author Denys Shabelnyk Description: controller for main page Last modify:
 *         v0.4 10.01.2022 - add injection of SubscriberModel
 */
@Controller
@RequestMapping("/main")
public class MainPageController {

	@Autowired
	SubscriberModel subscriberModel;

	/**
	 * Description: method bundle with main.jsp page
	 *
	 * @param model - object for page rendering.
	 * @return String - a text on the page
	 * @since 0.1
	 *
	 */
	/*
	 * @RequestMapping(method = RequestMethod.GET) public String
	 * printGreatings(ModelMap model) { model.addAttribute("message",
	 * "Welcome on MyServiceVehicleApplication web page"); // need test task
	 * 20.1.1.2 model.addAttribute("username", subscriberModel.getUsername());
	 * model.addAttribute("password", subscriberModel.getPassword());
	 * model.addAttribute("firstname", subscriberModel.getFirstname());
	 * model.addAttribute("lastname", subscriberModel.getLastname()); // ... //
	 * return "main"; }
	 */

	/**
	 * Description: method bundle with main.jsp page
	 *
	 * @return ModelAndView - web page with static text and form depended with model
	 * @since 0.4
	 *
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printGreatings() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("subscriberModel", new SubscriberModel());
		modelAndView.setViewName("main");
		modelAndView.addObject("message", "Welcome on MyServiceVehicleApplication web page");
		return modelAndView;
	}
}
