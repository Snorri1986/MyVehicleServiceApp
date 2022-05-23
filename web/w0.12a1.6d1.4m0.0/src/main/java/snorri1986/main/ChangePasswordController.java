package snorri1986.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.ChPasswordRequestModel;

@Controller
@RequestMapping("/main/change-password")
public class ChangePasswordController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showChangePasswordWebPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("chPasswordRequestModel", new ChPasswordRequestModel());
		modelAndView.setViewName("change-password");
		return modelAndView;

	}

}