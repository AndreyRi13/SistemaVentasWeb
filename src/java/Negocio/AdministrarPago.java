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

    /*CRUD Pago*/
    public boolean agregarPago(Double monto, String estado) {
        PagoDAO pago = new PagoDAO();
        Pago emp = new Pago(monto, estado);

        try {
            pago.addPago(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

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

    public void editarPago(Integer idPago, Double monto, String estado) throws Exception {
        Pago em = new Pago();
        em.setIdPago(idPago);
        em.setMonto(monto);
        em.setEstado(estado);

        PagoDAO empdao = new PagoDAO();
        empdao.updatePago(em);
    }

    public void eliminarPago(Integer id) throws Exception {
        PagoDAO empdao = new PagoDAO();
        empdao.deletePago(id);
    }

    public List<Pago> listaPagos() {
        PagoDAO emp = new PagoDAO();
        List<Pago> pago = emp.readPagos();
        return pago;
    }
}
