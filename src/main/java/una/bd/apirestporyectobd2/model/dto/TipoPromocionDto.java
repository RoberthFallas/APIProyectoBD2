/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.model.dto;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import una.bd.apirestporyectobd2.model.PvTipoPromocion;

/**
 *
 * @author 50671
 */
@XmlRootElement(name = "TipoPromocionDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class TipoPromocionDto {

    Integer tpId;
    String tpNombre;
    String tpDescripcion;

    public TipoPromocionDto() {
    }

    public TipoPromocionDto(PvTipoPromocion tp) {
        tpId = tp.getTipId();
        tpNombre = tp.getTipNombre();
        tpDescripcion = tp.getTipDescripcion();
    }

    public Integer getTpId() {
        return tpId;
    }



    public String getTpNombre() {
        return tpNombre;
    }

    public String getTpDescripcion() {
        return tpDescripcion;
    }
}
