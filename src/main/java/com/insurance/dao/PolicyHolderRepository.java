package com.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.insurance.entities.PolicyHolder;


/*
 * Repository class
 */
@Repository
public interface PolicyHolderRepository extends JpaRepository<PolicyHolder, Integer> {
	/*
	 * Query
	 */
	@Query("SELECT policyholder FROM PolicyHolder policyholder  WHERE policyholder.policyHolderId=:pid")
	public PolicyHolder readPolicyHolder(@Param("pid") int id);

}