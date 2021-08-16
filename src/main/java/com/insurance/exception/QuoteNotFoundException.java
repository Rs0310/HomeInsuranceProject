package com.insurance.exception;

/*
 * User defined Exception
 */
@SuppressWarnings("serial")
public class QuoteNotFoundException extends Exception {

	public QuoteNotFoundException(String message) {
		super(message);
	}
}
