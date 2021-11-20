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
import una.bd.apirestporyectobd2.model.PvTiposPago;
import una.bd.apirestporyectobd2.model.dto.TiposPagosDto;
import una.bd.apirestporyectobd2.util.CodigoRespuesta;
import una.bd.apirestporyectobd2.util.Respuesta;

/**
 *
 * @author 50671
 */
@Stateless
@LocalBean
public class TiposPagoService {

    private static final Logger LOG = Logger.getLogger(TiposPagoService.class.getName());

    @PersistenceContext(unitName = "Bd2PU")
    EntityManager em;

    public Respuesta getAll() {
        try {
            Query query = em.createNamedQuery("PvTiposPago.findAll", PvTiposPago.class);

            List<PvTiposPago> results = query.getResultList();
            if (results.isEmpty()) {
                return new Respuesta(true, CodigoRespuesta.ERROR_NOENCONTRADO, "Sin resultados", "");
            }

            List<TiposPagosDto> dtoList = new ArrayList();

            results.forEach(item -> {
                dtoList.add(new TiposPagosDto(item));
            });

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "data", dtoList);
        } catch (Exception ex) {

        }
        return null;
    }

    public Respuesta guardarTipoPago(TiposPagosDto tp) {
        try {
            PvTiposPago tipoPago;
            if (tp.getTipoPagoId() != null) {
                tipoPago = em.find(PvTiposPago.class, tp.getTipoPagoId());
                if (tipoPago == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el tipo de pago", "Actividades NoResultException");
                }
                tipoPago.actualizarTipoDePago(tp);
                tipoPago = em.merge(tipoPago);

            } else
            {
                tipoPago=new PvTiposPago(tp);
                em.persist(tipoPago);
            }
            em.flush();
              return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "metodoPago", new TiposPagosDto(tipoPago));

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al al guardar el tipo de pago.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, ""
                    + "Ocurrio un error al crear el metodo de pago.",
                    "guardarTipoPago " + e.getMessage());
        }
    }
}
