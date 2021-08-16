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
import com.insurance.entities.PolicyHolder;
import com.insurance.exception.PolicyHolderNotFoundException;
import com.insurance.service.IPolicyHolderService;

@RestController
@RequestMapping("/api/v1")
public class PolicyHolderController {
	/*
	 *  AutoWired service layer
	 */
	@Autowired
	private IPolicyHolderService policyService;

	/*
	 *  Get mapping used to get list of policyholders
	 */
	@GetMapping("/showpolicyholder")
	public ResponseEntity<List<PolicyHolder>> showAllPolicyHolders() {
		List<PolicyHolder> show = policyService.showAllPolicyHolders();
		if (show.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<PolicyHolder>>(show, HttpStatus.OK);
	}

	/*
	 *  Post mapping used to add policyholder
	 */
	@PostMapping("/addpolicyholder")
	public ResponseEntity<List<PolicyHolder>> addPolicyHolder(@Valid @RequestBody PolicyHolder policyholder) {
		List<PolicyHolder> pol = policyService.addPolicyHolder(policyholder);
		if (pol.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<PolicyHolder>>(pol, HttpStatus.OK);
	}

	/*
	 *  Put mapping used to update policyholder
	 */
	@PutMapping("/updatepolicyholder/{policyHolderId}")
	public ResponseEntity<PolicyHolder> updatePolicyHolder(@PathVariable("policyHolderId") Integer policyHolderId,
			@RequestBody PolicyHolder policyholder) throws PolicyHolderNotFoundException {
		PolicyHolder pol = policyService.readPolicyHolder(policyHolderId);
		ResponseEntity<PolicyHolder> response = null;
		if (pol.getPolicyHolderId() != 0) {
			policyService.updatePolicyHolder(policyholder);
			response = new ResponseEntity<PolicyHolder>(pol, HttpStatus.OK);
			return response;

		} else

			throw new PolicyHolderNotFoundException("PolicyHolder with this ID Not Found");
	}

	/*
	 *  Get mapping used to findpolicyholder by id
	 */
	@GetMapping("/findpolicyholder/{policyHolderId}")
	public ResponseEntity<PolicyHolder> findPolicyHolder(@PathVariable("policyHolderId") Integer policyHolderId)
			throws PolicyHolderNotFoundException {
		PolicyHolder pol = policyService.readPolicyHolder(policyHolderId);
		ResponseEntity<PolicyHolder> response = null;
		if (pol.getPolicyHolderId() != 0) {
			policyService.findPolicyHolderById(policyHolderId);
			response = new ResponseEntity<PolicyHolder>(pol, HttpStatus.OK);
			return response;
		} else

			throw new PolicyHolderNotFoundException("PolicyHolder with this ID Not Found");
	}

	/*
	 *  Delete mapping used to delete policyholder
	 */
	@DeleteMapping(path = "/deletepolicyholder/{id}")
	public ResponseEntity<PolicyHolder> deletePolicyHolder(@PathVariable("id") int id, @RequestBody PolicyHolder p)
			throws PolicyHolderNotFoundException {
		PolicyHolder result = policyService.readPolicyHolder(id);
		ResponseEntity<PolicyHolder> response = null;
		if (result.getPolicyHolderId() != 0) {
			policyService.removePolicyHolder(id);
			response = new ResponseEntity<PolicyHolder>(result, HttpStatus.OK);
			return response;
		} else
			throw new PolicyHolderNotFoundException("PolicyHolder with this ID Not Found");
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
