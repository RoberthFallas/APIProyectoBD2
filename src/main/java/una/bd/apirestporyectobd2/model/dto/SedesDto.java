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
import una.bd.apirestporyectobd2.model.PvSedes;

/**
 *
 * @author 50671
 */
@XmlRootElement(name = "SedesDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class SedesDto {

    private BigDecimal sedID;
    private String sedNombre;
    private String sedDireccion;
    private char sedEstado;

    public SedesDto() {
    }

    public SedesDto(PvSedes sed) {
        sedID = sed.getSedId();
        sedNombre = sed.getSedNombre();
        sedDireccion = sed.getSedDireccion();
        sedEstado = sed.getSedeEstado();
    }

    public BigDecimal getSedID() {
        return sedID;
    }

    public String getSedNombre() {
        return sedNombre;
    }

    public String getSedDireccion() {
        return sedDireccion;
    }

    public char getSedEstado() {
        return sedEstado;
    }
}
