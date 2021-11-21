/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.bd.apirestporyectobd2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import una.bd.apirestporyectobd2.model.PvTipoPromocion;
import una.bd.apirestporyectobd2.model.dto.TipoPromocionDto;
import una.bd.apirestporyectobd2.util.CodigoRespuesta;
import una.bd.apirestporyectobd2.util.Respuesta;



/**
 *
 * @author 50671
 */
@Stateless
@LocalBean
public class TipoPromocionService {
    private static final Logger LOG = Logger.getLogger(TipoPromocionService.class.getName());

    @PersistenceContext(unitName = "Bd2PU")
    EntityManager em;

    public Respuesta getAll() {
        try {
            Query query = em.createNamedQuery("PvTipoPromocion.findAll", PvTipoPromocion.class);

            List<PvTipoPromocion> results = query.getResultList();
            if (results.isEmpty()) {
                return new Respuesta(true, CodigoRespuesta.ERROR_NOENCONTRADO, "Sin resultados", "");
            }

          
            List<TipoPromocionDto> dtoList = new ArrayList();

            results.forEach(item -> {
                dtoList.add(new TipoPromocionDto(item));
            });
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "data", dtoList);
        } catch (Exception ex) {

        }
        return null;
    }

    public Respuesta guardarPromocion(TipoPromocionDto tp) {
        try {
            PvTipoPromocion tipoPromocion;
            if (tp.getTpId() != null) {
                tipoPromocion = em.find(PvTipoPromocion.class, tp.getTpId());
                if (tipoPromocion == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el tipo de pago", "Actividades NoResultException");
                }
                tipoPromocion.guardarPromocion(tp);
                tipoPromocion = em.merge(tipoPromocion);

            } else
            {
                tipoPromocion=new PvTipoPromocion(tp);
                em.persist(tipoPromocion);
            }
            em.flush();
              return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "metodoPago", new TipoPromocionDto(tipoPromocion));

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al al guardar la promocion .", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, ""
                    + "Ocurrio un error al crear la promocion.",
                    "guardarPromocion " + e.getMessage());
        }
    }
}
