package com.insurance.service;

import java.util.List;
import com.insurance.entities.Agent;
import com.insurance.exception.AgentNotFoundException;
/*
 * Agent interface
 */
public interface IAgentService {

	public List<Agent> addAgent(Agent agent);

	public List<Agent> viewAllAgents();

	public List<Agent> updateAgent(Agent agent) throws AgentNotFoundException;

	public Agent findAgentById(int agentId) throws AgentNotFoundException;

	public List<Agent> removeAgent(int agentId) throws AgentNotFoundException;

	Agent readAgent(int agentId) throws AgentNotFoundException;

}