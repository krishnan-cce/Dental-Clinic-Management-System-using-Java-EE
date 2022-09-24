/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.clinic.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author krish
 */
@Entity
@Table(name = "DoctorSchedules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DoctorSchedules.findAll", query = "SELECT d FROM DoctorSchedules d"),
    @NamedQuery(name = "DoctorSchedules.findByScheduleId", query = "SELECT d FROM DoctorSchedules d WHERE d.scheduleId = :scheduleId"),
    @NamedQuery(name = "DoctorSchedules.findByScheduleDate", query = "SELECT d FROM DoctorSchedules d WHERE d.scheduleDate = :scheduleDate"),
    @NamedQuery(name = "DoctorSchedules.findByScheduleDay", query = "SELECT d FROM DoctorSchedules d WHERE d.scheduleDay = :scheduleDay"),
    @NamedQuery(name = "DoctorSchedules.findByStartTime", query = "SELECT d FROM DoctorSchedules d WHERE d.startTime = :startTime"),
    @NamedQuery(name = "DoctorSchedules.findByEndTime", query = "SELECT d FROM DoctorSchedules d WHERE d.endTime = :endTime"),
    @NamedQuery(name = "DoctorSchedules.findByScheduleStatus", query = "SELECT d FROM DoctorSchedules d WHERE d.scheduleStatus = :scheduleStatus"),
    @NamedQuery(name = "DoctorSchedules.findByDoctorID", query = "SELECT d FROM DoctorSchedules d WHERE d.doctorID = :doctorID")})
public class DoctorSchedules implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScheduleId")
    private Integer scheduleId;
    @Size(max = 255)
    @Column(name = "ScheduleDate")
    private String scheduleDate;
    @Size(max = 255)
    @Column(name = "ScheduleDay")
    private String scheduleDay;
    @Size(max = 255)
    @Column(name = "StartTime")
    private String startTime;
    @Size(max = 255)
    @Column(name = "EndTime")
    private String endTime;
    @Size(max = 255)
    @Column(name = "ScheduleStatus")
    private String scheduleStatus;
    @Column(name = "DoctorID")
    private Integer doctorID;
    @JoinColumn(name = "ScheduleId", referencedColumnName = "DoctorId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DoctorMaster doctorMaster;

    public DoctorSchedules() {
    }

    public DoctorSchedules(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleDay() {
        return scheduleDay;
    }

    public void setScheduleDay(String scheduleDay) {
        this.scheduleDay = scheduleDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public DoctorMaster getDoctorMaster() {
        return doctorMaster;
    }

    public void setDoctorMaster(DoctorMaster doctorMaster) {
        this.doctorMaster = doctorMaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleId != null ? scheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctorSchedules)) {
            return false;
        }
        DoctorSchedules other = (DoctorSchedules) object;
        if ((this.scheduleId == null && other.scheduleId != null) || (this.scheduleId != null && !this.scheduleId.equals(other.scheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.main.clinic.entity.DoctorSchedules[ scheduleId=" + scheduleId + " ]";
    }
    
}
