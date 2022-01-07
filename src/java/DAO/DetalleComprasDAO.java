/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DetalleCompras;
import Persistencia.DetalleComprasJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey R
 */
public class DetalleComprasDAO{
 DetalleComprasJpaController detalleCompras;

    public DetalleComprasDAO() {

        Conexion con = Conexion.getConexion();
        this.detalleCompras = new DetalleComprasJpaController(con.getBd());

    }

    /**
     * 
     * @return List
     */
    public List<DetalleCompras> readDetalleCompras() {
        return this.detalleCompras.findDetalleComprasEntities();
    }

    /**
     * 
     * @param idDetalleCompras
     * @return DetalleCompras
     */
    public DetalleCompras findDetalleCompras(int idDetalleCompras) {
        return this.detalleCompras.findDetalleCompras(idDetalleCompras);
    }

    /**
     * 
     * @param emp
     * @throws Exception 
     */
    public void addDetalleCompras(DetalleCompras emp) throws Exception {
   
            this.detalleCompras.create(emp);
  
    }
    
    /**
     * 
     * @param idEm
     * @return boolean
     */
    public boolean deleteDetalleCompras(Integer idEm){
    
        try {
            detalleCompras.destroy(idEm);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(DetalleComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    
    /**
     * 
     * @param e
     * @return boolean
     */
    public boolean updateDetalleCompras(DetalleCompras e){
        try {
            detalleCompras.edit(e);
            return true;
        } catch (Exception ex) {        
            Logger.getLogger(DetalleComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

