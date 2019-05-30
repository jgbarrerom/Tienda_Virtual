package co.com.entidades.entidades1;

import co.com.entidades.Comprador;
import co.com.entidades.Orden;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-28T22:55:12")
@StaticMetamodel(Comprador.class)
public class Comprador_ extends Persona_ {

    public static volatile SingularAttribute<Comprador, Integer> cantidadCompras;
    public static volatile ListAttribute<Comprador, Orden> ordenes;

}