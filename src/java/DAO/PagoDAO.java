/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Pago;
import Persistencia.PagoJpaController;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey R
 */
public class PagoDAO {
PagoJpaController pago;

    public PagoDAO() {

        Conexion con = Conexion.getConexion();
        pago = new PagoJpaController(con.getBd());

    }

    public List<Pago> readPagos() {
        return this.pago.findPagoEntities();
    }

    public Pago findPago(int idPago) {
        return this.pago.findPago(idPago);
    }

    public void addPago(Pago emp) throws Exception {
   
            this.pago.create(emp);
  
    }
    
    public boolean deletePago(Integer idEm){
    
      
    try {
        pago.destroy(idEm);
        return true;
    } catch (IllegalOrphanException ex) {
        Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    } catch (NonexistentEntityException ex) {
        Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
         
     
    
    }
    
    
    public boolean updatePago(Pago e){
        try {
            pago.edit(e);
            return true;
        } catch (Exception ex) {        
            Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
