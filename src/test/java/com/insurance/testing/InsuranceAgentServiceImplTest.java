package com.insurance.testing;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.insurance.HomeInsuranceGroup4Batch2Application;
import com.insurance.entities.Agent;
import com.insurance.exception.AgentNotFoundException;
import com.insurance.service.IAgentService;

@SpringBootTest
class InsuranceAgentServiceImplTest {
	/*
	 * Autowiring
	 */
	@Autowired
	private IAgentService agentService;
	static final Logger LOGGER = LoggerFactory.getLogger(HomeInsuranceGroup4Batch2Application.class);

 /*
  *  Test methods
  */
	@Test
	public void testaddAgent() throws AgentNotFoundException {
		Agent agent = new Agent(7, "kashyazzp", "datacc officer", "fortyc thousand", "kakiznada",
				"agent@gmail.com", "twezcisesifi");
		int id = agent.getAgentId();
		LOGGER.info("The element added with id ", +id);

		agentService.addAgent(agent);
		Agent result = agentService.readAgent(7);
		assertThat(agent.getAgentId()).isEqualTo(result.getAgentId());
		assertThat(agent.getAgentName()).isEqualTo(result.getAgentName());
		assertThat(agent.getDesignation()).isEqualTo(result.getDesignation());
		assertThat(agent.getSalary()).isEqualTo(result.getSalary());
		assertThat(agent.getAddress()).isEqualTo(result.getAddress());
		assertThat(agent.getEmail()).isEqualTo(result.getEmail());
		assertThat(agent.getMobileNo()).isEqualTo(result.getMobileNo());
	}


	@Test
	public void testfindAgentById() throws AgentNotFoundException {
		int agentId = 9731;
		LOGGER.info("The element with id to find is" + agentId);
		Agent ag = agentService.findAgentById(agentId);

		assertThat(ag.getAgentId()).isEqualTo(agentId);
	}


	@Test
	public void testupdateAgent() throws AgentNotFoundException {
		int agentId = 7;
		LOGGER.info("The update is started for element with id " + agentId);
		Agent ag = new Agent(agentId, "kashyazzp", "datacc officer", "fortyc thousand", "kakiznada",
				"agent@gmail.com", "twezcisesifi");
		ag.setDesignation("employee");
		agentService.addAgent(ag);
		Agent update = agentService.findAgentById(agentId);
		assertThat(update.getDesignation()).isEqualTo(ag.getDesignation());
	}


	@Test
	public void testviewAllAgents() {
		List<Agent> ag = agentService.viewAllAgents();
		LOGGER.info("The list of elements are");
		for (Agent i : ag) {
			int id = i.getAgentId();
			LOGGER.info("The details for id" + id);
		}
		assertThat(ag).size().isGreaterThan(0);
	}

	@Test
	public void testremoveAgent() throws AgentNotFoundException {
		int id = 7;
		LOGGER.info("The element to be removed is " + id);
		agentService.removeAgent(id);
		Agent result = agentService.readAgent(22);
		Assertions.assertNull(result.getAgentName());
	}
}