/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.ComprasDAO;
import DTO.Comprador;
import DTO.Compras;
import DTO.DetalleCompras;
import DTO.Pago;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class AdministrarCompras {

  
    /**
     * Metodo para agregar Compras
     * @param fechaCompras
     * @param monto
     * @param estado
     * @param idPago
     * @param idCliente
     * @param detalleComprasCollection
     * @return 
     */
    public boolean agregarCompras(String fechaCompras, Double monto, String estado, Pago idPago, Comprador idCliente, Collection<DetalleCompras> detalleComprasCollection) {
        ComprasDAO compras = new ComprasDAO();
        Compras emp = new Compras(fechaCompras, monto, estado, idPago, idCliente, detalleComprasCollection);

        try {
            compras.addCompras(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
/**
 * Metodo para buscar compras por id
 * @param idCompras
 * @return Compras
 * @throws Exception 
 */
    public Compras buscarComprasporId(Integer idCompras) throws Exception {
        ComprasDAO emp = new ComprasDAO();
        List<Compras> comprasList = emp.readCompras();
        Compras aux = null;
        for (Compras m : comprasList) {
            if (m.getIdCompras().equals(idCompras)) {
                aux = m;
            }
        }
        return aux;
    }

    /**
     * Metodo para editar compra
     * @param idCompras
     * @param fechaCompras
     * @param monto
     * @param estado
     * @param idPago
     * @param idCliente
     * @param detalleComprasCollection
     * @throws Exception 
     */
    public void editarCompras(Integer idCompras, String fechaCompras, Double monto, String estado, Pago idPago, Comprador idCliente, Collection<DetalleCompras> detalleComprasCollection) throws Exception {
        Compras em = new Compras();
        em.setIdCompras(idCompras);
        em.setIdCliente(idCliente);
        em.setFechaCompras(fechaCompras);
        em.setMonto(monto);
        em.setEstado(estado);
        em.setIdPago(idPago);    
        ComprasDAO empdao = new ComprasDAO();
        empdao.updateCompras(em);
    }

    /**
     * Metodo para eliminar compra por id
     * @param id
     * @throws Exception 
     */
    public void eliminarCompras(Integer id) throws Exception {
        ComprasDAO empdao = new ComprasDAO();
        empdao.deleteCompras(id);
    }

    /**
     * Metodo para listar compras
     * @return List
     */
    public List<Compras> listaComprass() {
        ComprasDAO emp = new ComprasDAO();
        List<Compras> compras = emp.readCompras();
        return compras;
    }
}
