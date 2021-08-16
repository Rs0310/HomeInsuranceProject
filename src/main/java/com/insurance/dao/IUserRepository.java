package com.insurance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insurance.entities.User;


/*
 * Repository class
 */
@Repository
public interface IUserRepository extends JpaRepository<User, String> {

	/*
	 *  Queries
	 */
	@Query("SELECT users FROM User users")
	public List<User> viewAllUsers();
	
	/*
	 * Queries
	 */
	@Query("SELECT users FROM User users  WHERE users.userName=:uname")
	public User readUserHolder(@Param("uname") String UserName);

	/*
	 *  Queries
	 */
	@Query("SELECT users FROM User users WHERE users.userName=:uname and users.password=:pass")
	public User checkLogin(@Param("uname") String uname, @Param("pass") String pass);

}
