/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.AgentType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unicorn
 */
@Local
public interface AgentTypeFacadeLocal {

    void create(AgentType agentType);

    void edit(AgentType agentType);

    void remove(AgentType agentType);

    AgentType find(Object id);

    List<AgentType> findAll();

    List<AgentType> findRange(int[] range);

    int count();
    
}
