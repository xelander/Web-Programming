package com.didacusabella.supplierejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author diego
 */
@Singleton
@LocalBean
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.ClientDriver",
        name = "java:global/MerciExercise",
        user = "app",
        password = "app"
)
public class DatabasePopulator {

  @EJB
  private SupplyEJB remote;
  private Supply s1, s2;

  @PostConstruct
  private void populateDB() {
    s1 = new Supply("Diego", "Avella", "Anti-Borghesia Spa", "089", 30);
    s2 = new Supply("Dario", "Tecchia", "Sugar Spa", "088", 20);
    remote.createSupply(s1);
    remote.createSupply(s2);
  }

  @PreDestroy
  private void deleteDB() {
    remote.removeSupply(s1);
    remote.removeSupply(s2);
  }

}
