package com.didacusabella.studentejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author diego
 */
@MessageDriven(mappedName = "jms/javaee7/Topic", activationConfig = {
    @ActivationConfigProperty(propertyName="acknowledgeMode",propertyValue="Auto-acknowledge")
})
public class StudentMDB implements MessageListener {
    
    @EJB
    private StudentEjbRemote remote;
    
    public StudentMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            Student arrived = message.getBody(Student.class);
            remote.updateNumberOfExams(arrived.getNumberOfExams(), arrived.getId());
            System.out.println("Student updated!");
        } catch (JMSException ex) {
            Logger.getLogger(StudentMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
