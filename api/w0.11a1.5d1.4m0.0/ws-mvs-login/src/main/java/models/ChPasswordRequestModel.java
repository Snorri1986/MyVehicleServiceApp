package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChPasswordRequestModel {
	private String login;
	private String oldPassword;
	private String newPassword;

	public ChPasswordRequestModel() {
		super();
	}

	public ChPasswordRequestModel(String login, String oldPassword, String newPassword) {
		super();
		this.login = login;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	@JsonProperty("login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@JsonProperty("oldpass")
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	@JsonProperty("newpass")
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "ChPasswordRequestModel [login=" + login + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + "]";
	}
}