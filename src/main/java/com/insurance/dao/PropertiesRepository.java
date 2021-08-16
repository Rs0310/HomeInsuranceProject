package com.insurance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurance.entities.Properties;


/*
 * Repository class
 */
@Repository
public interface PropertiesRepository extends JpaRepository<Properties, Integer> {
	/*
	 * queries
	 */
	@Query("SELECT p FROM Properties p")
	public List<Properties> showAllQuotes();
}
