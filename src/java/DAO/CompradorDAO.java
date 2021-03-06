/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Comprador;
import Persistencia.CompradorJpaController;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey R
 */
public class CompradorDAO {
 CompradorJpaController comprador;

 
 
    public CompradorDAO() {
        Conexion con = Conexion.getConexion();
        this.comprador = new CompradorJpaController(con.getBd());

    }

    /**
     * 
     * @return List
     */
    public List<Comprador> readCompradores() {
        return this.comprador.findCompradorEntities();
    }

    /**
     * 
     * @param idComprador
     * @return Comprador
     */
    public Comprador findComprador(int idComprador) {
        return this.comprador.findComprador(idComprador);
    }

    /**
     * 
     * @param emp
     * @throws Exception 
     */
    public void addComprador(Comprador emp) throws Exception {
   
            this.comprador.create(emp);
  
    }
    
    /**
     * 
     * @param idEm
     * @return boolean
     * @throws IllegalOrphanException 
     */
    public boolean deleteComprador(Integer idEm) throws IllegalOrphanException{
    
        try {
            comprador.destroy(idEm);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CompradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    
    /**
     * 
     * @param e
     * @return boolean
     */
    public boolean updateComprador(Comprador e){
        try {
            comprador.edit(e);
            return true;
        } catch (Exception ex) {        
            Logger.getLogger(CompradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
