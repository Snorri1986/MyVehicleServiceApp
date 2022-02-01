package snorri1986.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import models.SubscriberAuthModelRequest;
import models.SubscriberAuthModelResponse;
import models.SubscriberModel;

/**
 * @author Denys Shabelnyk Description: controller for main page Last modify:
 *         v0.4 10.01.2022 - add injection of SubscriberModel
 */
@EnableWebMvc
@Controller
@RequestMapping("/main")
public class MainPageController {

	@Autowired
	SubscriberModel subscriberModel;

	// need test task 28.1
	private final String authUrlPath = "https://ws-mvs-login.herokuapp.com/login";
	private final Integer zeroAuthSuccessAuth = 0;
	private final Integer negativeAuthSuccessAuth = -1;

	// need test task 28.1
	SubscriberAuthModelResponse subscriberAuthModelResponse;
	// ... //

	/**
	 * Description: method bundle with main.jsp page Last modify: 11.01.2022 v0.5
	 *
	 * @return ModelAndView - web page with static text and form depended with model
	 * @since 0.4
	 *
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printGreatings() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("subscriberModel", new SubscriberModel());
		modelAndView.addObject("subscriberAuthModelRequest", new SubscriberAuthModelRequest());
		modelAndView.setViewName("main");
		modelAndView.addObject("message", "Welcome on MyServiceVehicleApplication web page");
		return modelAndView;
	}

	// need test task 28.1 old: value = "/workdesk", method = RequestMethod.GET
	@RequestMapping("/main/workdesk")
	// @ResponseBody
	public String myAuthController(@RequestBody MultiValueMap<String, String[]> formData) {
		Integer responseBody;
		RestTemplate rest = new RestTemplate();
		ResponseEntity<SubscriberAuthModelResponse> response = rest.postForEntity(authUrlPath, formData,
				SubscriberAuthModelResponse.class);
		// String manipulatedResult = manipulateResult(response.getBody());
		responseBody = response.getBody().getCode();
		if (responseBody == zeroAuthSuccessAuth)
			return "workdesk";
		else {
			return "Invalid login or password";
		}
		// temporary
		// return null;
		// ... //
	}
	// ... //
}
