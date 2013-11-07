/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Unicorn
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {

    @PersistenceContext(unitName = "PortalEntitiesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public List<Customer> findAgentCustomers(String agentID) {
        return this.em.createNamedQuery("Customer.findByAgent").setParameter("agentID", agentID).getResultList();
    }

    @Override
    public List<Customer> findAgentsByTypeName(String agentTypeName) {
        return this.em.createNamedQuery("Customer.findByAgentTypeName").setParameter("agenttypename", agentTypeName).getResultList();
    }

    @Override
    public List<Customer> findDownlineCustomers(String agentID) {
        return this.em.createNamedQuery("Customer.findDownlineCustomers").setParameter("parentId",agentID).getResultList();
    }
}
