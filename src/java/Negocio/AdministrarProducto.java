/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.ProductoDAO;
import DTO.Producto;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class AdministrarProducto {

    public AdministrarProducto() {
    }

    /*CRUD PRODUCTO*/
    public boolean agregarProducto(Integer referencia, String nombres, String descripcion, String marca, String color, String colorSuela, Integer talla, Double precio, Integer stock, String estado, String Foto) {

        ProductoDAO producto = new ProductoDAO();

        Producto pro = new Producto();

        pro.setReferencia(referencia);
        pro.setNombres(nombres);
        pro.setDescripcion(descripcion);
        pro.setMarca(marca);
        pro.setColor(color);
        pro.setColorSuela(colorSuela);
        pro.setTalla(talla);
        pro.setPrecio(precio);
        pro.setStock(stock);
        pro.setEstado(estado);
        pro.setFoto(Foto);

        try {
            producto.addProducto(pro);
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    public List<Producto> listaProductos() {
        ProductoDAO pro = new ProductoDAO();
        List<Producto> productos = pro.readProductos();
        return productos;
    }

    
        public Producto buscarProductoporId(Integer idProducto) throws Exception {
        ProductoDAO pro = new ProductoDAO();
        List<Producto> productosList = pro.readProductos();
        Producto aux = null;
        for (Producto m : productosList) {
            if (m.getIdProducto().equals(idProducto)) {
                aux = m;
            }
        }
        return aux;
    }
    
    public void editarProducto(Integer idProducto, Integer referencia, String nombres, String descripcion, String marca, String color, String colorSuela, Integer talla, double precio, Integer stock, String estado, String Foto) throws Exception {
        Producto pro = new Producto();
        pro.setIdProducto(idProducto);
        pro.setReferencia(referencia);
        pro.setNombres(nombres);
        pro.setDescripcion(descripcion);
        pro.setMarca(marca);
        pro.setColor(color);
        pro.setColorSuela(colorSuela);
        pro.setTalla(talla);
        pro.setPrecio(precio);
        pro.setStock(stock);
        pro.setEstado(estado);
        pro.setFoto(Foto);
        ProductoDAO prodao = new ProductoDAO();
        prodao.updateProducto(pro);
    }

    public void eliminarProduct(Integer id) throws Exception {
        ProductoDAO prodao = new ProductoDAO();
        prodao.deleteProducto(id);
    }

}
