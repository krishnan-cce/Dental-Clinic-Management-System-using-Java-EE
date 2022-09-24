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
@Table(name = "DurationMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DurationMaster.findAll", query = "SELECT d FROM DurationMaster d"),
    @NamedQuery(name = "DurationMaster.findByDurationId", query = "SELECT d FROM DurationMaster d WHERE d.durationId = :durationId"),
    @NamedQuery(name = "DurationMaster.findByDuration", query = "SELECT d FROM DurationMaster d WHERE d.duration = :duration")})
public class DurationMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DurationId")
    private Integer durationId;
    @Size(max = 255)
    @Column(name = "Duration")
    private String duration;
    @OneToMany(mappedBy = "durationId")
    private Collection<ReportMaster> reportMasterCollection;

    public DurationMaster() {
    }

    public DurationMaster(Integer durationId) {
        this.durationId = durationId;
    }

    public Integer getDurationId() {
        return durationId;
    }

    public void setDurationId(Integer durationId) {
        this.durationId = durationId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
        hash += (durationId != null ? durationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DurationMaster)) {
            return false;
        }
        DurationMaster other = (DurationMaster) object;
        if ((this.durationId == null && other.durationId != null) || (this.durationId != null && !this.durationId.equals(other.durationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return duration;
    }
    
}
