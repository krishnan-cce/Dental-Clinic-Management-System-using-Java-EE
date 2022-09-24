/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.clinic.reports;

import com.main.clinic.bean.MedicineMasterFacade;
import com.main.clinic.entity.MedicineMaster;
import com.main.clinic.entity.PatientMaster;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


/**
 *
 * @author krish
 */
@ManagedBean(name = "demoBean")
@SessionScoped
public class DemoBean implements Serializable   {
    private List<MedicineMaster> listOfUser;

    
    @EJB MedicineMasterFacade userFacade;
    
    @EJB
    ReportGenerator reportGeneration;
    
    private PatientMaster selectedPatient;
    private List<PatientMaster> patientList;
    
    private Date asOnDate;
    
    @PostConstruct
    public void init() {
		asOnDate = new Date();
	}
    
    public List<MedicineMaster> getListOfUser() {
        listOfUser=userFacade.findAll();
        return listOfUser;
    }
    /*
    public String dateToString(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String strDate = sdf.format(date);
        return strDate;
                //DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		//String asonDate = df.format(asOnDate);
    }
*/
    public void setListOfUser(List<MedicineMaster> listOfUser) {
        this.listOfUser = listOfUser;
    }
    JasperPrint jasperPrint;
                


    public void initAs() throws JRException, NamingException, FileNotFoundException, SQLException{
        
        InitialContext initialContext = new InitialContext();
        DataSource dataSource = (DataSource)initialContext.lookup("java:app/DS");
        Connection connection = dataSource.getConnection();
        
        DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String asonDate = sdf.format(asOnDate);  
        String title = "APPOINTMENTS"; 
        HashMap<String,Object> map = new HashMap<>();
        //Map<String, Object> map = new HashMap<>();
        map.put("AppointmentDate", asonDate);
        map.put("Title", title);        
        JasperReport jasperReport = JasperCompileManager.compileReport("C:\\ClinicSystem\\Reports\\AppointmentByDate.jrxml");
        jasperPrint = JasperFillManager.fillReport(jasperReport, map, connection);

    }
    public void initTreatments() throws JRException, NamingException, FileNotFoundException, SQLException{   
        InitialContext initialContext = new InitialContext();
        DataSource dataSource = (DataSource)initialContext.lookup("java:app/DS");
        Connection connection = dataSource.getConnection();        
        DateFormat sdfTT = new SimpleDateFormat("dd-MMM-yyyy");
        String asonDateTT = sdfTT.format(asOnDate);  
        String titleTT = "TREATMENT LIST"; 
        HashMap<String,Object> mapTT = new HashMap<>();
        //Map<String, Object> map = new HashMap<>();
        mapTT.put("TreatmentDate", asonDateTT);
        mapTT.put("PatientID", selectedPatient.getPatientId());
        mapTT.put("Title", titleTT);        
        JasperReport jasperReportTT = JasperCompileManager.compileReport("C:\\ClinicSystem\\Reports\\TreatmentTransEqlDate.jrxml");
        jasperPrint = JasperFillManager.fillReport(jasperReportTT, mapTT, connection);
        
    }
    public void initAsss() throws JRException, NamingException, FileNotFoundException, SQLException{  
        InitialContext initialContext = new InitialContext();
        DataSource dataSource = (DataSource)initialContext.lookup("java:app/DS");
        Connection connection = dataSource.getConnection();        
        DateFormat sdfTM = new SimpleDateFormat("dd-MMM-yyyy");
        String asonDateTM = sdfTM.format(asOnDate);  
        String titleTM = "MEDICINE REPORT"; 
        HashMap<String,Object> mapTM = new HashMap<>();
        //Map<String, Object> map = new HashMap<>();
        mapTM.put("ReportDate", asonDateTM);
        mapTM.put("PatientID", selectedPatient.getPatientId());
        mapTM.put("Title", titleTM);        
        JasperReport jasperReportTM = JasperCompileManager.compileReport("C:\\ClinicSystem\\Reports\\TreatmentReportPM.jrxml");
        jasperPrint = JasperFillManager.fillReport(jasperReportTM, mapTM, connection);
                
      
    }

   public void PDF(ActionEvent actionEvent) throws JRException, IOException, NamingException, FileNotFoundException, SQLException{
       initAs();

       HttpServletResponse httpServletResponse =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
       ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
       JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);        

       
   }
   public void PDF1(ActionEvent actionEvent) throws JRException, IOException, NamingException, FileNotFoundException, SQLException{
 
       initTreatments();
       HttpServletResponse httpServletResponse =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
       ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
       JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);        

       
   }
   public void PDF2(ActionEvent actionEvent) throws JRException, IOException, NamingException, FileNotFoundException, SQLException{
       initAsss();

       HttpServletResponse httpServletResponse =(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
       ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
       JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);        

       
   }
   //Getters & Setters -

    public Date getAsOnDate() {
        return asOnDate;
    }

    public void setAsOnDate(Date asOnDate) {
        this.asOnDate = asOnDate;
    }

    public PatientMaster getSelectedPatient() {
        return selectedPatient;
    }

    public void setSelectedPatient(PatientMaster selectedPatient) {
        this.selectedPatient = selectedPatient;
    }

    public List<PatientMaster> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<PatientMaster> patientList) {
        this.patientList = patientList;
    }
    
        
}