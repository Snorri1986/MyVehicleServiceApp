package snorri1986.main;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import models.ChPasswordResponseModel;

@Controller
@RequestMapping("/main/change-password-send")
public class ChangePasswordSendController {

	private final String changePasswordUrl = "https://ws-mvs-login.herokuapp.com/change-password-send";

	private final Integer SuccessAnswer = 0;

	ChPasswordResponseModel chPasswordResponseModel;

	/**
	 * Description: method for sending change password request to API
	 *
	 * @param formData - data from user request
	 * @return String 0 - success,-1 - login didn't found
	 * @return String - move to main page
	 * @since w0.11a1.5d1.4m0.0
	 */
	// TODO: find another solutions
	@RequestMapping(method = RequestMethod.POST)
	public String doChangePassword(@RequestBody MultiValueMap<String, String[]> formData) {

		System.out.print(formData.toString());

		Integer responseBody;
		RestTemplate rest = new RestTemplate();
		ResponseEntity<ChPasswordResponseModel> response = rest.postForEntity(changePasswordUrl, formData,
				ChPasswordResponseModel.class);

		// Log response answer from ws-mvs-login API
		System.out.println("Response from change password reguest full body" + response.toString());

		responseBody = response.getBody().getCode();

		if (responseBody == SuccessAnswer)
			return "workdesk";

		return "change-password";

	}

}
