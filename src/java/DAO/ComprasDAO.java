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

    public List<Compras> readCompras() {
        return this.compras.findComprasEntities();
    }

    public Compras findCompras(int idCompras) {
        return this.compras.findCompras(idCompras);
    }

    public void addCompras(Compras emp) throws Exception {
        this.compras.create(emp);
    }

    public boolean deleteCompras(Integer idEm) {

        try {
            compras.destroy(idEm);
            return true;
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

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
