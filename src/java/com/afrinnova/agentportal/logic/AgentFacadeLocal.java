/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.Agent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unicorn
 */
@Local
public interface AgentFacadeLocal {

    void create(Agent agent);

    void edit(Agent agent);

    void remove(Agent agent);

    Agent find(Object id);

    List<Agent> findAll();

    List<Agent> findRange(int[] range);

    int count();
    
    List<Agent> findByType(String agentName);
    
    Agent findAgentWithAccountName(String username);
    
}
