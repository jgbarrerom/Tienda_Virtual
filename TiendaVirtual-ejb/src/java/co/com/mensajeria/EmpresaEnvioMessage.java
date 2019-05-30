/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mensajeria;

import co.com.entidades.Orden;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author jeisson
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/CreacionOrdenTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/CreacionOrdenTopic")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/CreacionOrdenTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class EmpresaEnvioMessage implements MessageListener {
    
    public EmpresaEnvioMessage() {
    }
    
    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage)message;
        Orden orden;
        try {
            orden = (Orden)objectMessage.getObject();
            System.out.println("Empresa que envío: Se ha recibido la notificación para "
                    + "que los productos sean enviados a la dirección " + orden.getInformacionEnvio().getDireccion());
        } catch (JMSException ex) {
            Logger.getLogger(EmpresaEnvioMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
