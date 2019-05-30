/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.logica;

import co.com.entidades.Bitacora;
import co.com.entidades.Comprador;
import co.com.entidades.InformacionEnvio;
import co.com.entidades.InformacionFactura;
import co.com.entidades.Orden;
import co.com.entidades.Producto;
import co.com.excepciones.CrearOrdenException;
import co.com.excepciones.ModificarProductoException;
import co.com.notificaciones.EntidadFinancieraInterceptor;
import co.com.notificaciones.NotificacionInterceptor;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jeisson
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class AdministracionPersistenciaJPA implements AdministracionPersistenciaJPALocal {

    @PersistenceContext(unitName = "TiendaVirtual-ejbPU")
    private EntityManager em;

    @Resource
    private TimerService timerService;

    @Override
    public Producto consultarProducto(int idProducto) {
        return em.find(Producto.class, idProducto);
    }

    @Override
    @Interceptors({NotificacionInterceptor.class, EntidadFinancieraInterceptor.class})
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Integer crearOrden(Orden orden) throws CrearOrdenException {
        try {
            em.persist(orden);
            timerService.createTimer(15000, orden);
            return orden.getId();
        } catch (Exception e) {
            throw new CrearOrdenException(e);
        }
    }

    @Timeout
    private void timerCrearOrden(Timer timer) {
        Orden ord = (Orden) timer.getInfo();
        System.out.println("Se ha enviado la orden a la direccion "
                + ord.getInformacionEnvio().getDireccion());
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Integer crearInformacionEnvio(InformacionEnvio ie) {
        em.persist(ie);
        return ie.getId();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Integer crearInformacionFactura(InformacionFactura infFac) {
        em.persist(infFac);
        return infFac.getId();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modificarProductos(List<Producto> productos, Orden orden) throws ModificarProductoException {
        try {
            for (Producto pro : productos) {
                pro.setOrden(orden);
                em.merge(pro);
            }
            //throw new ModificarProductoException("Error de prueba");
        } catch (Exception e) {
            throw new ModificarProductoException(e);
        }
    }

    @Override
    public Comprador consultaComprador(String login) {
        return em.find(Comprador.class, login);
    }

    @Override
    public List<Producto> consultaProductos() {
        Query qr = em.createNamedQuery("findAllProductos");
        List<Producto> lista = qr.getResultList();
        return lista;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Integer crearBitacora(Bitacora bitacora) {
        em.merge(bitacora);
        return bitacora.getId();
    }

    @Override
    public List<Comprador> consultaCompradores() {
        Query qr = em.createNamedQuery("findAllComprador");
        return qr.getResultList();
    }

    @Schedule(second = "*/20", minute = "*", hour = "*")
    private void timerHora() {
        System.out.println("Hora TiendaVirtual: " + Calendar.getInstance().getTime());
    }

}
