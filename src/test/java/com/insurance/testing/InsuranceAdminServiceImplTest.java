package com.insurance.testing;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.HomeInsuranceGroup4Batch2Application;
import com.insurance.entities.Agent;
import com.insurance.entities.Policy;
import com.insurance.entities.PolicyHolder;
import com.insurance.exception.AgentNotFoundException;
import com.insurance.exception.PolicyHolderNotFoundException;
import com.insurance.exception.PolicyNotFoundException;
import com.insurance.service.IAgentService;
import com.insurance.service.IPolicyHolderService;
import com.insurance.service.IPolicyService;

@SpringBootTest
class InsuranceAdminServiceImplTest {
	/*
	 * Autowiring
	 */
	@Autowired
	private IPolicyHolderService policyService;

	@Autowired
	private IPolicyService aser;

	@Autowired
	private IAgentService agser;

	final Logger logger = LoggerFactory.getLogger(HomeInsuranceGroup4Batch2Application.class);

	/*
	 * Test methods
	 */
	@Test
	public void testshowallPolicyHolder() {
		List<PolicyHolder> p = policyService.showAllPolicyHolders();
		for (PolicyHolder i : p) {
			logger.info("the id is" + i.getPolicyHolderId());
		}
		assertThat(p).size().isGreaterThan(0);
	}

	@Test
	public void testremovePolicyHolder() throws PolicyHolderNotFoundException {
		int id = 8;
		policyService.removePolicyHolder(id);
		logger.info("the  id to remove is " + id);
		PolicyHolder result = policyService.readPolicyHolder(id);
		Assertions.assertNull(result.getPolicyHolderName());
	}

	@Test
	public void testshowallPolicy() {
		List<Policy> p = aser.showAllPolicies();
		for (Policy i : p) {
			logger.info("the id is " + i.getPolicyid());
		}
		assertThat(p).size().isGreaterThan(0);
	}

	@Test
	public void testremovePolicy() throws PolicyNotFoundException {
		String id = "k";
		aser.removePolicy(id);
		logger.info("the  id to remove is " + id);
		Policy result = aser.readPolicy(id);
		Assertions.assertNull(result.getPolicyid());
	}

	@Test
	public void testshowallAgent() {
		List<Agent> p = agser.viewAllAgents();
		for (Agent i : p) {
			logger.info("the id is " + i.getAgentId());
		}
		assertThat(p).size().isGreaterThan(0);
	}

	@Test
	public void testremoveAgent() throws AgentNotFoundException {
		int id = 8;
		agser.removeAgent(id);
		logger.info("the  id to remove is " + id);
		Agent result = agser.readAgent(id);
		Assertions.assertNull(result.getAgentId());
	}
}
