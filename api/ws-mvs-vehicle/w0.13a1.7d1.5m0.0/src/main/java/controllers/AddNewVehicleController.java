// TODO: test this class on Rest Client
package controllers;

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

	@PostMapping("/addNewVehicle")
	public @ResponseBody AddNewVehicleResponse doAddNewVehicle(AddNewVehicleRequest addNewVehicleRequest)

			throws Exception {
		AddNewVehicleResponse addNewVehicleResponse = null;
		Integer answer;

		logger.info("Incoming add new vehicle request(info): {}", addNewVehicleRequest.toString());

		answer = dbMethods.addNewVehicle(addNewVehicleRequest.getLogin(), addNewVehicleRequest.getBrand(),
				addNewVehicleRequest.getModel(), addNewVehicleRequest.getDateOfManufacturing(),
				addNewVehicleRequest.getTotalMileage(), addNewVehicleRequest.getLastServiceCheck(),
				addNewVehicleRequest.getType(), addNewVehicleRequest.getStateNumber());

		String resultInString = String.valueOf(answer);

		ObjectMapper regResult = new ObjectMapper();
		addNewVehicleResponse = regResult.readValue(resultInString, AddNewVehicleResponse.class);

		logger.info("Add new vehicle response (info): {}", addNewVehicleResponse.toString());

		return addNewVehicleResponse;
	}

}
// ... //