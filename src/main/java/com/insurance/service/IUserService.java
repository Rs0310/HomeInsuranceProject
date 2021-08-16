package com.insurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.entities.User;

/*
 * service class
 */
@Service
public interface IUserService {

	
	public List<User> viewAllUsers();

	public List<User> addNewUser(User user);

	public User findsignIn(String userName);

	public User loginCheck(String userName, String password);

	User read(String userName);

}
