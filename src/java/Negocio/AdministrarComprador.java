/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.CompradorDAO;
import DTO.Comprador;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class AdministrarComprador {

    public AdministrarComprador() {
    }

   
    /**
     * Metodo para agregar comprador
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param fechaNacimiento
     * @param edad
     * @param genero
     * @param username
     * @param password
     * @param direccion
     * @param numeroCelular
     * @param correoElectronico
     * @param estado
     * @return boolean
     */
    public boolean agregarComprador(String cedula, String nombres, String apellidos, Date fechaNacimiento, int edad, String genero, String username, String password, String direccion, String numeroCelular, String correoElectronico,  String estado) {
        CompradorDAO empleado = new CompradorDAO();
        Comprador com = new Comprador(cedula, nombres, apellidos,fechaNacimiento ,edad,genero,username, password, direccion, numeroCelular, correoElectronico, estado);

        try {
            empleado.addComprador(com);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para buscar comprador por id
     * @param idComprador
     * @return Comprador
     * @throws Exception 
     */
    public Comprador buscarCompradorporId(Integer idComprador) throws Exception {
        CompradorDAO emp = new CompradorDAO();
        List<Comprador> empleadosList = emp.readCompradores();
        Comprador aux = null;
        for (Comprador m : empleadosList) {
            if (m.getIdComprador().equals(idComprador)) {
                aux = m;
            }
        }
        return aux;
    }

    /**
     * Metodo para editar comprador
     * @param id
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param fechaNacimiento
     * @param edad
     * @param genero
     * @param username
     * @param password
     * @param direccion
     * @param numeroCelular
     * @param correoElectronico
     * @param estado
     * @throws Exception 
     */
    public void editarComprador(Integer id, String cedula, String nombres, String apellidos, Date fechaNacimiento, int edad, String genero, String username, String password, String direccion, String numeroCelular, String correoElectronico,  String estado) throws Exception {
        Comprador em = new Comprador();
        em.setIdComprador(id);
        em.setCedula(cedula);
        em.setNombres(nombres);
        em.setApellidos(apellidos);
        em.setFechaNacimiento(fechaNacimiento);
        em.setEdad(edad);
        em.setUsername(username);
        em.setPassword(password);
        em.setDireccion(direccion);
        em.setNumeroCelular(numeroCelular);
        em.setCorreoElectronico(correoElectronico);
        em.setEstado(estado);
        CompradorDAO empdao = new CompradorDAO();
        empdao.updateComprador(em);
    }

    /**
     * Metodo para eliminar comprador por id
     * @param id
     * @throws Exception 
     */
    public void eliminarComprador(Integer id) throws Exception {
        CompradorDAO comdao = new CompradorDAO();
        comdao.deleteComprador(id);
    }

    /**
     * Metodo para listar los compradores
     * @return List
     */
    public List<Comprador> listaCompradores() {
        CompradorDAO emp = new CompradorDAO();
        List<Comprador> empleados = emp.readCompradores();
        return empleados;
    }

}
