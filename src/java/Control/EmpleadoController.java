/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.EmpleadoDAO;
import DTO.Empleado;
import DTO.Producto;
import Negocio.AdministrarEmpleado;
import Negocio.Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrey R
 */
public class EmpleadoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("menu");

        switch (action) {
            case "agregarEmpleado":
                request.getRequestDispatcher("agregarEmpleado.jsp").forward(request, response);
                break;

            case "listaEmpleado":
                listaEmpleado(request, response);
                break;

            case "addEmpleado":
                addEmpleado(request, response);
                break;

            case "editEmpleado":
                editEmpleado(request, response);
                break;

            case "editarEmpleado":
                editarEmpleado(request, response);
                break;

            case "eliminarEmpleado":
                eliminaEmpleado(request, response);
                break;

            default:
                throw new AssertionError();
        }
    }

    ///////////////////////////////////////Metodo para agregar empleado
    public void addEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("txtDni");
        String nombres = request.getParameter("txtNombres");
        String telefono = request.getParameter("txtTelefono");
        String estado = request.getParameter("txtEstado");
        String usuario = request.getParameter("txtUser");
        /*Instancia El negocio de administrar  */
        AdministrarEmpleado adm = new AdministrarEmpleado();
        if (adm.agregarEmpleado(dni, nombres, telefono, estado, usuario) == true) {

            listaEmpleado(request, response);

        } else {

            request.getRequestDispatcher("agregarEmpleado.jsp").forward(request, response);
        }

    }

///////////////////////////////////////METODO DE LISTAR EMPLEADOS
    public void listaEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarEmpleado adm = new AdministrarEmpleado();
        List<Empleado> emplead = adm.listaEmpleados();
        request.setAttribute("empleados", emplead);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaEmpleado.jsp");
        dispatcher.forward(request, response);
    }

///////////////////////////////////////METODO DE DIRECCIONAR PARA EDICION DE EMPLEADO
    Integer idEmple = 0;

    public void editEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        idEmple = Integer.parseInt(request.getParameter("id"));
        Empleado emplead = null;
        AdministrarEmpleado adm = new AdministrarEmpleado();
        try {
            emplead = adm.buscarEmpleadoporId(idEmple);
            request.setAttribute("empleado", emplead);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editarEmpleado.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
///////////////////////////////////////METODO DE EDITAR EMPLEADO

    public void editarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarEmpleado admi = new AdministrarEmpleado();
        String dni1 = request.getParameter("txtDni");
        String nombres1 = request.getParameter("txtNombres");
        String telefono1 = request.getParameter("txtTelefono");
        String estado1 = request.getParameter("txtEstado");
        String usuario1 = request.getParameter("txtUser");
        try {
            admi.editarEmpleado(idEmple, dni1, nombres1, telefono1, estado1, usuario1);
            listaEmpleado(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
///////////////////////////////////////METODO DE ELIMINAR EMPLEADO

    public void eliminaEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarEmpleado adm = new AdministrarEmpleado();
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            adm.eliminarEmpleado(id);
            listaEmpleado(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
