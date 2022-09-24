/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.clinic.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author krish
 */
@Entity
@Table(name = "TreatmentMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TreatmentMaster.findAll", query = "SELECT t FROM TreatmentMaster t"),
    @NamedQuery(name = "TreatmentMaster.findById", query = "SELECT t FROM TreatmentMaster t WHERE t.id = :id"),
    @NamedQuery(name = "TreatmentMaster.findByDateTime", query = "SELECT t FROM TreatmentMaster t WHERE t.dateTime = :dateTime"),
    @NamedQuery(name = "TreatmentMaster.findByOtherTreatment", query = "SELECT t FROM TreatmentMaster t WHERE t.otherTreatment = :otherTreatment"),
    @NamedQuery(name = "TreatmentMaster.findByDescription", query = "SELECT t FROM TreatmentMaster t WHERE t.description = :description")})
public class TreatmentMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "DateTime")
    @Temporal(TemporalType.DATE)
    private Date dateTime;
    @Size(max = 255)
    @Column(name = "OtherTreatment")
    private String otherTreatment;
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "PatientId", referencedColumnName = "PatientId")
    @ManyToOne
    private PatientMaster patientId;
    @JoinColumn(name = "ToothId", referencedColumnName = "ToothId")
    @ManyToOne
    private ToothMaster toothId;
    @JoinColumn(name = "TreatementId", referencedColumnName = "TreatmentTransId")
    @ManyToOne
    private TreatmentTrans treatementId;

    public TreatmentMaster() {
    }

    public TreatmentMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getOtherTreatment() {
        return otherTreatment;
    }

    public void setOtherTreatment(String otherTreatment) {
        this.otherTreatment = otherTreatment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PatientMaster getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientMaster patientId) {
        this.patientId = patientId;
    }

    public ToothMaster getToothId() {
        return toothId;
    }

    public void setToothId(ToothMaster toothId) {
        this.toothId = toothId;
    }

    public TreatmentTrans getTreatementId() {
        return treatementId;
    }

    public void setTreatementId(TreatmentTrans treatementId) {
        this.treatementId = treatementId;
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
        if (!(object instanceof TreatmentMaster)) {
            return false;
        }
        TreatmentMaster other = (TreatmentMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.main.clinic.entity.TreatmentMaster[ id=" + id + " ]";
    }
    
}
