/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Comprador;
import Persistencia.CompradorJpaController;
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

    public List<Comprador> readCompradores() {
        return this.comprador.findCompradorEntities();
    }

    public Comprador findComprador(int idComprador) {
        return this.comprador.findComprador(idComprador);
    }

    public void addComprador(Comprador emp) throws Exception {
   
            this.comprador.create(emp);
  
    }
    
    public boolean deleteComprador(Integer idEm){
    
        try {
            comprador.destroy(idEm);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CompradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    
    
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
