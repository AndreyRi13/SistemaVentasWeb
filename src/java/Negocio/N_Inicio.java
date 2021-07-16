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
public class N_Inicio {

    public N_Inicio() {
    }
    
    
    public List<Calzado> listCalzados(){
       CalzadoDAO pr = new CalzadoDAO();
        List<Calzado> product = pr.readCalzados();
        return product;
    }
}
