/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.math.BigDecimal;

/**
 *
 * @author Santiago
 */
public class Consulta3 {
    
    private String continente;
    private BigDecimal cantidadEnviadaContinente;
    private BigDecimal totalGeneralEnviado;
    private double porcentajeParticipacion;

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public BigDecimal getCantidadEnviadaContinente() {
        return cantidadEnviadaContinente;
    }

    public void setCantidadEnviadaContinente(BigDecimal cantidadEnviadaContinente) {
        this.cantidadEnviadaContinente = cantidadEnviadaContinente;
    }

    public BigDecimal getTotalGeneralEnviado() {
        return totalGeneralEnviado;
    }

    public void setTotalGeneralEnviado(BigDecimal totalGeneralEnviado) {
        this.totalGeneralEnviado = totalGeneralEnviado;
    }

    public double getPorcentajeParticipacion() {
        return porcentajeParticipacion;
    }

    public void setPorcentajeParticipacion(double porcentajeParticipacion) {
        this.porcentajeParticipacion = porcentajeParticipacion;
    }

    public Consulta3() {
    }
    
}
