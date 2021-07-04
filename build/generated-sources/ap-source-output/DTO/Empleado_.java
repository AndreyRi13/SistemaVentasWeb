package DTO;

import DTO.Ventas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-02T16:33:01")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> estado;
    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile CollectionAttribute<Empleado, Ventas> ventasCollection;
    public static volatile SingularAttribute<Empleado, String> telefono;
    public static volatile SingularAttribute<Empleado, String> user;
    public static volatile SingularAttribute<Empleado, String> dni;
    public static volatile SingularAttribute<Empleado, String> nombres;

}