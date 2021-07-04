package DTO;

import DTO.DetalleVentasPK;
import DTO.Producto;
import DTO.Ventas;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-02T16:33:01")
@StaticMetamodel(DetalleVentas.class)
public class DetalleVentas_ { 

    public static volatile SingularAttribute<DetalleVentas, DetalleVentasPK> detalleVentasPK;
    public static volatile SingularAttribute<DetalleVentas, Ventas> ventas;
    public static volatile SingularAttribute<DetalleVentas, Integer> cantidad;
    public static volatile SingularAttribute<DetalleVentas, Producto> producto;
    public static volatile SingularAttribute<DetalleVentas, Double> precioVenta;

}