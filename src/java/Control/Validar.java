package Control;

import DAO.EmpresaDAO;
import DTO.Empleado;
import DTO.Calzado;
import DTO.Comprador;
import DTO.Empresa;
import Negocio.AdministrarEmpleado;
import Negocio.Login;
import Negocio.N_Inicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            case "PageditarPerfil":
                PageditarPerfil(request, response);
                break;
            case "editarPerfil":
                editarPerfil(request, response);
                break;
        }

    }

   

    /**
     * 
     */
    int idUsuario = 0;

    /**
     * Metodo que valida los datos de inicio de sesion
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void ingresar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("txtuser");
        String pass = request.getParameter("txtpass");

        Login lg = new Login();

        if (lg.tipoLogin(user, pass) != null) {

            if (lg.tipoLogin(user, pass).equals("Empleado")) {
                HttpSession session = request.getSession();
                Empleado empleado = lg.loginEmpleado(user, pass);
                idUsuario = empleado.getIdEmpleado();
                session.setAttribute("empleado", empleado);
                dashboard(request, response);

            } else if (lg.tipoLogin(user, pass).equals("Comprador")) {
                HttpSession session = request.getSession();
                Comprador comprador = lg.loginComprador(user, pass);
                request.setAttribute("comprador", comprador);
                request.getRequestDispatcher("/vistas/carritocontroller?a=main").include(request, response);
            }

        } else {
            String mensaje = "Error - Usuario o contraseña Incorrecta";
            request.setAttribute("mensaje", mensaje);
            login(request, response);
        }
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void dashboard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {              
        RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void PageditarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("editarPerfil.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void editarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarEmpleado admi = new AdministrarEmpleado();
        String cedula = request.getParameter("txtCedula");
        String nombres = request.getParameter("txtNombres");
        String apellidos = request.getParameter("txtApellidos");
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String direccion = request.getParameter("txtDireccion");
        String numeroCelular = request.getParameter("txtNumeroCelular");
        String correoElectronico = request.getParameter("txtCorreoElectronico");
        String estado = request.getParameter("txtEstado");
        try {
            admi.editarEmpleado(idUsuario, cedula, nombres, apellidos, username, password, direccion, numeroCelular, correoElectronico, estado);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmpresaDAO empr = new EmpresaDAO();
        Empresa empresa = empr.findEmpresa(1);
        request.setAttribute("empresa", empresa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
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
    }
}
