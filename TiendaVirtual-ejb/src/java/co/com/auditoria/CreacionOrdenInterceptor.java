/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.auditoria;

import co.com.entidades.Bitacora;
import co.com.logica.AdministracionOrdenLocal;
import co.com.logica.AdministracionPersistenciaJPALocal;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author jeisson
 */
public class CreacionOrdenInterceptor {
    
    @EJB
    AdministracionPersistenciaJPALocal administracionPersistencia;
    
    @AroundInvoke
    public Object creacionOrden(InvocationContext ic) throws Exception{
        Object obj = ic.getTarget();
        AdministracionOrdenLocal administracionOrden = (AdministracionOrdenLocal)obj;
        
        Bitacora bita= new Bitacora();
        bita.setPersona(administracionOrden.getComprador());
        bita.setFecha(Calendar.getInstance().getTime());
        bita.setDescripcion("Creación de nueva orden");
        
        administracionPersistencia.crearBitacora(bita);
        return ic.proceed();
    }
}
