package com.insurance.service;

import java.util.List;
import com.insurance.exception.PolicyNotFoundException;

import com.insurance.entities.Policy;

/*
 * policy interface
 */
public interface IPolicyService {
	public List<Policy> addPolicy(Policy policy);

	public List<Policy> showAllPolicies();

	public List<Policy> updatePolicy(Policy policy) throws PolicyNotFoundException;

	public Policy findPolicyById(String policyId) throws PolicyNotFoundException;

	public List<Policy> removePolicy(String policyId) throws PolicyNotFoundException;

	Policy readPolicy(String policyid) throws PolicyNotFoundException;

}
