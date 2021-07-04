package DTO;

import DTO.Cliente;
import DTO.DetalleVentas;
import DTO.Empleado;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-02T16:33:01")
@StaticMetamodel(Ventas.class)
public class Ventas_ { 

    public static volatile SingularAttribute<Ventas, String> numeroSerie;
    public static volatile SingularAttribute<Ventas, String> estado;
    public static volatile SingularAttribute<Ventas, Double> monto;
    public static volatile SingularAttribute<Ventas, Cliente> idCliente;
    public static volatile SingularAttribute<Ventas, Empleado> idEmpleado;
    public static volatile CollectionAttribute<Ventas, DetalleVentas> detalleVentasCollection;
    public static volatile SingularAttribute<Ventas, Integer> idVentas;
    public static volatile SingularAttribute<Ventas, Date> fechaVentas;

}