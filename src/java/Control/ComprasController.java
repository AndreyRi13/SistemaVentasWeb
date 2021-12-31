
package Control;

import DAO.CalzadoDAO;
import DAO.EmpresaDAO;
import DTO.Calzado;
import DTO.Carrito;
import DTO.Comprador;
import DTO.Empresa;
import Control.Validar;
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
public class ComprasController extends HttpServlet {

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

    Cookie ck;
    int cant = 0;
    double totalPagar = 0.0;
    Carrito carrito = new Carrito();
    HttpSession session = null;
    Comprador comp = null;

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

    private void eliminarItemCarrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = 0;
        index = Integer.parseInt(request.getParameter("id"));
        carrito.eliminarItem(index);
        cant = cant - 1;
        ck.setValue("(" + String.valueOf(cant) + ")");
        response.sendRedirect("/SistemasVentasWeb/vistas/comprascontroller?a=main");
    }

    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/SistemasVentasWeb/inicio");
    }

    private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCalza = 0;
        idCalza = Integer.parseInt(request.getParameter("id"));
        //Instancia la clase negocio y un objeto calzado
        AdministrarCalzado cal = new AdministrarCalzado();
        Calzado calzado = cal.buscarCalzadoporId(idCalza);
        ck = new Cookie("contador", String.valueOf(cant));
        if (calzado != null) {
            carrito.agregarCalzado(calzado, 1);
            cant = cant + 1;
            ck.setValue("(" + String.valueOf(cant) + ")");
            ck.setMaxAge(-1);
            response.sendRedirect("/SistemasVentasWeb/vistas/comprascontroller?a=main");
        } else {
            response.sendRedirect("/SistemasVentasWeb/vistas/comprascontroller?a=main");
        }
    }

    private void actualizarCantidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idpro = Integer.parseInt(request.getParameter("idp"));
        int canti = Integer.parseInt(request.getParameter("Cantidad"));

        for (int i = 0; i < carrito.getProductos().size(); i++) {

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

    private void comprar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idCalza = 0;
        idCalza = Integer.parseInt(request.getParameter("id"));
        //Instancia la clase negocio y un objeto calzado
        AdministrarCalzado cal = new AdministrarCalzado();
        Calzado calzado = cal.buscarCalzadoporId(idCalza);
        ck = new Cookie("contador", String.valueOf(cant));
        if (calzado != null) {
            carrito.agregarCalzado(calzado, 1);
            cant = cant + 1;
            ck.setValue("(" + String.valueOf(cant) + ")");
            ck.setMaxAge(-1);
            EmpresaDAO empr = new EmpresaDAO();
            Empresa empresa = empr.findEmpresa(1);
            request.setAttribute("empresa", empresa);
            request.setAttribute("productos", carrito.getProductos());
            totalPagar = carrito.obtenerTotal();
            request.setAttribute("totalPagar", totalPagar);
            response.sendRedirect("/SistemasVentasWeb/vistas/comprascontroller?a=carrito");
        } else {
            response.sendRedirect("/SistemasVentasWeb/vistas/comprascontroller?a=main");
        }

    }

    private void carrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("comprador", comp);
        EmpresaDAO empr = new EmpresaDAO();
        Empresa empresa = empr.findEmpresa(1);
        request.setAttribute("empresa", empresa);
        request.setAttribute("productos", carrito.getProductos());
        totalPagar = carrito.obtenerTotal();
        request.setAttribute("totalPagar", totalPagar);
        request.getRequestDispatcher("carrito.jsp").forward(request, response);

    }

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
