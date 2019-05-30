/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.notificaciones;

import co.com.entidades.Orden;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;

/**
 *
 * @author jeisson
 */
public class NotificacionInterceptor {
    
    @Inject
    @JMSConnectionFactory("jms/CreacionOrdenFactory")
    private JMSContext context;
    
    @Resource(name = "jms/CreacionOrdenTopic")
    private Destination destination;
    
    @AroundInvoke
    public Object notificarCreacionOrden(InvocationContext ic) throws Exception{
        Object[] objects = ic.getParameters();
        Orden ord = (Orden)objects[0];
        
        ObjectMessage message = context.createObjectMessage();
        message.setObject(ord);
        
        JMSProducer producer = context.createProducer();
        producer.send(destination, message);
        return ic.proceed();
    }
}
