package com.alcd.appbackend.services.exceptions;

public class UnickKeyException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UnickKeyException(String msg) {
		super(msg);
	}
	
	public UnickKeyException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
