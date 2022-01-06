package snorri1986.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Denys Shabelnyk Description: controller for main page
 *
 */
@Controller
@RequestMapping("/main")
public class MainPageController {

	/**
	 * Description: method bundle with main.jsp page
	 *
	 * @param model - object for page rendering.
	 * @return String - a text on the page
	 * @since 0.1
	 *
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String printGreatings(ModelMap model) {
		model.addAttribute("message", "Welcome on MyServiceVehicleApplication web page");
		return "main";
	}
}
