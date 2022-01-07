/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Empresa;
import Persistencia.EmpresaJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey R
 */
public class EmpresaDAO {
 EmpresaJpaController empresa;

    public EmpresaDAO() {

        Conexion con = Conexion.getConexion();
        this.empresa = new EmpresaJpaController(con.getBd());

    }

    /**
     * 
     * @return List
     */
    public List<Empresa> readEmpresas() {
        return this.empresa.findEmpresaEntities();
    }

    /**
     * 
     * @param idEmpresa
     * @return Empresa
     */
    public Empresa findEmpresa(int idEmpresa) {
        return this.empresa.findEmpresa(idEmpresa);
    }

    /**
     * 
     * @param emp
     * @throws Exception 
     */
    public void addEmpresa(Empresa emp) throws Exception {
            this.empresa.create(emp);
    }
    
    /**
     * 
     * @param idEm
     * @return boolean
     */
    public boolean deleteEmpresa(Integer idEm){
    
        try {
            empresa.destroy(idEm);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }   
    }
    
    /**
     * 
     * @param e
     * @return boolean
     */
    public boolean updateEmpresa(Empresa e){
        try {
            empresa.edit(e);
            return true;
        } catch (Exception ex) {        
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

