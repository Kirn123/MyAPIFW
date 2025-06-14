package com.qa.api.exceptions;

public class APIException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public APIException(String message) {
		super(message);
	}

	public APIException(String message, Throwable cause) {
		super(message, cause);
	}

	public APIException(Throwable cause) {
		super(cause);
	}

	public APIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
