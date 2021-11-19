/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.model.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import una.bd.apirestporyectobd2.model.PvProductos;

/**
 *
 * @author roberth
 */
public class ProductoDto {
    

    private BigDecimal proId;
    private String proNombre;
    private BigInteger proCantidad;
    private double proDescuentoMaximo;
    private Date proVencimiento;
    private Date proIngreso;
    private Character proEstado;
    
    
    
    //TODO
 
//    private PvFamilias proFamilia;
//   
//    private PvProveedores proProvedor;
//    
//    private List<PvProdPromo> pvProdPromoList;
//
//    private List<PvMovimientos> pvMovimientosList;
// 
//    private List<PvPrecios> pvPreciosList;
//
//    private List<PvCodigosBarras> pvCodigosBarrasList;
//
//    private List<PvDetallFacVenta> pvDetallFacVentaList;
//
//    private List<PvDetallFacCompra> pvDetallFacCompraList;

    public ProductoDto(PvProductos p) {
        proId = p.getProId();
        proNombre = p.getProNombre();
        proCantidad = p.getProCantidad();
        proDescuentoMaximo = p.getProDescuentoMaximo();
        proVencimiento = p.getProVencimiento();
        proIngreso = p.getProIngreso();
        proEstado = p.getProEstado();
    }

    public BigDecimal getProId() {
        return proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public BigInteger getProCantidad() {
        return proCantidad;
    }

    public double getProDescuentoMaximo() {
        return proDescuentoMaximo;
    }

    public Date getProVencimiento() {
        return proVencimiento;
    }

    public Date getProIngreso() {
        return proIngreso;
    }

    public Character getProEstado() {
        return proEstado;
    }
    
    
    
}
