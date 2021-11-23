// need test v0.5
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import models.RegisterRequestModel;
import models.RegisterResponseModel;
import repository.DataBaseBridge;

@RestController
public class UserRegistrationController {

	// need test v0.5
	@Autowired
	DataBaseBridge dbBridge;
	// ... //

	// TODO: add endpoint declaration. Show tips from working laptop
	public @ResponseBody RegisterResponseModel addNewUser(@RequestBody RegisterRequestModel registerRequestModel)
			throws JsonMappingException, JsonProcessingException {
		RegisterResponseModel registerResponseModel = null;
		Integer result = 0;

		result = dbBridge.setNewUser(registerRequestModel.getFirstname(), registerRequestModel.getLastname(),
				registerRequestModel.getUsername(), registerRequestModel.getPassword());

		String resultInString = String.valueOf(result);

		JsonMapper regResult = new JsonMapper();
		registerResponseModel = regResult.readValue(resultInString, RegisterResponseModel.class);

		return registerResponseModel;
	}

}
// ... //
