/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import DAO.CalzadoDAO;
import DAO.EmpresaDAO;
import DTO.Calzado;
import DTO.Carrito;
import DTO.Comprador;
import DTO.Empresa;
import Negocio.AdministrarCalzado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class CarritoController extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("a");
        if (action == null) {
            MainComprador(request, response);
        } else {

            switch (action) {

                case "main":
                    MainComprador(request, response);
                    break;
                case "home":
                    home(request, response);
                    break;
                case "Login":
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "eliminarItemCarrito":
                    eliminarItemCarrito(request, response);
                    break;

                case "actualizarCantidad":
                    actualizarCantidad(request, response);
                    break;

                case "comprar":
                    comprar(request, response);
                    break;

                case "compracontroller":
                    CompraController(request, response);
                    break;

                case "pagocontroller":
                    PagarController(request, response);
                    break;

                case "verMas":
                    verMas(request, response);
                    break;

                case "addCart":
                    addCart(request, response);
                    break;
                case "carrito":
                    carrito(request, response);
                    break;

            }

        }
    }

    /**
     *
     */
    private Cookie ck;
    private int cant = 0;
    private double totalPagar = 0.0;
    private Carrito carrito = new Carrito();
    HttpSession session = null;
    Comprador comp = null;

    public void setCk(Cookie ck) {
        this.ck = ck;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public void setComp(Comprador comp) {
        this.comp = comp;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void MainComprador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (comp == null) {
            comp = (Comprador) request.getAttribute("comprador");
        }
      
        CalzadoDAO pr = new CalzadoDAO();
        List<Calzado> product = pr.readCalzados();
        EmpresaDAO empr = new EmpresaDAO();
        Empresa empresa = empr.findEmpresa(1);
        request.setAttribute("calzados", product);
        request.setAttribute("empresa", empresa);
        request.setAttribute("comprador", comp);
        if (ck != null) {
            request.setAttribute("contador", ck.getValue());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("mainComprador.jsp");
        dispatcher.forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void eliminarItemCarrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = 0;
        index = Integer.parseInt(request.getParameter("id"));
        this.carrito.eliminarItem(index);
        cant = cant - 1;
        ck.setValue("(" + String.valueOf(cant) + ")");
        response.sendRedirect("/SistemasVentasWeb/vistas/carritocontroller?a=main");
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/SistemasVentasWeb/inicio");
    }

    private void CompraController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("carrito", this.carrito);
        request.getRequestDispatcher("comprascontroller?a=addCompra").include(request, response);
        response.sendRedirect("/SistemasVentasWeb/vistas/carritocontroller?a=main");

    }

    private void PagarController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("comprador", this.comp);
        request.getRequestDispatcher("/vistas/comprascontroller?a=pagar").include(request, response);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCalza = 0;
        idCalza = Integer.parseInt(request.getParameter("id"));
        //Instancia la clase negocio y un objeto calzado
        AdministrarCalzado cal = new AdministrarCalzado();
        Calzado calzado = cal.buscarCalzadoporId(idCalza);
        ck = new Cookie("contador", String.valueOf(cant));
        if (calzado != null) {
            this.carrito.agregarCalzado(calzado, 1);
            cant = cant + 1;
            ck.setValue("(" + String.valueOf(cant) + ")");
            ck.setMaxAge(-1);
            response.sendRedirect("/SistemasVentasWeb/vistas/carritocontroller?a=main");
        } else {
            response.sendRedirect("/SistemasVentasWeb/vistas/carritocontroller?a=main");
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void actualizarCantidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idpro = Integer.parseInt(request.getParameter("idp"));
        int canti = Integer.parseInt(request.getParameter("Cantidad"));

        for (int i = 0; i < this.carrito.getProductos().size(); i++) {

            if (this.carrito.getProductos().get(i).getCalzado().getIdCalzado() == idpro) {

                if (canti > this.carrito.getProductos().get(i).getCantidad()) {
                    cant = cant + 1;
                    ck.setValue("(" + String.valueOf(cant) + ")");
                    ck.setMaxAge(-1);

                } else if (canti < this.carrito.getProductos().get(i).getCantidad()) {
                    cant = cant - 1;
                    ck.setValue("(" + String.valueOf(cant) + ")");
                    ck.setMaxAge(-1);
                } else {
                    cant = cant;
                    ck.setValue("(" + String.valueOf(cant) + ")");
                    ck.setMaxAge(-1);

                }

                this.carrito.getProductos().get(i).setCantidad(canti);
            }

        }

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void comprar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idCalza = 0;
        idCalza = Integer.parseInt(request.getParameter("id"));
        //Instancia la clase negocio y un objeto calzado
        AdministrarCalzado cal = new AdministrarCalzado();
        Calzado calzado = cal.buscarCalzadoporId(idCalza);
        ck = new Cookie("contador", String.valueOf(cant));
        if (calzado != null) {
            this.carrito.agregarCalzado(calzado, 1);
            cant = cant + 1;
            ck.setValue("(" + String.valueOf(cant) + ")");
            ck.setMaxAge(-1);
            EmpresaDAO empr = new EmpresaDAO();
            Empresa empresa = empr.findEmpresa(1);
            request.setAttribute("empresa", empresa);
            request.setAttribute("productos", this.carrito.getProductos());
            this.setTotalPagar(carrito.obtenerTotal());

            request.setAttribute("totalPagar", this.getTotalPagar());
            response.sendRedirect("/SistemasVentasWeb/vistas/carritocontroller?a=carrito");
        } else {
            response.sendRedirect("/SistemasVentasWeb/vistas/carritocontroller?a=main");
        }

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void carrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("comprador", comp);
        EmpresaDAO empr = new EmpresaDAO();
        Empresa empresa = empr.findEmpresa(1);
        request.setAttribute("empresa", empresa);
        request.setAttribute("productos", carrito.getProductos());
        this.setTotalPagar(carrito.obtenerTotal());

        request.setAttribute("totalPagar", this.getTotalPagar());
        request.getRequestDispatcher("carrito.jsp").forward(request, response);

    }

    public Carrito getCarrito() {
        return this.carrito;
    }

    public Cookie getCk() {
        return this.ck;
    }

    public int getCant() {
        return this.cant;
    }

    public double getTotalPagar() {
        return this.totalPagar;
    }

    public HttpSession getSession() {
        return this.session;
    }

    public Comprador getComp() {
        return this.comp;
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void verMas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCal = Integer.parseInt(request.getParameter("id"));
        AdministrarCalzado cal = new AdministrarCalzado();
        try {
            Calzado calzado = cal.buscarCalzadoporId(idCal);
            request.setAttribute("calzado", calzado);
            request.setAttribute("comprador", comp);
            EmpresaDAO empr = new EmpresaDAO();
            Empresa empresa = empr.findEmpresa(1);
            request.setAttribute("empresa", empresa);
            RequestDispatcher dispatcher = request.getRequestDispatcher("productoVerMas.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
