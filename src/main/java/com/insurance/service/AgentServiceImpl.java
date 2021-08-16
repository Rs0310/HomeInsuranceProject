package com.insurance.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.dao.AgentRepository;
import com.insurance.entities.Agent;
import com.insurance.exception.AgentNotFoundException;


/*
 * Service class
 */
@Service
public class AgentServiceImpl implements IAgentService {

	public AgentServiceImpl(AgentRepository agentRepo) {
		super();
		this.agentRepo = agentRepo;
	}

	/*
	 *  Autowired repository layer
	 */
	@Autowired
	private AgentRepository agentRepo;

	@Override
	public List<Agent> viewAllAgents() {
		return agentRepo.findAll();
	}

	@Override
	public List<Agent> addAgent(Agent agent) {
		agentRepo.saveAndFlush(agent);
		return agentRepo.findAll();
	}

	@Override
	public List<Agent> updateAgent(Agent agent) {
		agentRepo.save(agent);
		return agentRepo.findAll();
	}

	@Override
	public Agent findAgentById(int agentId) {
		Optional<Agent> agn = agentRepo.findById(agentId); // predefined method
		return agn.get();
	}

	@Override
	public List<Agent> removeAgent(int agentId) {
		agentRepo.deleteById(agentId);
		return agentRepo.findAll();
	}

	/*
	 *  readAgent declared here
	 */
	@Override
	public Agent readAgent(int agentId) throws AgentNotFoundException {
		Agent result = agentRepo.readAgent(agentId);
		if (result != null) {
			return result;
		} else {
			Agent agn = new Agent();
			agn.setAgentId(0);
			return agn;
		}
	}
}