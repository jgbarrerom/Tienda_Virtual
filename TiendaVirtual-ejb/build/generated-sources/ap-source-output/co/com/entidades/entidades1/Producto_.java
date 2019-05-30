package co.com.entidades.entidades1;

import co.com.entidades.Categoria;
import co.com.entidades.Orden;
import co.com.entidades.Producto;
import co.com.entidades.Vendedor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-28T22:55:12")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Long> precio;
    public static volatile SingularAttribute<Producto, Vendedor> vendedor;
    public static volatile ListAttribute<Producto, Categoria> categorias;
    public static volatile SingularAttribute<Producto, Date> fechaCreacion;
    public static volatile SingularAttribute<Producto, Integer> id;
    public static volatile SingularAttribute<Producto, Orden> orden;
    public static volatile SingularAttribute<Producto, String> nombre;

}