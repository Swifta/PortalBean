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
@Table(name = "agenttype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgentType.findAll", query = "SELECT a FROM AgentType a"),
    @NamedQuery(name = "AgentType.findById", query = "SELECT a FROM AgentType a WHERE a.id = :id"),
    @NamedQuery(name = "AgentType.findByAgenttypename", query = "SELECT a FROM AgentType a WHERE a.agenttypename = :agenttypename"),
    @NamedQuery(name = "AgentType.findByDatecreated", query = "SELECT a FROM AgentType a WHERE a.datecreated = :datecreated")})
public class AgentType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "agenttypename")
    private String agenttypename;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agenttypeId")
    private Collection<Agent> agentCollection;

    public AgentType() {
    }

    public AgentType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgenttypename() {
        return agenttypename;
    }

    public void setAgenttypename(String agenttypename) {
        this.agenttypename = agenttypename;
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
        if (!(object instanceof AgentType)) {
            return false;
        }
        AgentType other = (AgentType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.afrinnova.agentportal.entities.AgentType[ id=" + id + " ]";
    }
    
}
