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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByIdCompras", query = "SELECT c FROM Compras c WHERE c.idCompras = :idCompras"),
    @NamedQuery(name = "Compras.findByFechaCompras", query = "SELECT c FROM Compras c WHERE c.fechaCompras = :fechaCompras"),
    @NamedQuery(name = "Compras.findByMonto", query = "SELECT c FROM Compras c WHERE c.monto = :monto"),
    @NamedQuery(name = "Compras.findByEstado", query = "SELECT c FROM Compras c WHERE c.estado = :estado")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCompras")
    private Integer idCompras;
    @Column(name = "fechaCompras")
    private String fechaCompras;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idPago", referencedColumnName = "idPago")
    @ManyToOne(optional = false)
    private Pago idPago;
    @JoinColumn(name = "idCliente", referencedColumnName = "idComprador")
    @ManyToOne(optional = false)
    private Comprador idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompras")
    private Collection<DetalleCompras> detalleComprasCollection;

    public Compras() {
    }

    public Compras(String fechaCompras, Double monto, String estado, Pago idPago, Comprador idCliente, Collection<DetalleCompras> detalleComprasCollection) {
        this.fechaCompras = fechaCompras;
        this.monto = monto;
        this.estado = estado;
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.detalleComprasCollection = detalleComprasCollection;
    }

    public Compras(Integer idCompras, String fechaCompras, Double monto, String estado, Pago idPago, Comprador idCliente, Collection<DetalleCompras> detalleComprasCollection) {
        this.idCompras = idCompras;
        this.fechaCompras = fechaCompras;
        this.monto = monto;
        this.estado = estado;
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.detalleComprasCollection = detalleComprasCollection;
    }


    public Integer getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(Integer idCompras) {
        this.idCompras = idCompras;
    }

    public String getFechaCompras() {
        return fechaCompras;
    }

    public void setFechaCompras(String fechaCompras) {
        this.fechaCompras = fechaCompras;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pago getIdPago() {
        return idPago;
    }

    public void setIdPago(Pago idPago) {
        this.idPago = idPago;
    }

    public Comprador getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Comprador idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public Collection<DetalleCompras> getDetalleComprasCollection() {
        return detalleComprasCollection;
    }

    public void setDetalleComprasCollection(Collection<DetalleCompras> detalleComprasCollection) {
        this.detalleComprasCollection = detalleComprasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompras != null ? idCompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.idCompras == null && other.idCompras != null) || (this.idCompras != null && !this.idCompras.equals(other.idCompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Compras[ idCompras=" + idCompras + " ]";
    }

}