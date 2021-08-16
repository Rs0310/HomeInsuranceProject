package com.insurance.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/*
 *Entity class
 */
@Entity
@Table(name = "quote")
public class Quote {
	@Id
	@Column(name = "quoteid")
	@Positive(message = "This value should be positive")
	private int quoteId;

	@Column(name = "premiumtype")
	@NotNull
	private String premiumType;

	@Column(name = "premium")
	@NotNull
	private double premium;

	@Column(name = "dwellingcoverage")
	@Positive(message = "This value should be positive")
	private double dwellingCoverage;

	@Column(name = "detachedstructurecoverage")
	@Positive(message = "This value should be positive")
	private double detachedStructureCoverage;

	@Column(name = "personalpropertycoverage")
	@Positive(message = "This value should be positive")
	private double personalPropertyCoverage;

	@Column(name = "additionallivingexpense")
	@Positive(message = "This value should be positive")
	private double additionalLivingExpense;

	@Column(name = "medicalexpense")
	@DecimalMin("5000.00")
	private double medicalExpense;

	@Column(name = "deductibleamount")
	@DecimalMin("5000.00")
	private double deductibleAmount;

	/*
	 * Mapping
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policyid")
	private Policy policy;

	/*
	 * Mapping
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "propertyid")
	private Properties properties;

	public Quote() {

	}

	/*
	 * constructor
	 */
	public Quote(int quoteId, String premiumType, double premium, double dwellingCoverage,
			double detachedStructureCoverage, double personalPropertyCoverage, double additionalLivingExpense,
			double medicalExpense, double deductibleAmount) {
		super();
		this.quoteId = quoteId;
		this.premiumType = premiumType;
		this.premium = premium;
		this.dwellingCoverage = dwellingCoverage;
		this.detachedStructureCoverage = detachedStructureCoverage;
		this.personalPropertyCoverage = personalPropertyCoverage;
		this.additionalLivingExpense = additionalLivingExpense;
		this.medicalExpense = medicalExpense;
		this.deductibleAmount = deductibleAmount;

	}

	public int getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}

	public String getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public double getDwellingCoverage() {
		return dwellingCoverage;
	}

	public void setDwellingCoverage(double dwellingCoverage) {
		this.dwellingCoverage = dwellingCoverage;
	}

	public double getDetachedStructureCoverage() {
		return detachedStructureCoverage;
	}

	public void setDetachedStructureCoverage(double detachedStructureCoverage) {
		this.detachedStructureCoverage = detachedStructureCoverage;
	}

	public double getPersonalPropertyCoverage() {
		return personalPropertyCoverage;
	}

	public void setPersonalPropertyCoverage(double personalPropertyCoverage) {
		this.personalPropertyCoverage = personalPropertyCoverage;
	}

	public double getAdditionalLivingExpense() {
		return additionalLivingExpense;
	}

	public void setAdditionalLivingExpense(double additionalLivingExpense) {
		this.additionalLivingExpense = additionalLivingExpense;
	}

	public double getMedicalExpense() {
		return medicalExpense;
	}

	public void setMedicalExpense(double medicalExpense) {
		this.medicalExpense = medicalExpense;
	}

	public double getDeductibleAmount() {
		return deductibleAmount;
	}

	public void setDeductibleAmount(double deductibleAmount) {
		this.deductibleAmount = deductibleAmount;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
