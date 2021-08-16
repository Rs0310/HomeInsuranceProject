package com.insurance.exception;

/*
 * User defined Exception
 */
@SuppressWarnings("serial")
public class PolicyHolderNotFoundException extends Exception {
	public PolicyHolderNotFoundException(String message) {
		super(message);
	}
}
