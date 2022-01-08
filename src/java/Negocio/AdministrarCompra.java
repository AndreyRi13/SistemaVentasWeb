/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.CompraDAO;
import DTO.Compra;
import DTO.Comprador;
import DTO.DetalleCompra;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Andrey
 */
public class AdministrarCompra {
     public boolean agregarCompra( int codigo, Date fechaCompra, double precioTotal, String estado) {
        CompraDAO empleado = new CompraDAO();
        Compra com = new Compra(  codigo,fechaCompra,  precioTotal, estado);

        try {
            empleado.addCompra(com);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para buscar  compras por id
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
     * Metodo para editar  compra
     * @param id
     * @param cantidad
     * @param precioCompra
     * @param idCalzado
     * @param idCompra
     * @throws Exception 
     */
    public void editarCompra(Integer idCompra,  int codigo, Date fechaCompra, double precioTotal, String estado) throws Exception {
        Compra em = new Compra();
        em.setIdCompra(idCompra);
        em.setCodigo(codigo);
        em.setFechaCompra(fechaCompra);
        em.setPrecioTotal(precioTotal);
        em.setEstado(estado);     
        CompraDAO comdao = new CompraDAO();
        comdao.updateCompra(em);
    }

    /**
     * Metodo para eliminar compra por id
     * @param id
     * @throws Exception 
     */
    public void eliminarCompra(Integer id) throws Exception {
        CompraDAO comdao = new CompraDAO();
        comdao.deleteCompra(id);
    }

    /**
     * Metodo para listar compras
     * @return List
     */
    public List<Compra> listaCompras() {
        CompraDAO emp = new CompraDAO();
        List<Compra> Compra = emp.readCompra();
        return Compra;
    }

    

}