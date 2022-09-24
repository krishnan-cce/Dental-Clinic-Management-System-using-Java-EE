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
@Table(name = "TreatmentTrans")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TreatmentTrans.findAll", query = "SELECT t FROM TreatmentTrans t"),
    @NamedQuery(name = "TreatmentTrans.findByTreatmentTransId", query = "SELECT t FROM TreatmentTrans t WHERE t.treatmentTransId = :treatmentTransId"),
    @NamedQuery(name = "TreatmentTrans.findByTreatmentCode", query = "SELECT t FROM TreatmentTrans t WHERE t.treatmentCode = :treatmentCode"),
    @NamedQuery(name = "TreatmentTrans.findByTreatmentName", query = "SELECT t FROM TreatmentTrans t WHERE t.treatmentName = :treatmentName")})
public class TreatmentTrans implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TreatmentTransId")
    private Integer treatmentTransId;
    @Size(max = 255)
    @Column(name = "TreatmentCode")
    private String treatmentCode;
    @Size(max = 255)
    @Column(name = "TreatmentName")
    private String treatmentName;
    @OneToMany(mappedBy = "treatementId")
    private Collection<TreatmentMaster> treatmentMasterCollection;

    public TreatmentTrans() {
    }

    public TreatmentTrans(Integer treatmentTransId) {
        this.treatmentTransId = treatmentTransId;
    }

    public Integer getTreatmentTransId() {
        return treatmentTransId;
    }

    public void setTreatmentTransId(Integer treatmentTransId) {
        this.treatmentTransId = treatmentTransId;
    }

    public String getTreatmentCode() {
        return treatmentCode;
    }

    public void setTreatmentCode(String treatmentCode) {
        this.treatmentCode = treatmentCode;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
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
        hash += (treatmentTransId != null ? treatmentTransId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TreatmentTrans)) {
            return false;
        }
        TreatmentTrans other = (TreatmentTrans) object;
        if ((this.treatmentTransId == null && other.treatmentTransId != null) || (this.treatmentTransId != null && !this.treatmentTransId.equals(other.treatmentTransId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return treatmentName;
    }
    
}
