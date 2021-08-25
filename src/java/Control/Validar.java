/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.EmpresaDAO;
import DTO.Empleado;
import DTO.Calzado;
import DTO.Comprador;
import DTO.Empresa;
import Negocio.Login;
import Negocio.N_Inicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

            case "Login":
                login(request, response);
                break;

            case "dasboard":
                dashboard(request, response);
                break;
        }

    }

    public Validar() {
    }

    public void ingresar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("txtuser");
        String pass = request.getParameter("txtpass");

        Login lg = new Login();

        if (lg.tipoLogin(user, pass) != null) {

            if (lg.tipoLogin(user, pass).equals("Empleado")) {
                HttpSession session = request.getSession();
                Empleado empleado = lg.loginEmpleado(user, pass);
                session.setAttribute("usuario", empleado);
                dashboard(request, response);

            } else if (lg.tipoLogin(user, pass).equals("Comprador")) {
                HttpSession session = request.getSession();
                Comprador comprador = lg.loginComprador(user, pass);
                session.setAttribute("usuario", comprador);
                dashboardComprador(request, response);
            }

        } else {
            String mensaje = "Error - Usuario o contraseña Incorrecta";
            request.setAttribute("mensaje", mensaje);
            login(request, response);
        }
    }

    public void dashboard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
        dispatcher.forward(request, response);
    }

    public void dashboardComprador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/SistemasVentasWeb/inicio");
    }

    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmpresaDAO empr = new EmpresaDAO();
        Empresa empresa = empr.findEmpresa(1);
        request.setAttribute("empresa", empresa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
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

//    public class SeguimientoSesion extends HttpServlet {
//    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        //Retiramos el objeto Session antes de enviar ninguna salida al cliente
//        HttpSession sesion = req.getSession();
//        res.setContentType("text/html");
//        PrintWriter salida = res.getWriter();
//        salida.println(“<HEAD><TITLE> Seguir sesion”);
//        salida.println(“</TITLE></HEAD><BODY>”);
//        salida.println(“<h1> Seguimiento de sesión</h1>”);
//        //Un contador de accesos simple para esta petición
//        Integer ivalue = (Integer) sesion.getAttribute(“GorkaElorduy”);
//        if (ivalue == null) {
//            ivalue = new Integer(1);
//        } else {
//            ivalue = new Integer(ivalue.intValue() + 1);
//        }
//        sesion.setAttribute(“GorkaElorduy”, ivalue);
//        salida.println(“Has accedido a esta página ” + ivalue + ” veces”);
//        salida.println(“<h2>”);
//        salida.println(“Grabados datos de la sesión </h2>”);
//        //Iteramos por todos los datos de la sesión
//        Enumeration nombresSesion = sesion.getAttributeNames();
//        while (nombresSesion.hasMoreElements()) {
//            String nombre = nombresSesion.nextElement().toString();
//            Object valor = sesion.getAttribute(nombre);
//            salida.println(nombre + ” = ” + valor + “<br>”);
//        }
//        salida.println(“<h3> Estadísticas de la sesión</h3>”);
//        salida.println(“ID Sesion: ” + sesion.getId() + “<br>”);
//        salida.println(“Nueva Sesión ” + sesion.isNew());
//        salida.println(“Hora de creación: ” + sesion.getCreationTime());
//        salida.println(“Intervalo de inactividad de la sesión: ” + sesion.getMaxInactiveInterval());
//        salida.println(“ID de sesion desde cookie: ” + req.isRequestedSessionIdFromCookie());
//        salida.println(“</BODY>”);
//    }
//}
}
