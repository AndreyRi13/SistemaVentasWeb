/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.CalzadoDAO;
import DAO.EmpresaDAO;
import DTO.Calzado;
import DTO.Carrito;
import DTO.Empresa;
import Negocio.AdministrarCalzado;
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
public class Inicio extends HttpServlet {

    List<Carrito> listacarrito = new ArrayList<>();
    double totalPagar = 0.0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("a");

        if (action == null) {
            CalzadoDAO pr = new CalzadoDAO();
            List<Calzado> product = pr.readCalzados();
            EmpresaDAO empr = new EmpresaDAO();
            Empresa empresa = empr.findEmpresa(1);
            request.setAttribute("calzados", product);
            request.setAttribute("empresa", empresa);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } else {

            switch (action) {

                case "home":
                    inicio(request, response);
                    break;

                case "Login":
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                    break;

                case "verMas":
                    verMas(request, response);
                    break;

                case "agregarCarrito":

                    int item = 0;
                    int cantidad = 1;

                    //Guarda el id del calzado que elige en agregar al carrito
                    int idCalza = Integer.parseInt(request.getParameter("id"));
                    //Instancia la clase negocio y un objeto calzado
                    AdministrarCalzado cal = new AdministrarCalzado();
                    Calzado calzad = null;

                    try {
                        //Busca el calzado por el id y lo guarda en el objeto calzado
                        calzad = cal.buscarCalzadoporId(idCalza);
                    } catch (Exception ex) {
                        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    item = item + 1;
                    Carrito car = new Carrito(item, idCalza, calzad.getNombres(), calzad.getDescripcion(), calzad.getPrecio(), cantidad, cantidad * calzad.getPrecio());
                    listacarrito.add(car);
                    request.setAttribute("contador", listacarrito.size());
                    request.getRequestDispatcher("inicio?a=home").forward(request, response);

                    break;


                case "carrito":
                    carrito(request, response);
                    break;

            }
        }

    }

    public void carrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmpresaDAO empr = new EmpresaDAO();
        Empresa empresa = empr.findEmpresa(1);
        request.setAttribute("empresa", empresa);

        totalPagar = 0.0;

        request.setAttribute("calzados", listacarrito);
        request.getRequestDispatcher("carrito.jsp").forward(request, response);

    }

    public void verMas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCal = Integer.parseInt(request.getParameter("id"));
        AdministrarCalzado cal = new AdministrarCalzado();
        try {
            Calzado calzado = cal.buscarCalzadoporId(idCal);
            request.setAttribute("calzado", calzado);
            EmpresaDAO empr = new EmpresaDAO();
            Empresa empresa = empr.findEmpresa(1);
            request.setAttribute("empresa", empresa);
            RequestDispatcher dispatcher = request.getRequestDispatcher("productoVerMas.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void inicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CalzadoDAO pr = new CalzadoDAO();
        List<Calzado> product = pr.readCalzados();
        EmpresaDAO empr = new EmpresaDAO();
        Empresa empresa = empr.findEmpresa(1);
        request.setAttribute("calzados", product);
        request.setAttribute("empresa", empresa);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
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
