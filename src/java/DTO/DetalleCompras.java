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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrey R
 */
@Entity
@Table(name = "detalle_compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCompras.findAll", query = "SELECT d FROM DetalleCompras d"),
    @NamedQuery(name = "DetalleCompras.findByIdDetalle", query = "SELECT d FROM DetalleCompras d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleCompras.findByCantidad", query = "SELECT d FROM DetalleCompras d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleCompras.findByPrecioCompra", query = "SELECT d FROM DetalleCompras d WHERE d.precioCompra = :precioCompra")})
public class DetalleCompras implements Serializable {

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
    private Calzado idCalzado;
    @JoinColumn(name = "idCompras", referencedColumnName = "idCompras")
    @ManyToOne(optional = false)
    private Compras idCompras;

    public DetalleCompras() {
    }

    public DetalleCompras(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetalleCompras(Integer idDetalle, int cantidad, double precioCompra, Calzado idCalzado, Compras idCompras) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.idCalzado = idCalzado;
        this.idCompras = idCompras;
    }


    

    public DetalleCompras(int cantidad, double precioCompra, Calzado idCalzado, Compras idCompras) {

        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.idCalzado = idCalzado;
        this.idCompras = idCompras;
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

    public Calzado getIdCalzado() {
        return idCalzado;
    }

    public void setIdCalzado(Calzado idCalzado) {
        this.idCalzado = idCalzado;
    }

    public Compras getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(Compras idCompras) {
        this.idCompras = idCompras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompras)) {
            return false;
        }
        DetalleCompras other = (DetalleCompras) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.DetalleCompras[ idDetalle=" + idDetalle + " ]";
    }

}
