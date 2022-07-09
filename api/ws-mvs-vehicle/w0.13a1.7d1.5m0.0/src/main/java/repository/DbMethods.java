package repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.AddNewVehicleResponse;

/**
 * Description: The repository class
 *
 * @author Denys Shabelnyk
 * @since w0.13a1.7d1.5m0.0
 */
@Repository
public class DbMethods {

	@Autowired
	EntityManager entityManager;

	/**
	 * Description: method for adding new vehicle
	 *
	 * @author Denys Shabelnyk
	 * @since w0.13a1.7d1.5m0.0
	 * @param login               - subscriber's login
	 * @param brand               - brand of a vehicle
	 * @param model               - model of a vehicle
	 * @param yearofmanufacturing - year of manufacturing
	 * @param totalmileage        - total milleage of the vehicle
	 * @param lastservicedate     - last service check of the vehicle
	 * @param type                - type of a vehicle
	 * @param statenumber         - state number of a vehicle
	 * @return Integer - result code. 0 - success, -1 - fail
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	public AddNewVehicleResponse addNewVehicle(String login, String brand, String model, Integer yearofmanufacturing,
			Integer totalmileage, Date lastservicedate, String type, String statenumber)
			throws JsonMappingException, JsonProcessingException {
		Integer answerCode = 0;

		AddNewVehicleResponse addNewVehicleResponse = null;

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("park.c_addnewvehicle")
				.registerStoredProcedureParameter("i_usrname", String.class, ParameterMode.IN)
				.setParameter("i_usrname", login)
				.registerStoredProcedureParameter("i_brand", String.class, ParameterMode.IN)
				.setParameter("i_brand", brand)
				.registerStoredProcedureParameter("i_model", String.class, ParameterMode.IN)
				.setParameter("i_model", model)
				.registerStoredProcedureParameter("i_dmanuf", Integer.class, ParameterMode.IN)
				.setParameter("i_dmanuf", yearofmanufacturing)
				.registerStoredProcedureParameter("i_tmilleage", Integer.class, ParameterMode.IN)
				.setParameter("i_tmilleage", totalmileage)
				.registerStoredProcedureParameter("i_lastservice", Date.class, ParameterMode.IN)
				.setParameter("i_lastservice", lastservicedate)
				.registerStoredProcedureParameter("i_type", String.class, ParameterMode.IN).setParameter("i_type", type)
				.registerStoredProcedureParameter("i_statenumber", String.class, ParameterMode.IN)
				.setParameter("i_statenumber", statenumber)
				.registerStoredProcedureParameter("v_result", Integer.class, ParameterMode.OUT);

		query.execute();
		answerCode = (Integer) query.getOutputParameterValue("v_result");

		ObjectMapper regResult = new ObjectMapper();
		addNewVehicleResponse = regResult.readValue(String.valueOf(answerCode), AddNewVehicleResponse.class);

		return addNewVehicleResponse;

	}

}