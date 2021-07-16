/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.EmpleadoDAO;
import DAO.CalzadoDAO;
import DAO.CompradorDAO;
import DTO.Empleado;
import DTO.Calzado;
import DTO.Comprador;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class Login {

    public Login() {
    }

    public String tipoLogin(String user, String pass) {

     String tipo=null;
        Empleado emp = new Empleado();
        EmpleadoDAO empldao = new EmpleadoDAO();
        List<Empleado> empleadoList = empldao.readEmpleados();

        for (Empleado m : empleadoList) {
            if (m.getUsername().equals(user)) {
                if (m.getPassword().equals(pass)) {

                    tipo="Empleado";

                }
            }
        }

        Comprador com = new Comprador();
        CompradorDAO comdao = new CompradorDAO();
        List<Comprador> compradorList = comdao.readCompradores();

        for (Comprador c : compradorList) {
            if (c.getUsername().equals(user)) {
                if (c.getPassword().equals(pass)) {

                   tipo="Comprador";
                }

            }
        }

       return tipo;
    }

    public Empleado loginEmpleado(String user, String pass) {

        Empleado emp = new Empleado();
        EmpleadoDAO empldao = new EmpleadoDAO();

        List<Empleado> empleadoList = empldao.readEmpleados();

        for (Empleado m : empleadoList) {
            if (m.getUsername().equals(user)) {
                if (m.getPassword().equals(pass)) {

                    emp = m;

                }
            }
        }

        return emp;
    }

    public Comprador loginComprador(String user, String pass) {

        Comprador com = new Comprador();
        CompradorDAO comdao = new CompradorDAO();

        List<Comprador> empleadoList = comdao.readCompradores();

        for (Comprador m : empleadoList) {
            if (m.getUsername().equals(user)) {
                if (m.getPassword().equals(pass)) {

                    com = m;

                }
            }
        }

        return com;
    }

}
