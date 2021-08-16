package com.insurance.exception;

/*
 * User defined Exception
 */
@SuppressWarnings("serial")
public class AgentNotFoundException extends Exception {

	public AgentNotFoundException(String message) {
		super(message);
	}
}