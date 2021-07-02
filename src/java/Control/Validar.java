/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DTO.Empleado;
import DTO.Producto;
import Negocio.Login;
import Negocio.N_Inicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrey R
 */
public class Validar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("a");
     
        switch (action) {
            case "ingresar":
                ingresar(request, response);
                break;

            case "Salir":
                login(request, response);
                break;
                
           case "Login":
                login(request, response);
                break;

        }

    }

    public void ingresar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("txtuser");
        String pass = request.getParameter("txtpass");

        Login lg = new Login();

        Empleado empleado;

        empleado = lg.login(user, pass);

        if (empleado != null) {
            request.setAttribute("empleado", empleado);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./vistas/main.jsp");
            dispatcher.forward(request, response);

        } else {

            String mensaje = "Error - Usuario o contraseña Incorrecta";
            request.setAttribute("mensaje", mensaje);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./vistas/login.jsp");
            dispatcher.forward(request, response);
        }

    }


    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       RequestDispatcher dispatcher = request.getRequestDispatcher("./vistas/login.jsp");
            dispatcher.forward(request, response);
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
