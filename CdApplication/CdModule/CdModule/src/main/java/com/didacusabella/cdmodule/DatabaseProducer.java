package com.didacusabella.cdmodule;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diego
 */
public class DatabaseProducer {
  
   @Produces
   @PersistenceContext(unitName = "com.didacusAbella_CdModule_ejb_1.0-SNAPSHOTPU")
   private EntityManager em;
  
}
