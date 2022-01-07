/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.EmpresaDAO;
import DTO.Empresa;
import java.util.List;

/**
 *
 * @author Andrey R
 */
public class AdministrarEmpresa {

    public AdministrarEmpresa() {
    }

  
    /**
     * Metodo para agregar empresa
     * @param rut
     * @param saludo
     * @param nosotros
     * @param ofrecemos
     * @param elegirnos
     * @param nuestroClientes
     * @param direccion
     * @param telefonos
     * @param correoElectronico
     * @return boolean
     */
    public boolean agregarEmpresa(Integer rut, String saludo, String nosotros, String ofrecemos, String elegirnos, String nuestroClientes, String direccion, String telefonos, String correoElectronico) {
        EmpresaDAO empresa = new EmpresaDAO();
        Empresa emp = new Empresa(rut, saludo, nosotros, ofrecemos, elegirnos, nuestroClientes, direccion, telefonos, correoElectronico);

        try {
            empresa.addEmpresa(emp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para buscar empresa por id
     * @param idEmpresa
     * @return Empresa
     * @throws Exception 
     */
    public Empresa buscarEmpresaporId(Integer idEmpresa) throws Exception {
        EmpresaDAO emp = new EmpresaDAO();
        List<Empresa> empresasList = emp.readEmpresas();
        Empresa aux = null;
        for (Empresa m : empresasList) {
            if (m.getIdEmpresa().equals(idEmpresa)) {
                aux = m;
            }
        }
        return aux;
    }

    /**
     * Metodo para editar empresa
     * @param idEmpresa
     * @param rut
     * @param saludo
     * @param nosotros
     * @param ofrecemos
     * @param elegirnos
     * @param nuestroClientes
     * @param direccion
     * @param telefonos
     * @param correoElectronico
     * @throws Exception 
     */
    public void editarEmpresa(Integer idEmpresa, Integer rut, String saludo, String nosotros, String ofrecemos, String elegirnos, String nuestroClientes, String direccion, String telefonos, String correoElectronico) throws Exception {
        Empresa em = new Empresa();
        em.setIdEmpresa(idEmpresa);
        em.setRut(rut);
        em.setSaludo(saludo);
        em.setNosotros(nosotros);
        em.setOfrecemos(ofrecemos);
        em.setPorqueElegirnos(elegirnos);
        em.setNuestrosClientes(nuestroClientes);
        em.setDireccion(direccion);
        em.setTelefonos(telefonos);
        em.setCorreoElectronico(correoElectronico);

        EmpresaDAO empdao = new EmpresaDAO();
        empdao.updateEmpresa(em);

    }

    /**
     * Metodo para eliminar empresa por id
     * @param id
     * @throws Exception 
     */
    public void eliminarEmpresa(Integer id) throws Exception {
        EmpresaDAO empdao = new EmpresaDAO();
        empdao.deleteEmpresa(id);
    }

    /**
     * Metodo para listar empresa
     * @return List
     */
    public List<Empresa> listaEmpresas() {
        EmpresaDAO emp = new EmpresaDAO();
        List<Empresa> empresas = emp.readEmpresas();
        return empresas;
    }

}
