package co.com.entidades.entidades1;

import co.com.entidades.Persona;
import co.com.entidades.TipoIdentificacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-28T22:55:12")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, TipoIdentificacion> tipoId;
    public static volatile SingularAttribute<Persona, String> apellido2;
    public static volatile SingularAttribute<Persona, String> password;
    public static volatile SingularAttribute<Persona, String> numeroIdentificacion;
    public static volatile SingularAttribute<Persona, Date> fechaNacimiento;
    public static volatile SingularAttribute<Persona, String> apellido1;
    public static volatile SingularAttribute<Persona, String> login;
    public static volatile SingularAttribute<Persona, String> nombre2;
    public static volatile SingularAttribute<Persona, String> nombre1;

}