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

    public AdministrarPago() {
    }

    
    
 
    /**
     * Metodo para agregar Pago
     * @param monto
     * @param estado
     * @return boolean
     */
    
    
    
    
    public boolean agregarPago(Integer codigo,Double monto, String estado) {
        PagoDAO pago = new PagoDAO();
        Pago emp = new Pago(codigo, monto, estado);

        try {
            pago.addPago(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para buscar pago por id
     * @param idPago
     * @return Pago
     * @throws Exception 
     */
    public Pago buscarPagoporId(Integer idPago) throws Exception {
        PagoDAO emp = new PagoDAO();
        List<Pago> pagosList = emp.readPagos();
        Pago aux = null;
        for (Pago m : pagosList) {
            if (m.getIdPago().equals(idPago)) {
                aux = m;
            }
        }
        return aux;
    }
    
     public Pago buscarPagoporCodigo(Integer codigo) throws Exception {
        PagoDAO emp = new PagoDAO();
        List<Pago> pagosList = emp.readPagos();
        Pago aux = null;
        for (Pago m : pagosList) {
           if (m.getIdPago().equals(codigo)) {
                aux = m;
            }
        }
        return aux;
    }
    
    
 public boolean CodigoRepetido(Integer codigo) throws Exception {
        PagoDAO emp = new PagoDAO();
        List<Pago> pagosList = emp.readPagos();
        Pago aux = null;
        for (Pago m : pagosList) {
           if (m.getCodigo()==codigo) {
              return true;
            }
        }
        return false;
    }
       
    
    
    
    /**
     * Metodo para editar pago
     * @param idPago
     * @param monto
     * @param estado
     * @throws Exception 
     */
    public void editarPago(Integer idPago, Integer codigo,Double monto, String estado) throws Exception {
        Pago em = new Pago();
        em.setIdPago(idPago);
        em.setCodigo(codigo);
        em.setMonto(monto);
        em.setEstado(estado);

        PagoDAO empdao = new PagoDAO();
        empdao.updatePago(em);
    }

    /**
     * Metodo para eliminar pago por id
     * @param id
     * @throws Exception 
     */
    public void eliminarPago(Integer id) throws Exception {
        PagoDAO empdao = new PagoDAO();
        empdao.deletePago(id);
    }

    /**
     * Metodo para listar pagos
     * @return List
     */
    public List<Pago> listaPagos() {
        PagoDAO emp = new PagoDAO();
        List<Pago> pago = emp.readPagos();
        return pago;
    }
}
