package com.insurance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 *Entity class
 */
@Entity
@Table(name = "homeaddress")
public class HomeAddress {
	@Id
	@Column(name = "addressid")
	@NotNull
	@Size(min = 3, message = "Addressid must have at least 5 characters")
	private String addressid;

	@Column(name = "residencetype")
	@NotNull
	@Size(min = 3, message = "Residencetype must have at least 5 characters")
	private String residenceType;

	@Column(name = "addressline1")
	@NotNull
	@Size(min = 3, message = "Addressline1  must have at least 5 characters")
	private String addressLine1;

	@Column(name = "addressline2")
	@NotNull
	@Size(min = 3, message = "Addressline2 must have at least 5 characters")
	private String addressLine2;

	@Column(name = "city")
	@NotNull
	@Size(min = 3, message = "City must have at least 5 characters")
	private String city;

	@Column(name = "state")
	@NotNull
	@Size(min = 3, message = "State must have at least 5 characters")
	private String state;

	@Column(name = "zip")
	@NotNull
	@Size(min = 3, message = "Zip must have at least 5 characters")
	private String zip;

	@Column(name = "residenceuse")
	@NotNull
	@Size(min = 3, message = "Residenceuse Name must have at least 5 characters")
	private String residenceUse;

	/*
	 * getter and setter methods
	 */
	public HomeAddress() {

	}

	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getResidenceUse() {
		return residenceUse;
	}

	public void setResidenceUse(String residenceUse) {
		this.residenceUse = residenceUse;
	}

}
