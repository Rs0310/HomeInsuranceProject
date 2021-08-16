package com.insurance.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 *Entity class
 */
@Entity
@Table(name = "agent")
public class Agent {

	@Id
	@Column(name = "agentid")
	@Positive(message = "This value should be positive")
	private int agentId;

	@Column(name = "agentname")
	@NotNull
	@Size(min = 3, message = "Agent Name must have at least 3 characters")
	private String agentName;

	@Column(name = "designation")
	@NotNull
	@Size(min = 3, message = "Designation must have at least 3 characters")
	private String designation;

	@Column(name = "salary")
	@NotNull
	@Size(min = 3, message = "Salary must have at least 3 characters")
	private String salary;

	@Column(name = "address")
	@NotNull
	@Size(min = 3, message = "Address must have at least 3 characters")
	private String address;

	@Column(name = "email")
	@Email(message = "Email should be valid")
	private String email;

	@Column(name = "mobileno")
	@NotNull
	@Size(min = 3, message = "MobileNo must have at least 5 characters")
	private String mobileNo;

	/*
	 *  Mapping to Policy
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policyid")
	private Policy policy;

	/*
	 *  Mapping to PolicyHolder
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policyholderid")
	private PolicyHolder policyholder;

	public Agent() {
	}

	/*
	 *  Creating constructor
	 */
	public Agent(int agentId, String agentName, String designation, String salary, String address, String email,
			String mobileNo) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
		this.email = email;
		this.mobileNo = mobileNo;
	}

	/*
	 *  Creating getter and setter methods
	 */
	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public PolicyHolder getPolicyholder() {
		return policyholder;
	}

	public void setPolicyholder(PolicyHolder policyholder) {
		this.policyholder = policyholder;
	}

}