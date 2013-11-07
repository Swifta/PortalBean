/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Unicorn
 */
@Entity
@Table(name = "usertransactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTransactions.findAll", query = "SELECT u FROM UserTransactions u"),
    @NamedQuery(name = "UserTransactions.findById", query = "SELECT u FROM UserTransactions u WHERE u.id = :id"),
    @NamedQuery(name = "UserTransactions.findByTransactionType", query = "SELECT u FROM UserTransactions u WHERE u.transactiontypeId.transactiontypename = :typename"),
    @NamedQuery(name = "UserTransactions.findByAgentTypeName", query = "SELECT u FROM UserTransactions u WHERE u.agentsId.agenttypeId.agenttypename = :typename"),
    @NamedQuery(name = "UserTransactions.findByAmount", query = "SELECT u FROM UserTransactions u WHERE u.amount = :amount"),
    @NamedQuery(name = "UserTransactions.findByDatecreated", query = "SELECT u FROM UserTransactions u WHERE u.datecreated = :datecreated")})
public class UserTransactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "amount")
    private String amount;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @JoinColumn(name = "transactiontype_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransactionType transactiontypeId;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "agents_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Agent agentsId;

    public UserTransactions() {
    }

    public UserTransactions(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public TransactionType getTransactiontypeId() {
        return transactiontypeId;
    }

    public void setTransactiontypeId(TransactionType transactiontypeId) {
        this.transactiontypeId = transactiontypeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Agent getAgentsId() {
        return agentsId;
    }

    public void setAgentsId(Agent agentsId) {
        this.agentsId = agentsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTransactions)) {
            return false;
        }
        UserTransactions other = (UserTransactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.afrinnova.agentportal.entities.UserTransactions[ id=" + id + " ]";
    }
    
}
