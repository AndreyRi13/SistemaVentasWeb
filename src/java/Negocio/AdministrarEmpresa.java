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

    /*CRUD EMPRESA*/
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

    public void eliminarEmpresa(Integer id) throws Exception {
        EmpresaDAO empdao = new EmpresaDAO();
        empdao.deleteEmpresa(id);
    }

    public List<Empresa> listaEmpresas() {
        EmpresaDAO emp = new EmpresaDAO();
        List<Empresa> empresas = emp.readEmpresas();
        return empresas;
    }

}
