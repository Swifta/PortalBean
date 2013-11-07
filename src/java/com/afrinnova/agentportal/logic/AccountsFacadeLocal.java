/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.Accounts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unicorn
 */
@Local
public interface AccountsFacadeLocal {

    void create(Accounts accounts);

    void edit(Accounts accounts);

    void remove(Accounts accounts);

    Accounts find(Object id);

    List<Accounts> findAll();

    List<Accounts> findRange(int[] range);

    int count();
    
    Accounts findUsernameAndPassword(String username,String password);
    
}
