/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.Agent;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Unicorn
 */
@Stateless
public class AgentFacade extends AbstractFacade<Agent> implements AgentFacadeLocal {

    @PersistenceContext(unitName = "PortalEntitiesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgentFacade() {
        super(Agent.class);
    }

    @Override
    public List<Agent> findByType(String agentName) {
        return this.em.createNamedQuery("Agent.findByAgentTypeName").setParameter("agenttypename", agentName).getResultList();
    }

    @Override
    public Agent findAgentWithAccountName(String username) {
        try {
            return (Agent) this.em.createNamedQuery("Agent.findByUserAccount").setParameter("msisdn", username).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
