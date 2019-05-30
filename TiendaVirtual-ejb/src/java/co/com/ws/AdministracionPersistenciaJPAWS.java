/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ws;

import co.com.entidades.Bitacora;
import co.com.entidades.Comprador;
import co.com.entidades.InformacionEnvio;
import co.com.entidades.InformacionFactura;
import co.com.entidades.Orden;
import co.com.entidades.Producto;
import co.com.excepciones.CrearOrdenException;
import co.com.excepciones.ModificarProductoException;
import co.com.logica.AdministracionPersistenciaJPALocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author jeisson
 */
@WebService(serviceName = "AdministracionPersistenciaJPAWS")
@Stateless
public class AdministracionPersistenciaJPAWS {

    @EJB
    private AdministracionPersistenciaJPALocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "consultarProducto")
    public Producto consultarProducto(@WebParam(name = "idProducto") int idProducto) {
        return ejbRef.consultarProducto(idProducto);
    }

    @WebMethod(operationName = "crearOrden")
    public Integer crearOrden(@WebParam(name = "orden") Orden orden) throws CrearOrdenException {
        return ejbRef.crearOrden(orden);
    }

    @WebMethod(operationName = "crearInformacionEnvio")
    public Integer crearInformacionEnvio(@WebParam(name = "ie") InformacionEnvio ie) {
        return ejbRef.crearInformacionEnvio(ie);
    }

    @WebMethod(operationName = "crearInformacionFactura")
    public Integer crearInformacionFactura(@WebParam(name = "infFac") InformacionFactura infFac) {
        return ejbRef.crearInformacionFactura(infFac);
    }

    @WebMethod(operationName = "modificarProductos")
    public void modificarProductos(@WebParam(name = "productos") List<Producto> productos, @WebParam(name = "orden") Orden orden) throws ModificarProductoException {
        ejbRef.modificarProductos(productos, orden);
    }

    @WebMethod(operationName = "consultaComprador")
    public Comprador consultaComprador(@WebParam(name = "login") String login) {
        return ejbRef.consultaComprador(login);
    }

    @WebMethod(operationName = "consultaProductos")
    public List<Producto> consultaProductos() {
        return ejbRef.consultaProductos();
    }

    @WebMethod(operationName = "crearBitacora")
    public Integer crearBitacora(@WebParam(name = "bitacora") Bitacora bitacora) {
        return ejbRef.crearBitacora(bitacora);
    }

    @WebMethod(operationName = "consultaCompradores")
    public List<Comprador> consultaCompradores() {
        return ejbRef.consultaCompradores();
    }
    
}
