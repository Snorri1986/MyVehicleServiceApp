package snorri1986.main;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import models.SubscriberRegModelResponse;

/**
 * Description: controller for registration process. After succesfull
 * registration subscriber redirects to vehicle-register page.
 *
 * @author Denys Shabelnyk
 */
@Controller
@RequestMapping("/main/vehicle-register")
public class RegisterController {

	private final String regUrlPath = "https://ws-mvs-login.herokuapp.com/register";
	private final Integer successReg = 0;
	private final Integer badRegister = -1;

	SubscriberRegModelResponse subscriberRegModelResponse;

	/**
	 * Description: method of register process mapping with logging into console for
	 * request and response
	 *
	 * @param formData - data from web form
	 * @return String - web-page depended with auth code 0|1
	 * @since 0.6.3
	 *
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String myRegController(@RequestBody MultiValueMap<String, String[]> formData) {

		// Log data from HTML form in console
		for (String formKeyIterator : formData.keySet()) {
			System.out.print("Key: " + formData.toString());
			System.out.println("Value: " + formData.get(formKeyIterator).toString());
		}

		Integer responseBody;
		RestTemplate rest = new RestTemplate();
		ResponseEntity<SubscriberRegModelResponse> response = rest.postForEntity(regUrlPath, formData,
				SubscriberRegModelResponse.class);

		// Log response answer from ws-mvs-login API
		System.out.println("Response from registration reguest full body" + response.toString());

		responseBody = response.getBody().getCode();
		if (responseBody == successReg)
			return "vehicle-register";
		else if (responseBody == badRegister) {
			return "Subscriber already exists. Try change login";
		}

		return null;
	}

}
