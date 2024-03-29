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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jeisson
 */
@Entity
@DiscriminatorValue(value = "C")
@NamedQueries({
    @NamedQuery(name = "findAllComprador" , query = "SELECT c FROM Comprador c")
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Comprador extends Persona {
    /**
     * cuando hay una relacion bidireccional tiene que haber un dueño que se define en el mappedBy
     * el dueño de la realcion el de lado muchos
     * 
     * no molesta por el @Id ya que lo hereda del padre
     */
    @OneToMany(mappedBy = "comprador")
    @XmlTransient
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
