/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.Linkage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unicorn
 */
@Local
public interface LinkageFacadeLocal {

    void create(Linkage linkage);

    void edit(Linkage linkage);

    void remove(Linkage linkage);

    Linkage find(Object id);

    List<Linkage> findAll();

    List<Linkage> findRange(int[] range);

    int count();
    
    List<Linkage> findDownlines(String parentID);
    
    Linkage findParentAgent(String childID);
}
