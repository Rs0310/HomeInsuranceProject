package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.dao.PolicyHolderRepository;
import com.insurance.entities.PolicyHolder;
import com.insurance.exception.PolicyHolderNotFoundException;

@Service
public class PolicyHolderServiceImpl implements IPolicyHolderService {
	/*
	 *  Autowired repositorylayer
	 */
	@Autowired
	private PolicyHolderRepository policyRepo;

	@Override
	public List<PolicyHolder> showAllPolicyHolders() {
		return policyRepo.findAll();
	}

	@Override
	public List<PolicyHolder> addPolicyHolder(PolicyHolder policyHolder) {
		policyRepo.saveAndFlush(policyHolder);
		return policyRepo.findAll();
	}

	@Override
	public List<PolicyHolder> updatePolicyHolder(PolicyHolder policyHolder) {
		policyRepo.save(policyHolder);
		return policyRepo.findAll();
	}

	@Override
	public PolicyHolder findPolicyHolderById(int policyHolderId) {
		Optional<PolicyHolder> pol = policyRepo.findById(policyHolderId); // predefined method
		return pol.get();
	}

	@Override
	public List<PolicyHolder> removePolicyHolder(int policyHolderId) {
		policyRepo.deleteById(policyHolderId);
		return policyRepo.findAll();
	}

	@Override
	public PolicyHolder readPolicyHolder(int policyHolderid) throws PolicyHolderNotFoundException {
		PolicyHolder result = policyRepo.readPolicyHolder(policyHolderid);
		if (result != null) {
			return result;
		} else {
			PolicyHolder p = new PolicyHolder();
			p.setPolicyHolderId(0);
			return p;
		}
	}
}
