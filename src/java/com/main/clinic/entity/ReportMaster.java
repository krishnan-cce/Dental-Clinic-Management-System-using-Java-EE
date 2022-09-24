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
@Table(name = "ReportMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportMaster.findAll", query = "SELECT r FROM ReportMaster r"),
    @NamedQuery(name = "ReportMaster.findByReportId", query = "SELECT r FROM ReportMaster r WHERE r.reportId = :reportId"),
    @NamedQuery(name = "ReportMaster.findByReportDate", query = "SELECT r FROM ReportMaster r WHERE r.reportDate = :reportDate"),
    @NamedQuery(name = "ReportMaster.findByConsultationFee", query = "SELECT r FROM ReportMaster r WHERE r.consultationFee = :consultationFee"),
    @NamedQuery(name = "ReportMaster.findByNotes", query = "SELECT r FROM ReportMaster r WHERE r.notes = :notes")})
public class ReportMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReportId")
    private Integer reportId;
    @Column(name = "ReportDate")
    @Temporal(TemporalType.DATE)
    private Date reportDate;
    @Column(name = "ConsultationFee")
    private Integer consultationFee;
    @Size(max = 255)
    @Column(name = "Notes")
    private String notes;
    @JoinColumn(name = "DosageId", referencedColumnName = "DosageId")
    @ManyToOne
    private DosageMaster dosageId;
    @JoinColumn(name = "DurationId", referencedColumnName = "DurationId")
    @ManyToOne
    private DurationMaster durationId;
    @JoinColumn(name = "MedicineId", referencedColumnName = "MedicineId")
    @ManyToOne
    private MedicineMaster medicineId;
    @JoinColumn(name = "PatientId", referencedColumnName = "PatientId")
    @ManyToOne
    private PatientMaster patientId;

    public ReportMaster() {
    }

    public ReportMaster(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Integer getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Integer consultationFee) {
        this.consultationFee = consultationFee;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public DosageMaster getDosageId() {
        return dosageId;
    }

    public void setDosageId(DosageMaster dosageId) {
        this.dosageId = dosageId;
    }

    public DurationMaster getDurationId() {
        return durationId;
    }

    public void setDurationId(DurationMaster durationId) {
        this.durationId = durationId;
    }

    public MedicineMaster getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(MedicineMaster medicineId) {
        this.medicineId = medicineId;
    }

    public PatientMaster getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientMaster patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportMaster)) {
            return false;
        }
        ReportMaster other = (ReportMaster) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.main.clinic.entity.ReportMaster[ reportId=" + reportId + " ]";
    }
    
}
