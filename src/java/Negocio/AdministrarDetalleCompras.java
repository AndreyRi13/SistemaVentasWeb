/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DetalleComprasDAO;
import DTO.Calzado;
import DTO.Compras;
import DTO.DetalleCompras;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class AdministrarDetalleCompras {
     /*CRUD EMPLEADO*/
    public boolean agregarDetalleCompras(int cantidad, double precioCompra, Calzado idCalzado, Compras idCompras) {
        DetalleComprasDAO empleado = new DetalleComprasDAO();
        DetalleCompras emp = new DetalleCompras(cantidad,precioCompra,idCalzado,idCompras);
        
        try {
            empleado.addDetalleCompras(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public DetalleCompras buscarDetalleComprasporId(Integer idDetalleCompras) throws Exception {
        DetalleComprasDAO emp = new DetalleComprasDAO();
        List<DetalleCompras> detalleCompras = emp.readDetalleCompras();
        DetalleCompras aux = null;
        for (DetalleCompras m : detalleCompras) {
            if (m.getIdDetalle().equals(idDetalleCompras)) {
                aux = m;
            }
        }
        return aux;
    }

    public void editarDetalleCompras(Integer id, int cantidad, double precioCompra, Calzado idCalzado, Compras idCompras) throws Exception {
        DetalleCompras em = new DetalleCompras();
        em.setIdDetalle(id);
        em.setCantidad(cantidad);
        em.setPrecioCompra(precioCompra);
        em.setIdCalzado(idCalzado);
        em.setIdCompras(idCompras);
        
        DetalleComprasDAO empdao = new DetalleComprasDAO();
        empdao.updateDetalleCompras(em);
    }

    public void eliminarDetalleCompras(Integer id) throws Exception {
        DetalleComprasDAO empdao = new DetalleComprasDAO();
        empdao.deleteDetalleCompras(id);
    }

    public List<DetalleCompras> listaDetalleComprass() {
        DetalleComprasDAO emp = new DetalleComprasDAO();
        List<DetalleCompras> detalleCompras = emp.readDetalleCompras();
        return detalleCompras;
    }

}