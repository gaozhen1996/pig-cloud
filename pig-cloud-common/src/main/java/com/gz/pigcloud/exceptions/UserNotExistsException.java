package com.gz.pigcloud.exceptions;

public class UserNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotExistsException() {
	}

	public UserNotExistsException(String message) {
		super(message);
	}

	public UserNotExistsException(Throwable cause) {
		super(cause);
	}

	public UserNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}