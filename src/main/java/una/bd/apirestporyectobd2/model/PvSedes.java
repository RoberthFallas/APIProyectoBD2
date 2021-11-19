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
@Table(name = "PV_SEDES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvSedes.findAll", query = "SELECT p FROM PvSedes p"),
    @NamedQuery(name = "PvSedes.findBySedId", query = "SELECT p FROM PvSedes p WHERE p.sedId = :sedId"),
    @NamedQuery(name = "PvSedes.findBySedNombre", query = "SELECT p FROM PvSedes p WHERE p.sedNombre = :sedNombre"),
    @NamedQuery(name = "PvSedes.findBySedDireccion", query = "SELECT p FROM PvSedes p WHERE p.sedDireccion = :sedDireccion"),
    @NamedQuery(name = "PvSedes.findBySedeEstado", query = "SELECT p FROM PvSedes p WHERE p.sedeEstado = :sedeEstado")})
public class PvSedes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SED_ID")
    private BigDecimal sedId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "SED_NOMBRE")
    private String sedNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SED_DIRECCION")
    private String sedDireccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEDE_ESTADO")
    private Character sedeEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facSede")
    private List<PvFacturasVenta> pvFacturasVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "decSede")
    private List<PvDescuentos> pvDescuentosList;
    @OneToMany(mappedBy = "invSede")
    private List<PvInventarios> pvInventariosList;

    public PvSedes() {
    }

    public PvSedes(BigDecimal sedId) {
        this.sedId = sedId;
    }

    public PvSedes(BigDecimal sedId, String sedNombre, String sedDireccion, Character sedeEstado) {
        this.sedId = sedId;
        this.sedNombre = sedNombre;
        this.sedDireccion = sedDireccion;
        this.sedeEstado = sedeEstado;
    }

    public BigDecimal getSedId() {
        return sedId;
    }

    public void setSedId(BigDecimal sedId) {
        this.sedId = sedId;
    }

    public String getSedNombre() {
        return sedNombre;
    }

    public void setSedNombre(String sedNombre) {
        this.sedNombre = sedNombre;
    }

    public String getSedDireccion() {
        return sedDireccion;
    }

    public void setSedDireccion(String sedDireccion) {
        this.sedDireccion = sedDireccion;
    }

    public Character getSedeEstado() {
        return sedeEstado;
    }

    public void setSedeEstado(Character sedeEstado) {
        this.sedeEstado = sedeEstado;
    }

    @XmlTransient
    public List<PvFacturasVenta> getPvFacturasVentaList() {
        return pvFacturasVentaList;
    }

    public void setPvFacturasVentaList(List<PvFacturasVenta> pvFacturasVentaList) {
        this.pvFacturasVentaList = pvFacturasVentaList;
    }

    @XmlTransient
    public List<PvDescuentos> getPvDescuentosList() {
        return pvDescuentosList;
    }

    public void setPvDescuentosList(List<PvDescuentos> pvDescuentosList) {
        this.pvDescuentosList = pvDescuentosList;
    }

    @XmlTransient
    public List<PvInventarios> getPvInventariosList() {
        return pvInventariosList;
    }

    public void setPvInventariosList(List<PvInventarios> pvInventariosList) {
        this.pvInventariosList = pvInventariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sedId != null ? sedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvSedes)) {
            return false;
        }
        PvSedes other = (PvSedes) object;
        if ((this.sedId == null && other.sedId != null) || (this.sedId != null && !this.sedId.equals(other.sedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "una.bd.apirestporyectobd2.model.PvSedes[ sedId=" + sedId + " ]";
    }
    
}
