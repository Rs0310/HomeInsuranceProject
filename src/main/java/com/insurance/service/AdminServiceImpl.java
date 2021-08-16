package com.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.AdminRepository;
import com.insurance.entities.Admin;

/*
 * Service class
 */
@Service
public class AdminServiceImpl implements IAdminService {

	/*
	 *  Autowired repository
	 */
	@Autowired
	AdminRepository arep;

	@Override
	public Admin loginCheck(int id, String name) {
		Admin u = arep.checkLogin(id, name);
		return u;

	}
}
