package com.insurance.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/*
 *Entity class
 */
@Entity
@Table(name = "policyholder")
public class PolicyHolder {
	@Id
	@Column(name = "policyholderid")
	@Positive(message="This value should be positive")
	private int policyHolderId;
	
	@Column(name = "policyholdername")
	@NotNull
    @Size(min = 3, message = "PolicyHolder Name must have at least 5 characters")
	private String policyHolderName;
	
	@Column(name = "policyname")
	@NotBlank(message = "Blog Editor cannot be blank")
	private String policyName;
	
	@Column(name = "premiumtype")
	@NotNull
	@Size(min = 3, message = "PremiumType Name must have at least 5 characters")
	private String premiumType;
	
	@Column(name = "creditcard")
	@NotNull
	@Size(min = 3, message = "CreditCard Name must have at least 3 characters")
	private String creditCard;
	
	@Column(name = "dob")
	@NotNull
	@Size(min = 3, message = "Date of birth  must have at least 10 characters")
	private String dob;
	
	@Column(name = "occupation")
	@NotNull
	@Size(min = 3, message = "Annualincome Name must have at least 5 characters")
	private String occupation;
	
	@Column(name = "annualincome")
	@DecimalMin("5000.00")
	private double annualIncome;
	
	@Column(name = "isretired")
	@NotNull
	@Size(min = 2, message = "Annualincome Name must have at least 2 characters")
	private String isRetired;
	
	@Column(name = "ssn")
	@NotNull
	@Size(min = 3, message = "Annualincome Name must have at least 6 characters")
	private String ssn;
	
	@Column(name = "emailid")
	@Email(message = "Email should be valid")
	private String emailId;
	
	/*
	 * Mapping
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressid", referencedColumnName = "addressid")
	private HomeAddress address;

	/*
	 * Mapping
	 */
	@ManyToOne
	@JoinColumn(name = "policyid")
	private Policy policy;

	public PolicyHolder() {

	}

	/*
	 * constructor
	 */
	public PolicyHolder(int policyHolderId, String policyHolderName, String policyName, String premiumType,
			String creditCard, String dob, String occupation, double annualIncome, String isRetired, String ssn,
			String emailId) {
		super();
		this.policyHolderId = policyHolderId;
		this.policyHolderName = policyHolderName;
		this.policyName = policyName;
		this.premiumType = premiumType;
		this.creditCard = creditCard;
		this.dob = dob;
		this.occupation = occupation;
		this.annualIncome = annualIncome;
		this.isRetired = isRetired;
		this.ssn = ssn;
		this.emailId = emailId;
	}

	/*
	 * getter and setter methods
	 */
	public int getPolicyHolderId() {
		return policyHolderId;
	}

	public void setPolicyHolderId(int policyHolderId) {
		this.policyHolderId = policyHolderId;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getIsRetired() {
		return isRetired;
	}

	public void setIsRetired(String isRetired) {
		this.isRetired = isRetired;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public HomeAddress getAddress() {
		return address;
	}

	public void setAddress(HomeAddress address) {
		this.address = address;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
}