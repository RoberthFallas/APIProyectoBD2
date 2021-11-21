/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.model.dto;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import una.bd.apirestporyectobd2.model.PvPagoFacturaPK;

/**
 *
 * @author 50671
 */
@XmlRootElement(name = "PagoFacturaPkDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class PagoFacturaPkDto {
   private BigInteger pagFacturaId;
   private BigInteger pagTipoPagoId;

    public PagoFacturaPkDto() {
    }
   
    public PagoFacturaPkDto(PvPagoFacturaPK pag)
    {
        pagFacturaId=pag.getPagFactura();
        pagTipoPagoId=pag.getPagTipoPago();
    }

    public BigInteger getPagFacturaId() {
        return pagFacturaId;
    }

    public BigInteger getPagTipoPagoId() {
        return pagTipoPagoId;
    }
    
}
