/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.Linkage;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Unicorn
 */
@Stateless
public class LinkageFacade extends AbstractFacade<Linkage> implements LinkageFacadeLocal {
    @PersistenceContext(unitName = "PortalEntitiesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LinkageFacade() {
        super(Linkage.class);
    }

    @Override
    public List<Linkage> findDownlines(String parentID) {
        return this.em.createNamedQuery("Linkage.findAgentDownlines").setParameter("parentID",parentID).getResultList();
    }

    @Override
    public Linkage findParentAgent(String childID) {
        return (Linkage)this.em.createNamedQuery("Linkage.findAgentParent").setParameter("childID",childID).getSingleResult();
    }
    
}
