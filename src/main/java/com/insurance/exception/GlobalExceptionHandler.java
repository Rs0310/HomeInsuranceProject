package com.insurance.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * Exceptionhandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PolicyHolderNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handlePolicyHolderNotFoundException(PolicyHolderNotFoundException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);

	}

	@ExceptionHandler(AgentNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleAgentNotFoundException(AgentNotFoundException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);

	}

	@ExceptionHandler(PolicyNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handlePolicyNotFoundException(PolicyNotFoundException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);

	}
	
	@ExceptionHandler(QuoteNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleQuoteNotFoundException(QuoteNotFoundException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);

	}
}
