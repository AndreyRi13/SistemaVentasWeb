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
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class Login {

    public Login() {
    }

    public Empleado login(String user, String pass) {

        Empleado emp = null;
        EmpleadoDAO empldao = new EmpleadoDAO();

        List<Empleado> empleadoList = empldao.readEmpleados();

        for (Empleado m : empleadoList) {
            if (m.getUser().equals(user)) {
                if (m.getDni().equals(pass)) {

                    emp = m;

                }
            }
        }
        return emp;
    }



}
