/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.logica;

import co.com.entidades.InformacionEnvio;
import co.com.entidades.InformacionFactura;
import co.com.entidades.Orden;
import co.com.entidades.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jeisson
 */
@Local
public interface AdministracionPersistenciaLocal {

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
    public Integer crearOrden(Orden orden);

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
    public void modificarProductos(List<Producto> productos, Orden orden);

}
