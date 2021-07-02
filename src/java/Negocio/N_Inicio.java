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
public class N_Inicio {

    public N_Inicio() {
    }
    
    
    public List<Producto> listEmpleados(){
       ProductoDAO pr = new ProductoDAO();
        List<Producto> product = pr.readProductos();
        return product;
    }
}
