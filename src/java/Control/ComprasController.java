package Control;

import DAO.CalzadoDAO;
import DAO.CompraDAO;
import DAO.EmpresaDAO;
import DTO.Calzado;
import DTO.Carrito;
import DTO.Compra;
import DTO.Comprador;
import DTO.DetalleCompra;
import DTO.Empresa;
import Negocio.AdministrarCalzado;
import Negocio.AdministrarCompra;
import Negocio.AdministrarDetalleCompra;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

            case "editVenta":
                editVenta(request, response);
                break;

            case "editarVenta":
                editarVenta(request, response);
                break;

            case "listarVenta":
                listarVenta(request, response);
                break;

            case "informeVenta":
                informeVenta(request, response);
                break;

        }
    }
    private Carrito carrito = new Carrito();
    Integer idVenta = 0;

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
        /**
         * Generar Codigo para la compra
         */
        Random rnd = new Random();
        Integer codigo = 0;
        codigo = rnd.nextInt(99999999 - 100 + 1) + 100;
        while (admcom.CodigoRepetido(codigo) == true) {
            codigo = rnd.nextInt(99999999 - 1000000 + 1) + 1000000;
        }
        carrito = (Carrito) request.getAttribute("carrito");

        admcom.agregarCompra(codigo, fechaCompra, carrito.obtenerTotal(), estado, compr);
        for (int i = 0; i < carrito.getProductos().size(); i++) {

            admdetcom.agregarDetalleCompra(carrito.getProductos().get(i).getCantidad(), carrito.getProductos().get(i).getSubTotal(), carrito.getProductos().get(i).getCalzado(), admcom.buscarCompraporCodigo(codigo));
        }
    }

    private void CalzadoVendido(HttpServletRequest request, HttpServletResponse response, Calzado idCal, int cantidad) throws Exception {
        AdministrarCalzado adcal = new AdministrarCalzado();
        if (idCal.getStock() >= 1) {
            Integer cantVent = idCal.getStock() - cantidad;
            adcal.editarCalzado(idCal.getIdCalzado(), idCal.getReferencia(), idCal.getNombres(), idCal.getDescripcion(), idCal.getModelo(), idCal.getColor(), idCal.getColorSuela(), idCal.getTalla(), idCal.getPrecio(), cantVent, idCal.getEstado(), idCal.getFoto());
        } else {
            adcal.editarCalzado(idCal.getIdCalzado(), idCal.getReferencia(), idCal.getNombres(), idCal.getDescripcion(), idCal.getModelo(), idCal.getColor(), idCal.getColorSuela(), idCal.getTalla(), idCal.getPrecio(), 0, "No disponible", idCal.getFoto());

        }

    }

    private void editVenta(HttpServletRequest request, HttpServletResponse response) {
        idVenta = Integer.parseInt(request.getParameter("id"));
        Compra venta = null;
        AdministrarCompra adm = new AdministrarCompra();
        try {
            venta = adm.buscarCompraporId(idVenta);
            request.setAttribute("venta", venta);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editarVenta.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CalzadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editarVenta(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AdministrarCompra admi = new AdministrarCompra();

        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        Date fechaCompra = admi.buscarCompraporId(idVenta).getFechaCompra();
        double precioTotal = Double.parseDouble(request.getParameter("txtPrecioTotal"));
        String estado = request.getParameter("txtEstado");
        Comprador idCompr = admi.buscarCompraporId(idVenta).getIdComprador();

        try {
            admi.editarCompra(idVenta, codigo, fechaCompra, precioTotal, estado, idCompr);
            listarVenta(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CalzadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AdministrarCompra admcom = new AdministrarCompra();
        List<Compra> compra = admcom.listaCompras();
        request.setAttribute("ventas", compra);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaVentas.jsp");
        dispatcher.forward(request, response);

    }

    private void informeVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdministrarCompra admcom = new AdministrarCompra();
        // AdministrarDetalleCompra admdet = new AdministrarDetalleCompra();
        List<Compra> compra = admcom.listaCompras();
        // List<DetalleCompra> detalleCompra = admdet.listaDetalleCompra();
        ArrayList c = new ArrayList();
        for (Compra co : compra) {
            c.add(co);
        }
        request.setAttribute("c", c);
//        request.setAttribute("detalleCompra", detalleCompra);
        RequestDispatcher dispatcher = request.getRequestDispatcher("informeVentas.jsp");
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
