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
@Table(name = "StateMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StateMaster.findAll", query = "SELECT s FROM StateMaster s"),
    @NamedQuery(name = "StateMaster.findByStateId", query = "SELECT s FROM StateMaster s WHERE s.stateId = :stateId"),
    @NamedQuery(name = "StateMaster.findByStateNo", query = "SELECT s FROM StateMaster s WHERE s.stateNo = :stateNo"),
    @NamedQuery(name = "StateMaster.findByState", query = "SELECT s FROM StateMaster s WHERE s.state = :state")})
public class StateMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "StateId")
    private Integer stateId;
    @Size(max = 255)
    @Column(name = "StateNo")
    private String stateNo;
    @Size(max = 255)
    @Column(name = "State")
    private String state;
    @OneToMany(mappedBy = "stateId")
    private Collection<PatientMaster> patientMasterCollection;
    @OneToMany(mappedBy = "stateId")
    private Collection<DoctorMaster> doctorMasterCollection;

    public StateMaster() {
    }

    public StateMaster(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateNo() {
        return stateNo;
    }

    public void setStateNo(String stateNo) {
        this.stateNo = stateNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateMaster)) {
            return false;
        }
        StateMaster other = (StateMaster) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return state;
    }
    
}
