package snorri1986.main;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import models.SubscriberRegModelResponse;

@Controller
@RequestMapping("/main/vehicle-register")
public class RegisterController {

	private final String regUrlPath = "https://ws-mvs-login.herokuapp.com/register";
	private final Integer successReg = 0;
	private final Integer badRegister = -1;

	SubscriberRegModelResponse subscriberRegModelResponse;

	@RequestMapping(method = RequestMethod.POST)
	public String myRegController(@RequestBody MultiValueMap<String, String[]> formData) {

		Integer responseBody;
		RestTemplate rest = new RestTemplate();
		ResponseEntity<SubscriberRegModelResponse> response = rest.postForEntity(regUrlPath, formData,
				SubscriberRegModelResponse.class);
		responseBody = response.getBody().getCode();
		if (responseBody == successReg)
			return "vehicle-register";
		else if (responseBody == badRegister) {
			return "Subscriber already exists. Try change login";
		}

		return null;
	}

}
