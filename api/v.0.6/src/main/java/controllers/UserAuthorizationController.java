// need test task 4
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

import models.LoginRequestModel;
import models.LoginResponseModel;
import repository.DataBaseBridge;

@RestController
public class UserAuthorizationController {

	@Autowired
	DataBaseBridge dbBridge;

	@PostMapping("/login")
	public @ResponseBody LoginResponseModel authUser(@RequestBody @Valid final LoginRequestModel loginRequestModel)
			throws JsonMappingException, JsonProcessingException {
		LoginResponseModel loginResponseModel = null;
		Integer result = 0;

		result = dbBridge.checkUserAuth(loginRequestModel.getUsername(), loginRequestModel.getPassword());

		String resultInString = String.valueOf(result);

		ObjectMapper regResult = new ObjectMapper();
		loginResponseModel = regResult.readValue(resultInString, LoginResponseModel.class);

		return loginResponseModel;
	}

}
// ... //
