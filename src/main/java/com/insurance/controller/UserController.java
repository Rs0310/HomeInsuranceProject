package com.insurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entities.User;
import com.insurance.service.IUserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private IUserService iuserservice;

	/*
	 *  @GetMapping is used to fetch all the users
	 */
	@GetMapping("/user")
	public ResponseEntity<List<User>> viewAllUsers() {
		List<User> us = iuserservice.viewAllUsers();
		if (us.isEmpty()) {
			return ResponseEntity.status(204).build();
		}
		return new ResponseEntity<List<User>>(us, HttpStatus.OK);
	}

	/*
	 *  @GetMapping is used to login the agent or policy or admin
	 */
	@GetMapping("/login")
	public ResponseEntity<User> logincheck() {
		User l = new User();
		String username = l.getUserName();
		String password = l.getPassword();
		User u = iuserservice.loginCheck(username, password);
		if (u != null) {
			String role = u.getRole();
			if (role.equals("admin")) {
				return new ResponseEntity("Hello admin", HttpStatus.OK);
			} else if (role.equals("policyholder")) {
				return new ResponseEntity("Hello policyholder", HttpStatus.OK);
			} else {
				return new ResponseEntity("Hello agent", HttpStatus.OK);
			}
		}
		return new ResponseEntity("Hello please enter valid credentials", HttpStatus.OK);
	}

	/*
	 *  @PostMapping is used to add the users
	 */
	@PostMapping("/user")
	public ResponseEntity<List<User>> insertUser(@Valid @RequestBody User user) {
		List<User> usern = (List<User>) iuserservice.addNewUser(user);
		if (usern.isEmpty()) {
			return ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<User>>(usern, HttpStatus.OK);
	}

	/*
	 *  @GetMapping is used to find the users
	 */
	@GetMapping("/userfind/{userName}")
	public ResponseEntity<User> findUser(@PathVariable("userName") String userName) {
		User ur = iuserservice.read(userName);
		ResponseEntity<User> response = null;
		if (ur != null) {
			if (ur.getUserName() != null) {
				iuserservice.findsignIn(userName);
				response = new ResponseEntity<User>(ur, HttpStatus.OK);
				return response;
		       }
	     }
		return new ResponseEntity("username not found",HttpStatus.OK);
	}

	/*
	 *  @ResponseStatus is used to give the message, instead of the error
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}

}
