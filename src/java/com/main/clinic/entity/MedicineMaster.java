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
@Table(name = "MedicineMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicineMaster.findAll", query = "SELECT m FROM MedicineMaster m"),
    @NamedQuery(name = "MedicineMaster.findByMedicineId", query = "SELECT m FROM MedicineMaster m WHERE m.medicineId = :medicineId"),
    @NamedQuery(name = "MedicineMaster.findByMedicineName", query = "SELECT m FROM MedicineMaster m WHERE m.medicineName = :medicineName"),
    @NamedQuery(name = "MedicineMaster.findByMedicineCode", query = "SELECT m FROM MedicineMaster m WHERE m.medicineCode = :medicineCode")})
public class MedicineMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MedicineId")
    private Integer medicineId;
    @Size(max = 255)
    @Column(name = "MedicineName")
    private String medicineName;
    @Column(name = "MedicineCode")
    private Integer medicineCode;
    @OneToMany(mappedBy = "medicineId")
    private Collection<ReportMaster> reportMasterCollection;

    public MedicineMaster() {
    }

    public MedicineMaster(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(Integer medicineCode) {
        this.medicineCode = medicineCode;
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
        hash += (medicineId != null ? medicineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicineMaster)) {
            return false;
        }
        MedicineMaster other = (MedicineMaster) object;
        if ((this.medicineId == null && other.medicineId != null) || (this.medicineId != null && !this.medicineId.equals(other.medicineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return medicineName;
    }
    
}
