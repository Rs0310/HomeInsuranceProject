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
import com.insurance.entities.PolicyHolder;
import com.insurance.exception.PolicyHolderNotFoundException;
import com.insurance.service.IPolicyHolderService;

@SpringBootTest
class InsurancePolicyHolderServiceImplTest {
	/*
	 * Auto wiring
	 */
	@Autowired
	private IPolicyHolderService policyService;
	static final Logger LOGGER = LoggerFactory.getLogger(HomeInsuranceGroup4Batch2Application.class);

	/*
	 * Test methods
	 */
	@Test
	public void testaddPolicyHolder() throws PolicyHolderNotFoundException {
		PolicyHolder policyholder = new PolicyHolder(9, "Van", "lic", "premium", "sbi", "jan", "emp", 6000.1, "yes",
				"ssh", "ram@gmail");
		int id = policyholder.getPolicyHolderId();
		LOGGER .info("The element added with id"+id);
		policyService.addPolicyHolder(policyholder);
		PolicyHolder result = policyService.readPolicyHolder(9);
		assertThat(policyholder.getPolicyHolderId()).isEqualTo(result.getPolicyHolderId());
		assertThat(policyholder.getPolicyHolderName()).isEqualTo(result.getPolicyHolderName());
		assertThat(policyholder.getPolicyName()).isEqualTo(result.getPolicyName());
		assertThat(policyholder.getPremiumType()).isEqualTo(result.getPremiumType());
		assertThat(policyholder.getCreditCard()).isEqualTo(result.getCreditCard());
		assertThat(policyholder.getDob()).isEqualTo(result.getDob());
		assertThat(policyholder.getOccupation()).isEqualTo(result.getOccupation());
		assertThat(policyholder.getAnnualIncome()).isEqualTo(result.getAnnualIncome());
		assertThat(policyholder.getIsRetired()).isEqualTo(result.getIsRetired());
		assertThat(policyholder.getSsn()).isEqualTo(result.getSsn());
		assertThat(policyholder.getEmailId()).isEqualTo(result.getEmailId());
	}

	@Test
	public void testfindbyPolicyHolderId() throws PolicyHolderNotFoundException {
		int policyHolderId = 9;
		LOGGER .info("The element with id to find is "+policyHolderId);
		PolicyHolder policyholder = policyService.findPolicyHolderById(policyHolderId);

		assertThat(policyholder.getPolicyHolderId()).isEqualTo(policyHolderId);
	}

	@Test
	public void testupdatePolicyHolder() throws PolicyHolderNotFoundException {
		int policyHolderId = 9;
		LOGGER .info("The update is started for element with id "+policyHolderId);
		PolicyHolder policyholder = new PolicyHolder(policyHolderId, "Van", "lic", "premium", "sbi", "jan", "employee", 7000.1,
				"yes", "shijkla", "jank@gmail.com");
		policyholder.setCreditCard("hdfc");
		policyService.addPolicyHolder(policyholder);
		PolicyHolder update = policyService.findPolicyHolderById(policyHolderId);
		assertThat(update.getCreditCard()).isEqualTo(policyholder.getCreditCard());
	}

	@Test
	public void testshowallPolicyHolder() {
		List<PolicyHolder> p = policyService.showAllPolicyHolders();
		LOGGER .info("The list of elements are");
		for(PolicyHolder i:p)
		{
			int id = i.getPolicyHolderId();
			LOGGER .info("The details for id "+id);
		}
		assertThat(p).size().isGreaterThan(0);
	}

	@Test
	public void testremovePolicyHolder() throws PolicyHolderNotFoundException {
		int id = 9;
		LOGGER .info("The element to be removed is "+id);
		policyService.removePolicyHolder(id);
		PolicyHolder result = policyService.readPolicyHolder(id);
		Assertions.assertNull(result.getPolicyHolderName());
	}
}

