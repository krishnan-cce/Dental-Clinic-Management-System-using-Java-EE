/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.clinic.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author krish
 */
@Entity
@Table(name = "PatientMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientMaster.findAll", query = "SELECT p FROM PatientMaster p"),
    @NamedQuery(name = "PatientMaster.findByPatientId", query = "SELECT p FROM PatientMaster p WHERE p.patientId = :patientId"),
    @NamedQuery(name = "PatientMaster.findByName", query = "SELECT p FROM PatientMaster p WHERE p.name = :name"),
    @NamedQuery(name = "PatientMaster.findByGender", query = "SELECT p FROM PatientMaster p WHERE p.gender = :gender"),
    @NamedQuery(name = "PatientMaster.findByOccupation", query = "SELECT p FROM PatientMaster p WHERE p.occupation = :occupation"),
    @NamedQuery(name = "PatientMaster.findByAddress", query = "SELECT p FROM PatientMaster p WHERE p.address = :address"),
    @NamedQuery(name = "PatientMaster.findByPinCode", query = "SELECT p FROM PatientMaster p WHERE p.pinCode = :pinCode"),
    @NamedQuery(name = "PatientMaster.findByEmail", query = "SELECT p FROM PatientMaster p WHERE p.email = :email"),
    @NamedQuery(name = "PatientMaster.findByMobile", query = "SELECT p FROM PatientMaster p WHERE p.mobile = :mobile"),
    @NamedQuery(name = "PatientMaster.findByTelephone", query = "SELECT p FROM PatientMaster p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "PatientMaster.findByBirthDate", query = "SELECT p FROM PatientMaster p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "PatientMaster.findBySmoking", query = "SELECT p FROM PatientMaster p WHERE p.smoking = :smoking"),
    @NamedQuery(name = "PatientMaster.findByChronicDiseases", query = "SELECT p FROM PatientMaster p WHERE p.chronicDiseases = :chronicDiseases"),
    @NamedQuery(name = "PatientMaster.findByAllergies", query = "SELECT p FROM PatientMaster p WHERE p.allergies = :allergies")})
public class PatientMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PatientId")
    private Integer patientId;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "Gender")
    private String gender;
    @Size(max = 255)
    @Column(name = "Occupation")
    private String occupation;
    @Size(max = 255)
    @Column(name = "Address")
    private String address;
    @Column(name = "PinCode")
    private Integer pinCode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "Email")
    private String email;
    @Column(name = "Mobile")
    private String mobile;
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "BirthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Size(max = 255)
    @Column(name = "Smoking")
    private String smoking;
    @Size(max = 255)
    @Column(name = "ChronicDiseases")
    private String chronicDiseases;
    @Size(max = 255)
    @Column(name = "Allergies")
    private String allergies;
    @OneToMany(mappedBy = "patientId")
    private Collection<Appointment> appointmentCollection;
    @OneToMany(mappedBy = "patientId")
    private Collection<TreatmentMaster> treatmentMasterCollection;
    @OneToMany(mappedBy = "patientId")
    private Collection<ReportMaster> reportMasterCollection;
    @JoinColumn(name = "DistrictId", referencedColumnName = "DistrictId")
    @ManyToOne
    private DistrictMaster districtId;
    @JoinColumn(name = "DoctorId", referencedColumnName = "DoctorId")
    @ManyToOne
    private DoctorMaster doctorId;
    @JoinColumn(name = "StateId", referencedColumnName = "StateId")
    @ManyToOne
    private StateMaster stateId;

    public PatientMaster() {
    }

    public PatientMaster(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getChronicDiseases() {
        return chronicDiseases;
    }

    public void setChronicDiseases(String chronicDiseases) {
        this.chronicDiseases = chronicDiseases;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @XmlTransient
    public Collection<TreatmentMaster> getTreatmentMasterCollection() {
        return treatmentMasterCollection;
    }

    public void setTreatmentMasterCollection(Collection<TreatmentMaster> treatmentMasterCollection) {
        this.treatmentMasterCollection = treatmentMasterCollection;
    }

    @XmlTransient
    public Collection<ReportMaster> getReportMasterCollection() {
        return reportMasterCollection;
    }

    public void setReportMasterCollection(Collection<ReportMaster> reportMasterCollection) {
        this.reportMasterCollection = reportMasterCollection;
    }

    public DistrictMaster getDistrictId() {
        return districtId;
    }

    public void setDistrictId(DistrictMaster districtId) {
        this.districtId = districtId;
    }

    public DoctorMaster getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(DoctorMaster doctorId) {
        this.doctorId = doctorId;
    }

    public StateMaster getStateId() {
        return stateId;
    }

    public void setStateId(StateMaster stateId) {
        this.stateId = stateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientMaster)) {
            return false;
        }
        PatientMaster other = (PatientMaster) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
