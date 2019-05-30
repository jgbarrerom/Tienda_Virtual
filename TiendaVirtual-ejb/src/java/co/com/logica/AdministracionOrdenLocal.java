/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.logica;

import co.com.entidades.Comprador;
import co.com.entidades.InformacionEnvio;
import co.com.entidades.InformacionFactura;
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
public interface AdministracionOrdenLocal {

    public void adicionarComprador(Comprador comprador);

    public void adicionarInformacionFactura(InformacionFactura infoFact);

    public void adicionarInformacionEnvio(InformacionEnvio infoEnv);

    public Integer crearOrdenCompra() throws CrearOrdenException, ModificarProductoException;

    public void cancelarOrdenCompra();

    public void adicionarProducto(Producto prod);

    public Comprador getComprador();

    public List consultaCarroCompras();
}
