/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.logic;

import com.afrinnova.agentportal.entities.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Unicorn
 */
@Local
public interface CustomerFacadeLocal {

    void create(Customer customer);

    void edit(Customer customer);

    void remove(Customer customer);

    Customer find(Object id);

    List<Customer> findAll();

    List<Customer> findRange(int[] range);

    int count();
    
    List<Customer> findAgentCustomers(String agentID);
    
    List<Customer> findAgentsByTypeName(String agentTypeName);
    
    List<Customer> findDownlineCustomers(String agentID);
    
}
