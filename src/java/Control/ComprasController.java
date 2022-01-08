package Control;

import DAO.CalzadoDAO;
import DAO.CompraDAO;
import DAO.EmpresaDAO;
import DTO.Calzado;
import DTO.Carrito;
import DTO.Comprador;
import DTO.DetalleCompra;
import DTO.Empresa;
import Negocio.AdministrarCalzado;
import Negocio.AdministrarCompra;
import Negocio.AdministrarDetalleCompra;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
 * @author Andrey
 */
public class ComprasController extends HttpServlet {

    Comprador compr;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String action = request.getParameter("a");

        switch (action) {

            case "pagar":
                pagar(request, response);
                break;

            case "addCompra":
                addCompra(request, response);
                break;

        }
    }
    private Carrito carrito = new Carrito();

    private void pagar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        compr = (Comprador) request.getAttribute("comprador");
        request.setAttribute("comprador", compr);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pago.jsp");
        dispatcher.forward(request, response);

    }

    private void addCompra(HttpServletRequest request, HttpServletResponse response) throws Exception {

        AdministrarCompra admcom = new AdministrarCompra();
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date fechaCompra = calendar.getTime();
        String estado = "Pendiente";

        AdministrarDetalleCompra admdetcom = new AdministrarDetalleCompra();
        Collection<DetalleCompra> detalleCompraCollection = null;
        Random rnd = new Random();
        Integer codigo = 0;
        codigo = rnd.nextInt(99999999 - 100 + 1) + 100;

        while (admcom.CodigoRepetido(codigo) == true) {
            codigo = rnd.nextInt(99999999 - 1000000 + 1) + 1000000;
        }

        carrito = (Carrito) request.getAttribute("carrito");

        System.out.println("Total " + carrito.obtenerTotal());
        admcom.agregarCompra(codigo, fechaCompra, carrito.obtenerTotal(), estado);

        //  int cantidad, double precioCompra, Calzado idCalzado, Compra idCompras
        for (int i = 0; i < carrito.getProductos().size(); i++) {

            admdetcom.agregarDetalleCompra(carrito.getProductos().get(i).getCantidad(), carrito.getProductos().get(i).getSubTotal(), carrito.getProductos().get(i).getCalzado(), admcom.buscarCompraporCodigo(codigo));

        }
        
        MainController(request, response);

    }
    
    
     private void MainController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("comprador", this.compr);
        request.getRequestDispatcher("/vistas/carritocontroller?a=main").include(request, response);

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
        } catch (Exception ex) {
            Logger.getLogger(ComprasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ComprasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
