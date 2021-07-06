/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DTO.Empleado;
import DTO.Producto;
import Negocio.AdministrarEmpleado;
import Negocio.AdministrarProducto;
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

            case "addProducto":
                addProducto(request, response);
                break;

            case "listaProducto":
                listaProducto(request, response);
                break;

            case "editProducto":
                editProducto(request, response);
                break;

            case "editarProducto":
                editarProducto(request, response);
                break;

            case "eliminarProducto":
                eliminaProducto(request, response);
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
        String descripcion = request.getParameter("txtDescripcion");
        String marca = request.getParameter("txtMarca");
        String color = request.getParameter("txtColor");
        String colorSuela = request.getParameter("txtColorS");
        Integer talla = Integer.parseInt(request.getParameter("txtTalla"));
        Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
        Integer stock = Integer.parseInt(request.getParameter("txtStock"));
        String estado = request.getParameter("txtEstado");
        String Foto = request.getParameter("txtFoto");

        /*Instancia El negocio de administrar  */
        AdministrarProducto adm = new AdministrarProducto();
        if (adm.agregarProducto(referencia, nombres, descripcion, marca, color, colorSuela, talla, precio, stock, estado, Foto) == true) {

            listaProducto(request, response);

        } else {

            request.getRequestDispatcher("agregarProducto.jsp").forward(request, response);
        }

    }

    ///////////////////////////////////////METODO DE LISTAR PRODUCTOS
    public void listaProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarProducto adm = new AdministrarProducto();
        List<Producto> product = adm.listaProductos();
        request.setAttribute("productos", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaProductos.jsp");
        dispatcher.forward(request, response);
    }

///////////////////////////////////////METODO DE RIDECCIONAR A EDITAR PRODUCTOS
    Integer idProduct = 0;

    public void editProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        idProduct = Integer.parseInt(request.getParameter("id"));
        Producto product = null;
        AdministrarProducto adm = new AdministrarProducto();
        try {
            product = adm.buscarProductoporId(idProduct);
            request.setAttribute("producto", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editarProducto.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///////////////////////////////////////METODO DE EDITAR PRODUCTOS
    public void editarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarProducto admi = new AdministrarProducto();

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
            admi.editarProducto(idProduct, referencia, nombres, descripcion, marca, color, colorSuela, talla, precio, stock, estado, Foto);
            listaProducto(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
///////////////////////////////////////METODO DE ELIMINAR EMPLEADO

    public void eliminaProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdministrarProducto adm = new AdministrarProducto();
        Integer ide = Integer.parseInt(request.getParameter("id"));
        try {
            adm.eliminarProduct(ide);
            listaProducto(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
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
