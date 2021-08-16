package com.insurance.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.HomeInsuranceGroup4Batch2Application;
import com.insurance.entities.Policy;
import com.insurance.exception.PolicyNotFoundException;
import com.insurance.service.IPolicyService;

@SuppressWarnings("unused")
@SpringBootTest
class InsurancePolicyServiceImplTest {
	/*
	 * Auto wiring
	 */
	@Autowired
	private IPolicyService pser;
	final Logger logger = LoggerFactory.getLogger(HomeInsuranceGroup4Batch2Application.class);

/*
 * Test method
 */
	@Test
	public void testaddPolicy() throws PolicyNotFoundException {
		Policy policy = new Policy("gold", "10/10/2020", "10/10/2023", 3, "active");
		String id = policy.getPolicyid();
		logger.info("The element added with id" + id);
		pser.addPolicy(policy);
		Policy result = pser.readPolicy("gold");
		assertThat(policy.getPolicyid()).isEqualTo(result.getPolicyid());
		assertThat(policy.getPolicyeffectivedate()).isEqualTo(result.getPolicyeffectivedate());
		assertThat(policy.getPolicyenddate()).isEqualTo(result.getPolicyenddate());
		assertThat(policy.getPolicyterm()).isEqualTo(result.getPolicyterm());
		assertThat(policy.getPolicystatus()).isEqualTo(result.getPolicystatus());

	}


	@Test
	public void testfindbyPolicyId() throws PolicyNotFoundException {
		String policyId = "gold";
		logger.info("The element with id to find is" + policyId);
		Policy policy = pser.findPolicyById(policyId);

		assertThat(policy.getPolicyid()).isEqualTo(policyId);

	}

	@Test
	public void testupdatePolicy() throws PolicyNotFoundException {
		String policyId = "silver";
		logger.info("The update is started for element with id" + policyId);
		Policy policy = new Policy(policyId, "10/10/2020", "10/10/2023", 3, "active");
		policy.setPolicyenddate("09/11/2020");
		pser.addPolicy(policy);
		Policy update = pser.findPolicyById(policyId);
		assertThat(update.getPolicyenddate()).isEqualTo(policy.getPolicyenddate());

	}


	@Test
	public void testshowallPolicies() {
		List<Policy> p = pser.showAllPolicies();
		logger.info("The list of elements are");
		for (Policy policy : p) {
			String policyid = policy.getPolicyid();
			logger.info("the details for id" + policyid);
		}
		assertThat(p).size().isGreaterThan(0);
	}


	@Test
	public void removePolicy() throws PolicyNotFoundException {
		String id = "policy4";
		logger.info("The element to be removed is" + id);
		pser.removePolicy(id);
		Policy result = pser.readPolicy("abc");
		Assertions.assertNull(result.getPolicyid());

	}
}