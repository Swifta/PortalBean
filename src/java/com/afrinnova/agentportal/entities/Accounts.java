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
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findById", query = "SELECT a FROM Accounts a WHERE a.id = :id"),
    @NamedQuery(name = "Accounts.findByMsisdn", query = "SELECT a FROM Accounts a WHERE a.msisdn = :msisdn"),
    @NamedQuery(name = "Accounts.findByPassword", query = "SELECT a FROM Accounts a WHERE a.password = :password"),
    @NamedQuery(name = "Accounts.authenticate", query = "SELECT a FROM Accounts a WHERE a.password = :password and a.msisdn = :username"),
    @NamedQuery(name = "Accounts.findByDateloggedin", query = "SELECT a FROM Accounts a WHERE a.dateloggedin = :dateloggedin"),
    @NamedQuery(name = "Accounts.findByActive", query = "SELECT a FROM Accounts a WHERE a.active = :active"),
    @NamedQuery(name = "Accounts.findByDatecreated", query = "SELECT a FROM Accounts a WHERE a.datecreated = :datecreated")})
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "msisdn")
    private String msisdn;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Column(name = "dateloggedin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateloggedin;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useraccountsId")
    private Collection<Agent> agentCollection;

    public Accounts() {
    }

    public Accounts(Integer id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateloggedin() {
        return dateloggedin;
    }

    public void setDateloggedin(Date dateloggedin) {
        this.dateloggedin = dateloggedin;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    @XmlTransient
    public Collection<Agent> getAgentCollection() {
        return agentCollection;
    }

    public void setAgentCollection(Collection<Agent> agentCollection) {
        this.agentCollection = agentCollection;
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
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.afrinnova.agentportal.entities.Accounts[ id=" + id + " ]";
    }
    
}
