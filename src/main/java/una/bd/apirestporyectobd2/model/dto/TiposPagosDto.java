/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.model.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import una.bd.apirestporyectobd2.model.PvPagoFactura;
import una.bd.apirestporyectobd2.model.PvTiposPago;

/**
 *
 * @author 50671
 */
@XmlRootElement(name = "TiposPagosDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class TiposPagosDto {

    private Integer tipoPagoId;
    private String tipoPagoNombre;
    private String tipoDescripcion;
   // private List<PvPagoFactura> tipoPagoFacturas;

    public TiposPagosDto() {

    }

    public TiposPagosDto(PvTiposPago p) {
        tipoPagoId = p.getTipId();
        tipoPagoNombre = p.getTipNombre();
        tipoDescripcion = p.getTipDescripcion();
    }


    public Integer getTipoPagoId() {
        return tipoPagoId;
    }

    public String getTipoPagoNombre() {
        return tipoPagoNombre;
    }

    public String getTipoDescripcion() { 
        
        return tipoDescripcion;
    }

    public void setTipoPagoId(Integer tipoPagoId) {
        this.tipoPagoId = tipoPagoId;
    }

    public void setTipoPagoNombre(String tipoPagoNombre) {
        this.tipoPagoNombre = tipoPagoNombre;
    }

    public void setTipoDescripcion(String tipoDescripcion) {
        this.tipoDescripcion = tipoDescripcion;
    }

}
