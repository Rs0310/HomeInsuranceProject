package com.insurance.exception;

/*
 * User defined Exception
 */
@SuppressWarnings("serial")
public class PolicyNotFoundException extends Exception {
	public PolicyNotFoundException(String message) {
		super(message);
	}
}
