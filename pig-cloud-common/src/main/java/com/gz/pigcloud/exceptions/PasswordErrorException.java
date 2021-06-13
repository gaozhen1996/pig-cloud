package com.gz.pigcloud.exceptions;

public class PasswordErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PasswordErrorException() {
	}

	public PasswordErrorException(String message) {
		super(message);
	}

	public PasswordErrorException(Throwable cause) {
		super(cause);
	}

	public PasswordErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}