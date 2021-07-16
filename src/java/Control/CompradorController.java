/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DTO.Comprador;
import Negocio.AdministrarComprador;
import java.io.IOException;
import java.io.PrintWriter;
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        String action = request.getParameter("menu");

        switch (action) {
            
            
            case "registrarComprador":
                request.getRequestDispatcher("registrarComprador.jsp").forward(request, response);
                break;
            
            
            case "agregarComprador":
                request.getRequestDispatcher("agregarComprador.jsp").forward(request, response);
                break;

            case "listaCompradores":
                listaComprador(request, response);
                break;

            case "addComprador":
                addComprador(request, response);
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

    ///////////////////////////////////////Metodo para agregar comprador
    public void addComprador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cedula = request.getParameter("txtCedula");
        String nombres = request.getParameter("txtNombres");
        String apellidos = request.getParameter("txtApellidos");
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String direccion = request.getParameter("txtDireccion");
        String numeroCelular = request.getParameter("txtNumeroCelular");
        String correoElectronico = request.getParameter("txtCorreoElectronico");    
        String estado = request.getParameter("txtEstado");

        /*Instancia El negocio de administrar  */
        AdministrarComprador adm = new AdministrarComprador();
        if (adm.agregarComprador(cedula,nombres,apellidos,username,password,direccion,numeroCelular,correoElectronico,estado) == true) {

            listaComprador(request, response);

        } else {

            request.getRequestDispatcher("agregarComprador.jsp").forward(request, response);
        }

    }

///////////////////////////////////////METODO DE LISTAR compradorS
    public void listaComprador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarComprador adm = new AdministrarComprador();
        List<Comprador> emplead = adm.listaCompradores();
        request.setAttribute("compradores", emplead);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaCompradores.jsp");
        dispatcher.forward(request, response);
    }

///////////////////////////////////////METODO DE DIRECCIONAR PARA EDICION DE comprador
    Integer idEmple = 0;

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
            Logger.getLogger(CompradorController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
///////////////////////////////////////METODO DE EDITAR comprador

    public void editarComprador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarComprador admi = new AdministrarComprador();
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
            admi.editarComprador(idEmple, cedula,  nombres, apellidos,  username,  password,  direccion,  numeroCelular,  correoElectronico,  estado);
            listaComprador(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CompradorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
///////////////////////////////////////METODO DE ELIMINAR comprador

    public void eliminaComprador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarComprador adm = new AdministrarComprador();
        Integer id = Integer.parseInt(request.getParameter("id"));
        try {
            adm.eliminarComprador(id);
            listaComprador(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CompradorController.class.getName()).log(Level.SEVERE, null, ex);
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
