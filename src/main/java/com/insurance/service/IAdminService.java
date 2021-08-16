package com.insurance.service;

import com.insurance.entities.Admin;
/*
 * service interface
 */
public interface IAdminService {
	public Admin loginCheck(int id, String name);
}
