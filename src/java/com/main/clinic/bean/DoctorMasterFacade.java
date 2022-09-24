/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.clinic.bean;

import com.main.clinic.entity.DistrictMaster;
import com.main.clinic.entity.StateMaster;
import com.main.clinic.entity.DoctorMaster;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author krish
 */
@Stateless
public class DoctorMasterFacade extends AbstractFacade<DoctorMaster> {

    @PersistenceContext(unitName = "ClincDSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DoctorMasterFacade() {
        super(DoctorMaster.class);
    }
    
 /*
    public List<Object[]> getByJpql(){
        
        String queryString = "select  s.name ,sp.specializations,dt.district,st.state from DoctorMaster s  join s.specializationId sp join s.stateId st join s.districtId dt";
        Query query = em.createQuery(queryString);
        List<Object[]> resultList = new ArrayList();
        resultList  = query.getResultList();

        //List<DoctorDetails> resultList = query.getResultList();
        return resultList;
    }*/
}
