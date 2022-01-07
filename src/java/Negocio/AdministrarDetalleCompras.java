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

    
    /**
     * Metodo para agregar detalle de compra
     * @param cantidad
     * @param precioCompra
     * @param idCalzado
     * @param idCompras
     * @return boolean
     */
    public boolean agregarDetalleCompras(int cantidad, double precioCompra, Calzado idCalzado, Compras idCompras) {
        DetalleComprasDAO empleado = new DetalleComprasDAO();
        DetalleCompras emp = new DetalleCompras(cantidad, precioCompra, idCalzado, idCompras);

        try {
            empleado.addDetalleCompras(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para buscar detalle de compras por id
     * @param idDetalleCompras
     * @return DetalleCompras
     * @throws Exception 
     */
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

    /**
     * Metodo para editar detalle de compra
     * @param id
     * @param cantidad
     * @param precioCompra
     * @param idCalzado
     * @param idCompras
     * @throws Exception 
     */
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

    /**
     * Metodo para eliminar detalle de compra por id
     * @param id
     * @throws Exception 
     */
    public void eliminarDetalleCompras(Integer id) throws Exception {
        DetalleComprasDAO empdao = new DetalleComprasDAO();
        empdao.deleteDetalleCompras(id);
    }

    /**
     * Metodo para listar detalles de compras
     * @return List
     */
    public List<DetalleCompras> listaDetalleComprass() {
        DetalleComprasDAO emp = new DetalleComprasDAO();
        List<DetalleCompras> detalleCompras = emp.readDetalleCompras();
        return detalleCompras;
    }

}
