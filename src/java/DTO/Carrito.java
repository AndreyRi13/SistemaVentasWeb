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
@Table(name = "carrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrito.findAll", query = "SELECT c FROM Carrito c"),
    @NamedQuery(name = "Carrito.findByIdCarrito", query = "SELECT c FROM Carrito c WHERE c.idCarrito = :idCarrito"),
    @NamedQuery(name = "Carrito.findByItem", query = "SELECT c FROM Carrito c WHERE c.item = :item"),
    @NamedQuery(name = "Carrito.findByPrecioCompra", query = "SELECT c FROM Carrito c WHERE c.precioCompra = :precioCompra"),
    @NamedQuery(name = "Carrito.findByCantidad", query = "SELECT c FROM Carrito c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "Carrito.findBySubTotal", query = "SELECT c FROM Carrito c WHERE c.subTotal = :subTotal")})
public class Carrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarrito")
    private Integer idCarrito;
    @Basic(optional = false)
    @Column(name = "item")
    private int item;
    @Basic(optional = false)
    @Column(name = "precioCompra")
    private double precioCompra;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "subTotal")
    private double subTotal;
    @JoinColumn(name = "idCalzado", referencedColumnName = "idCalzado")
    @ManyToOne(optional = false)
    private Calzado idCalzado;
    @JoinColumn(name = "idComprador", referencedColumnName = "idComprador")
    @ManyToOne(optional = false)
    private Comprador idComprador;
    @JoinColumn(name = "idPago", referencedColumnName = "idPago")
    @ManyToOne(optional = false)
    private Pago idPago;

    public Carrito() {
    }

    public Carrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Carrito(Integer idCarrito, int item, double precioCompra, int cantidad, double subTotal) {
        this.idCarrito = idCarrito;
        this.item = item;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public Carrito(int item, double precioCompra, int cantidad, double subTotal, Calzado idCalzado, Comprador idComprador, Pago idPago) {
        this.item = item;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.idCalzado = idCalzado;
        this.idComprador = idComprador;
        this.idPago = idPago;
    }

    
    
    public Integer getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Calzado getIdCalzado() {
        return idCalzado;
    }

    public void setIdCalzado(Calzado idCalzado) {
        this.idCalzado = idCalzado;
    }

    public Comprador getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Comprador idComprador) {
        this.idComprador = idComprador;
    }

    public Pago getIdPago() {
        return idPago;
    }

    public void setIdPago(Pago idPago) {
        this.idPago = idPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrito != null ? idCarrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrito)) {
            return false;
        }
        Carrito other = (Carrito) object;
        if ((this.idCarrito == null && other.idCarrito != null) || (this.idCarrito != null && !this.idCarrito.equals(other.idCarrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Carrito[ idCarrito=" + idCarrito + " ]";
    }
    
}
