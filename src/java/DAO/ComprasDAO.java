/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Compras;
import Persistencia.ComprasJpaController;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey R
 */
public class ComprasDAO {

    ComprasJpaController compras;

   
    public ComprasDAO() {
        Conexion con = Conexion.getConexion();
        this.compras = new ComprasJpaController(con.getBd());
    }

    /**
     * 
     * @return List
     */
    public List<Compras> readCompras() {
        return this.compras.findComprasEntities();
    }

    /**
     * 
     * @param idCompras
     * @return Compras
     */
    public Compras findCompras(int idCompras) {
        return this.compras.findCompras(idCompras);
    }

    /**
     * 
     * @param emp
     * @throws Exception 
     */
    public void addCompras(Compras emp) throws Exception {
        this.compras.create(emp);
    }

    /**
     * 
     * @param idEm
     * @return boolean
     * @throws IllegalOrphanException 
     */
    public boolean deleteCompras(Integer idEm) throws IllegalOrphanException {

        try {
            compras.destroy(idEm);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    /**
     * 
     * @param e
     * @return boolean
     */
    public boolean updateCompras(Compras e) {
        try {
            compras.edit(e);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
