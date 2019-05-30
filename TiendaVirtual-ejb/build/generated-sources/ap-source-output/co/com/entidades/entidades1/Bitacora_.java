package co.com.entidades.entidades1;

import co.com.entidades.Bitacora;
import co.com.entidades.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-28T22:55:12")
@StaticMetamodel(Bitacora.class)
public class Bitacora_ { 

    public static volatile SingularAttribute<Bitacora, String> descripcion;
    public static volatile SingularAttribute<Bitacora, Date> fecha;
    public static volatile SingularAttribute<Bitacora, Persona> persona;
    public static volatile SingularAttribute<Bitacora, Integer> id;

}