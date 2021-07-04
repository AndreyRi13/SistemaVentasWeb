package DTO;

import DTO.Ventas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-07-02T16:33:01")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> estado;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile CollectionAttribute<Cliente, Ventas> ventasCollection;
    public static volatile SingularAttribute<Cliente, String> dni;
    public static volatile SingularAttribute<Cliente, String> nombres;

}