/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrey
 */
@Entity
@Table(name = "detalle_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCompra.findAll", query = "SELECT d FROM DetalleCompra d"),
    @NamedQuery(name = "DetalleCompra.findByIdDetalle", query = "SELECT d FROM DetalleCompra d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleCompra.findByCantidad", query = "SELECT d FROM DetalleCompra d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleCompra.findByPrecioCompra", query = "SELECT d FROM DetalleCompra d WHERE d.precioCompra = :precioCompra"),
    @NamedQuery(name = "DetalleCompra.findByIdCalzado", query = "SELECT d FROM DetalleCompra d WHERE d.idCalzado = :idCalzado"),
    @NamedQuery(name = "DetalleCompra.findByIdCompra", query = "SELECT d FROM DetalleCompra d WHERE d.idCompra = :idCompra")})
public class DetalleCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDetalle")
    private Integer idDetalle;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precioCompra")
    private double precioCompra;
    @JoinColumn(name = "idCalzado", referencedColumnName = "idCalzado")
    @ManyToOne(optional = false)
    private Integer idCalzado;
    @JoinColumn(name = "idCompra", referencedColumnName = "idCompra")
    @ManyToOne(optional = false)
    private Integer idCompra;

    public DetalleCompra() {
    }

    public DetalleCompra(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetalleCompra(Integer idDetalle, int cantidad, double precioCompra) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
    }

    public DetalleCompra(int cantidad, double precioCompra, Integer idCalzado, Integer idCompra) {
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.idCalzado = idCalzado;
        this.idCompra = idCompra;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Integer getIdCalzado() {
        return idCalzado;
    }

    public void setIdCalzado(Integer idCalzado) {
        this.idCalzado = idCalzado;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "DTO.DetalleCompra[ idDetalle=" + idDetalle + " ]";
    }

}
