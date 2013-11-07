/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.Accounts;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Unicorn
 */
@Stateless
public class AccountsFacade extends AbstractFacade<Accounts> implements AccountsFacadeLocal {

    @PersistenceContext(unitName = "PortalEntitiesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountsFacade() {
        super(Accounts.class);
    }

    @Override
    public Accounts findUsernameAndPassword(String username, String password) {
        try{
            return (Accounts) this.em.createNamedQuery("Accounts.authenticate").setParameter("username", username).setParameter("password", password).getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
