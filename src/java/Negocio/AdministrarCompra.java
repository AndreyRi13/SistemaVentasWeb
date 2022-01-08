/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.CompraDAO;
import DTO.Compra;
import DTO.Comprador;
import DTO.DetalleCompra;
import DTO.Pago;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Andrey
 */
public class AdministrarCompra {
     public boolean agregarCompra( int codigo, Date fechaCompra, double precioTotal, String estado,Comprador idcomprador,Pago idPago, Collection<DetalleCompra> detalleCompraCollection) {
        CompraDAO empleado = new CompraDAO();
        Compra com = new Compra(  codigo,  fechaCompra,  precioTotal, estado,idcomprador,idPago,detalleCompraCollection);

        try {
            empleado.addCompra(com);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para buscar detalle de compras por id
     * @param idCompra
     * @return Compra
     * @throws Exception 
     */
    public Compra buscarCompraporId(Integer idCompra) throws Exception {
        CompraDAO emp = new CompraDAO();
        List<Compra> Compra = emp.readCompra();
        Compra aux = null;
        for (Compra m : Compra) {
            if (m.getIdCompra().equals(idCompra)) {
                aux = m;
            }
        }
        return aux;
    }
    
    public Compra buscarCompraporCodigo(Integer codigo) throws Exception {
        CompraDAO emp = new CompraDAO();
        List<Compra> Compra = emp.readCompra();
        Compra aux = null;
        for (Compra m : Compra) {
           if (m.getCodigo()==codigo) {
                aux = m;
            }
        }
        return aux;
    }
    
    public boolean CodigoRepetido(Integer codigo) throws Exception {
        CompraDAO emp = new CompraDAO();
        List<Compra> Compra = emp.readCompra();
        Compra aux = null;
        for (Compra m : Compra) {
            if (m.getCodigo()==codigo) {
                return true;
            }
        }
        return false;
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
    public void editarCompra(Integer idCompra, int codigo, Date fechaCompra, double precioTotal, String estado, Collection<DetalleCompra> detalleCompraCollection) throws Exception {
        Compra em = new Compra();
        em.setIdCompra(idCompra);
        em.setCodigo(codigo);
        em.setFechaCompra(fechaCompra);
        em.setPrecioTotal(precioTotal);
        em.setEstado(estado);
        em.setDetalleCompraCollection(detalleCompraCollection);
        CompraDAO comdao = new CompraDAO();
        comdao.updateCompra(em);
    }

    /**
     * Metodo para eliminar detalle de compra por id
     * @param id
     * @throws Exception 
     */
    public void eliminarCompra(Integer id) throws Exception {
        CompraDAO comdao = new CompraDAO();
        comdao.deleteCompra(id);
    }

    /**
     * Metodo para listar detalles de compras
     * @return List
     */
    public List<Compra> listaCompras() {
        CompraDAO emp = new CompraDAO();
        List<Compra> Compra = emp.readCompra();
        return Compra;
    }

}