package com.insurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.entities.Quote;
import com.insurance.exception.QuoteNotFoundException;
import com.insurance.service.QuoteService;

@RestController
@RequestMapping("/api/v1")
public class QuoteController {
	/*
	 *  Autowired service layer
	 */
	@Autowired
	private QuoteService qser;

	/*
	 *  Exception for validation
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return errors;
	}

	/*
	 *  Get Mapping used to get list of quotes
	 */
	@GetMapping("/quote")
	public ResponseEntity<List<Quote>> getAllQAuotes() {
		List<Quote> quote = qser.showAllQuotes();
		if (quote.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<Quote>>(quote, HttpStatus.OK);
	}

	/*
	 *  Post Mapping used to add the quotes
	 */
	@PostMapping("/addquote")
	public ResponseEntity<List<Quote>> addQuote(@Valid @RequestBody Quote quote) {
		List<Quote> quotes = qser.addQuote(quote);
		if (quotes.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<Quote>>(quotes, HttpStatus.OK);
	}

	/*
	 *  Used to update the quote
	 */
	@PutMapping("/updatequote/{id}")
	public ResponseEntity<Quote> updatePolicyHolder(@PathVariable("id") Integer id, @RequestBody Quote quote)
			throws QuoteNotFoundException {
		Quote quote1 = qser.readQuote(id);
		ResponseEntity<Quote> response = null;
		if (quote1.getQuoteId() != 0) {
			qser.updateQuote(quote);
			response = new ResponseEntity<Quote>(quote1, HttpStatus.OK);
			return response;

		} else

			throw new QuoteNotFoundException("Quote with this ID Not Found");
	}

	/*
	 *  used to find the quote by id
	 */
	@GetMapping("/findquote/{id}")
	public ResponseEntity<Quote> findQuoteById(@PathVariable("id") Integer id) throws QuoteNotFoundException {
		Quote quotes = qser.readQuote(id);
		ResponseEntity<Quote> response = null;
		if (quotes.getQuoteId() != 0) {
			qser.findQuoteById(id);
			response = new ResponseEntity<Quote>(quotes, HttpStatus.OK);
			return response;
		} else

			throw new QuoteNotFoundException("Quote with this ID Not Found");
	}

	/*
	 *  used to delete the quote
	 */
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Quote> deletePolicyHolder(@PathVariable("id") int id, @RequestBody Quote quote)
			throws QuoteNotFoundException {
		Quote result = qser.readQuote(id);
		ResponseEntity<Quote> response = null;
		if (result.getQuoteId() != 0) {
			qser.removeQuote(id);
			response = new ResponseEntity<Quote>(result, HttpStatus.OK);
			return response;
		} else
			throw new QuoteNotFoundException("Quote with this ID Not Found");
	}

}
