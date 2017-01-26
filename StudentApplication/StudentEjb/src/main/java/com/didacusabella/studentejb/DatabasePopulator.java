package com.didacusabella.studentejb;

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
name = "java:global/StudentExercise",
className = "org.apache.derby.jdbc.ClientDriver",
user = "app",
password = "app"
)
public class DatabasePopulator {

    @EJB
    private StudentEjb remote;
    private Student s1, s2;
    
    @PostConstruct
    private void populateDB(){
        s1 = new Student("123", "Diego", "Avella", 12);
        s2 = new Student("321", "Marco", "Ferraioli", 10);
        remote.createStudent(s1);
        remote.createStudent(s2);
    }
    
    @PreDestroy
    private void destroyDB(){
       remote.removeStudent(s1);
       remote.removeStudent(s2);
    }
}
