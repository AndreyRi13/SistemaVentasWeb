/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Carrito;
import Persistencia.CarritoJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey R
 */
public class CarritoDAO {
    CarritoJpaController comprador;

    public CarritoDAO() {

        Conexion con = Conexion.getConexion();
        this.comprador = new CarritoJpaController(con.getBd());

    }

    public List<Carrito> readCarritos() {
        return this.comprador.findCarritoEntities();
    }

    public Carrito findCarrito(int idCarrito) {
        return this.comprador.findCarrito(idCarrito);
    }

    public void addCarrito(Carrito emp) throws Exception {
   
            this.comprador.create(emp);
  
    }
    
    public boolean deleteCarrito(Integer idEm){
    
        try {
            comprador.destroy(idEm);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CarritoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    
    
    public boolean updateCarrito(Carrito e){
        try {
            comprador.edit(e);
            return true;
        } catch (Exception ex) {        
            Logger.getLogger(CarritoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

