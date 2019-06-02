/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Santiago
 */
@Stateless
public class FacadeConsultas {

    @PersistenceContext(unitName = "WebSPPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public FacadeConsultas() {

    }

    public List<Consulta1> totalesHemisferioContinente() {
        StoredProcedureQuery query
                = em.createStoredProcedureQuery("CONSULTASSQLEXTENDIDO.totalesHemisferioContinente")
                        .registerStoredProcedureParameter(
                                1,
                                Class.class,
                                ParameterMode.REF_CURSOR
                        );

        query.execute();

        List<Object[]> consultaObjs = query.getResultList();
        List<Consulta1> consultas = new ArrayList<>();

        for (Object[] m : consultaObjs) {
            Consulta1 consulta1 = new Consulta1();
            consulta1.setHemisferio(new String(m[0].toString()));
            consulta1.setContinente(new String(m[1].toString()));
            consulta1.setCantidadEnviada(new BigDecimal(m[2].toString()));
            consultas.add(consulta1);
        }

        return consultas;
    }

    public List<Consulta2> totalesHemisferioAnio() {
        StoredProcedureQuery query
                = em.createStoredProcedureQuery("CONSULTASSQLEXTENDIDO.totalesHemisferioAnio")
                        .registerStoredProcedureParameter(
                                1,
                                Class.class,
                                ParameterMode.REF_CURSOR
                        );

        query.execute();

        List<Object[]> consultaObjs = query.getResultList();
        List<Consulta2> consultas = new ArrayList<>();

        for (Object[] m : consultaObjs) {
            Consulta2 consulta2 = new Consulta2();
            consulta2.setHemisferio(new String(m[0].toString()));
            consulta2.setAnio(new String(m[1].toString()));
            consulta2.setCantidadEnviada(new BigDecimal(m[2].toString()));
            consultas.add(consulta2);
        }

        return consultas;
    }

    public List<Consulta3> participacionContinente() {
        StoredProcedureQuery query
                = em.createStoredProcedureQuery("CONSULTASSQLEXTENDIDO.participacionContinente")
                        .registerStoredProcedureParameter(
                                1,
                                Class.class,
                                ParameterMode.REF_CURSOR
                        );

        query.execute();

        List<Object[]> consultaObjs = query.getResultList();
        List<Consulta3> consultas = new ArrayList<>();

        for (Object[] m : consultaObjs) {
            Consulta3 consulta3 = new Consulta3();
            consulta3.setContinente(new String(m[0].toString()));
            consulta3.setCantidadEnviadaContinente(new BigDecimal(m[1].toString()));
            consulta3.setTotalGeneralEnviado(new BigDecimal(m[2].toString()));
            consulta3.setPorcentajeParticipacion(new Double(m[3].toString()));
            consultas.add(consulta3);
        }

        return consultas;
    }

    public List<Consulta4> rankingContinentes() {
        StoredProcedureQuery query
                = em.createStoredProcedureQuery("CONSULTASSQLEXTENDIDO.rankingContinentes")
                        .registerStoredProcedureParameter(
                                1,
                                Class.class,
                                ParameterMode.REF_CURSOR
                        );

        query.execute();

        List<Object[]> consultaObjs = query.getResultList();
        List<Consulta4> consultas = new ArrayList<>();

        for (Object[] m : consultaObjs) {
            Consulta4 consulta4 = new Consulta4();
            consulta4.setHemisferio(new String(m[0].toString()));
            consulta4.setContinente(new String(m[1].toString()));
            consulta4.setTotalEnviado(new BigDecimal(m[2].toString()));
            consulta4.setNumeroRanking(new BigDecimal(m[3].toString()));
            consultas.add(consulta4);
        }

        return consultas;
    }

    public List<Consulta5> totalesPivot() {
        StoredProcedureQuery query
                = em.createStoredProcedureQuery("CONSULTASSQLEXTENDIDO.totalesPivot")
                        .registerStoredProcedureParameter(
                                1,
                                Class.class,
                                ParameterMode.REF_CURSOR
                        );

        query.execute();

        List<Object[]> consultaObjs = query.getResultList();
        List<Consulta5> consultas = new ArrayList<>();

        for (Object[] m : consultaObjs) {
            Consulta5 consulta5 = new Consulta5();
            consulta5.setHemisferio(new String(m[0].toString()));
            consulta5.setAnio_2015(new BigDecimal(m[1].toString()));
            consulta5.setAnio_2016(new BigDecimal(m[2].toString()));
            consulta5.setAnio_2017(new BigDecimal(m[3].toString()));
            consulta5.setAnio_2018(new BigDecimal(m[4].toString()));
            consulta5.setAnio_2019(new BigDecimal(m[5].toString()));
            consulta5.setAnio_2020(new BigDecimal(m[6].toString()));
            consulta5.setTotal(new BigDecimal(m[7].toString()));
            consultas.add(consulta5);
        }

        return consultas;
    }

    public int loginSQLInjection(String usuario, String password) {

        StoredProcedureQuery query
                = em.createStoredProcedureQuery("LOGINSQLINJECTION.ingresar")
                        .registerStoredProcedureParameter(
                                1,
                                String.class,
                                ParameterMode.IN
                        )
                        .registerStoredProcedureParameter(
                                2,
                                String.class,
                                ParameterMode.IN
                        )
                        .registerStoredProcedureParameter(
                                3,
                                BigDecimal.class,
                                ParameterMode.OUT
                        )
                        .setParameter(1, usuario)
                        .setParameter(2, password);

        query.execute();        
        
        BigDecimal retorno = (BigDecimal) query.getOutputParameterValue(3);

        return retorno.intValue();
    }

}
