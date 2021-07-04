/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Empleado;
import Persistencia.EmpleadoJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey R
 */
public class EmpleadoDAO {

    EmpleadoJpaController empleado;

    public EmpleadoDAO() {

        Conexion con = Conexion.getConexion();
        this.empleado = new EmpleadoJpaController(con.getBd());

    }

    public List<Empleado> readEmpleados() {
        return this.empleado.findEmpleadoEntities();
    }

    public Empleado findEmpleado(int idEmpleado) {
        return this.empleado.findEmpleado(idEmpleado);
    }

    public void addEmpleado(Empleado emp) {
        this.empleado.create(emp);
    }
    
    public boolean deleteEmpleado(Integer idEm){
    
        try {
            empleado.destroy(idEm);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    
    
    public boolean updateEmpleado(Empleado e){
        try {
            empleado.edit(e);
            return true;
        } catch (Exception ex) {        
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
