/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.UserTransactions;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Unicorn
 */
@Stateless
public class UserTransactionsFacade extends AbstractFacade<UserTransactions> implements UserTransactionsFacadeLocal {
    @PersistenceContext(unitName = "PortalEntitiesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserTransactionsFacade() {
        super(UserTransactions.class);
    }

    @Override
    public List<UserTransactions> findTransactionsByTypeName(String typeName) {
        return this.em.createNamedQuery("UserTransactions.findByTransactionType").setParameter("typename", typeName).getResultList();
    }

    @Override
    public List<UserTransactions> findTransactionsByAgentType(String typeName) {
        return this.em.createNamedQuery("UserTransactions.findByAgentTypeName").setParameter("typename",typeName).getResultList();
    }
    
}
