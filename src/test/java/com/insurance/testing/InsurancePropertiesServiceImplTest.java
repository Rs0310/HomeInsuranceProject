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
import com.insurance.entities.Properties;
import com.insurance.exception.PolicyNotFoundException;
import com.insurance.service.IPolicyService;
import com.insurance.service.IPropertieservice;

@SuppressWarnings("unused")
@SpringBootTest
class InsurancePropertiesServiceImplTest {
	/*
	 * Auto wiring
	 */
	@Autowired
	private IPropertieservice pserr;
	final Logger logger = LoggerFactory.getLogger(HomeInsuranceGroup4Batch2Application.class);
	
	/*
	 * Test methods
	 */
	@Test
	public void testaddPropertie() {
		Properties p = new Properties(10,222,333,234,"medium","top",9,7,3,"yes");
		int id = p.getPropertyid();
		logger.info("The element added with id" + id);
		pserr.addProperties(p);
		assertThat(p.getPropertyid()).isEqualTo(10);
		assertThat(p.getMarketValue()).isEqualTo(222);
		assertThat(p.getYearBuilt()).isEqualTo(333);
		assertThat(p.getSquareFootage()).isEqualTo(234);
		assertThat(p.getDwellingStyle()).isEqualTo(9);
		assertThat(p.getRoofMaterial()).isEqualTo("top");
		assertThat(p.getGarageType()).isEqualTo("medium");
		assertThat(p.getFullBathCount()).isEqualTo(7);
		assertThat(p.getHalfBathCount()).isEqualTo(3);
		assertThat(p.getHasSwimmingPool()).isEqualTo("yes");
	}

	@Test
	public void testshowallProperties() {
		List<Properties> p=pserr.showAllProperties();
		logger.info("The list of elements are");
		for (Properties i : p) {
			int id = i.getPropertyid();
			logger.info("The details for id "+ id);
		}
		assertThat(p).size().isGreaterThan(0);

	}

}