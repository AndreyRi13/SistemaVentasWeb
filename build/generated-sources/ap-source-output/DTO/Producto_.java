package DTO;

import DTO.DetalleVentas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-02T16:33:01")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Double> precio;
    public static volatile SingularAttribute<Producto, String> estado;
    public static volatile CollectionAttribute<Producto, DetalleVentas> detalleVentasCollection;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, Integer> stock;
    public static volatile SingularAttribute<Producto, String> nombres;

}