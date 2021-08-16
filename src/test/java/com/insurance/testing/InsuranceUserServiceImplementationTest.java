package com.insurance.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.HomeInsuranceGroup4Batch2Application;
import com.insurance.entities.User;
import com.insurance.service.IUserService;

@SpringBootTest
public class InsuranceUserServiceImplementationTest {
	/*
	 * Auto wiring 
	 */
	@Autowired
	private IUserService iuserservice;
	final Logger logger = LoggerFactory.getLogger(HomeInsuranceGroup4Batch2Application.class);

	// Test methods
	@Test
	public void testAddUser() {
		User user = new User("sajid", "sajid123", 1, "user");
		String username = user.getUserName();
		logger.info("The element added with id " + username);
		iuserservice.addNewUser(user);
		User result = iuserservice.findsignIn("sajid");
		assertThat(user.getUserName()).isEqualTo(result.getUserName());
		assertThat(user.getPassword()).isEqualTo(result.getPassword());
		assertThat(user.getUserId()).isEqualTo(result.getUserId());
		assertThat(user.getRole()).isEqualTo(result.getRole());
	}

	
	@Test
	public void testfindbyUserName() {
		String username = "sajid";
		logger.info("The element with username to find is " + username);
		User user = iuserservice.findsignIn("sajid");
		assertThat(user.getUserName()).isEqualTo(username);
	}


	@Test
	public void testviewAllUsers() {
		List<User> ur = iuserservice.viewAllUsers();
		logger.info("The list of elements are");
		for (User u : ur) {
			String username = u.getUserName();
			logger.info("The details for username" + username);
		}
		assertThat(ur).size().isGreaterThan(0);
	}
}
