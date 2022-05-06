package models;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

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