/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.EmpleadoDAO;
import DAO.CalzadoDAO;
import DTO.Empleado;
import DTO.Calzado;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class AdministrarEmpleado {

    public AdministrarEmpleado() {
    }

  
    /**
     * Metodo para agregar empleado
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param username
     * @param password
     * @param direccion
     * @param numeroCelular
     * @param correoElectronico
     * @param estado
     * @return boolean
     */
    public boolean agregarEmpleado(String cedula, String nombres, String apellidos, String username, String password, String direccion, String numeroCelular, String correoElectronico, String estado) {
        EmpleadoDAO empleado = new EmpleadoDAO();
        Empleado emp = new Empleado(cedula, nombres, apellidos, username, password, direccion, numeroCelular, correoElectronico, estado);

        try {
            empleado.addEmpleado(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para empleado por id
     * @param idEmpleado
     * @return Empleado
     * @throws Exception 
     */
    public Empleado buscarEmpleadoporId(Integer idEmpleado) throws Exception {
        EmpleadoDAO emp = new EmpleadoDAO();
        List<Empleado> empleadosList = emp.readEmpleados();
        Empleado aux = null;
        for (Empleado m : empleadosList) {
            if (m.getIdEmpleado().equals(idEmpleado)) {
                aux = m;
            }
        }
        return aux;
    }

    /**
     * Metodo para editar empleado
     * @param id
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param username
     * @param password
     * @param direccion
     * @param numeroCelular
     * @param correoElectronico
     * @param estado
     * @throws Exception 
     */
    public void editarEmpleado(Integer id, String cedula, String nombres, String apellidos, String username, String password, String direccion, String numeroCelular, String correoElectronico, String estado) throws Exception {
        Empleado em = new Empleado();
        em.setIdEmpleado(id);
        em.setCedula(cedula);
        em.setNombres(nombres);
        em.setApellidos(apellidos);
        em.setUsername(username);
        em.setPassword(password);
        em.setDireccion(direccion);
        em.setNumeroCelular(numeroCelular);
        em.setCorreoElectronico(correoElectronico);
        em.setEstado(estado);
        EmpleadoDAO empdao = new EmpleadoDAO();
        empdao.updateEmpleado(em);
    }

    /**
     * Metodo para eliminar empleado por id
     * @param id
     * @throws Exception 
     */
    public void eliminarEmpleado(Integer id) throws Exception {
        EmpleadoDAO empdao = new EmpleadoDAO();
        empdao.deleteEmpleado(id);
    }

    /**
     * Metodo para listar empleados
     * @return List
     */
    public List<Empleado> listaEmpleados() {
        EmpleadoDAO emp = new EmpleadoDAO();
        List<Empleado> empleados = emp.readEmpleados();
        return empleados;
    }

}
