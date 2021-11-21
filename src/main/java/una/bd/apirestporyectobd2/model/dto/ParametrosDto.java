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
import una.bd.apirestporyectobd2.model.PvParametros;

/**
 *
 * @author 50671
 */
@XmlRootElement(name = "ParametrosDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class ParametrosDto {

    private BigDecimal parId;
    private String parUsuario;
    private String parContrasenna;
    private String parCorreo;
    private String parEstado;

    public ParametrosDto() {
    }

    public ParametrosDto(PvParametros par) {
        parId = par.getParId();
        parUsuario = par.getParUsuario();
        parContrasenna = par.getParContrasena();
        parCorreo = par.getParCorreo();
        parEstado = par.getParEstado();

    }

    public BigDecimal getParId() {
        return parId;
    }

    public String getParUsuario() {
        return parUsuario;
    }

    public String getParContrasenna() {
        return parContrasenna;
    }

    public String getParCorreo() {
        return parCorreo;
    }

    public String getParEstado() {
        return parEstado;
    }

}
