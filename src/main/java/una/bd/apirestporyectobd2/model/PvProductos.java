/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roberth
 */
@Entity
@Table(name = "PV_PRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvProductos.findAll", query = "SELECT p FROM PvProductos p"),
    @NamedQuery(name = "PvProductos.findByProId", query = "SELECT p FROM PvProductos p WHERE p.proId = :proId"),
    @NamedQuery(name = "PvProductos.findByProNombre", query = "SELECT p FROM PvProductos p WHERE p.proNombre = :proNombre"),
    @NamedQuery(name = "PvProductos.findByProCantidad", query = "SELECT p FROM PvProductos p WHERE p.proCantidad = :proCantidad"),
    @NamedQuery(name = "PvProductos.findByProDescuentoMaximo", query = "SELECT p FROM PvProductos p WHERE p.proDescuentoMaximo = :proDescuentoMaximo"),
    @NamedQuery(name = "PvProductos.findByProVencimiento", query = "SELECT p FROM PvProductos p WHERE p.proVencimiento = :proVencimiento"),
    @NamedQuery(name = "PvProductos.findByProIngreso", query = "SELECT p FROM PvProductos p WHERE p.proIngreso = :proIngreso"),
    @NamedQuery(name = "PvProductos.findByProEstado", query = "SELECT p FROM PvProductos p WHERE p.proEstado = :proEstado")})
public class PvProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_ID")
    private BigDecimal proId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "PRO_NOMBRE")
    private String proNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_CANTIDAD")
    private BigInteger proCantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_DESCUENTO_MAXIMO")
    private double proDescuentoMaximo;
    @Column(name = "PRO_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proVencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_ESTADO")
    private Character proEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pvProductos")
    private List<PvDescLiquidacion> pvDescLiquidacionList;
    @JoinColumn(name = "PRO_FAMILIA", referencedColumnName = "FAM_ID")
    @ManyToOne(optional = false)
    private PvFamilias proFamilia;
    @JoinColumn(name = "PRO_INVENTARIO", referencedColumnName = "INV_ID")
    @ManyToOne(optional = false)
    private PvInventarios proInventario;
    @JoinColumn(name = "PRO_PROVEDOR", referencedColumnName = "PRO_ID")
    @ManyToOne(optional = false)
    private PvProveedores proProvedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pvProductos")
    private List<PvProdPromo> pvProdPromoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movProducto")
    private List<PvMovimientos> pvMovimientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preProducto")
    private List<PvPrecios> pvPreciosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProducto")
    private List<PvCodigosBarras> pvCodigosBarrasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pvProductos")
    private List<PvDetallFacVenta> pvDetallFacVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pvProductos")
    private List<PvDetallFacCompra> pvDetallFacCompraList;

    public PvProductos() {
    }

    public PvProductos(BigDecimal proId) {
        this.proId = proId;
    }

    public PvProductos(BigDecimal proId, String proNombre, BigInteger proCantidad, double proDescuentoMaximo, Date proIngreso, Character proEstado) {
        this.proId = proId;
        this.proNombre = proNombre;
        this.proCantidad = proCantidad;
        this.proDescuentoMaximo = proDescuentoMaximo;
        this.proIngreso = proIngreso;
        this.proEstado = proEstado;
    }

    public BigDecimal getProId() {
        return proId;
    }

    public void setProId(BigDecimal proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public BigInteger getProCantidad() {
        return proCantidad;
    }

    public void setProCantidad(BigInteger proCantidad) {
        this.proCantidad = proCantidad;
    }

    public double getProDescuentoMaximo() {
        return proDescuentoMaximo;
    }

    public void setProDescuentoMaximo(double proDescuentoMaximo) {
        this.proDescuentoMaximo = proDescuentoMaximo;
    }

    public Date getProVencimiento() {
        return proVencimiento;
    }

    public void setProVencimiento(Date proVencimiento) {
        this.proVencimiento = proVencimiento;
    }

    public Date getProIngreso() {
        return proIngreso;
    }

    public void setProIngreso(Date proIngreso) {
        this.proIngreso = proIngreso;
    }

    public Character getProEstado() {
        return proEstado;
    }

    public void setProEstado(Character proEstado) {
        this.proEstado = proEstado;
    }

    @XmlTransient
    public List<PvDescLiquidacion> getPvDescLiquidacionList() {
        return pvDescLiquidacionList;
    }

    public void setPvDescLiquidacionList(List<PvDescLiquidacion> pvDescLiquidacionList) {
        this.pvDescLiquidacionList = pvDescLiquidacionList;
    }

    public PvFamilias getProFamilia() {
        return proFamilia;
    }

    public void setProFamilia(PvFamilias proFamilia) {
        this.proFamilia = proFamilia;
    }

    public PvInventarios getProInventario() {
        return proInventario;
    }

    public void setProInventario(PvInventarios proInventario) {
        this.proInventario = proInventario;
    }

    public PvProveedores getProProvedor() {
        return proProvedor;
    }

    public void setProProvedor(PvProveedores proProvedor) {
        this.proProvedor = proProvedor;
    }

    @XmlTransient
    public List<PvProdPromo> getPvProdPromoList() {
        return pvProdPromoList;
    }

    public void setPvProdPromoList(List<PvProdPromo> pvProdPromoList) {
        this.pvProdPromoList = pvProdPromoList;
    }

    @XmlTransient
    public List<PvMovimientos> getPvMovimientosList() {
        return pvMovimientosList;
    }

    public void setPvMovimientosList(List<PvMovimientos> pvMovimientosList) {
        this.pvMovimientosList = pvMovimientosList;
    }

    @XmlTransient
    public List<PvPrecios> getPvPreciosList() {
        return pvPreciosList;
    }

    public void setPvPreciosList(List<PvPrecios> pvPreciosList) {
        this.pvPreciosList = pvPreciosList;
    }

    @XmlTransient
    public List<PvCodigosBarras> getPvCodigosBarrasList() {
        return pvCodigosBarrasList;
    }

    public void setPvCodigosBarrasList(List<PvCodigosBarras> pvCodigosBarrasList) {
        this.pvCodigosBarrasList = pvCodigosBarrasList;
    }

    @XmlTransient
    public List<PvDetallFacVenta> getPvDetallFacVentaList() {
        return pvDetallFacVentaList;
    }

    public void setPvDetallFacVentaList(List<PvDetallFacVenta> pvDetallFacVentaList) {
        this.pvDetallFacVentaList = pvDetallFacVentaList;
    }

    @XmlTransient
    public List<PvDetallFacCompra> getPvDetallFacCompraList() {
        return pvDetallFacCompraList;
    }

    public void setPvDetallFacCompraList(List<PvDetallFacCompra> pvDetallFacCompraList) {
        this.pvDetallFacCompraList = pvDetallFacCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvProductos)) {
            return false;
        }
        PvProductos other = (PvProductos) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "una.bd.apirestporyectobd2.model.PvProductos[ proId=" + proId + " ]";
    }
    
}
