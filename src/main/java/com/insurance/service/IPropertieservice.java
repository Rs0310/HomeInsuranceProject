package com.insurance.service;

import java.util.List;

import com.insurance.entities.Properties;

/*
 * properties interface
 */
public interface IPropertieservice {
	public List<Properties> addProperties(Properties properties);

	public List<Properties> showAllProperties();
}
