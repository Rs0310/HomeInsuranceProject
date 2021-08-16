package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.PropertiesRepository;
import com.insurance.entities.Properties;

/*
 * service class
 */
@Service
public class IPropertieserviceImpl implements IPropertieservice {
	/*
	 *  Autowired repository layer
	 */
	@Autowired
	private PropertiesRepository policyRepo;


	@Override
	public List<Properties> addProperties(Properties properties) {
		policyRepo.saveAndFlush(properties);
		return policyRepo.findAll();
	}

	@Override
	public List<Properties> showAllProperties() {
		return policyRepo.findAll();
	}

}
