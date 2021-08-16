package com.insurance.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

/*
 *Entity class
 */
@Entity
@Table(name = "policy")
public class Policy {
	@Id
	@Column(name = "policyid")
	@NotNull
	@Size(min = 3, message = "policyid must have at least 4 characters")
	private String policyid;

	@Column(name = "policyeffectivedate", length = 50)
	@NotNull
	@Size(min = 3, message = "effectivedate must have at least 5 characters")
	private String policyeffectivedate;

	@Column(name = "policyenddate")
	@NotNull
	private String policyenddate;

	@Column(name = "policyterm")
	@Positive(message = "This value should be positive")
	private int policyterm;

	@Column(name = "policystatus")
	private String policystatus;

	@OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
	private Set<PolicyHolder> p = new HashSet<>();

	/*
	 *  Mapping
	 */
	@OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
	private Set<Agent> a = new HashSet<>();

	public Policy() {
		super();

	}

	/*
	 *  constructor created
	 */
	public Policy(String policyid, String policyeffectivedate, String policyenddate, int policyterm,
			String policystatus) {
		super();
		this.policyid = policyid;
		this.policyeffectivedate = policyeffectivedate;
		this.policyenddate = policyenddate;
		this.policyterm = policyterm;
		this.policystatus = policystatus;
	}

	/*
	 *  created getter and setter methods
	 */
	public String getPolicyid() {
		return policyid;
	}

	public void setPolicyid(String policyid) {
		this.policyid = policyid;
	}

	public String getPolicyeffectivedate() {
		return policyeffectivedate;
	}

	public void setPolicyeffectivedate(String policyeffectivedate) {
		this.policyeffectivedate = policyeffectivedate;
	}

	public String getPolicyenddate() {
		return policyenddate;
	}

	public void setPolicyenddate(String policyenddate) {
		this.policyenddate = policyenddate;
	}

	public int getPolicyterm() {
		return policyterm;
	}

	public void setPolicyterm(int policyterm) {
		this.policyterm = policyterm;
	}

	public String getPolicystatus() {
		return policystatus;
	}

	public void setPolicystatus(String policystatus) {
		this.policystatus = policystatus;
	}

}
