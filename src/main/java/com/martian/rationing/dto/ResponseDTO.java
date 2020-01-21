package com.martian.rationing.dto;

import java.io.Serializable;

public class ResponseDTO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1920346260963919257L;
	private String statusCode;
	private String statusMessage;
	private T results;

	public ResponseDTO(String statusCode, String statusMessage) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public ResponseDTO(String statusCode, String statusMessage, T results) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.results = results;
	}

	public ResponseDTO() {
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public T getResults() {
		return results;
	}

	public void setResults(T results) {
		this.results = results;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseVO [statusCode=");
		builder.append(statusCode);
		builder.append(", statusMessage=");
		builder.append(statusMessage);
		builder.append(", results=");
		builder.append(results);
		builder.append("]");
		return builder.toString();
	}

}
