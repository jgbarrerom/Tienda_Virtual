/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.auditoria;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author jeisson
 */
public class TiendaVirtualInterceptor {
    
    @AroundInvoke
    public Object interceptor(InvocationContext ic) throws Exception{
        System.out.println("Se va a ejecutar el metodo " + ic.getMethod().getName());
        return ic.proceed();
    }
}
