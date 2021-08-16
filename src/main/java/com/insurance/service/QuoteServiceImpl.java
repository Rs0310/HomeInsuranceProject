package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.QuoteRepository;

import com.insurance.entities.Quote;
import com.insurance.exception.QuoteNotFoundException;

/*
 * service layer
 */
@Service
public class QuoteServiceImpl implements QuoteService {
	/*
	 * Autowired repository layer
	 */
	@Autowired
	private QuoteRepository qrep;

	@Override
	public List<Quote> showAllQuotes() {
		return qrep.findAll();
	}

	@Override
	public List<Quote> addQuote(Quote quote) {
		qrep.saveAndFlush(quote);
		return qrep.findAll();
	}

	@Override
	public List<Quote> updateQuote(Quote quote) {
		qrep.saveAndFlush(quote);
		return qrep.findAll();
	}

	@Override
	public Quote findQuoteById(int id) {
		Optional<Quote> q = qrep.findById(id); // predefined method
		return q.get();
	}

	@Override
	public List<Quote> removeQuote(int id) {
		qrep.deleteById(id);
		return qrep.findAll();
	}

	@Override
	public Quote readQuote(int id) throws QuoteNotFoundException {
		Quote result = qrep.readQuote(id);
		if (result != null) {
			return result;
		} else {
			Quote p = new Quote();
			p.setQuoteId(0);
			return p;
		}
	}
}
	

