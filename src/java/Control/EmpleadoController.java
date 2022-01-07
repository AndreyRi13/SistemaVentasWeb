
package Control;

import DAO.EmpleadoDAO;
import DTO.Empleado;
import DTO.Calzado;
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

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
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

   
    /**
     * Metodo para agregar empleado
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void addEmpleado(HttpServletRequest request, HttpServletResponse response)
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
        AdministrarEmpleado adm = new AdministrarEmpleado();
        if (adm.agregarEmpleado(cedula,nombres,apellidos,username,password,direccion,numeroCelular,correoElectronico,estado) == true) {

            listaEmpleado(request, response);

        } else {

            request.getRequestDispatcher("agregarEmpleado.jsp").forward(request, response);
        }

    }


    /**
     * Metodo de listar empleados
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void listaEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarEmpleado adm = new AdministrarEmpleado();
        List<Empleado> emplead = adm.listaEmpleados();
        request.setAttribute("empleados", emplead);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaEmpleado.jsp");
        dispatcher.forward(request, response);
    }


    /**
     * Variable para obtener id de empleado
     */
    Integer idEmple = 0;

    /**
     * Metodo de direccionar para edicion de empleado
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
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

/**
 * Metodo para editar empleado
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException 
 */
    public void editarEmpleado(HttpServletRequest request, HttpServletResponse response)
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
            admi.editarEmpleado(idEmple, cedula,  nombres, apellidos,  username,  password,  direccion,  numeroCelular,  correoElectronico,  estado);
            listaEmpleado(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para eliminar empleado
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
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
