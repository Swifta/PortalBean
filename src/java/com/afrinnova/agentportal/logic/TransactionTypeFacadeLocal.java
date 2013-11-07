/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.TransactionType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unicorn
 */
@Local
public interface TransactionTypeFacadeLocal {

    void create(TransactionType transactionType);

    void edit(TransactionType transactionType);

    void remove(TransactionType transactionType);

    TransactionType find(Object id);

    List<TransactionType> findAll();

    List<TransactionType> findRange(int[] range);

    int count();
    
}
