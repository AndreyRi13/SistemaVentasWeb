/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Producto;
import Persistencia.ProductoJpaController;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class ProductoDAO {
    
ProductoJpaController pro;
    
    public ProductoDAO() {
        
        Conexion con=Conexion.getConexion();
        this.pro=new ProductoJpaController(con.getBd());
        
    }
    
    
    public List<Producto> readProductos()
    {
        return this.pro.findProductoEntities();
    }
 
    public Producto findProducto(int idProducto)
    {
        return this.pro.findProducto(idProducto);
    }
    
    public void insert(Producto p) throws Exception{
        this.pro.create(p);
    }
    public void update(Producto p) throws Exception{
        this.pro.edit(p);
    }
    

}