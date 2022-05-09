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
import models.LoginRequestModel;
import models.LoginResponseModel;
import repository.DataBaseBridge;

/**
 * Description: The controller class for login proccess Request example: {
 * "login":"kabanchik","password":"chry123" } Response example: { "code": 0 } or
 * { "code": -1 }
 *
 * @author Denys Shabelnyk
 * @since 0.6
 */
@RestController
public class UserAuthorizationController {

	@Autowired
	DataBaseBridge dbBridge;

	/**
	 * Description: method for handling authorization requests Last modify on v1.0:
	 * -> Utils.getBase64HashPhrase(loginRequestModel.getPassword())
	 *
	 * @author Denys Shabelnyk
	 * @param loginRequestModel - a request which written by JSON and send from
	 *                          outside form
	 * @return LoginResponseModel - a response which returns from database. Can be
	 *         only 0 - success, -1 - failure.
	 * @throws JsonMappingException    - error while field mappings
	 * @throws JsonProcessingException - error while JSON parsing
	 * @since 1.0
	 */
	@PostMapping("/login")
	public @ResponseBody LoginResponseModel authUser(@RequestBody @Valid final LoginRequestModel loginRequestModel)
			throws JsonMappingException, JsonProcessingException {
		LoginResponseModel loginResponseModel = null;
		Integer result = 0;

		result = dbBridge.checkUserAuth(loginRequestModel.getUsername(),
				Utils.getBase64HashPhrase(loginRequestModel.getPassword()));

		String resultInString = String.valueOf(result);

		ObjectMapper regResult = new ObjectMapper();
		loginResponseModel = regResult.readValue(resultInString, LoginResponseModel.class);

		return loginResponseModel;
	}

}
