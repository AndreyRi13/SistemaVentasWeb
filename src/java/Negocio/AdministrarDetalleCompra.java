/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.DatalleCompraDAO;
import DTO.Calzado;
import DTO.Compra;
import DTO.DetalleCompra;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class AdministrarDetalleCompra {

    
   /**
    * Metodo para agregar detalle de compras
    * @param cantidad
    * @param precioCompra
    * @param idCalzado
    * @param idCompra
    * @return 
    */
    public boolean agregarDetalleCompra(int cantidad, double precioCompra, Calzado idCalzado, Compra idCompra) {
        DatalleCompraDAO empleado = new DatalleCompraDAO();
        DetalleCompra emp = new DetalleCompra(cantidad, precioCompra,idCalzado,idCompra);

        try {
            empleado.addDetalleCompra(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para buscar detalle de compras por id
     * @param idDetalleCompra
     * @return DetalleCompra
     * @throws Exception 
     */
    public DetalleCompra buscarDetalleCompraporId(Integer idDetalleCompra) throws Exception {
        DatalleCompraDAO emp = new DatalleCompraDAO();
        List<DetalleCompra> detalleCompra = emp.readDatalleCompra();
        DetalleCompra aux = null;
        for (DetalleCompra m : detalleCompra) {
            if (m.getIdDetalle().equals(idDetalleCompra)) {
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
     * @param idCompra
     * @throws Exception 
     */
    public void editarDetalleCompra(Integer id,int cantidad, double precioCompra, Calzado idCalzado, Compra idCompra) throws Exception {
        DetalleCompra em = new DetalleCompra();
        em.setIdDetalle(id);
        em.setCantidad(cantidad);
        em.setPrecioCompra(precioCompra);
        em.setIdCalzado(idCalzado);
        em.setIdCompra(idCompra);

        DatalleCompraDAO empdao = new DatalleCompraDAO();
        empdao.updateDetalleCompra(em);
    }

    /**
     * Metodo para eliminar detalle de compra por id
     * @param id
     * @throws Exception 
     */
    public void eliminarDetalleCompra(Integer id) throws Exception {
        DatalleCompraDAO empdao = new DatalleCompraDAO();
        empdao.deleteDetalleCompra(id);
    }

    /**
     * Metodo para listar detalles de compras
     * @return List
     */
    public List<DetalleCompra> listaDetalleCompra() {
        DatalleCompraDAO emp = new DatalleCompraDAO();
        List<DetalleCompra> detalleCompra = emp.readDatalleCompra();
        return detalleCompra;
    }

}
