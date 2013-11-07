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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Unicorn
 */
@Entity
@Table(name = "linkage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linkage.findAll", query = "SELECT l FROM Linkage l"),
    @NamedQuery(name = "Linkage.findById", query = "SELECT l FROM Linkage l WHERE l.id = :id"),
    @NamedQuery(name = "Linkage.findAgentDownlines", query = "SELECT l FROM Linkage l WHERE l.parentId.useraccountsId.msisdn = :parentID"),
    @NamedQuery(name = "Linkage.findAgentParent", query = "SELECT l FROM Linkage l WHERE l.childId.useraccountsId.msisdn = :childID"),
    @NamedQuery(name = "Linkage.findByDatecreated", query = "SELECT l FROM Linkage l WHERE l.datecreated = :datecreated")})
public class Linkage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @JoinColumn(name = "child_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Agent childId;
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Agent parentId;

    public Linkage() {
    }

    public Linkage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Agent getChildId() {
        return childId;
    }

    public void setChildId(Agent childId) {
        this.childId = childId;
    }

    public Agent getParentId() {
        return parentId;
    }

    public void setParentId(Agent parentId) {
        this.parentId = parentId;
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
        if (!(object instanceof Linkage)) {
            return false;
        }
        Linkage other = (Linkage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.afrinnova.agentportal.entities.Linkage[ id=" + id + " ]";
    }
    
}
