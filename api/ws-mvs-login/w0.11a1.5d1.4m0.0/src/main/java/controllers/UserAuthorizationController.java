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
import models.ChPasswordRequestModel;
import models.ChPasswordResponseModel;
import models.LoginRequestModel;
import models.LoginResponseModel;
import models.Mail;
import models.PasswordRequestModel;
import models.PasswordResponseModel;
import repository.DataBaseBridge;
import services.MailService;

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

	@Autowired
	MailService mailService;

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

	/**
	 * Description: method for handling restore password request
	 *
	 * @author Denys Shabelnyk
	 * @param passwordRequestModel - a request which written by JSON and send from
	 *                             outside form
	 * @return PasswordResponseModel - a response of request. 0 - hash password sent
	 *         by email, -1 - didn't sent.
	 * @throws Exception - need for sending email with password hash
	 * @since w0.10a1.4d1.3m0.0
	 */
	@PostMapping("/restore-password")
	public @ResponseBody PasswordResponseModel getSubscriberPassHash(final PasswordRequestModel passwordRequestModel)
			throws Exception {
		PasswordResponseModel passwordResponseModel = null;
		String answer;
		String usrEmail;

		logger.info("Incoming password restore request(info): {}", passwordRequestModel.toString());

		answer = dbBridge.getCurrentUsrPassHash(passwordRequestModel.getLogin());
		usrEmail = passwordRequestModel.getEmail();

		if (!answer.equalsIgnoreCase("None")) {
			ObjectMapper regResult = new ObjectMapper();
			passwordResponseModel = regResult.readValue(Utils.positiveAnswer, PasswordResponseModel.class);

			Mail mail = new Mail();
			mail.setMailFrom("msvamailsender@gmail.com");
			mail.setMailTo(usrEmail);
			mail.setMailSubject("Subcriber's pass hash mail");
			mail.setMailContent("Your password hash is: " + answer);
			mailService.sendEmail(mail);

		} else {
			ObjectMapper regResult = new ObjectMapper();
			passwordResponseModel = regResult.readValue(Utils.negativeAnswer, PasswordResponseModel.class);
		}

		logger.info("Password restore response (info): {}", passwordResponseModel.toString());

		return passwordResponseModel;
	}

	// @RequestBody - delete before implement into Heroku
	/**
	 * Description: method for handling changing password request
	 *
	 * @author Denys Shabelnyk
	 * @param chPasswordRequestModel - a request which written by JSON and send from
	 *                               outside form
	 * @return ChPasswordResponseModel - a response of request. 0 - success, -1 -
	 *         failure.
	 * @throws Exception - need for sending email with password hash
	 * @since w0.11a1.5d1.4m0.0
	 */
	@PostMapping("/change-password")
	public @ResponseBody ChPasswordResponseModel doChangePasswordRequest(ChPasswordRequestModel chPasswordRequestModel)
			throws Exception {
		ChPasswordResponseModel chPasswordResponseModel = null;
		Integer answer;

		logger.info("Incoming password changing request(info): {}", chPasswordRequestModel.toString());

		answer = dbBridge.changeSubscriberPassword(chPasswordRequestModel.getLogin(),
				Utils.getBase64HashPhrase(chPasswordRequestModel.getOldPassword()),
				Utils.getBase64HashPhrase(chPasswordRequestModel.getNewPassword()));

		String resultInString = String.valueOf(answer);

		ObjectMapper regResult = new ObjectMapper();
		chPasswordResponseModel = regResult.readValue(resultInString, ChPasswordResponseModel.class);

		logger.info("Change password response (info): {}", chPasswordResponseModel.toString());

		return chPasswordResponseModel;
	}

}