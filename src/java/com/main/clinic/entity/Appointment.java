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
@Table(name = "Appointment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a.appointmentId,a.dateOfAppointment,a.doctorId.name,a.patientId.name,a.appointmentStatus,a.complaint FROM Appointment a"),
    @NamedQuery(name = "Appointment.findByAppointmentId", query = "SELECT a FROM Appointment a WHERE a.appointmentId = :appointmentId"),
    @NamedQuery(name = "Appointment.findByDateOfAppointment", query = "SELECT a FROM Appointment a WHERE a.dateOfAppointment = :dateOfAppointment"),
    @NamedQuery(name = "Appointment.findByComplaint", query = "SELECT a FROM Appointment a WHERE a.complaint = :complaint"),
    @NamedQuery(name = "Appointment.findByAppointmentStatus", query = "SELECT a FROM Appointment a WHERE a.appointmentStatus = :appointmentStatus")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AppointmentId")
    private Integer appointmentId;
    @Column(name = "DateOfAppointment")
    @Temporal(TemporalType.DATE)
    private Date dateOfAppointment;
    @Size(max = 255)
    @Column(name = "Complaint")
    private String complaint;
    @Size(max = 255)
    @Column(name = "AppointmentStatus")
    private String appointmentStatus;
    @JoinColumn(name = "DoctorId", referencedColumnName = "DoctorId")
    @ManyToOne
    private DoctorMaster doctorId;
    @JoinColumn(name = "PatientId", referencedColumnName = "PatientId")
    @ManyToOne
    private PatientMaster patientId;
    @JoinColumn(name = "TimeOfAppointment", referencedColumnName = "TimeOfAppointment")
    @ManyToOne
    private ScheduleTiming timeOfAppointment;

    public Appointment() {
    }

    public Appointment(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public DoctorMaster getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(DoctorMaster doctorId) {
        this.doctorId = doctorId;
    }

    public PatientMaster getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientMaster patientId) {
        this.patientId = patientId;
    }

    public ScheduleTiming getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(ScheduleTiming timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentId != null ? appointmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.appointmentId == null && other.appointmentId != null) || (this.appointmentId != null && !this.appointmentId.equals(other.appointmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.main.clinic.entity.Appointment[ appointmentId=" + appointmentId + " ]";
    }
    
}
