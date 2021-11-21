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
import una.bd.apirestporyectobd2.model.dto.TipoPromocionDto;

/**
 *
 * @author roberth
 */
@Entity
@Table(name = "PV_TIPO_PROMOCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvTipoPromocion.findAll", query = "SELECT p FROM PvTipoPromocion p"),
    @NamedQuery(name = "PvTipoPromocion.findByTipId", query = "SELECT p FROM PvTipoPromocion p WHERE p.tipId = :tipId"),
    @NamedQuery(name = "PvTipoPromocion.findByTipNombre", query = "SELECT p FROM PvTipoPromocion p WHERE p.tipNombre = :tipNombre"),
    @NamedQuery(name = "PvTipoPromocion.findByTipDescripcion", query = "SELECT p FROM PvTipoPromocion p WHERE p.tipDescripcion = :tipDescripcion")})
public class PvTipoPromocion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIP_ID")
    private Integer tipId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "TIP_NOMBRE")
    private String tipNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TIP_DESCRIPCION")
    private String tipDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proTipo")
    private List<PvPromociones> pvPromocionesList;

    public PvTipoPromocion() {
    }

    public PvTipoPromocion(Integer tipId) {
        this.tipId = tipId;
    }

    public PvTipoPromocion(Integer tipId, String tipNombre, String tipDescripcion) {
        this.tipId = tipId;
        this.tipNombre = tipNombre;
        this.tipDescripcion = tipDescripcion;
    }

    public PvTipoPromocion(TipoPromocionDto tp) {
        this.tipId = tp.getTpId();
        this.guardarPromocion(tp);
    }

    public Integer getTipId() {
        return tipId;
    }

    public void setTipId(Integer tipId) {
        this.tipId = tipId;
    }

    public String getTipNombre() {
        return tipNombre;
    }

    public void setTipNombre(String tipNombre) {
        this.tipNombre = tipNombre;
    }

    public String getTipDescripcion() {
        return tipDescripcion;
    }

    public void setTipDescripcion(String tipDescripcion) {
        this.tipDescripcion = tipDescripcion;
    }

    @XmlTransient
    public List<PvPromociones> getPvPromocionesList() {
        return pvPromocionesList;
    }

    public void setPvPromocionesList(List<PvPromociones> pvPromocionesList) {
        this.pvPromocionesList = pvPromocionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipId != null ? tipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvTipoPromocion)) {
            return false;
        }
        PvTipoPromocion other = (PvTipoPromocion) object;
        if ((this.tipId == null && other.tipId != null) || (this.tipId != null && !this.tipId.equals(other.tipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "una.bd.apirestporyectobd2.model.PvTipoPromocion[ tipId=" + tipId + " ]";
    }

    public void guardarPromocion(TipoPromocionDto tp) {
        this.tipNombre = tp.getTpNombre();
        this.tipDescripcion = tp.getTpDescripcion();

    }

}
