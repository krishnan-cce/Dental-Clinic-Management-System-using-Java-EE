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
@Table(name = "DistrictMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DistrictMaster.findAll", query = "SELECT d FROM DistrictMaster d"),
    @NamedQuery(name = "DistrictMaster.findByDistrictId", query = "SELECT d FROM DistrictMaster d WHERE d.districtId = :districtId"),
    @NamedQuery(name = "DistrictMaster.findByDistrictNo", query = "SELECT d FROM DistrictMaster d WHERE d.districtNo = :districtNo"),
    @NamedQuery(name = "DistrictMaster.findByDistrict", query = "SELECT d FROM DistrictMaster d WHERE d.district = :district")})
public class DistrictMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DistrictId")
    private Integer districtId;
    @Column(name = "DistrictNo")
    private Integer districtNo;
    @Size(max = 255)
    @Column(name = "District")
    private String district;
    @OneToMany(mappedBy = "districtId")
    private Collection<PatientMaster> patientMasterCollection;
    @OneToMany(mappedBy = "districtId")
    private Collection<DoctorMaster> doctorMasterCollection;

    public DistrictMaster() {
    }

    public DistrictMaster(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(Integer districtNo) {
        this.districtNo = districtNo;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @XmlTransient
    public Collection<PatientMaster> getPatientMasterCollection() {
        return patientMasterCollection;
    }

    public void setPatientMasterCollection(Collection<PatientMaster> patientMasterCollection) {
        this.patientMasterCollection = patientMasterCollection;
    }

    @XmlTransient
    public Collection<DoctorMaster> getDoctorMasterCollection() {
        return doctorMasterCollection;
    }

    public void setDoctorMasterCollection(Collection<DoctorMaster> doctorMasterCollection) {
        this.doctorMasterCollection = doctorMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtId != null ? districtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DistrictMaster)) {
            return false;
        }
        DistrictMaster other = (DistrictMaster) object;
        if ((this.districtId == null && other.districtId != null) || (this.districtId != null && !this.districtId.equals(other.districtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return district;
    }
    
}
