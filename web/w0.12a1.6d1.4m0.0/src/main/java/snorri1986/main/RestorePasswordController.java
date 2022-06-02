package snorri1986.main;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import models.RestorePasswordModelResponse;

/**
 * Description: class for handling restore password process
 *
 * @author Denys Shabelnyk
 * @since w0.10a1.4d1.3m0.0
 */
@Controller
@RequestMapping("/main/restore-password")
public class RestorePasswordController {

	private final String restorePasswordUrl = "https://ws-mvs-login.herokuapp.com/restore-password";
	private final Integer SuccessAnswer = 0;

	RestorePasswordModelResponse restorePasswordModelResponse;

	/**
	 * Description: method for sending restore password request to API
	 *
	 * @param formData - data from user request
	 * @return String 0 - success,-1 - login didn't found
	 * @return Integer value of answer code
	 * @since w0.10a1.4d1.3m0.0
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String doRestorePassword(@RequestBody MultiValueMap<String, String[]> formData) {

		// Log data from HTML form in console
		for (String formKeyIterator : formData.keySet()) {
			System.out.print("Key: " + formData.toString());
			System.out.println("Value: " + formData.get(formKeyIterator).toString());
		}

		Integer responseBody;
		RestTemplate rest = new RestTemplate();
		ResponseEntity<RestorePasswordModelResponse> response = rest.postForEntity(restorePasswordUrl, formData,
				RestorePasswordModelResponse.class);

		// Log response answer from ws-mvs-login API
		System.out.println("Response from restore password reguest full body" + response.toString());

		responseBody = response.getBody().getCode();

		if (responseBody == SuccessAnswer)
			return "restore-password";

		return null;

	}

}
