package snorri1986.main;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import models.SubscriberAuthModelResponse;

/**
 * Description: controller for authentication process
 *
 * @author Denys Shabelnyk
 */
@Controller
@RequestMapping("/main/workdesk")
public class AuthController {

	private final String authUrlPath = "https://ws-mvs-login.herokuapp.com/login";
	private final Integer zeroAuthSuccessAuth = 0;
	private final Integer negativeAuthSuccessAuth = -1;

	SubscriberAuthModelResponse subscriberAuthModelResponse;

	/**
	 * Description: method of auth process mapping
	 *
	 * @param formData - data from web form
	 * @return String - web-page depended with auth code 0|1
	 * @since 0.6.1
	 *
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String myAuthController(@RequestBody MultiValueMap<String, String[]> formData) {

		Integer responseBody;
		RestTemplate rest = new RestTemplate();
		ResponseEntity<SubscriberAuthModelResponse> response = rest.postForEntity(authUrlPath, formData,
				SubscriberAuthModelResponse.class);
		responseBody = response.getBody().getCode();
		if (responseBody == zeroAuthSuccessAuth)
			return "workdesk";
		else if (responseBody == negativeAuthSuccessAuth) {
			return "Invalid login or password";
		}

		return null;
	}

}
