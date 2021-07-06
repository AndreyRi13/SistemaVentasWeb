/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Producto;
import Persistencia.ProductoJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void addProducto(Producto p) throws Exception{
        this.pro.create(p);
    }
    public void updateProducto(Producto p) throws Exception{
        this.pro.edit(p);
    }
    
  
    public boolean deleteProducto(Integer idPro){
    
        try {
            pro.destroy(idPro);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

}

}