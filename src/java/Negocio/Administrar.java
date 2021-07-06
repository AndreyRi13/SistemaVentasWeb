/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.EmpleadoDAO;
import DAO.ProductoDAO;
import DTO.Empleado;
import DTO.Producto;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class Administrar {

    public Administrar() {
    }

    /*CRUD EMPLEADO*/
    public boolean agregarEmpleado(String dni, String nombres, String telefono, String estado, String usuario) {
        EmpleadoDAO empleado = new EmpleadoDAO();
        Empleado emp = new Empleado();
        emp.setDni(dni);
        emp.setNombres(nombres);
        emp.setTelefono(telefono);
        emp.setEstado(estado);
        emp.setUser(usuario);
        try {
            empleado.addEmpleado(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

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
    
//    public int buscaridporDatos(String dni1, String nombres1, String telefono1, String estado1, String usuario1) throws Exception {
//        EmpleadoDAO emp = new EmpleadoDAO();
//        List<Empleado> empleadosList = emp.readEmpleados();
//        int aux = 0;
//        for (Empleado m : empleadosList) {
//            if (m.getDni().equals(dni1)) {
//
//                if (m.getNombres().equals(nombres1)) {
//
//                    if (m.getTelefono().equals(telefono1)) {
//                        if (m.getEstado().equals(estado1)) {
//                            if (m.getUser().equals(usuario1)) {
//                                aux = m.getIdEmpleado();
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return aux;
//    }

    public void editarEmpleado(Integer id, String dni1, String nombres1, String telefono1, String estado1, String usuario1) throws Exception {
        Empleado em = new Empleado();
        em.setIdEmpleado(id);
        em.setDni(dni1);
        em.setNombres(nombres1);
        em.setTelefono(telefono1);
        em.setEstado(estado1);
        em.setUser(usuario1);
        EmpleadoDAO empdao = new EmpleadoDAO();
        empdao.updateEmpleado(em);
    }

    public void eliminarEmpleado(Integer id) throws Exception {
      EmpleadoDAO empdao = new EmpleadoDAO();
        empdao.deleteEmpleado(id);
    }
    
    
    public List<Empleado> listaEmpleados() {
        EmpleadoDAO emp = new EmpleadoDAO();
        List<Empleado> empleados = emp.readEmpleados();
        return empleados;
    }
    
    
        /*CRUD PRODUCTO*/
    public boolean agregarProducto(Integer referencia, String nombres, String descripcion, String marca, String color,double precio,Integer stock,String estado,String Foto) {

        ProductoDAO producto = new ProductoDAO();

        Producto pro = new Producto();

        pro.setReferencia(referencia);
        pro.setNombres(nombres);
        pro.setDescripción(descripcion);
        pro.setMarca(marca);
        pro.setColor(color);
        pro.setPrecio(precio);
        pro.setStock(stock);
        pro.setEstado(estado);
        pro.setFoto(Foto);
      
        try {
            producto.addProducto(pro);
            return true;
        } catch (Exception e) {
            return false;

        }

    }
    
    
        public List<Producto> listaProductos() {
        ProductoDAO pro = new ProductoDAO();
        List<Producto> productos = pro.readProductos();
        return productos;
    }

}
