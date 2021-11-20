/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package una.bd.apirestporyectobd2.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import una.bd.apirestporyectobd2.model.dto.ProductoDto;
import una.bd.apirestporyectobd2.service.ProductoService;
import una.bd.apirestporyectobd2.util.CodigoRespuesta;
import una.bd.apirestporyectobd2.util.Respuesta;

/**
 *
 * @author roberth
 */

@Path("/ProductoController")
public class ProductoController {
    
    @EJB
    private ProductoService productoService;
    
    
    
    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        try{
            Respuesta resp = productoService.getAll(); 
            if(!resp.getEstado()){
                return Response.status(resp.getCodigoRespuesta().getValue()).entity(resp.getMensaje()).build();
            }
            
            return Response.ok((List<ProductoDto>) resp.getResultado("data")).build();
        }catch(Exception ex){
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("msj_serverError_NoDataBaseAcces").build();
        }
    }
    
}
