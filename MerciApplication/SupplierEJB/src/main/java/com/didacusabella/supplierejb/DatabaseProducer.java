package com.didacusabella.supplierejb;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {
    
    @Produces
    @PersistenceContext(unitName = "com.didacusAbella_SupplierEJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

}
