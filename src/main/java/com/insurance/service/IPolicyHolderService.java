package com.insurance.service;

import java.util.List;

import com.insurance.entities.PolicyHolder;
import com.insurance.exception.PolicyHolderNotFoundException;

/*
 * policyholder interface
 */
public interface IPolicyHolderService {

	public List<PolicyHolder> addPolicyHolder(PolicyHolder policyHolder);

	public List<PolicyHolder> showAllPolicyHolders();

	public List<PolicyHolder> updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;

	public PolicyHolder findPolicyHolderById(int policyHolderId) throws PolicyHolderNotFoundException;

	public List<PolicyHolder> removePolicyHolder(int policyHolderId) throws PolicyHolderNotFoundException;

	PolicyHolder readPolicyHolder(int policyHolderid) throws PolicyHolderNotFoundException;

}
