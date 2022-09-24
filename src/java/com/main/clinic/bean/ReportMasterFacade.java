/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.clinic.bean;

import com.main.clinic.entity.ReportMaster;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author krish
 */
@Stateless
public class ReportMasterFacade extends AbstractFacade<ReportMaster> {

    @PersistenceContext(unitName = "ClincDSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReportMasterFacade() {
        super(ReportMaster.class);
    }
    
}
