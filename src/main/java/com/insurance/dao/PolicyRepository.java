package com.insurance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insurance.entities.Policy;


/*
 * Repository class
 */
@Repository
public interface PolicyRepository extends JpaRepository<Policy, String> {
	/*
	 *  queries
	 */
	@Query("SELECT  p FROM Policy p")
	public List<Policy> showAllPolicies();

	@Query("SELECT p FROM Policy p WHERE p.policyid=:id")
	public Policy readpolicy(@Param("id") String id);

}
