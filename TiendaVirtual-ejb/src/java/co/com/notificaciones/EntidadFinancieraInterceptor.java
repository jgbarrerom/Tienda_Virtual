/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.notificaciones;

import co.com.entidades.InformacionFactura;
import co.com.entidades.Orden;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jeisson
 */
public class EntidadFinancieraInterceptor {

    @PersistenceContext(unitName = "TiendaVirtual-ejbPU2")
    private EntityManager em;

    @AroundInvoke
    public Object crearInformacionFactura(InvocationContext ic) throws Exception {
        Object[] obj = ic.getParameters();
        Orden ord = (Orden) obj[0];
        InformacionFactura informacionFactura = ord.getInformacionFactura();
        
        em.persist(informacionFactura);
        return ic.proceed();
    }

}
