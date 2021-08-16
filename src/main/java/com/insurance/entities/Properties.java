package com.insurance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/*
 *Entity class
 */
@Entity
@Table(name = "properties")
public class Properties {
	@Id
	@Column(name = "propertyid")
	@Positive(message = "This value should be positive")
	private int propertyid;

	@Column(name = "marketvalue")
	@Positive(message = "This value should be positive")
	private int marketValue;

	@Column(name = "yearbuilt")
	@Positive(message = "This value should be positive")
	private int yearBuilt;

	@Column(name = "squarefootage")
	@Positive(message = "This value should be positive")
	private int squareFootage;

	@Column(name = "dwellingstyle")
	@Positive(message = "This value should be positive")
	private double dwellingStyle;

	@Column(name = "roofmaterial")
	@NotNull
	@Size(min = 3, message = "PolicyHolder Name must have at least 5 characters")
	private String roofMaterial;

	@Column(name = "garagetype")
	@NotNull
	@Size(min = 3, message = "PolicyHolder Name must have at least 5 characters")
	private String garageType;

	@Column(name = "fullbathcount")
	@Positive(message = "This value should be positive")
	private int fullBathCount;

	@Column(name = "halfbathcount")
	@Positive(message = "This value should be positive")
	private int halfBathCount;

	@Column(name = "hasswimmingpool")
	@NotNull
	@Size(min = 3, message = "PolicyHolder Name must have at least 5 characters")
	private String hasSwimmingPool;

	public Properties() {

	}

	/*
	 * constructor
	 */
	public Properties(int propertyid, int marketValue, int yearBuilt, int squareFootage, String garageType,
			String roofMaterial, double dwellingStyle, int fullBathCount, int halfBathCount, String hasSwimmingPool) {
		super();
		this.propertyid = propertyid;
		this.marketValue = marketValue;
		this.yearBuilt = yearBuilt;
		this.squareFootage = squareFootage;
		this.dwellingStyle = dwellingStyle;
		this.roofMaterial = roofMaterial;
		this.garageType = garageType;
		this.fullBathCount = fullBathCount;
		this.halfBathCount = halfBathCount;
		this.hasSwimmingPool = hasSwimmingPool;
	}

	/*
	 * getter and setter methods
	 */
	public int getPropertyid() {
		return propertyid;
	}

	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}

	public int getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(int marketValue) {
		this.marketValue = marketValue;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public int getSquareFootage() {
		return squareFootage;
	}

	public void setSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
	}

	public double getDwellingStyle() {
		return dwellingStyle;
	}

	public void setDwellingStyle(double dwellingStyle) {
		this.dwellingStyle = dwellingStyle;
	}

	public String getRoofMaterial() {
		return roofMaterial;
	}

	public void setRoofMaterial(String roofMaterial) {
		this.roofMaterial = roofMaterial;
	}

	public String getGarageType() {
		return garageType;
	}

	public void setGarageType(String garageType) {
		this.garageType = garageType;
	}

	public int getFullBathCount() {
		return fullBathCount;
	}

	public void setFullBathCount(int fullBathCount) {
		this.fullBathCount = fullBathCount;
	}

	public int getHalfBathCount() {
		return halfBathCount;
	}

	public void setHalfBathCount(int halfBathCount) {
		this.halfBathCount = halfBathCount;
	}

	public String getHasSwimmingPool() {
		return hasSwimmingPool;
	}

	public void setHasSwimmingPool(String hasSwimmingPool) {
		this.hasSwimmingPool = hasSwimmingPool;
	}
}
