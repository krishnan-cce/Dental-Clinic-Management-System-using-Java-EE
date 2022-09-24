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
@Table(name = "DosageMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DosageMaster.findAll", query = "SELECT d FROM DosageMaster d"),
    @NamedQuery(name = "DosageMaster.findByDosageId", query = "SELECT d FROM DosageMaster d WHERE d.dosageId = :dosageId"),
    @NamedQuery(name = "DosageMaster.findByDosage", query = "SELECT d FROM DosageMaster d WHERE d.dosage = :dosage")})
public class DosageMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DosageId")
    private Integer dosageId;
    @Size(max = 255)
    @Column(name = "Dosage")
    private String dosage;
    @OneToMany(mappedBy = "dosageId")
    private Collection<ReportMaster> reportMasterCollection;

    public DosageMaster() {
    }

    public DosageMaster(Integer dosageId) {
        this.dosageId = dosageId;
    }

    public Integer getDosageId() {
        return dosageId;
    }

    public void setDosageId(Integer dosageId) {
        this.dosageId = dosageId;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @XmlTransient
    public Collection<ReportMaster> getReportMasterCollection() {
        return reportMasterCollection;
    }

    public void setReportMasterCollection(Collection<ReportMaster> reportMasterCollection) {
        this.reportMasterCollection = reportMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dosageId != null ? dosageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DosageMaster)) {
            return false;
        }
        DosageMaster other = (DosageMaster) object;
        if ((this.dosageId == null && other.dosageId != null) || (this.dosageId != null && !this.dosageId.equals(other.dosageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dosage;
    }
    
}
