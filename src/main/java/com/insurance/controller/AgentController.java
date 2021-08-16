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

import com.insurance.entities.Agent;
import com.insurance.exception.AgentNotFoundException;
import com.insurance.service.IAgentService;

@RestController
@RequestMapping("/api/v1")
public class AgentController {
	/*
	 *  AutoWired service layer
	 */
	@Autowired
	private IAgentService agentService;

	/*
	 *  Showing all agents
	 */
	@GetMapping("/agent")
	public ResponseEntity<List<Agent>> viewAllAgents() {
		List<Agent> agnt = agentService.viewAllAgents();
		if (agnt.isEmpty()) {
			ResponseEntity.status(204).build();
		}
		return new ResponseEntity<List<Agent>>(agnt, HttpStatus.OK);
	}

	/*
	 *  Adding new agent
	 */
	@PostMapping("/addagent")
	public ResponseEntity<List<Agent>> addAgent(@Valid @RequestBody Agent agent) {
		List<Agent> agnt = agentService.addAgent(agent);
		if (agnt.isEmpty()) {
			ResponseEntity.status(204).build();
		}

		return new ResponseEntity<List<Agent>>(agnt, HttpStatus.OK);
	}

	/*
	 *  Updating agents
	 */
	@PutMapping("/updateagent/{agentId}")
	public ResponseEntity<Agent> updateAgent(@PathVariable("agentId") Integer agentId, @RequestBody Agent agent)
			throws AgentNotFoundException {
		Agent agnt = agentService.readAgent(agentId);
		ResponseEntity<Agent> response = null;
		if (agnt.getAgentId() != 0) {
			agentService.updateAgent(agent);
			response = new ResponseEntity<Agent>(agnt, HttpStatus.OK);
			return response;
		} else

			throw new AgentNotFoundException("Agent with this ID is not found");
	}

	/*
	 *  Finding agent by ID
	 */
	@GetMapping("/agentfind/{agentId}")
	public ResponseEntity<Agent> findAgentById(@PathVariable("agentId") Integer agentId) throws AgentNotFoundException {
		Agent agnt = agentService.readAgent(agentId);
		ResponseEntity<Agent> response = null;
		if (agnt.getAgentId() != 0) {
			agentService.findAgentById(agentId);
			response = new ResponseEntity<Agent>(agnt, HttpStatus.OK);
			return response;
		} else

			throw new AgentNotFoundException("Agent with this ID not found");
	}

	/*
	 *  Removing a agent
	 */
	@DeleteMapping(path = "agentdelete/{id}")
	public ResponseEntity<Agent> removeAgent(@PathVariable("id") int id, @RequestBody Agent agent)
			throws AgentNotFoundException {
		Agent result = agentService.readAgent(id);
		ResponseEntity<Agent> response = null;
		if (result.getAgentId() != 0) {
			agentService.removeAgent(id);
			response = new ResponseEntity<Agent>(result, HttpStatus.OK);
			return response;
		} else
			throw new AgentNotFoundException("Agent with this ID not found");
	}

	/*
	 *  show user-defined message for validation errors
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}

}