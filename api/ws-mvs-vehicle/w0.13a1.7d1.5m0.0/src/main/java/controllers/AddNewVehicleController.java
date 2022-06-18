package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.AddNewVehicleRequest;
import models.AddNewVehicleResponse;
import repository.DbMethods;

/**
 * Description: The controller class for adding new vehicle
 *
 * @author Denys Shabelnyk
 * @since w0.13a1.7d1.5m0.0
 */
@RestController
public class AddNewVehicleController {

	private static final Logger logger = LoggerFactory.getLogger(AddNewVehicleController.class);

	@Autowired
	DbMethods dbMethods;

	/**
	 * Description: The method for handling adding new vehicle from client
	 *
	 * @param addNewVehicleRequest - request model
	 * @return AddNewVehicleResponse - 0 - successfully adding, -1 - error or
	 *         duplicate value
	 * @throws Exception - general exception
	 * @since w0.13a1.7d1.5m0.0
	 */
	@PostMapping("/add-new-vehicle")
	public @ResponseBody AddNewVehicleResponse doAddNewVehicle(AddNewVehicleRequest addNewVehicleRequest)

			throws Exception {
		AddNewVehicleResponse addNewVehicleResponse = null;
		Integer answer;

		logger.info("Incoming add new vehicle request(info): {}", addNewVehicleRequest.toString());

		DateFormat formatter = new SimpleDateFormat("dd.mm.yyyy");
		Date lsrvcheck = formatter.parse(addNewVehicleRequest.getLastServiceCheck());

		answer = dbMethods.addNewVehicle(addNewVehicleRequest.getLogin(), addNewVehicleRequest.getBrand(),
				addNewVehicleRequest.getModel(), Integer.parseInt(addNewVehicleRequest.getDateOfManufacturing()),
				Integer.parseInt(addNewVehicleRequest.getTotalMileage()), lsrvcheck, addNewVehicleRequest.getType(),
				addNewVehicleRequest.getStateNumber());

		String resultInString = String.valueOf(answer);

		if (resultInString == "null") {
			addNewVehicleResponse = new AddNewVehicleResponse(-1);
			logger.info("Add new vehicle response (info): {}", addNewVehicleResponse.toString());
			return addNewVehicleResponse;
		} else {
			ObjectMapper regResult = new ObjectMapper();
			addNewVehicleResponse = regResult.readValue(resultInString, AddNewVehicleResponse.class);
			logger.info("Add new vehicle response (info): {}", addNewVehicleResponse.toString());
		}

		return addNewVehicleResponse;
	}

}
