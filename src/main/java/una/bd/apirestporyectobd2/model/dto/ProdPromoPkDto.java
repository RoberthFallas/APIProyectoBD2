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
import una.bd.apirestporyectobd2.model.PvProdPromoPK;

/**
 *
 * @author 50671
 */
@XmlRootElement(name = "ProdPromoPkDto")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class ProdPromoPkDto {
    BigInteger prodId;
    BigInteger proPromoId;

    public ProdPromoPkDto() {
    }
    
    public  ProdPromoPkDto(PvProdPromoPK prd)
    {
        proPromoId=prd.getProPromocion();
        prodId=prd.getProProducto();
    }
}
