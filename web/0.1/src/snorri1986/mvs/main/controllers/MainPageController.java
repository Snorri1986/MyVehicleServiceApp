// need test task 1.3
package snorri1986.mvs.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: controller class of main page
 *
 * @author Denys Shabelnyk
 */
@Controller
public class MainPageController {

	// need test task 1.3
	/**
	 * Description: method for call main.jsp
	 *
	 * @return String - web page data
	 * @author Denys Shabelnyk
	 */
	@RequestMapping("/")
	public String showMainPage() {
		return "main";
	}
	// ... //

}
// ... //
