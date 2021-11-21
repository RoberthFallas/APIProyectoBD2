/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.model.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import una.bd.apirestporyectobd2.model.PvPromociones;

/**
 *
 * @author 50671
 */
@XmlRootElement(name = "PromocionesDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class PromocionesDto {
    private  BigDecimal  proId;
    private String proNombre;
    private String proDescripcion;
    private Date proFechaValides;
    private char proEstado;
    
    public PromocionesDto() {
    }
    public  PromocionesDto(PvPromociones pro){
        proId=pro.getProId();
        proNombre=pro.getProNombre();
        proDescripcion=pro.getProDescripcion();
        proFechaValides=pro.getProValidezHasta();
        proEstado=pro.getProEstado();
    }

    public BigDecimal getProId() {
        return proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public String getProDescripcion() {
        return proDescripcion;
    }

    public Date getProFechaValides() {
        return proFechaValides;
    }

    public char getProEstado() {
        return proEstado;
    }
}
