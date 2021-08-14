/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.PagoDAO;
import DTO.Pago;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class AdministrarPago {

    /*CRUD PAGO
    
    
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPago")
    private Collection<Carrito> carritoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPago")
    private Integer idPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    
    
    
     */
    public boolean agregarPago(int item, double precioCompra, int cantidad, double subTotal, Calzado idCalzado, Comprador idComprador, Pago idPago) {

        PagoDAO empleado = new PagoDAO();

        Pago com = new Pago(item, precioCompra, cantidad, subTotal, idCalzado, idComprador, idPago);

        try {
            empleado.addPago(com);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Pago buscarPagoporId(Integer idPago) throws Exception {
        PagoDAO emp = new PagoDAO();
        List<Pago> empleadosList = emp.readPagos();
        Pago aux = null;
        for (Pago m : empleadosList) {
            if (m.getIdPago().equals(idPago)) {
                aux = m;
            }
        }
        return aux;
    }

    public void editarPago(Integer idPago, int item, double precioCompra, int cantidad, double subTotal, Calzado idCalzado, Comprador idComprador, Pago idPago) throws Exception {
        Pago em = new Pago();
        em.setIdPago(idPago);
        em.setItem(item);
        em.setPrecioCompra(precioCompra);
        em.setCantidad(cantidad);
        em.setSubTotal(subTotal);
        em.setIdCalzado(idCalzado);
        em.setIdComprador(idComprador);
        em.setIdPago(idPago);

        PagoDAO empdao = new PagoDAO();
        empdao.updatePago(em);
    }

    public void eliminarPago(Integer id) throws Exception {
        PagoDAO comdao = new PagoDAO();
        comdao.deletePago(id);
    }

    public List<Pago> listaPagoes() {
        PagoDAO emp = new PagoDAO();
        List<Pago> empleados = emp.readPagos();
        return empleados;
    }

}
