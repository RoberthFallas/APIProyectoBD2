/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import una.bd.apirestporyectobd2.model.PvPrecios;

/**
 *
 * @author 50671
 */

@XmlRootElement(name = "PreciosDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class PreciosDto {
   private BigDecimal preId;
   private double preCosto;
   private double preImpuesto;
   private double preUtilidad;
   private Date preFecha;
   private String preEstado;

    public PreciosDto() {
    }
   public  PreciosDto(PvPrecios pre)
   {
       preId=pre.getPreId();
       preCosto=pre.getPrePrecioCosto();
       preImpuesto=pre.getPreImpuesto();
       preUtilidad=pre.getPreUtilidad();
       preFecha=pre.getPreFecha();
       preEstado=pre.getPreEstado();
   }

    public BigDecimal getPreId() {
        return preId;
    }

    public double getPreCosto() {
        return preCosto;
    }

    public double getPreImpuesto() {
        return preImpuesto;
    }

    public double getPreUtilidad() {
        return preUtilidad;
    }

    public Date getPreFecha() {
        return preFecha;
    }

    public String getPreEstado() {
        return preEstado;
    }
   
}
