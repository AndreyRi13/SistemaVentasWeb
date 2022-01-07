/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DetalleCompra;
import Persistencia.DetalleCompraJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey R
 */
public class DatalleCompraDAO {
    
     DetalleCompraJpaController DetalleCompra;

    public DatalleCompraDAO() {

        Conexion con = Conexion.getConexion();
        this.DetalleCompra = new DetalleCompraJpaController(con.getBd());

    }

    /**
     * 
     * @return List
     */
    public List<DetalleCompra> readDatalleCompra() {
        return this.DetalleCompra.findDetalleCompraEntities();
    }

    /**
     * 
     * @param idDetalleCompra
     * @return DetalleCompra
     */
    public DetalleCompra findDetalleCompra(int idDetalleCompra) {
        return this.DetalleCompra.findDetalleCompra(idDetalleCompra);
    }

    /**
     * 
     * @param emp
     * @throws Exception 
     */
    public void addDetalleCompra(DetalleCompra emp) throws Exception {
   
            this.DetalleCompra.create(emp);
  
    }
    
    /**
     * 
     * @param idEm
     * @return boolean
     */
    public boolean deleteDetalleCompra(Integer idEm){
    
     
         try {
             DetalleCompra.destroy(idEm);
             return true;
         } catch (NonexistentEntityException ex) {
             Logger.getLogger(DatalleCompraDAO.class.getName()).log(Level.SEVERE, null, ex);
                          return false;

         }
            
      
    
    }
    
    /**
     * 
     * @param e
     * @return boolean
     */
    public boolean updateDetalleCompra(DetalleCompra e){
    
         try {
             DetalleCompra.edit(e);
              return true;
         } catch (Exception ex) {
             Logger.getLogger(DatalleCompraDAO.class.getName()).log(Level.SEVERE, null, ex); 
             return false;
         }
           
     
    }
    
}
