/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afrinnova.agentportal.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Unicorn
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id"),
    @NamedQuery(name = "Customer.findByMsisdn", query = "SELECT c FROM Customer c WHERE c.msisdn = :msisdn"),
    @NamedQuery(name = "Customer.findByAgent", query = "SELECT c FROM Customer c WHERE c.agentsId.useraccountsId.msisdn = :agentID"),
    @NamedQuery(name = "Customer.findDownlineCustomers", query = "SELECT c FROM Customer c WHERE c.agentsId in (select l.childId from Linkage l where l.parentId = :parentId)"),
    @NamedQuery(name = "Customer.findByAgentTypeName", query = "SELECT c FROM Customer c WHERE c.agentsId.agenttypeId.agenttypename = :agenttypename"),
    @NamedQuery(name = "Customer.findByDatecreated", query = "SELECT c FROM Customer c WHERE c.datecreated = :datecreated")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "msisdn")
    private String msisdn;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @JoinColumn(name = "agents_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Agent agentsId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<UserTransactions> userTransactionsCollection;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Agent getAgentsId() {
        return agentsId;
    }

    public void setAgentsId(Agent agentsId) {
        this.agentsId = agentsId;
    }

    @XmlTransient
    public Collection<UserTransactions> getUserTransactionsCollection() {
        return userTransactionsCollection;
    }

    public void setUserTransactionsCollection(Collection<UserTransactions> userTransactionsCollection) {
        this.userTransactionsCollection = userTransactionsCollection;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.afrinnova.agentportal.entities.Customer[ id=" + id + " ]";
    }
    
}
