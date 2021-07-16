/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Calzado;
import Persistencia.CalzadoJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey R
 */
public class CalzadoDAO {

    CalzadoJpaController pro;

    public CalzadoDAO() {

        Conexion con = Conexion.getConexion();
        this.pro = new CalzadoJpaController(con.getBd());

    }

    public List<Calzado> readCalzados() {
        return this.pro.findCalzadoEntities();
    }

    public Calzado findCalzado(int idCalzado) {
        return this.pro.findCalzado(idCalzado);
    }

    public void addCalzado(Calzado p) throws Exception {
        this.pro.create(p);
    }

    public void updateCalzado(Calzado p) throws Exception {
        this.pro.edit(p);
    }

    public boolean deleteCalzado(Integer idPro) {

        try {
            pro.destroy(idPro);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
