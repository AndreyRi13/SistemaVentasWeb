/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.CompradorDAO;
import DTO.Comprador;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class AdministrarComprador {
    public AdministrarComprador() {
    }

    /*CRUD EMPLEADO*/
    public boolean agregarComprador(String cedula,String nombres,String apellidos,String username,String password,String direccion,String numeroCelular,String correoElectronico,String estado) {
        CompradorDAO empleado = new CompradorDAO();
        Comprador com = new Comprador(cedula,nombres,apellidos,username,password,direccion,numeroCelular,correoElectronico,estado);
        
        try {
            empleado.addComprador(com);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

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

//    public int buscaridporDatos(String dni1, String nombres1, String telefono1, String estado1, String usuario1) throws Exception {
//        CompradorDAO emp = new CompradorDAO();
//        List<Comprador> empleadosList = emp.readCompradors();
//        int aux = 0;
//        for (Comprador m : empleadosList) {
//            if (m.getDni().equals(dni1)) {
//
//                if (m.getNombres().equals(nombres1)) {
//
//                    if (m.getTelefono().equals(telefono1)) {
//                        if (m.getEstado().equals(estado1)) {
//                            if (m.getUser().equals(usuario1)) {
//                                aux = m.getIdComprador();
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return aux;
//    }
    public void editarComprador(Integer id, String cedula, String nombres, String apellidos, String username, String password, String direccion, String numeroCelular, String correoElectronico, String estado) throws Exception {
        Comprador em = new Comprador();
        em.setIdComprador(id);
        em.setCedula(cedula);
        em.setNombres(nombres);
        em.setApellidos(apellidos);
        em.setUsername(username);
        em.setPassword(password);
        em.setDireccion(direccion);
        em.setNumeroCelular(numeroCelular);
        em.setCorreoElectronico(correoElectronico);
        em.setEstado(estado);
        CompradorDAO empdao = new CompradorDAO();
        empdao.updateComprador(em);
    }

    public void eliminarComprador(Integer id) throws Exception {
        CompradorDAO comdao = new CompradorDAO();
        comdao.deleteComprador(id);
    }

    public List<Comprador> listaCompradores() {
        CompradorDAO emp = new CompradorDAO();
        List<Comprador> empleados = emp.readCompradores();
        return empleados;
    }

}
