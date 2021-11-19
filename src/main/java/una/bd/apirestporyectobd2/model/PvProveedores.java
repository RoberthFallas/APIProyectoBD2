/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roberth
 */
@Entity
@Table(name = "PV_PROVEEDORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvProveedores.findAll", query = "SELECT p FROM PvProveedores p"),
    @NamedQuery(name = "PvProveedores.findByProId", query = "SELECT p FROM PvProveedores p WHERE p.proId = :proId"),
    @NamedQuery(name = "PvProveedores.findByProNombre", query = "SELECT p FROM PvProveedores p WHERE p.proNombre = :proNombre"),
    @NamedQuery(name = "PvProveedores.findByProTelefono", query = "SELECT p FROM PvProveedores p WHERE p.proTelefono = :proTelefono"),
    @NamedQuery(name = "PvProveedores.findByProCorreo", query = "SELECT p FROM PvProveedores p WHERE p.proCorreo = :proCorreo")})
public class PvProveedores implements Serializable {

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
    @Size(min = 1, max = 24)
    @Column(name = "PRO_TELEFONO")
    private String proTelefono;
    @Size(max = 64)
    @Column(name = "PRO_CORREO")
    private String proCorreo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proProvedor")
    private List<PvProductos> pvProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pvProveedores")
    private List<PvLimiteCredito> pvLimiteCreditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facProvedor")
    private List<PvFacturasCompra> pvFacturasCompraList;
    @OneToMany(mappedBy = "decProveedor")
    private List<PvDescuentos> pvDescuentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cueProveedor")
    private List<PvCuentasPagar> pvCuentasPagarList;

    public PvProveedores() {
    }

    public PvProveedores(BigDecimal proId) {
        this.proId = proId;
    }

    public PvProveedores(BigDecimal proId, String proNombre, String proTelefono) {
        this.proId = proId;
        this.proNombre = proNombre;
        this.proTelefono = proTelefono;
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

    public String getProTelefono() {
        return proTelefono;
    }

    public void setProTelefono(String proTelefono) {
        this.proTelefono = proTelefono;
    }

    public String getProCorreo() {
        return proCorreo;
    }

    public void setProCorreo(String proCorreo) {
        this.proCorreo = proCorreo;
    }

    @XmlTransient
    public List<PvProductos> getPvProductosList() {
        return pvProductosList;
    }

    public void setPvProductosList(List<PvProductos> pvProductosList) {
        this.pvProductosList = pvProductosList;
    }

    @XmlTransient
    public List<PvLimiteCredito> getPvLimiteCreditoList() {
        return pvLimiteCreditoList;
    }

    public void setPvLimiteCreditoList(List<PvLimiteCredito> pvLimiteCreditoList) {
        this.pvLimiteCreditoList = pvLimiteCreditoList;
    }

    @XmlTransient
    public List<PvFacturasCompra> getPvFacturasCompraList() {
        return pvFacturasCompraList;
    }

    public void setPvFacturasCompraList(List<PvFacturasCompra> pvFacturasCompraList) {
        this.pvFacturasCompraList = pvFacturasCompraList;
    }

    @XmlTransient
    public List<PvDescuentos> getPvDescuentosList() {
        return pvDescuentosList;
    }

    public void setPvDescuentosList(List<PvDescuentos> pvDescuentosList) {
        this.pvDescuentosList = pvDescuentosList;
    }

    @XmlTransient
    public List<PvCuentasPagar> getPvCuentasPagarList() {
        return pvCuentasPagarList;
    }

    public void setPvCuentasPagarList(List<PvCuentasPagar> pvCuentasPagarList) {
        this.pvCuentasPagarList = pvCuentasPagarList;
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
        if (!(object instanceof PvProveedores)) {
            return false;
        }
        PvProveedores other = (PvProveedores) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "una.bd.apirestporyectobd2.model.PvProveedores[ proId=" + proId + " ]";
    }
    
}
