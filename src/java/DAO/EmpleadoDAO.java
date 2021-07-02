/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Empleado;
import Persistencia.EmpleadoJpaController;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class EmpleadoDAO {
    
 EmpleadoJpaController empleado;
    
    public EmpleadoDAO() {
        
        Conexion con=Conexion.getConexion();
        this.empleado=new EmpleadoJpaController(con.getBd());
        
    }
    
    
    public List<Empleado> readEmpleados()
    {
        return this.empleado.findEmpleadoEntities();
    }
 
    public Empleado findEmpleado(int idEmpleado)
    {
        return this.empleado.findEmpleado(idEmpleado);
    }
}
