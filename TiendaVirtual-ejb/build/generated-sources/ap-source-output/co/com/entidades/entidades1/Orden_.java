package co.com.entidades.entidades1;

import co.com.entidades.Comprador;
import co.com.entidades.InformacionEnvio;
import co.com.entidades.InformacionFactura;
import co.com.entidades.Orden;
import co.com.entidades.Producto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-28T22:55:12")
@StaticMetamodel(Orden.class)
public class Orden_ { 

    public static volatile SingularAttribute<Orden, Date> fecha;
    public static volatile SingularAttribute<Orden, InformacionEnvio> informacionEnvio;
    public static volatile SingularAttribute<Orden, InformacionFactura> informacionFactura;
    public static volatile SingularAttribute<Orden, Comprador> comprador;
    public static volatile SingularAttribute<Orden, Integer> id;
    public static volatile ListAttribute<Orden, Producto> productos;

}