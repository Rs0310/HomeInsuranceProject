package com.insurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entities.Properties;
import com.insurance.service.IPropertieservice;

@RestController
@RequestMapping("/api/v1")
public class PropertiesController {
	/*
	 *  Autowired service layer
	 */
	@Autowired
	private IPropertieservice pser;

	/*
	 *  shows the list of property
	 */
	@GetMapping("/showproperty")
	public ResponseEntity<List<Properties>> showAllPolicyHolders() {
		List<Properties> e = pser.showAllProperties();
		if (e.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<Properties>>(e, HttpStatus.OK);
	}

	/*
	 *  adds new property
	 */
	@PostMapping("/addproperty")
	public ResponseEntity<List<Properties>> addPolicyHolder(@Valid @RequestBody Properties policyholder) {
		List<Properties> pol = pser.addProperties(policyholder);
		if (pol.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<Properties>>(pol, HttpStatus.OK);
	}

	/*
	 *  Exception for validation
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return errors;
	}
}
