package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.PolicyRepository;
import com.insurance.entities.Policy;
import com.insurance.exception.PolicyNotFoundException;

@Service
public class PolicyServiceImpl implements IPolicyService {
	/*
	 *  Autowired repository layer
	 */
	@Autowired
	private PolicyRepository prep;

	@Override
	public List<Policy> showAllPolicies() {
		// TODO Auto-generated method stub
		return prep.findAll();
	}

	@Override
	public List<Policy> addPolicy(Policy policy) {
		prep.saveAndFlush(policy);
		return prep.findAll();
	}

	@Override
	public List<Policy> updatePolicy(Policy policy) {
		prep.saveAndFlush(policy);
		return prep.findAll();
	}

	@Override
	public Policy findPolicyById(String policyId) {
		Optional<Policy> p = prep.findById(policyId);
		return p.get();
	}

	@Override
	public List<Policy> removePolicy(String policyId) {
		prep.deleteById(policyId);
		return prep.findAll();
	}

	/*
	 * read method
	 */
	@Override
	public Policy readPolicy(String policyid) throws PolicyNotFoundException {
		Policy result = prep.readpolicy(policyid);
		if (result != null) {
			return result;
		} else {
			Policy p = new Policy();
			p.setPolicyid(null);
			return p;
		}
	}

}
