/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrey
 */
@Entity
@Table(name = "comprador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprador.findAll", query = "SELECT c FROM Comprador c"),
    @NamedQuery(name = "Comprador.findByIdComprador", query = "SELECT c FROM Comprador c WHERE c.idComprador = :idComprador"),
    @NamedQuery(name = "Comprador.findByCedula", query = "SELECT c FROM Comprador c WHERE c.cedula = :cedula"),
    @NamedQuery(name = "Comprador.findByNombres", query = "SELECT c FROM Comprador c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Comprador.findByApellidos", query = "SELECT c FROM Comprador c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Comprador.findByFechaNacimiento", query = "SELECT c FROM Comprador c WHERE c.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Comprador.findByEdad", query = "SELECT c FROM Comprador c WHERE c.edad = :edad"),
    @NamedQuery(name = "Comprador.findByGenero", query = "SELECT c FROM Comprador c WHERE c.genero = :genero"),
    @NamedQuery(name = "Comprador.findByUsername", query = "SELECT c FROM Comprador c WHERE c.username = :username"),
    @NamedQuery(name = "Comprador.findByPassword", query = "SELECT c FROM Comprador c WHERE c.password = :password"),
    @NamedQuery(name = "Comprador.findByDireccion", query = "SELECT c FROM Comprador c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Comprador.findByNumeroCelular", query = "SELECT c FROM Comprador c WHERE c.numeroCelular = :numeroCelular"),
    @NamedQuery(name = "Comprador.findByCorreoElectronico", query = "SELECT c FROM Comprador c WHERE c.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Comprador.findByEstado", query = "SELECT c FROM Comprador c WHERE c.estado = :estado")})
public class Comprador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComprador")
    private Integer idComprador;
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "numeroCelular")
    private String numeroCelular;
    @Basic(optional = false)
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;

    public Comprador() {
    }

    public Comprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public Comprador(String cedula, String nombres, String apellidos, Date fechaNacimiento, int edad, String genero, String username, String password, String direccion, String numeroCelular, String correoElectronico, String estado) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.genero = genero;
        this.username = username;
        this.password = password;
        this.direccion = direccion;
        this.numeroCelular = numeroCelular;
        this.correoElectronico = correoElectronico;
        this.estado = estado;
    }

    public Comprador(Integer idComprador, String cedula, String nombres, String apellidos, int edad, String genero, String username, String password, String direccion, String numeroCelular, String correoElectronico, String estado) {
        this.idComprador = idComprador;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
        this.username = username;
        this.password = password;
        this.direccion = direccion;
        this.numeroCelular = numeroCelular;
        this.correoElectronico = correoElectronico;
        this.estado = estado;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComprador != null ? idComprador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprador)) {
            return false;
        }
        Comprador other = (Comprador) object;
        if ((this.idComprador == null && other.idComprador != null) || (this.idComprador != null && !this.idComprador.equals(other.idComprador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Comprador[ idComprador=" + idComprador + " ]";
    }
    
}
