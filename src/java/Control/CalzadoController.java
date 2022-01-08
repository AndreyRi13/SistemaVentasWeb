
package Control;

import DTO.Empleado;
import DTO.Calzado;
import Negocio.AdministrarEmpleado;
import Negocio.AdministrarCalzado;
import java.io.File;
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
public class CalzadoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("menu");

        switch (action) {
            case "agregarCalzado":
                request.getRequestDispatcher("agregarCalzado.jsp").forward(request, response);
                break;

            case "addCalzado":
                addCalzado(request, response);
                break;

            case "listaCalzado":
                listaCalzado(request, response);
                break;

            case "editCalzado":
                editCalzado(request, response);
                break;

            case "editarCalzado":
                editarCalzado(request, response);
                break;

            case "eliminarCalzado":
                eliminaCalzado(request, response);
                break;

            default:
                throw new AssertionError();
        }
    }

    /**
     * @ Metodo para agregar calzado
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void addCalzado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

 
        Integer referencia = Integer.parseInt(request.getParameter("txtReferencia"));
        String nombres = request.getParameter("txtNombres");
        String descripcion = request.getParameter("txtDescripcion");
        String marca = request.getParameter("txtMarca");
        String color = request.getParameter("txtColor");
        String colorSuela = request.getParameter("txtColorS");
        Integer talla = Integer.parseInt(request.getParameter("txtTalla"));
        Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
        Integer stock = Integer.parseInt(request.getParameter("txtStock"));
        String estado = request.getParameter("txtEstado");
        String Foto = request.getParameter("txtFoto");

        /**
         * Instancia objeto administrar calzado  
         *
         */
        
        AdministrarCalzado adm = new AdministrarCalzado();
        if (adm.agregarCalzado(referencia, nombres, descripcion, marca, color, colorSuela, talla, precio, stock, estado, Foto) == true) {

            listaCalzado(request, response);

        } else {

            request.getRequestDispatcher("agregarCalzado.jsp").forward(request, response);
        }

    }

   
    /**
     * Metodo para listar los calzados
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void listaCalzado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarCalzado adm = new AdministrarCalzado();
        List<Calzado> product = adm.listaCalzados();
        request.setAttribute("calzados", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaCalzados.jsp");
        dispatcher.forward(request, response);
    }

/**
 * Variable para obtener el id del producto
 */
    Integer idProduct = 0;

    /**
     * Metodo que direcciona a editar Calzados
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void editCalzado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        idProduct = Integer.parseInt(request.getParameter("id"));
        Calzado product = null;
        AdministrarCalzado adm = new AdministrarCalzado();
        try {
            product = adm.buscarCalzadoporId(idProduct);
            request.setAttribute("calzado", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editarCalzado.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CalzadoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   
    /**
     * Metodo para editar calzados
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void editarCalzado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarCalzado admi = new AdministrarCalzado();

        Integer referencia = Integer.parseInt(request.getParameter("txtReferencia"));
        String nombres = request.getParameter("txtNombres");
        String descripcion = request.getParameter("txtDescripcion");
        String marca = request.getParameter("txtMarca");
        String color = request.getParameter("txtColor");
        String colorSuela = request.getParameter("txtColorS");
        Integer talla = Integer.parseInt(request.getParameter("txtTalla"));
        Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
        Integer stock = Integer.parseInt(request.getParameter("txtStock"));
        String estado = request.getParameter("txtEstado");
        String Foto = request.getParameter("txtFoto");

        try {
            admi.editarCalzado(idProduct, referencia, nombres, descripcion, marca, color, colorSuela, talla, precio, stock, estado, Foto);
            listaCalzado(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CalzadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para eliminar calzados
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void eliminaCalzado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarCalzado adm = new AdministrarCalzado();
        Integer ide = Integer.parseInt(request.getParameter("id"));
        try {
            adm.eliminarProduct(ide);
            listaCalzado(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CalzadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 
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
