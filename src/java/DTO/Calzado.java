/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrey R
 */
@Entity
@Table(name = "calzado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calzado.findAll", query = "SELECT c FROM Calzado c"),
    @NamedQuery(name = "Calzado.findByIdCalzado", query = "SELECT c FROM Calzado c WHERE c.idCalzado = :idCalzado"),
    @NamedQuery(name = "Calzado.findByReferencia", query = "SELECT c FROM Calzado c WHERE c.referencia = :referencia"),
    @NamedQuery(name = "Calzado.findByNombres", query = "SELECT c FROM Calzado c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Calzado.findByDescripcion", query = "SELECT c FROM Calzado c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Calzado.findByMarca", query = "SELECT c FROM Calzado c WHERE c.marca = :marca"),
    @NamedQuery(name = "Calzado.findByColor", query = "SELECT c FROM Calzado c WHERE c.color = :color"),
    @NamedQuery(name = "Calzado.findByColorSuela", query = "SELECT c FROM Calzado c WHERE c.colorSuela = :colorSuela"),
    @NamedQuery(name = "Calzado.findByTalla", query = "SELECT c FROM Calzado c WHERE c.talla = :talla"),
    @NamedQuery(name = "Calzado.findByPrecio", query = "SELECT c FROM Calzado c WHERE c.precio = :precio"),
    @NamedQuery(name = "Calzado.findByStock", query = "SELECT c FROM Calzado c WHERE c.stock = :stock"),
    @NamedQuery(name = "Calzado.findByEstado", query = "SELECT c FROM Calzado c WHERE c.estado = :estado"),
    @NamedQuery(name = "Calzado.findByFoto", query = "SELECT c FROM Calzado c WHERE c.foto = :foto")})
public class Calzado implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCalzado")
    private Collection<DetalleCompras> detalleComprasCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCalzado")
    private Integer idCalzado;
    @Basic(optional = false)
    @Column(name = "referencia")
    private int referencia;
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "colorSuela")
    private String colorSuela;
    @Basic(optional = false)
    @Column(name = "talla")
    private int talla;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "foto")
    private String foto;

    public Calzado() {
    }

    public Calzado(Integer idCalzado) {
        this.idCalzado = idCalzado;
    }

    public Calzado(Integer idCalzado, int referencia, String descripcion, String marca, String color, String colorSuela, int talla, String foto) {
        this.idCalzado = idCalzado;
        this.referencia = referencia;
        this.descripcion = descripcion;
        this.marca = marca;
        this.color = color;
        this.colorSuela = colorSuela;
        this.talla = talla;
        this.foto = foto;
    }

    public Integer getIdCalzado() {
        return idCalzado;
    }

    public void setIdCalzado(Integer idCalzado) {
        this.idCalzado = idCalzado;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorSuela() {
        return colorSuela;
    }

    public void setColorSuela(String colorSuela) {
        this.colorSuela = colorSuela;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalzado != null ? idCalzado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calzado)) {
            return false;
        }
        Calzado other = (Calzado) object;
        if ((this.idCalzado == null && other.idCalzado != null) || (this.idCalzado != null && !this.idCalzado.equals(other.idCalzado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Calzado{" + "idCalzado=" + idCalzado + ", referencia=" + referencia + ", nombres=" + nombres + ", descripcion=" + descripcion + ", marca=" + marca + ", color=" + color + ", colorSuela=" + colorSuela + ", talla=" + talla + ", precio=" + precio + ", stock=" + stock + ", estado=" + estado + ", foto=" + foto + '}';
    }

    @XmlTransient
    public Collection<DetalleCompras> getDetalleComprasCollection() {
        return detalleComprasCollection;
    }

    public void setDetalleComprasCollection(Collection<DetalleCompras> detalleComprasCollection) {
        this.detalleComprasCollection = detalleComprasCollection;
    }
  
    
}
