/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import una.bd.apirestporyectobd2.model.PvProductos;
import una.bd.apirestporyectobd2.model.dto.ProductoDto;
import una.bd.apirestporyectobd2.util.CodigoRespuesta;
import una.bd.apirestporyectobd2.util.Respuesta;

/**
 *
 * @author roberth
 */
@Stateless
@LocalBean
public class ProductoService {
    
    private static final Logger LOG = Logger.getLogger(ProductoService.class.getName());
    
    @PersistenceContext(unitName = "Bd2PU")
    EntityManager em;
    
    public Respuesta getAll(){
        try{
            Query query = em.createNamedQuery("PvProductos.findAll", PvProductos.class);
            
            List<PvProductos> results = query.getResultList();
            if(results.isEmpty()){
                return new Respuesta(true, CodigoRespuesta.ERROR_NOENCONTRADO, "Sin resultados", "");
            }
            
            List<ProductoDto> dtoList = new ArrayList();
            
            results.forEach(item ->{
                dtoList.add(new ProductoDto(item));
            });
            
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "","data", dtoList);
        }catch(Exception ex){
        
        }
        return null;
    }
}
