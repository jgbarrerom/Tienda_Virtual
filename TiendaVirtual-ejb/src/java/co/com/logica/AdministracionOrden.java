/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.logica;

import co.com.auditoria.CreacionOrdenInterceptor;
import co.com.entidades.Comprador;
import co.com.entidades.InformacionEnvio;
import co.com.entidades.InformacionFactura;
import co.com.entidades.Orden;
import co.com.entidades.Producto;
import co.com.excepciones.CrearOrdenException;
import co.com.excepciones.ModificarProductoException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;

/**
 *
 * @author jeisson
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)//para los que no se especifica el tipo de transaccionalidad coloca NOT_SUPPORTED
public class AdministracionOrden implements AdministracionOrdenLocal {

    private List<Producto> productos;
    private Comprador comprador;
    private InformacionFactura infoFactura;
    private InformacionEnvio infoEnvio;
    
    @EJB
    AdministracionPersistenciaLocal administracionPersistencia;
    
    @EJB
    AdministracionPersistenciaJPALocal administracionPersistenciaJPALocal;
    
    public AdministracionOrden() {
        productos = new ArrayList<>();
    }

    
    @Override
    public void adicionarComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    @Override
    public void adicionarInformacionFactura(InformacionFactura infoFact) {
        this.infoFactura = infoFact;
    }

    @Override
    public void adicionarInformacionEnvio(InformacionEnvio infoEnv) {
        this.infoEnvio = infoEnv;
    }

    @Deprecated
    public Integer crearOrdenCompra(String a) {
        infoEnvio.setId(administracionPersistencia.crearInformacionEnvio(infoEnvio));
        infoFactura.setId(administracionPersistencia.crearInformacionFactura(infoFactura));
        
        Orden ord = new Orden();
        ord.setComprador(comprador);
        ord.setFecha(Calendar.getInstance().getTime());
        ord.setInformacionEnvio(infoEnvio);
        ord.setInformacionFactura(infoFactura);
        
        ord.setId(administracionPersistencia.crearOrden(ord));
        administracionPersistencia.modificarProductos(productos, ord);
        return ord.getId();
    }
    
    @Override
    @Remove
    @Interceptors(CreacionOrdenInterceptor.class)
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Integer crearOrdenCompra() throws CrearOrdenException, ModificarProductoException{
        administracionPersistenciaJPALocal.crearInformacionEnvio(infoEnvio);
        administracionPersistenciaJPALocal.crearInformacionFactura(infoFactura);
        Orden ord = new Orden();
        ord.setComprador(comprador);
        ord.setFecha(Calendar.getInstance().getTime());
        ord.setInformacionEnvio(infoEnvio);
        ord.setInformacionFactura(infoFactura);
        ord.setProductos(productos);
        administracionPersistenciaJPALocal.crearOrden(ord);
        administracionPersistenciaJPALocal.modificarProductos(productos, ord);
        return ord.getId();
        
    }

    @Override
    @Remove
    public void cancelarOrdenCompra() {
    }

    @Override
    public void adicionarProducto(Producto prod) {
        productos.add(prod);
    }

    @Override
    public Comprador getComprador() {
        return comprador;
    }

    @Override
    public List consultaCarroCompras() {
        return productos;
    }
}
