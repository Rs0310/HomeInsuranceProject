package com.insurance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insurance.entities.Agent;


/*
 * Repository class
 */
@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {

	/*
	 *  Queries
	 */
	@Query("SELECT agent FROM Agent agent")
	public List<Agent> showAllQuotes();

	@Query("SELECT agent FROM Agent agent  WHERE agent.agentId=:aid")
	public Agent readAgent(@Param("aid") int id);

}