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
@Table(name = "ScheduleTiming")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScheduleTiming.findAll", query = "SELECT s FROM ScheduleTiming s"),
    @NamedQuery(name = "ScheduleTiming.findByTimeOfAppointment", query = "SELECT s FROM ScheduleTiming s WHERE s.timeOfAppointment = :timeOfAppointment"),
    @NamedQuery(name = "ScheduleTiming.findByTime", query = "SELECT s FROM ScheduleTiming s WHERE s.time = :time")})
public class ScheduleTiming implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TimeOfAppointment")
    private Integer timeOfAppointment;
    @Size(max = 255)
    @Column(name = "Time")
    private String time;
    @OneToMany(mappedBy = "timeOfAppointment")
    private Collection<Appointment> appointmentCollection;

    public ScheduleTiming() {
    }

    public ScheduleTiming(Integer timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public Integer getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(Integer timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeOfAppointment != null ? timeOfAppointment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScheduleTiming)) {
            return false;
        }
        ScheduleTiming other = (ScheduleTiming) object;
        if ((this.timeOfAppointment == null && other.timeOfAppointment != null) || (this.timeOfAppointment != null && !this.timeOfAppointment.equals(other.timeOfAppointment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return time;
    }
    
}
