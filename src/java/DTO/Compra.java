/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrey
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByIdCompra", query = "SELECT c FROM Compra c WHERE c.idCompra = :idCompra"),
    @NamedQuery(name = "Compra.findByCodigo", query = "SELECT c FROM Compra c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Compra.findByFechaCompra", query = "SELECT c FROM Compra c WHERE c.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "Compra.findByPrecioTotal", query = "SELECT c FROM Compra c WHERE c.precioTotal = :precioTotal"),
    @NamedQuery(name = "Compra.findByEstado", query = "SELECT c FROM Compra c WHERE c.estado = :estado"),
    @NamedQuery(name = "Compra.findByIdPago", query = "SELECT c FROM Compra c WHERE c.idPago = :idPago"),
    @NamedQuery(name = "Compra.findByIdCliente", query = "SELECT c FROM Compra c WHERE c.idCliente = :idCliente")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompra")
    private Integer idCompra;
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "fechaCompra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Basic(optional = false)
    @Column(name = "precioTotal")
    private double precioTotal;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idCliente", referencedColumnName = "idComprador")
    @ManyToOne(optional = false)
    private Integer idCliente;
    @JoinColumn(name = "idPago", referencedColumnName = "idPago")
    @ManyToOne(optional = false)
    private Integer idPago;
    

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Compra(Integer idCompra, int codigo, double precioTotal, String estado) {
        this.idCompra = idCompra;
        this.codigo = codigo;
        this.precioTotal = precioTotal;
        this.estado = estado;
    }

    public Compra(int codigo, Date fechaCompra, double precioTotal, String estado, Integer idCliente, Integer idPago) {
        this.codigo = codigo;
        this.fechaCompra = fechaCompra;
        this.precioTotal = precioTotal;
        this.estado = estado;
        this.idCliente = idCliente;
        this.idPago = idPago;
     
    }
    
    
    

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

 

    @Override
    public String toString() {
        return "DTO.Compra[ idCompra=" + idCompra + " ]";
    }
    
}
