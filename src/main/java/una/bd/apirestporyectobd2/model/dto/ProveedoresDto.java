/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.model.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import una.bd.apirestporyectobd2.model.PvProveedores;

/**
 *
 * @author 50671
 */
@XmlRootElement(name = "ProveedoresDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class ProveedoresDto {

    private BigDecimal proId;
    private String proNombre;
    private String proCorreo;
    private String proTelefono;

    public ProveedoresDto() {
    }

    public ProveedoresDto(PvProveedores pro) {
        proId = pro.getProId();
        proNombre = pro.getProNombre();
        proTelefono = pro.getProTelefono();
        proCorreo = pro.getProCorreo();
    }

    public BigDecimal getProId() {
        return proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public String getProCorreo() {
        return proCorreo;
    }

    public String getProTelefono() {
        return proTelefono;
    }
    
}
