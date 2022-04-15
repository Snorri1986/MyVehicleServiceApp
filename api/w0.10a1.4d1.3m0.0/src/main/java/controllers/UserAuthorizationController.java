package controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

	private static final Logger logger = LoggerFactory.getLogger(UserAuthorizationController.class);

	@Autowired
	DataBaseBridge dbBridge;

	/**
	 * Description: method for handling authorization requests Last modify on v1.0:
	 * -> Utils.getBase64HashPhrase(loginRequestModel.getPassword()) Last modify on
	 * v1.3 -> remove request body annotation and added logging
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
	public @ResponseBody LoginResponseModel authUser(@Valid final LoginRequestModel loginRequestModel)
			throws JsonMappingException, JsonProcessingException {
		LoginResponseModel loginResponseModel = null;
		Integer result = 0;

		logger.info("Incoming authentication request(info): {}", loginRequestModel.toString());

		result = dbBridge.checkUserAuth(loginRequestModel.getUsername(),
				Utils.getBase64HashPhrase(loginRequestModel.getPassword()));

		String resultInString = String.valueOf(result);

		ObjectMapper regResult = new ObjectMapper();
		loginResponseModel = regResult.readValue(resultInString, LoginResponseModel.class);

		logger.info("Authentication response (info): {}", loginResponseModel.toString());

		return loginResponseModel;
	}

}
