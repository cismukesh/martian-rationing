package com.martian.rationing.exceptions;

public class BadRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4288253916511191681L;
	private String errorCode;
	private String errorMessage;

	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public BadRequestException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
}
