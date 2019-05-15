/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.logica;

import co.com.entidades.Comprador;
import co.com.entidades.InformacionEnvio;
import co.com.entidades.InformacionFactura;
import co.com.entidades.Orden;
import co.com.entidades.Producto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author jeisson
 */
@Stateful
public class AdministracionOrden implements AdministracionOrdenLocal {

    private List<Producto> productos;
    private Comprador comprador;
    private InformacionFactura infoFactura;
    private InformacionEnvio infoEnvio;
    
    @EJB
    AdministracionPersistenciaLocal administracionPersistencia;
    
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

    @Override
    @Remove
    public Integer crearOrdenCompra() {
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
    public void cancelarOrdenCompra() {
    }

    @Override
    public void adicionarProducto(Producto prod) {
        productos.add(prod);
    }

    @Override
    public Comprador getComprador() {
        return null;
    }

    @Override
    public List consultaCarroCompras() {
        return null;
    }
    
}
