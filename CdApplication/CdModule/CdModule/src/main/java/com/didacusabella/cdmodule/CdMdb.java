/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.didacusabella.cdmodule;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author diego
 */
@JMSDestinationDefinition(name = "java:app/jms/javaee7/Topic", interfaceName = "javax.jms.Topic", resourceAdapter = "jmsra", destinationName = "Topic")
@MessageDriven(activationConfig = {
  @ActivationConfigProperty(propertyName = "clientId", propertyValue = "java:app/jms/javaee7/Topic")
  ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/jms/javaee7/Topic")
  ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
  ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "java:app/jms/javaee7/Topic")
  ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class CdMdb implements MessageListener {

  @EJB
  private CdEjbRemote remote;

  public CdMdb() {
    super();
  }

  @Override
  public void onMessage(Message message) {
    try {
      String mex = message.getBody(String.class);
      String[] arg = mex.split("-");
      remote.updatePrice(arg[0], Double.parseDouble(arg[1]));
      System.out.println("CD Aggiornato!");
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

}
