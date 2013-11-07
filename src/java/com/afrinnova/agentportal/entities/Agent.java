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
@Table(name = "agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a"),
    @NamedQuery(name = "Agent.findById", query = "SELECT a FROM Agent a WHERE a.id = :id"),
    @NamedQuery(name = "Agent.findByUserAccount", query = "SELECT a FROM Agent a WHERE a.useraccountsId.msisdn = :msisdn"),
    @NamedQuery(name = "Agent.findByBalance", query = "SELECT a FROM Agent a WHERE a.balance = :balance"),
    @NamedQuery(name = "Agent.findByAgentTypeName", query = "SELECT a FROM Agent a WHERE a.agenttypeId.agenttypename = :agenttypename"),
    @NamedQuery(name = "Agent.findByDatecreated", query = "SELECT a FROM Agent a WHERE a.datecreated = :datecreated")})
public class Agent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 255)
    @Column(name = "balance")
    private String balance;
    
    @Size(max = 255)
    @Column(name = "agentname")
    private String agentname;
    
    @Size(max = 255)
    @Column(name = "accountnumber")
    private String accountnumber;
    
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "childId")
    private Collection<Linkage> linkageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId")
    private Collection<Linkage> linkageCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentsId")
    private Collection<Customer> customerCollection;
    @JoinColumn(name = "useraccounts_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accounts useraccountsId;
    @JoinColumn(name = "agenttype_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AgentType agenttypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentsId")
    private Collection<UserTransactions> userTransactionsCollection;

    public Agent() {
    }

    public Agent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    @XmlTransient
    public Collection<Linkage> getLinkageCollection() {
        return linkageCollection;
    }

    public void setLinkageCollection(Collection<Linkage> linkageCollection) {
        this.linkageCollection = linkageCollection;
    }

    @XmlTransient
    public Collection<Linkage> getLinkageCollection1() {
        return linkageCollection1;
    }

    public void setLinkageCollection1(Collection<Linkage> linkageCollection1) {
        this.linkageCollection1 = linkageCollection1;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public Accounts getUseraccountsId() {
        return useraccountsId;
    }

    public void setUseraccountsId(Accounts useraccountsId) {
        this.useraccountsId = useraccountsId;
    }

    public AgentType getAgenttypeId() {
        return agenttypeId;
    }

    public void setAgenttypeId(AgentType agenttypeId) {
        this.agenttypeId = agenttypeId;
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
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.afrinnova.agentportal.entities.Agent[ id=" + id + " ]";
    }
    
}
