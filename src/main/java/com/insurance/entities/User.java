package com.insurance.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/*
 *Entity class
 */
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "username")
	@NotNull
	private String userName;

	@NotNull
	@Size(min = 3, message = "Password must have at least 3 characters")
	private String password;

	@Column(name = "userid")
	@Positive(message = "This value should be positive")
	private int userId;

	@NotNull
	private String role;

	/*
	 *  Mapping Relations
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "agentid")
	private Agent agent;

	/*
	 *  Mapping Relations
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policyholderid")
	private PolicyHolder policyholder;

	
	public User() {
	}

	/*
	 *  Defining Constructor
	 */
	public User(String userName, String password, int userId, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.userId = userId;
		this.role = role;

	}

	/*
	 *  Getter and Setters
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public PolicyHolder getPolicyholder() {
		return policyholder;
	}

	public void setPolicyholder(PolicyHolder policyholder) {
		this.policyholder = policyholder;
	}

}
