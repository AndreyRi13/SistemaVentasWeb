/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.CalzadoDAO;
import DTO.Calzado;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class AdministrarCalzado {

    public AdministrarCalzado() {
    }

   
    /**
     * Metodo para agregar calzado
     * @param referencia
     * @param nombres
     * @param descripcion
     * @param modelo
     * @param color
     * @param colorSuela
     * @param talla
     * @param precio
     * @param stock
     * @param estado
     * @param Foto
     * @return 
     */
    public boolean agregarCalzado(Integer referencia, String nombres, String descripcion, String modelo, String color, String colorSuela, Integer talla, Double precio, Integer stock, String estado, String Foto) {

        CalzadoDAO Calzado = new CalzadoDAO();

        Calzado pro = new Calzado();

        pro.setReferencia(referencia);
        pro.setNombres(nombres);
        pro.setDescripcion(descripcion);
        pro.setModelo(modelo);
        pro.setColor(color);
        pro.setColorSuela(colorSuela);
        pro.setTalla(talla);
        pro.setPrecio(precio);
        pro.setStock(stock);
        pro.setEstado(estado);
        pro.setFoto(Foto);

        try {
            Calzado.addCalzado(pro);
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    /**
     * Metodo para listar calzados
     * @return List
     */
    public List<Calzado> listaCalzados() {
        CalzadoDAO pro = new CalzadoDAO();
        List<Calzado> Calzados = pro.readCalzados();
        return Calzados;
    }

    /**
     * Metodo para buscar calzados por id
     * @param idCalzado
     * @return Calzado
     */
    public Calzado buscarCalzadoporId(Integer idCalzado) {
        CalzadoDAO pro = new CalzadoDAO();
        for (Calzado m : pro.readCalzados()) {
            if (m.getIdCalzado().equals(idCalzado)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Metodo para editar calzado
     * @param idCalzado
     * @param referencia
     * @param nombres
     * @param descripcion
     * @param modelo
     * @param color
     * @param colorSuela
     * @param talla
     * @param precio
     * @param stock
     * @param estado
     * @param Foto
     * @throws Exception 
     */
    public void editarCalzado(Integer idCalzado, Integer referencia, String nombres, String descripcion, String modelo, String color, String colorSuela, Integer talla, double precio, Integer stock, String estado, String Foto) throws Exception {
        Calzado pro = new Calzado();
        pro.setIdCalzado(idCalzado);
        pro.setReferencia(referencia);
        pro.setNombres(nombres);
        pro.setDescripcion(descripcion);
        pro.setModelo(modelo);
        pro.setColor(color);
        pro.setColorSuela(colorSuela);
        pro.setTalla(talla);
        pro.setPrecio(precio);
        pro.setStock(stock);
        pro.setEstado(estado);
        pro.setFoto(Foto);
        CalzadoDAO prodao = new CalzadoDAO();
        prodao.updateCalzado(pro);
    }

    /**
     * Metodo para eliminar calzado por id
     * @param id
     * @throws Exception 
     */
    public void eliminarProduct(Integer id) throws Exception {
        CalzadoDAO prodao = new CalzadoDAO();
        prodao.deleteCalzado(id);
    }

}
