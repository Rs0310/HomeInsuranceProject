package com.insurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entities.Policy;
import com.insurance.exception.PolicyNotFoundException;
import com.insurance.service.IPolicyService;

@RestController
@RequestMapping("/api/v1")
public class PolicyControl {
	/*
	 *  AutoWired service layer
	 */
	@Autowired
	private IPolicyService pser;

	/*
	 *  Get mapping used to get list of policies
	 */
	@GetMapping("/policy")
	public ResponseEntity<List<Policy>> getAllPolicies() {
		List<Policy> policy = pser.showAllPolicies();
		if (policy.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<Policy>>(policy, HttpStatus.OK); 
	}

	/*
	 *  Post mapping used to add policy
	 */
	@PostMapping("/addpolicy")
	public ResponseEntity<List<Policy>> addPolicy(@Valid @RequestBody Policy policy) {
		List<Policy> policy1 = pser.addPolicy(policy);
		if (policy1.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<Policy>>(policy1, HttpStatus.OK);
	}

	/*
	 *  Put mapping used to update policy
	 */
	@PutMapping("/policy/{policyId}")
	public ResponseEntity<Policy> updatePolicy(@PathVariable("policyId") String policyId, @RequestBody Policy policy)
			throws PolicyNotFoundException {

		Policy policy2 = pser.readPolicy(policyId);
		ResponseEntity<Policy> response = null;
		if (policy2.getPolicyid() != null) {
			pser.updatePolicy(policy);
			response = new ResponseEntity<Policy>(policy2, HttpStatus.OK);
			return response;
		} else
			throw new PolicyNotFoundException("Policy with this ID Not Found");
	}

	/*
	 *  Get mapping used to findPolicy by id
	 */
	@GetMapping("/policyfind/{policyId}")
	public ResponseEntity<Policy> findPolicy(@PathVariable("policyId") String policyId) throws PolicyNotFoundException {
		Policy policy3 = pser.readPolicy(policyId);
		ResponseEntity<Policy> response = null;
		if (policy3.getPolicyid() != null) {
			pser.findPolicyById(policyId);
			response = new ResponseEntity<Policy>(policy3, HttpStatus.OK);
			return response;
		} else

			throw new PolicyNotFoundException("Policy with this ID Not Found");
	}

	/*
	 *  Delete mapping used to delete policy
	 */
	@DeleteMapping("/policyfind/{policyId}")
	public ResponseEntity<Policy> deletePolicy(@PathVariable("policyId") String policyId)
			throws PolicyNotFoundException {

		Policy policy4 = pser.readPolicy(policyId);
		ResponseEntity<Policy> response = null;
		if (policy4.getPolicyid() != null) {
			pser.removePolicy(policyId);
			response = new ResponseEntity<Policy>(policy4, HttpStatus.OK);
			return response;
		} else
			throw new PolicyNotFoundException("Policy with this ID Not Found");
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return errors;
	}
}
