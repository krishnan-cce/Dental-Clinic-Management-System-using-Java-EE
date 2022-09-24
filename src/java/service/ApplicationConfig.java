/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author krish
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.AppointmentFacadeREST.class);
        resources.add(service.DistrictMasterFacadeREST.class);
        resources.add(service.DoctorMasterFacadeREST.class);
        resources.add(service.DoctorSchedulesFacadeREST.class);
        resources.add(service.DosageMasterFacadeREST.class);
        resources.add(service.DurationMasterFacadeREST.class);
        resources.add(service.MedicineMasterFacadeREST.class);
        resources.add(service.PatientMasterFacadeREST.class);
        resources.add(service.ReportMasterFacadeREST.class);
        resources.add(service.ScheduleTimingFacadeREST.class);
        resources.add(service.SpecializationsFacadeREST.class);
        resources.add(service.StateMasterFacadeREST.class);
        resources.add(service.ToothMasterFacadeREST.class);
        resources.add(service.TreatmentMasterFacadeREST.class);
        resources.add(service.TreatmentTransFacadeREST.class);
    }
    
}
