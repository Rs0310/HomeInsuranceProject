package com.insurance.service;

import java.util.List;

import com.insurance.entities.Quote;
import com.insurance.exception.QuoteNotFoundException;

/*
 * quote interface
 */
public interface QuoteService {

	public List<Quote> showAllQuotes();

	public List<Quote> addQuote(Quote quote);

	public List<Quote> updateQuote(Quote quote) throws QuoteNotFoundException;

	public Quote findQuoteById(int id) throws QuoteNotFoundException;

	public List<Quote> removeQuote(int id) throws QuoteNotFoundException;

	public Quote readQuote(int id) throws QuoteNotFoundException;

}
