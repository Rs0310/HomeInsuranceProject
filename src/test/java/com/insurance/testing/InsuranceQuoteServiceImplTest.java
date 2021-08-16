package com.insurance.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.insurance.HomeInsuranceGroup4Batch2Application;
import com.insurance.entities.Quote;
import com.insurance.exception.QuoteNotFoundException;
import com.insurance.service.QuoteService;

@SpringBootTest
public class InsuranceQuoteServiceImplTest {
	/*
	 * Autowired
	 */
	@Autowired
	private QuoteService qser;
	
	static final Logger LOGGER = LoggerFactory.getLogger(HomeInsuranceGroup4Batch2Application.class);
	
	/*
	 * Test methods
	 */
	@Test
	public void testaddQuote() throws QuoteNotFoundException {
		Quote quote = new Quote(2,"yes",2000,3000,2000,3000,4000,6000,9000);
		int id=quote.getQuoteId();
		LOGGER.info("Quote id is "+id);
		qser.addQuote(quote);
		Quote result = qser.readQuote(2);
		assertThat(quote.getPremiumType()).isEqualTo(result.getPremiumType());
		assertThat(quote.getPremium()).isEqualTo(result.getPremium());
		assertThat(quote.getDwellingCoverage()).isEqualTo(result.getDwellingCoverage());
		assertThat(quote.getDetachedStructureCoverage()).isEqualTo(result.getDetachedStructureCoverage());
		assertThat(quote.getPersonalPropertyCoverage()).isEqualTo(result.getPersonalPropertyCoverage());
		assertThat(quote.getAdditionalLivingExpense()).isEqualTo(result.getAdditionalLivingExpense());
		assertThat(quote.getMedicalExpense()).isEqualTo(result.getMedicalExpense());
		assertThat(quote.getDeductibleAmount()).isEqualTo(result.getDeductibleAmount());
	}
	
	@Test
	public void testfindbyQuoteId() throws QuoteNotFoundException {
		int id = 1;
		LOGGER.info("Quote id is "+ id);
    	Quote quote=qser.findQuoteById(id);
  
		assertThat(quote.getQuoteId()).isEqualTo(id);
		LOGGER.info("The test is ended");
	}
	
	@Test 
	public void testupdateQuote() throws QuoteNotFoundException {
		int id = 1;
		LOGGER.info("Quote id is "+ id);
		Quote quote = new Quote(id,"yes",2000,3000,2000,3000,4000,6000,9000);
		quote.setPremiumType("no");
		qser.addQuote(quote);
		Quote update = qser.findQuoteById(id);
		assertThat(update.getPremiumType()).isEqualTo(quote.getPremiumType());
	}
	
	@Test
	public void testshowallQuote() {
		List<Quote> p = qser.showAllQuotes();
		LOGGER .info("The list of elements are");
		for(Quote i:p)
		{
			int id = i.getQuoteId();
			LOGGER .info("The details for id"+id);
		}
		assertThat(p).size().isGreaterThan(0);
	}
		
	
	
	@Test
	public void removeQuote() throws QuoteNotFoundException{
			int id = 2;
			LOGGER.info("Quote id is "+ id);
		    qser.removeQuote(id);
			Quote result = qser.readQuote(id);
			Assertions.assertNull(result.getPremiumType());
	}

}