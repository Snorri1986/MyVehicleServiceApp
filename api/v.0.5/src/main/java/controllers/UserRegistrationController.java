// need test v0.5
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.RegisterRequestModel;
import models.RegisterResponseModel;
import repository.DataBaseBridge;

@RestController
//@RequestMapping("/user") // need test
public class UserRegistrationController {

	// need test v0.5
	@Autowired
	DataBaseBridge dbBridge;
	// ... //

	// need test v0.5
	@GetMapping("/register")
	public @ResponseBody RegisterResponseModel addNewUser(@RequestBody RegisterRequestModel registerRequestModel)
			throws JsonMappingException, JsonProcessingException {
		RegisterResponseModel registerResponseModel = null;
		Integer result = 0;

		result = dbBridge.setNewUser(registerRequestModel.getFirstname(), registerRequestModel.getLastname(),
				registerRequestModel.getUsername(), registerRequestModel.getPassword());

		String resultInString = String.valueOf(result);

		ObjectMapper regResult = new ObjectMapper();
		registerResponseModel = regResult.readValue(resultInString, RegisterResponseModel.class);

		return registerResponseModel;
	}
	// ... //

}
// ... //
