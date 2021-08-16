package com.insurance.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
/*
 *The class represents the admin details
 */
@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@Column(name = "adminid")
	@Positive(message = "this value should be in positive")
	private int adminid;

	@Column(name = "adminname")
	@NotNull
	@Size(min = 3, message = "admin name must have at least 5 characters")
	private String adminname;

	@Column(name = "contact")
	@NotNull
	@Size(min = 10, message = "admin contact must have at least 10 numbers")
	private String contact;

	public Admin() {

	}

	/*
	 *  creating a constructor
	 */

	public Admin(int adminid, String adminname, String contact) {

		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.contact = contact;

	}

	/*
	 *  creating Getters and setters
	 */

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
