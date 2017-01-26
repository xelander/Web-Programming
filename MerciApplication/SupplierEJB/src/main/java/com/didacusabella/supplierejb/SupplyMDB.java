package com.didacusabella.supplierejb;

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
  @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
  ,
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/javaee7/Topic")
  ,
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class SupplyMDB implements MessageListener {

  @EJB
  SupplyEJBRemote remote;

  public SupplyMDB() {
  }

  @Override
  public void onMessage(Message message) {

    try {
      String value = message.getBody(String.class);
      int id = Integer.parseInt(value);
      System.out.println("Supply Updated" + remote.order(id).toString());
    } catch (JMSException ex) {
      System.err.println("Errore nei messaggi");
    }
  }

}
