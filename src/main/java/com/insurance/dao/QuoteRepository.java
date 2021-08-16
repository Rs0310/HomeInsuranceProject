package com.insurance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insurance.entities.Quote;


/*
 * Repository class
 */
@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {
	/*
	 *  queries
	 */
	@Query("SELECT quote FROM Quote quote")
	public List<Quote> showAllQuotes();

	/*
	 *  queries
	 */
	@Query("SELECT quote FROM Quote quote  WHERE quote.id=:pid")
	public Quote readQuote(@Param("pid") int id);

}
