package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.insurance.entities.Admin;
import com.insurance.entities.Agent;
import com.insurance.entities.Policy;
import com.insurance.entities.PolicyHolder;
import com.insurance.exception.AgentNotFoundException;
import com.insurance.exception.PolicyHolderNotFoundException;
import com.insurance.exception.PolicyNotFoundException;
import com.insurance.service.IAdminService;
import com.insurance.service.IAgentService;
import com.insurance.service.IPolicyHolderService;
import com.insurance.service.IPolicyService;

@RestController
@RequestMapping("/api/v1")

public class AdminController {
/*
 *  Autowired serviced layer
 */
	@Autowired
	private IPolicyService aser;
/*
 * Autowired serviced layer
 */
	@Autowired
	private IAgentService agser;
/*
 * Autowired serviced layer
 */
	@Autowired
	private IPolicyHolderService policyService;
/*
 * Autowired service layer
 */
	@Autowired
	private IAdminService aservice;

/*
 * Login
 */
	@GetMapping("/loginadmin")
	public ResponseEntity<Admin> logincheck() {
		int adminid = 1;
		String adminname = "Srinivas";
		Admin a = aservice.loginCheck(adminid, adminname);
		if (a != null) {

			return new ResponseEntity("Hello admin", HttpStatus.OK);

		}
		return new ResponseEntity("Hello please enter valid credentials", HttpStatus.OK);
	}

/*
 *  Policy operations
 */
/*
 * Get mapping list is to get the policy list
 */
	@GetMapping("/policies")
	public ResponseEntity<List<Policy>> getAllPolicy() {
		List<Policy> policy = aser.showAllPolicies();
		if (policy.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<Policy>>(policy, HttpStatus.OK);
	}

/*
 * Delete mapping list is to delete the policy list
 */
	@DeleteMapping("/policydelete/{policyId}")
	public ResponseEntity<Policy> deletePolicy(@PathVariable("policyId") String policyId)
			throws PolicyNotFoundException {
		Policy policy4 = aser.readPolicy(policyId);
		ResponseEntity<Policy> response = null;
		if (policy4.getPolicyid() != null) {
			aser.removePolicy(policyId);
			response = new ResponseEntity<Policy>(policy4, HttpStatus.OK);
			return response;
		} else
			throw new PolicyNotFoundException("Policy with this ID Not Found");

	}

	/*
	 *  Agent operations
	 */
/*
 * Get mapping list is to get the agent list
 */
	@GetMapping("/agentlist")
	public ResponseEntity<List<Agent>> getAllAgent() {
		List<Agent> agent = agser.viewAllAgents();
		if (agent.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<Agent>>(agent, HttpStatus.OK);
	}

/*
 * Delete mapping list is to delete the agent list
 */
	@DeleteMapping(path = "admin/{id}")
	public ResponseEntity<Agent> removeAgent(@PathVariable("id") int id, @RequestBody Agent agent)
			throws AgentNotFoundException {
		Agent result = agser.readAgent(id);
		ResponseEntity<Agent> response = null;
		if (result.getAgentId() != 0) {
			agser.removeAgent(id);
			response = new ResponseEntity<Agent>(result, HttpStatus.OK);
			return response;
		} else
			throw new AgentNotFoundException("Agent with this ID not found");
	}

	/*
	 *  PolicyHolder operations
	 */
/*
 * Get mapping list is to get the PolicyHolder list
 */
	@GetMapping("/showpolicyholders")
	public ResponseEntity<List<PolicyHolder>> showAllPolicyHolders() {
		List<PolicyHolder> e = policyService.showAllPolicyHolders();
		if (e.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<PolicyHolder>>(e, HttpStatus.OK);
	}

/*
 * Delete mapping list is to delete the PolicyHolder list
 */
	@DeleteMapping(path = "/deletepolicyholders/{id}")
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
}
