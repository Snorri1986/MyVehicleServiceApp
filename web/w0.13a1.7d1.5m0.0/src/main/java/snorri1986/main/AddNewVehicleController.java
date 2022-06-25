package snorri1986.main;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import models.AddNewVehicleResponseModel;

/**
 * Description: controller for adding new vehicle
 *
 * @author Denys Shabelnyk
 */
@Controller
@RequestMapping("/main/add-new-vehicle")
public class AddNewVehicleController {

	private final String addNewVehicleUrlPath = "https://ws-mvs-vehicle.herokuapp.com/add-new-vehicle";
	private final Integer zeroAuthSuccessAuth = 0;
	private final Integer negativeAuthSuccessAuth = -1;

	@RequestMapping(method = RequestMethod.POST)
	public String doAddNewVehicle(@RequestBody MultiValueMap<String, String[]> formData) {

		System.out.print(formData.toString());

		Integer responseBody;
		RestTemplate rest = new RestTemplate();
		ResponseEntity<AddNewVehicleResponseModel> response = rest.postForEntity(addNewVehicleUrlPath, formData,
				AddNewVehicleResponseModel.class);

		// Log response answer from ws-mvs-login API
		System.out.println("Response from adding new vehicle reguest full body" + response.toString());

		responseBody = response.getBody().getCode();

		if (responseBody == zeroAuthSuccessAuth)
			return "workdesk";
		else if (responseBody == negativeAuthSuccessAuth) {
			return "vehicle-register";
		}

		return null;

	}

}