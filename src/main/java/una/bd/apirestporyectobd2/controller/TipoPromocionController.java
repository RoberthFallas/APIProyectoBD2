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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import una.bd.apirestporyectobd2.model.dto.TipoPromocionDto;
import una.bd.apirestporyectobd2.service.TipoPromocionService;
import una.bd.apirestporyectobd2.util.CodigoRespuesta;
import una.bd.apirestporyectobd2.util.Respuesta;

/**
 *
 * @author 50671
 */
@Path("/TipoPromocionController")
public class TipoPromocionController{

    @EJB
    private TipoPromocionService tipoPromocionService;

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {

        try {
            Respuesta resp = tipoPromocionService.getAll();
            if (!resp.getEstado()) {
                return Response.status(resp.getCodigoRespuesta().getValue()).entity(resp.getMensaje()).build();
            }

            return Response.ok((List<TipoPromocionDto>) resp.getResultado("data")).build();
        } catch (Exception ex) {
            Logger.getLogger(TiposPagoController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("msj_serverError_NoDataBaseAcces").build();
        }
    }

    @POST
    @Path("/guardarTipoPromocion")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarTipoPago(TipoPromocionDto tp) {
        try {
            Respuesta respuesta = tipoPromocionService.guardarPromocion(tp);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((TiposPagoController) respuesta.getResultado("data")).build();
        } catch (Exception ex) {
            Logger.getLogger(TiposPagoController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error al guardar la promocion").build();
        }

    }
}
