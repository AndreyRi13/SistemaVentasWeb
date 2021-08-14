/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrey R
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "Empresa.findByRut", query = "SELECT e FROM Empresa e WHERE e.rut = :rut"),
    @NamedQuery(name = "Empresa.findByDireccion", query = "SELECT e FROM Empresa e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empresa.findByTelefonos", query = "SELECT e FROM Empresa e WHERE e.telefonos = :telefonos"),
    @NamedQuery(name = "Empresa.findByCorreoElectronico", query = "SELECT e FROM Empresa e WHERE e.correoElectronico = :correoElectronico")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpresa")
    private Integer idEmpresa;
    @Basic(optional = false)
    @Column(name = "rut")
    private int rut;
    @Basic(optional = false)
    @Lob
    @Column(name = "saludo")
    private String saludo;
    @Basic(optional = false)
    @Lob
    @Column(name = "nosotros")
    private String nosotros;
    @Basic(optional = false)
    @Lob
    @Column(name = "ofrecemos")
    private String ofrecemos;
    @Basic(optional = false)
    @Lob
    @Column(name = "porque_elegirnos")
    private String porqueElegirnos;
    @Basic(optional = false)
    @Lob
    @Column(name = "nuestros_clientes")
    private String nuestrosClientes;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefonos")
    private String telefonos;
    @Basic(optional = false)
    @Column(name = "correoElectronico")
    private String correoElectronico;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, int rut, String saludo, String nosotros, String ofrecemos, String porqueElegirnos, String nuestrosClientes, String direccion, String telefonos, String correoElectronico) {
        this.idEmpresa = idEmpresa;
        this.rut = rut;
        this.saludo = saludo;
        this.nosotros = nosotros;
        this.ofrecemos = ofrecemos;
        this.porqueElegirnos = porqueElegirnos;
        this.nuestrosClientes = nuestrosClientes;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.correoElectronico = correoElectronico;
    }
    
        public Empresa( int rut, String saludo, String nosotros, String ofrecemos, String porqueElegirnos, String nuestrosClientes, String direccion, String telefonos, String correoElectronico) {

        this.rut = rut;
        this.saludo = saludo;
        this.nosotros = nosotros;
        this.ofrecemos = ofrecemos;
        this.porqueElegirnos = porqueElegirnos;
        this.nuestrosClientes = nuestrosClientes;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.correoElectronico = correoElectronico;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public String getNosotros() {
        return nosotros;
    }

    public void setNosotros(String nosotros) {
        this.nosotros = nosotros;
    }

    public String getOfrecemos() {
        return ofrecemos;
    }

    public void setOfrecemos(String ofrecemos) {
        this.ofrecemos = ofrecemos;
    }

    public String getPorqueElegirnos() {
        return porqueElegirnos;
    }

    public void setPorqueElegirnos(String porqueElegirnos) {
        this.porqueElegirnos = porqueElegirnos;
    }

    public String getNuestrosClientes() {
        return nuestrosClientes;
    }

    public void setNuestrosClientes(String nuestrosClientes) {
        this.nuestrosClientes = nuestrosClientes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
