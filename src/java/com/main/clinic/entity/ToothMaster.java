/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.clinic.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author krish
 */
@Entity
@Table(name = "ToothMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToothMaster.findAll", query = "SELECT t FROM ToothMaster t"),
    @NamedQuery(name = "ToothMaster.findByToothId", query = "SELECT t FROM ToothMaster t WHERE t.toothId = :toothId"),
    @NamedQuery(name = "ToothMaster.findByToothName", query = "SELECT t FROM ToothMaster t WHERE t.toothName = :toothName"),
    @NamedQuery(name = "ToothMaster.findByToothCode", query = "SELECT t FROM ToothMaster t WHERE t.toothCode = :toothCode")})
public class ToothMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ToothId")
    private Integer toothId;
    @Size(max = 255)
    @Column(name = "ToothName")
    private String toothName;
    @Column(name = "ToothCode")
    private Integer toothCode;
    @OneToMany(mappedBy = "toothId")
    private Collection<TreatmentMaster> treatmentMasterCollection;

    public ToothMaster() {
    }

    public ToothMaster(Integer toothId) {
        this.toothId = toothId;
    }

    public Integer getToothId() {
        return toothId;
    }

    public void setToothId(Integer toothId) {
        this.toothId = toothId;
    }

    public String getToothName() {
        return toothName;
    }

    public void setToothName(String toothName) {
        this.toothName = toothName;
    }

    public Integer getToothCode() {
        return toothCode;
    }

    public void setToothCode(Integer toothCode) {
        this.toothCode = toothCode;
    }

    @XmlTransient
    public Collection<TreatmentMaster> getTreatmentMasterCollection() {
        return treatmentMasterCollection;
    }

    public void setTreatmentMasterCollection(Collection<TreatmentMaster> treatmentMasterCollection) {
        this.treatmentMasterCollection = treatmentMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toothId != null ? toothId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToothMaster)) {
            return false;
        }
        ToothMaster other = (ToothMaster) object;
        if ((this.toothId == null && other.toothId != null) || (this.toothId != null && !this.toothId.equals(other.toothId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return toothName;
    }
    
}
