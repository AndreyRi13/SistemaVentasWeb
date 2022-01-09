/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.EmpresaDAO;
import DTO.Comprador;
import DTO.Empresa;
import Negocio.AdministrarComprador;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CompradorController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String action = request.getParameter("menu");

        switch (action) {

            case "registrarComprador":
                redireccionarRegistro(request, response);
                break;

            case "agregarComprador":
                request.getRequestDispatcher("agregarComprador.jsp").forward(request, response);
                break;

            case "addComprador":
                addComprador(request, response);
                break;

            case "registroComprador":
                registroComprador(request, response);
                break;

            case "listaCompradores":
                listaComprador(request, response);
                break;

            case "editComprador":
                editComprador(request, response);
                break;

            case "editarComprador":
                editarComprador(request, response);
                break;

            case "eliminarComprador":
                eliminaComprador(request, response);
                break;

            default:
                throw new AssertionError();
        }
    }

    
    /**
     * Metodo para redireccionar a resgistro
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void redireccionarRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmpresaDAO empr = new EmpresaDAO();
        Empresa empresa = empr.findEmpresa(1);
        request.setAttribute("empresa", empresa);
        request.getRequestDispatcher("registrarComprador.jsp").forward(request, response);
    }

  
    
    /**
     * Metodo para el registro del comprador
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws ParseException 
     */
    public void registroComprador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String datebirth = request.getParameter("txtFechaNacimiento");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(datebirth);
        Date fechaNacimiento = date;
        String cedula = request.getParameter("txtCedula");
        String nombres = request.getParameter("txtNombres");
        String apellidos = request.getParameter("txtApellidos");
        int edad = Integer.parseInt(request.getParameter("txtEdad"));
        String genero = request.getParameter("txtGenero");
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String direccion = request.getParameter("txtDireccion");
        String numeroCelular = request.getParameter("txtNumeroCelular");
        String correoElectronico = request.getParameter("txtCorreoElectronico");
        String estado = request.getParameter("txtEstado");

        /*Instancia El negocio de administrar  */
        AdministrarComprador adm = new AdministrarComprador();
        if (adm.agregarComprador(cedula, nombres, apellidos, fechaNacimiento, edad, genero, username, password, direccion, numeroCelular, correoElectronico, estado) == true) {

            response.sendRedirect("/SistemasVentasWeb/vistas/validar?a=Login");

        } else {
            request.getRequestDispatcher("registrarComprador.jsp").forward(request, response);
        }
    }

    
    /**
     * Metodo para agregar comprador desde el main
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws ParseException 
     */
    public void addComprador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        String datebirth = request.getParameter("txtFechaNacimiento");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(datebirth);
        Date fechaNacimiento = date;
        String cedula = request.getParameter("txtCedula");
        String nombres = request.getParameter("txtNombres");
        String apellidos = request.getParameter("txtApellidos");
        int edad = Integer.parseInt(request.getParameter("txtEdad"));
        String genero = request.getParameter("txtGenero");
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String direccion = request.getParameter("txtDireccion");
        String numeroCelular = request.getParameter("txtNumeroCelular");
        String correoElectronico = request.getParameter("txtCorreoElectronico");
        String estado = request.getParameter("txtEstado");

        /*Instancia El negocio de administrar  */
        AdministrarComprador adm = new AdministrarComprador();
        if (adm.agregarComprador(cedula, nombres, apellidos, fechaNacimiento, edad, genero, username, password, direccion, numeroCelular, correoElectronico, estado) == true) {

            listaComprador(request, response);

        } else {
            request.getRequestDispatcher("agregarComprador.jsp").forward(request, response);
        }

    }

    
    /**
     * Metodo para listar comprador en el main
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void listaComprador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarComprador adm = new AdministrarComprador();
        List<Comprador> emplead = adm.listaCompradores();
        request.setAttribute("compradores", emplead);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaCompradores.jsp");
        dispatcher.forward(request, response);
    }

/**
 * Variable para obtener id de empleado
 */
    Integer idEmple = 0;

    /**
     * Metodo para redireccionar a jsp editar comprador
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void editComprador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        idEmple = Integer.parseInt(request.getParameter("id"));
        Comprador emplead = null;
        AdministrarComprador adm = new AdministrarComprador();
        try {
            emplead = adm.buscarCompradorporId(idEmple);
            request.setAttribute("comprador", emplead);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editarComprador.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CompradorController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    /**
     * Metodo para editar comprador
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void editarComprador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarComprador admi = new AdministrarComprador();
        String sDate1 = request.getParameter("txtFechaNacimiento");
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);

        } catch (ParseException ex) {
            Logger.getLogger(CompradorController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        String cedula = request.getParameter("txtCedula");
        String nombres = request.getParameter("txtNombres");
        String apellidos = request.getParameter("txtApellidos");
        Date fechaNacimiento = date1;
        int edad = Integer.parseInt(request.getParameter("txtEdad"));
        String genero = request.getParameter("txtGenero");
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String direccion = request.getParameter("txtDireccion");
        String numeroCelular = request.getParameter("txtNumeroCelular");
        String correoElectronico = request.getParameter("txtCorreoElectronico");
        String estado = request.getParameter("txtEstado");
        try {
            admi.editarComprador(idEmple, cedula, nombres, apellidos, fechaNacimiento, edad, genero, username, password, direccion, numeroCelular, correoElectronico, estado);
            listaComprador(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CompradorController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /**
     * Metodo para eliminar comprador
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void eliminaComprador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarComprador adm = new AdministrarComprador();
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            adm.eliminarComprador(id);
            listaComprador(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CompradorController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CompradorController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CompradorController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
