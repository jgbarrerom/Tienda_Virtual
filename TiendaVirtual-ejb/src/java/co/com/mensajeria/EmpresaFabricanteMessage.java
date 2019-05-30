/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.mensajeria;

import co.com.entidades.Orden;
import co.com.entidades.Producto;
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
public class EmpresaFabricanteMessage implements MessageListener {

    public EmpresaFabricanteMessage() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            Orden orden = (Orden) objectMessage.getObject();
            StringBuffer sbf = new StringBuffer("Empresa fabricante: Se ha recibido ");
            sbf.append("la notificación de venta de los productos: ");
            for(Producto prod : orden.getProductos()){
                sbf.append(prod.getNombre());
                sbf.append(", ");
            }
            System.out.println(sbf.toString());
        } catch (JMSException ex) {
            Logger.getLogger(EmpresaFabricanteMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
