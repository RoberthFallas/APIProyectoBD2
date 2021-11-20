/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.model.dto;

import java.math.BigDecimal;
import una.bd.apirestporyectobd2.model.PvTiposPago;

/**
 *
 * @author 50671
 */
public class TiposPagosDto {

    private BigDecimal tipoPagoId;
    private String tipoPagoNombre;
    private String tipoDescripcion;

    public TiposPagosDto(PvTiposPago p) {
        tipoPagoId = p.getTipId();
        tipoPagoNombre = p.getTipNombre();
        tipoDescripcion = p.getTipDescripcion();
    }

    public BigDecimal getTipoPagoId() {
        return tipoPagoId;
    }

    public String getTipoPagoNombre() {
        return tipoPagoNombre;
    }

    public String getTipoDescripcion() {
        return tipoDescripcion;
    }
    
}
