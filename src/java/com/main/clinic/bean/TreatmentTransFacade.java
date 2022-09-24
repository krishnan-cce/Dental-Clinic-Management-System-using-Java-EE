/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.clinic.bean;

import com.main.clinic.entity.TreatmentTrans;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author krish
 */
@Stateless
public class TreatmentTransFacade extends AbstractFacade<TreatmentTrans> {

    @PersistenceContext(unitName = "ClincDSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TreatmentTransFacade() {
        super(TreatmentTrans.class);
    }
    
}
