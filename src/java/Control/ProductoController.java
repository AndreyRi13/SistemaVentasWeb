/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DTO.Empleado;
import DTO.Producto;
import Negocio.Administrar;
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
public class ProductoController extends HttpServlet {

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

            case "agregarProducto":
                request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
                break;

         
            case "listaProducto":
                listaProducto(request, response);
                break;

            default:
                throw new AssertionError();
        }
    }



///////////////////////////////////////METODO DE AGREGAR PRODUCTO
    public void addProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer referencia = Integer.parseInt(request.getParameter("txtReferencia"));
        String nombres = request.getParameter("txtNombres");
        String descripción = request.getParameter("txtDescripción");
        String marca = request.getParameter("txtMarca");
        String color = request.getParameter("txtColor");
        double precio = Double.parseDouble(request.getParameter("textPrecio"));
        Integer stock = Integer.parseInt(request.getParameter("txtStock"));
        String estado = request.getParameter("txtEstado");
        String Foto = request.getParameter("txtFoto");

        /*Instancia El negocio de administrar  */
        Administrar adm = new Administrar();
        if (adm.agregarProducto(referencia, nombres, descripción, marca, color, precio, stock, estado, Foto) == true) {

            listaProducto(request, response);

        } else {

            request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
        }

    }

    ///////////////////////////////////////METODO DE LISTAR PRODUCTOS
    public void listaProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Administrar adm = new Administrar();
        List<Producto> product = adm.listaProductos();
        request.setAttribute("productos", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaProductos.jsp");
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
