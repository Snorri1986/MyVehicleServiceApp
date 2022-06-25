// new code //
package models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class AddNewVehicleRequestModel {
	private String login;
	private String brand;
	private String model;
	private String dateOfManufacturing;
	private String totalMileage;
	private String lastServiceCheck;
	private String type;
	private String stateNumber;

	public AddNewVehicleRequestModel() {

	}

	public AddNewVehicleRequestModel(String login, String brand, String model, String dateOfManufacturing,
			String totalMileage, String lastServiceCheck, String type, String stateNumber) {
		this.login = login;
		this.brand = brand;
		this.model = model;
		this.dateOfManufacturing = dateOfManufacturing;
		this.totalMileage = totalMileage;
		this.lastServiceCheck = lastServiceCheck;
		this.type = type;
		this.stateNumber = stateNumber;
	}

	/**
	 * Description: login getter
	 *
	 * @author Denys Shabelnyk
	 *
	 * @return String value of login variable
	 *
	 * @since w0.13a1.7d1.5m0.0
	 */
	@JsonProperty("login")
	public String getLogin() {
		return login;
	}

	/**
	 * Description: login setter
	 *
	 * @author Denys Shabelnyk
	 * @param login gets from internal JSON request
	 * @since w0.13a1.7d1.5m0.0
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Description: brand of vehicle getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of brand variable
	 * @since w0.13a1.7d1.5m0.0
	 */
	@JsonProperty("brand")
	public String getBrand() {
		return brand;
	}

	/**
	 * Description: brand setter
	 *
	 * @author Denys Shabelnyk
	 * @param brand gets from internal JSON request
	 * @since w0.13a1.7d1.5m0.0
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Description: model of vehicle getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of model variable
	 * @since w0.13a1.7d1.5m0.0
	 */
	@JsonProperty("model")
	public String getModel() {
		return model;
	}

	/**
	 * Description: model setter
	 *
	 * @author Denys Shabelnyk
	 * @param model gets from internal JSON request
	 * @since w0.13a1.7d1.5m0.0
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Description: date of manufacturing of vehicle getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of model variable
	 * @since w0.13a1.7d1.5m0.0
	 */
	@JsonProperty("dom")
	public String getDateOfManufacturing() {
		return dateOfManufacturing;
	}

	/**
	 * Description: date of manufacturing setter
	 *
	 * @author Denys Shabelnyk
	 * @param dateOfManufacturing gets from internal JSON request
	 * @since w0.13a1.7d1.5m0.0
	 */
	public void setDateOfManufacturing(String dateOfManufacturing) {
		this.dateOfManufacturing = dateOfManufacturing;
	}

	/**
	 * Description: total mileage of vehicle getter
	 *
	 * @author Denys Shabelnyk
	 * @return String value of total mileage variable
	 * @since w0.13a1.7d1.5m0.0
	 */
	@JsonProperty("tmileage")
	public String getTotalMileage() {
		return totalMileage;
	}

	/**
	 * Description: total mileage setter
	 *
	 * @author Denys Shabelnyk
	 * @param totalMileage gets from internal JSON request
	 * @since w0.13a1.7d1.5m0.0
	 */
	public void setTotalMileage(String totalMileage) {
		this.totalMileage = totalMileage;
	}

	/**
	 * Description: last service check of vehicle getter
	 *
	 * @author Denys Shabelnyk
	 * @return String of last service check
	 * @since w0.13a1.7d1.5m0.0
	 */
	@JsonProperty("lsrvcheck")
	public String getLastServiceCheck() {
		return lastServiceCheck;
	}

	/**
	 * Description: last service check setter
	 *
	 * @author Denys Shabelnyk
	 * @param lastServiceCheck gets from internal JSON request
	 * @since w0.13a1.7d1.5m0.0
	 */
	public void setLastServiceCheck(String lastServiceCheck) {
		this.lastServiceCheck = lastServiceCheck;
	}

	/**
	 * Description: type of vehicle getter
	 *
	 * @author Denys Shabelnyk
	 * @return String type of vehicle
	 * @since w0.13a1.7d1.5m0.0
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	/**
	 * Description: type of vehicle setter
	 *
	 * @author Denys Shabelnyk
	 * @param type gets from internal JSON request
	 * @since w0.13a1.7d1.5m0.0
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Description: state number of vehicle getter
	 *
	 * @author Denys Shabelnyk
	 * @return String state number of vehicle
	 * @since w0.13a1.7d1.5m0.0
	 */
	@JsonProperty("statenumber")
	public String getStateNumber() {
		return stateNumber;
	}

	/**
	 * Description: stateNumber setter
	 *
	 * @author Denys Shabelnyk
	 * @param stateNumber gets from internal JSON request
	 * @since w0.13a1.7d1.5m0.0
	 */
	public void setStateNumber(String stateNumber) {
		this.stateNumber = stateNumber;
	}

	/**
	 * Description: simple toString() method in default implementation
	 *
	 * @author Denys Shabelnyk
	 * @since w0.13a1.7d1.5m0.0
	 */
	@Override
	public String toString() {
		return String.format(
				"AddNewVehicleRequestModel [login=%s, brand=%s, model=%s, dateOfManufacturing=%s, totalMileage=%s, lastServiceCheck=%s, type=%s, stateNumber=%s]",
				login, brand, model, dateOfManufacturing, totalMileage, lastServiceCheck, type, stateNumber);
	}

}
// ... //