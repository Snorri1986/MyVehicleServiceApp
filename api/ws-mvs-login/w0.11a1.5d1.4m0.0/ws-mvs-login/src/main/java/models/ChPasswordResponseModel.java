package models;

public class ChPasswordResponseModel {

	private Integer code;

	public ChPasswordResponseModel() {
		super();
	}

	public ChPasswordResponseModel(Integer code) {
		super();
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ChPasswordResponseModel [code=" + code + "]";
	}
}
