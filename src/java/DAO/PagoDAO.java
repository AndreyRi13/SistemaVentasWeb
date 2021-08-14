/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Pago;
import Persistencia.PagoJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey R
 */
public class PagoDAO {
PagoJpaController pr;

    public PagoDAO() {

        Conexion con = Conexion.getConexion();
        this.pr = new PagoJpaController(con.getBd());

    }

    public List<Pago> readPagos() {
        return this.pr.findPagoEntities();
    }

    public Pago findPago(int idPago) {
        return this.pr.findPago(idPago);
    }

    public void addPago(Pago emp) throws Exception {
   
            this.pr.create(emp);
  
    }
    
    public boolean deletePago(Integer idEm){
    
        try {
            pr.destroy(idEm);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    
    
    public boolean updatePago(Pago e){
        try {
            pr.edit(e);
            return true;
        } catch (Exception ex) {        
            Logger.getLogger(PagoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
