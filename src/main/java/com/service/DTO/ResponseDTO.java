package com.service.DTO;

public class ResponseDTO {

	private int code;
	private Object data;
	private boolean success;

	public ResponseDTO() {

	}

	public ResponseDTO(int code, Object data, boolean success) {
		super();
		this.code = code;
		this.data = data;
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getdata() {
		return data;
	}

	public void setdata(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
