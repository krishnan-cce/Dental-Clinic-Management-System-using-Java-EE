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
@Table(name = "Specializations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specializations.findAll", query = "SELECT s FROM Specializations s"),
    @NamedQuery(name = "Specializations.findBySpecializationId", query = "SELECT s FROM Specializations s WHERE s.specializationId = :specializationId"),
    @NamedQuery(name = "Specializations.findBySpecializationsCode", query = "SELECT s FROM Specializations s WHERE s.specializationsCode = :specializationsCode"),
    @NamedQuery(name = "Specializations.findBySpecializations", query = "SELECT s FROM Specializations s WHERE s.specializations = :specializations")})
public class Specializations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SpecializationId")
    private Integer specializationId;
    @Size(max = 255)
    @Column(name = "SpecializationsCode")
    private String specializationsCode;
    @Size(max = 255)
    @Column(name = "Specializations")
    private String specializations;
    @OneToMany(mappedBy = "specializationId")
    private Collection<DoctorMaster> doctorMasterCollection;

    public Specializations() {
    }

    public Specializations(Integer specializationId) {
        this.specializationId = specializationId;
    }

    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecializationsCode() {
        return specializationsCode;
    }

    public void setSpecializationsCode(String specializationsCode) {
        this.specializationsCode = specializationsCode;
    }

    public String getSpecializations() {
        return specializations;
    }

    public void setSpecializations(String specializations) {
        this.specializations = specializations;
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
        hash += (specializationId != null ? specializationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specializations)) {
            return false;
        }
        Specializations other = (Specializations) object;
        if ((this.specializationId == null && other.specializationId != null) || (this.specializationId != null && !this.specializationId.equals(other.specializationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return specializations;
    }
    
}
