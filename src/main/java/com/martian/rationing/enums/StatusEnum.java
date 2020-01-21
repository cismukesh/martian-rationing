package com.martian.rationing.enums;

public enum StatusEnum {

	SUCCESS("MRS200", "Success"), BAD_REQUEST("MRS100",
			"Bad Request, Invaild Request Parameters"), UNKNOWN_EXCEPTION("MRS999");
	private String statusCode;
	private String statusMessage;

	/**
	 * @param statusCode
	 * @param statusMessage
	 */
	StatusEnum(String statusCode, String statusMessage) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	/***
	 * 
	 * @param statusCode
	 */
	StatusEnum(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

}
