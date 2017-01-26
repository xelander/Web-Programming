package com.didacusabella.cdmodule;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.annotation.sql.DataSourceDefinitions;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author diego
 */
@Singleton
@LocalBean
@DataSourceDefinition
        (className = "org.apache.derby.jdbc.ClientDriver",
        name = "java:global/CdExercise",
        user = "app",
        password = "app",
        databaseName = "sample",
        properties = {"connectionAttributes=;create=true"}
        )
public class DatabasePopulator {

  @EJB
  private CdEjb populator;
  private Cd cd_1, cd_2;

  @PostConstruct
  private void populateDB() {
    cd_1 = new Cd("primo", "Pino Daniele", 13.5, "I so Pazz");
    cd_2 = new Cd("secondo", "Adriano Celentano", 10.6, "Quel Punto");
    populator.createCd(cd_1);
    populator.createCd(cd_2);
  }

  @PreDestroy
  private void cleanDB() {
    populator.deleteCd(cd_1);
    populator.deleteCd(cd_2);
  }

}
