package co.com.entidades.entidades1;

import co.com.entidades.Producto;
import co.com.entidades.Vendedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-28T22:55:12")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ extends Persona_ {

    public static volatile SingularAttribute<Vendedor, Integer> clasificacion;
    public static volatile ListAttribute<Vendedor, Producto> productos;

}