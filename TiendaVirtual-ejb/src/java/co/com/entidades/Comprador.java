/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author jeisson
 */
@Entity
@DiscriminatorValue(value = "C")
public class Comprador extends Persona {
    /**
     * cuando hay una relacion bidireccional tiene que haber un dueño que se define en el mappedBy
     * el dueño de la realcion el de lado muchos
     * 
     * no molesta por el @Id ya que lo hereda del padre
     */
    @OneToMany(mappedBy = "comprador")
    private List<Orden> ordenes;
    @Column(name = "CANTIDAD_COMPRAS")
    private int cantidadCompras;

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public int getCantidadCompras() {
        return cantidadCompras;
    }

    public void setCantidadCompras(int cantidadCompras) {
        this.cantidadCompras = cantidadCompras;
    }

}
