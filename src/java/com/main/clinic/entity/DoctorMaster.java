/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.clinic.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
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
@Table(name = "DoctorMaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DoctorMaster.findAll", query = "SELECT d FROM DoctorMaster d"),
    @NamedQuery(name = "DoctorMasterfindDetails",query="select  s.name ,sp.specializations,dt.district,st.state from DoctorMaster s  join s.specializationId sp join s.stateId st join s.districtId dt"),
    @NamedQuery(name = "DoctorMaster.findByDoctorId", query = "SELECT d FROM DoctorMaster d WHERE d.doctorId = :doctorId"),
    @NamedQuery(name = "DoctorMaster.findByName", query = "SELECT d FROM DoctorMaster d WHERE d.name = :name"),
    @NamedQuery(name = "DoctorMaster.findByGender", query = "SELECT d FROM DoctorMaster d WHERE d.gender = :gender"),
    @NamedQuery(name = "DoctorMaster.findByAddress", query = "SELECT d FROM DoctorMaster d WHERE d.address = :address"),
    @NamedQuery(name = "DoctorMaster.findByPinCode", query = "SELECT d FROM DoctorMaster d WHERE d.pinCode = :pinCode"),
    @NamedQuery(name = "DoctorMaster.findByEmail", query = "SELECT d FROM DoctorMaster d WHERE d.email = :email"),
    @NamedQuery(name = "DoctorMaster.findByMobile", query = "SELECT d FROM DoctorMaster d WHERE d.mobile = :mobile"),
    @NamedQuery(name = "DoctorMaster.findByTelephone", query = "SELECT d FROM DoctorMaster d WHERE d.telephone = :telephone"),
    @NamedQuery(name = "DoctorMaster.findByBirthDate", query = "SELECT d FROM DoctorMaster d WHERE d.birthDate = :birthDate"),
    @NamedQuery(name = "DoctorMaster.findByJoiningDate", query = "SELECT d FROM DoctorMaster d WHERE d.joiningDate = :joiningDate"),
    @NamedQuery(name = "DoctorMaster.findByQualification", query = "SELECT d FROM DoctorMaster d WHERE d.qualification = :qualification"),
    @NamedQuery(name = "DoctorMaster.findByTimings", query = "SELECT d FROM DoctorMaster d WHERE d.timings = :timings")})
public class DoctorMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DoctorId")
    private Integer doctorId;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "Gender")
    private String gender;
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
    @Column(name = "JoiningDate")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;
    @Size(max = 255)
    @Column(name = "Qualification")
    private String qualification;
    @Size(max = 255)
    @Column(name = "Timings")
    private String timings;
    @OneToMany(mappedBy = "doctorId")
    private Collection<Appointment> appointmentCollection;
    @OneToMany(mappedBy = "doctorId")
    private Collection<PatientMaster> patientMasterCollection;
    @JoinColumn(name = "DistrictId", referencedColumnName = "DistrictId")
    @ManyToOne
    private DistrictMaster districtId;
    @JoinColumn(name = "SpecializationId", referencedColumnName = "SpecializationId")
    @ManyToOne
    private Specializations specializationId;
    @JoinColumn(name = "StateId", referencedColumnName = "StateId")
    @ManyToOne
    private StateMaster stateId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "doctorMaster")
    private DoctorSchedules doctorSchedules;

    public DoctorMaster() {
    }

    public DoctorSchedules getDoctorSchedules() {
        return doctorSchedules;
    }

    public void setDoctorSchedules(DoctorSchedules doctorSchedules) {
        this.doctorSchedules = doctorSchedules;
    }


    public DoctorMaster(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
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

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @XmlTransient
    public Collection<PatientMaster> getPatientMasterCollection() {
        return patientMasterCollection;
    }

    public void setPatientMasterCollection(Collection<PatientMaster> patientMasterCollection) {
        this.patientMasterCollection = patientMasterCollection;
    }

    public DistrictMaster getDistrictId() {
        return districtId;
    }

    public void setDistrictId(DistrictMaster districtId) {
        this.districtId = districtId;
    }

    public Specializations getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Specializations specializationId) {
        this.specializationId = specializationId;
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
        hash += (doctorId != null ? doctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctorMaster)) {
            return false;
        }
        DoctorMaster other = (DoctorMaster) object;
        if ((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
