/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.model.dto;

import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import una.bd.apirestporyectobd2.model.PvParametros;
import una.bd.apirestporyectobd2.model.PvRoles;

/**
 *
 * @author 50671
 */
@XmlRootElement(name = "RolesDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class RolesDto {

    private BigDecimal rolId;
    private String rolNombre;
    private String rolContrasenna;
    public RolesDto() {
    }

    public RolesDto(PvRoles rol) {
        rolId = rol.getRolId();
        rolNombre = rol.getRolNombre();
        rolContrasenna = rol.getRolContrasenna();
    }

  

    public BigDecimal getRolId() {
        return rolId;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public String getRolContrasenna() {
        return rolContrasenna;
    }
}
