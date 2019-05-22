/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.auditoria;

import co.com.entidades.Producto;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

/**
 *
 * @author jeisson
 */
public class MonitoreoProducto {

    @PreUpdate
    public void preActualizarProducto(Producto prod) {
        System.out.println("El producto " + prod.getId()
                + " va a ser asignado a la orde de compra "
                + prod.getOrden().getId());
    }

    @PostUpdate
    public void postActualizarProducto(Producto prod) {
        System.out.println("El producto " + prod.getId()
                + "fue asignado a la orden de compra "
                + prod.getOrden().getId());

    }
}
