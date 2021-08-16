package com.insurance.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.IUserRepository;
import com.insurance.entities.User;

@Service
public class IUserServiceImplements implements IUserService {

	/*
	 *  Autowired repository layer
	 */
	@Autowired
	private IUserRepository iur;

	@Override
	public List<User> viewAllUsers() {
		return iur.findAll();
	}

	@Override
	public List<User> addNewUser(User user) {
		iur.saveAndFlush(user);
		return iur.findAll();
	}

	@Override
	public User findsignIn(String userName) {
		Optional<User> user1 = iur.findById(userName);
		return user1.get();
	}

	@Override
	public User loginCheck(String userName, String password) {
		User u = iur.checkLogin(userName, password);
		return u;
	}

	/*
	 * Read method
	 */
	@Override
	public User read(String userName) {
		User result = iur.readUserHolder(userName);
		if (result != null) {
			return result;
		} else {
			User p = new User();
			p.setUserName(null);
			return p;
		}
	}
	
}
