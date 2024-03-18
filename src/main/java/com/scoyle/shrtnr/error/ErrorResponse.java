package com.scoyle.shrtnr.error;

import javax.ws.rs.core.Response.Status;

public class ErrorResponse {
	
	private Status errorCode;
	private String message;
	
	public ErrorResponse(Status badRequest, String message) {
		this.setErrorCode(badRequest);
		this.setMessage(message);
	}
	
	public void setErrorCode(Status errorCode) {
		this.errorCode = errorCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Status getErrorCode() {
		return errorCode;
	}
	
	public String getMessage() {
		return message;
	}

}
