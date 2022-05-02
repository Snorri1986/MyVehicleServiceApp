package snorri1986.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/change-password")
public class ChangePasswordController {

	@RequestMapping(method = RequestMethod.GET)
	public String showChangePasswordWebPage() {
		return "change-password";
	}

}
