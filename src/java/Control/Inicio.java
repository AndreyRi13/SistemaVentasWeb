/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CalzadoDAO;
import DAO.EmpresaDAO;
import DTO.Calzado;
import DTO.Carrito;
import DTO.Carrito.ItemCarrito;
import DTO.Comprador;
import DTO.Empresa;
import Negocio.AdministrarCalzado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrey R
 */
public class Inicio extends HttpServlet {

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("a");
        if (action == null) {
            muestraInicio(request, response);
        } else {

            switch (action) {

                case "Login":
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "verMas":
                    verMas(request, response);
                    break;

            }
        }
    }

    /**
     * Variable HttpSession para obtener session 
     */
    HttpSession session = null;

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void muestraInicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        session = request.getSession();
        session.setAttribute("usuario", "invitado");
        CalzadoDAO pr = new CalzadoDAO();
        List<Calzado> product = pr.readCalzados();
        EmpresaDAO empr = new EmpresaDAO();
        Empresa empresa = empr.findEmpresa(1);
        request.setAttribute("calzados", product);
        request.setAttribute("empresa", empresa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void verMas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("/SistemasVentasWeb/vistas/validar?a=Login");

    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
