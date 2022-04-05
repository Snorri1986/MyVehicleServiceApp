package snorri1986.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.SubscriberAuthModelRequest;
import models.SubscriberRegModelRequest;

/**
 * Description: controller for main page Last modify: v0.4 10.01.2022 - add
 * injection of SubscriberModel
 *
 * @author Denys Shabelnyk
 */
@Controller
@RequestMapping("/main")
@ComponentScan({ "snorri1986.main", "models" })
public class MainPageController {

	@Autowired
	SubscriberRegModelRequest subscriberModel;

	/**
	 * Description: method bundle with main.jsp page Last modify: 30.03.2022 Last
	 * modify on version w0.9a1.3d1.2m0.0
	 *
	 * @param locale current locale code on the web request
	 * @return ModelAndView - web page with static text and form depended with model
	 * @since 0.4
	 *
	 *
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printGreatings() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("subscriberRegModelRequest", new SubscriberRegModelRequest());
		modelAndView.addObject("subscriberAuthModelRequest", new SubscriberAuthModelRequest());
		modelAndView.setViewName("main");
		modelAndView.addObject("message", "Welcome on MyServiceVehicleApplication web page");
		return modelAndView;

	}
}
