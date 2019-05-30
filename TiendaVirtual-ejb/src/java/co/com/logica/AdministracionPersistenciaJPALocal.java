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
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeisson
 */
@Local
public interface AdministracionPersistenciaJPALocal {

    /**
     *
     * @param idProducto
     * @return
     */
    public Producto consultarProducto(int idProducto);

    /**
     *
     * @param orden
     * @return
     */
    public Integer crearOrden(Orden orden) throws CrearOrdenException;

    /**
     *
     * @param ie
     * @return
     */
    public Integer crearInformacionEnvio(InformacionEnvio ie);

    /**
     *
     * @param infFac
     * @return
     */
    public Integer crearInformacionFactura(InformacionFactura infFac);

    /**
     *
     * @param productos
     * @param orden
     */
    public void modificarProductos(List<Producto> productos, Orden orden) throws ModificarProductoException;

    /**
     * 
     * @param login
     * @return 
     */
    public Comprador consultaComprador(String login);

    /**
     * 
     * @return 
     */
    public List<Producto> consultaProductos();

    /**
     * 
     * @param bitacora
     * @return 
     */
    public Integer crearBitacora(Bitacora bitacora);

    /**
     * 
     * @return 
     */
    public List<Comprador> consultaCompradores();

}
