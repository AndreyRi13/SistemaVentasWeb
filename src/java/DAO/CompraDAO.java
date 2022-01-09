/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Compra;
import Persistencia.CompraJpaController;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey
 */
public class CompraDAO {
    CompraJpaController Compra;

    public CompraDAO() {

        Conexion con = Conexion.getConexion();
        this.Compra = new CompraJpaController(con.getBd());

    }

    /**
     * 
     * @return List
     */
    public List<Compra> readCompra() {
        return this.Compra.findCompraEntities();
    }

    /**
     * 
     * @param idCompra
     * @return Compra
     */
    public Compra findCompra(int idCompra) {
        return this.Compra.findCompra(idCompra);
    }

    /**
     * 
     * @param emp
     * @throws Exception 
     */
    public void addCompra(Compra emp) throws Exception {  
            this.Compra.create(emp);  
    }
    
    /**
     * 
     * @param idEm
     * @return boolean
     */
    public boolean deleteCompra(Integer idEm){
    
     
     
        try {
            try {
                Compra.destroy(idEm);
                return true;
            } catch (IllegalOrphanException ex) {
                Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
            }
              
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
           
        
            
      
    
    }
    
    /**
     * 
     * @param e
     * @return boolean
     */
    public boolean updateCompra(Compra e){
    
         try {
             Compra.edit(e);
              return true;
         } catch (Exception ex) {
             Logger.getLogger(DatalleCompraDAO.class.getName()).log(Level.SEVERE, null, ex); 
             return false;
         }
           
     
    }
    
}