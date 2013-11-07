/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.UserTransactions;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unicorn
 */
@Local
public interface UserTransactionsFacadeLocal {

    void create(UserTransactions userTransactions);

    void edit(UserTransactions userTransactions);

    void remove(UserTransactions userTransactions);

    UserTransactions find(Object id);

    List<UserTransactions> findAll();

    List<UserTransactions> findRange(int[] range);

    int count();
    
    List<UserTransactions> findTransactionsByTypeName(String typeName);
    
    List<UserTransactions> findTransactionsByAgentType(String typeName);
}
