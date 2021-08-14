/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.CarritoDAO;
import DTO.Calzado;
import DTO.Carrito;
import DTO.Comprador;
import DTO.Pago;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class AdministrarCarrito {
    
    
 /*CRUD CARRITO
        private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarrito")
    private Integer idCarrito;
    @Basic(optional = false)
    @Column(name = "item")
    private int item;
    @Basic(optional = false)
    @Column(name = "precioCompra")
    private double precioCompra;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "subTotal")
    private double subTotal;
    @JoinColumn(name = "idCalzado", referencedColumnName = "idCalzado")
    @ManyToOne(optional = false)
    private Calzado idCalzado;
    @JoinColumn(name = "idComprador", referencedColumnName = "idComprador")
    @ManyToOne(optional = false)
    private Comprador idComprador;
    @JoinColumn(name = "idPago", referencedColumnName = "idPago")
    @ManyToOne(optional = false)
    private Pago idPago;
    
    
    
    */
    public boolean agregarCarrito(int item,double precioCompra,int cantidad,double subTotal,Calzado idCalzado,Comprador idComprador,Pago idPago) {
              
        CarritoDAO empleado = new CarritoDAO();
        
        Carrito com = new Carrito(item,precioCompra,cantidad, subTotal,idCalzado,idComprador,idPago);
        
        try {
            empleado.addCarrito(com);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Carrito buscarCarritoporId(Integer idCarrito) throws Exception {
        CarritoDAO emp = new CarritoDAO();
        List<Carrito> empleadosList = emp.readCarritos();
        Carrito aux = null;
        for (Carrito m : empleadosList) {
            if (m.getIdCarrito().equals(idCarrito)) {
                aux = m;
            }
        }
        return aux;
    }


    public void editarCarrito(Integer idCarrito, int item,double precioCompra,int cantidad,double subTotal,Calzado idCalzado,Comprador idComprador,Pago idPago) throws Exception {
        Carrito em = new Carrito();
        em.setIdCarrito(idCarrito);
        em.setItem(item);
        em.setPrecioCompra(precioCompra);
        em.setCantidad(cantidad);       
        em.setSubTotal(subTotal);
        em.setIdCalzado(idCalzado);
        em.setIdComprador(idComprador);
        em.setIdPago(idPago);
               
        CarritoDAO empdao = new CarritoDAO();
        empdao.updateCarrito(em);
    }

    public void eliminarCarrito(Integer id) throws Exception {
        CarritoDAO comdao = new CarritoDAO();
        comdao.deleteCarrito(id);
    }

    public List<Carrito> listaCarritoes() {
        CarritoDAO emp = new CarritoDAO();
        List<Carrito> empleados = emp.readCarritos();
        return empleados;
    }

}

