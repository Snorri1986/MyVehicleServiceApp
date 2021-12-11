package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.Utils;
import models.RegisterRequestModel;
import models.RegisterResponseModel;
import repository.DataBaseBridge;

/**
 * Description: The controller class for registration Request example: {
 * "login":"Ivan", "password":"Pass", "fname":"Ivan", "lname":"Ivanov" }
 * Response example: { "code": 0 }
 *
 * @author Denys Shabelnyk
 * @since 0.5
 */
@RestController
public class UserRegistrationController {

	@Autowired
	DataBaseBridge dbBridge;

	/**
	 * Description: method for handling new subscriber registration requests. Last
	 * modify on v1.0: ->
	 * Utils.getBase64HashPhrase(registerRequestModel.getPassword())
	 *
	 * @author Denys Shabelnyk
	 * @param registerRequestModel - a request which written by JSON and send from
	 *                             outside service
	 * @return RegisterResponseModel - a response which returns from database. Can
	 *         be only 0 - success, -1 - failure.
	 * @throws JsonMappingException    - error while field mappings
	 * @throws JsonProcessingException - error while JSON parsing
	 * @since 1.0
	 */
	@PostMapping("/register")
	public @ResponseBody RegisterResponseModel addNewUser(
			@RequestBody @Valid final RegisterRequestModel registerRequestModel)
			throws JsonMappingException, JsonProcessingException {
		RegisterResponseModel registerResponseModel = null;
		Integer result = 0;

		result = dbBridge.setNewUser(registerRequestModel.getUsername(),
				Utils.getBase64HashPhrase(registerRequestModel.getPassword()), registerRequestModel.getFirstname(),
				registerRequestModel.getLastname());

		String resultInString = String.valueOf(result);

		ObjectMapper regResult = new ObjectMapper();
		registerResponseModel = regResult.readValue(resultInString, RegisterResponseModel.class);

		return registerResponseModel;
	}

}
