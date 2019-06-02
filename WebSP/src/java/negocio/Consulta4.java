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
public class Consulta4 {
    
    private String hemisferio;
    private String continente;
    private BigDecimal totalEnviado;
    private BigDecimal numeroRanking;

    public String getHemisferio() {
        return hemisferio;
    }

    public void setHemisferio(String hemisferio) {
        this.hemisferio = hemisferio;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public BigDecimal getTotalEnviado() {
        return totalEnviado;
    }

    public void setTotalEnviado(BigDecimal totalEnviado) {
        this.totalEnviado = totalEnviado;
    }

    public BigDecimal getNumeroRanking() {
        return numeroRanking;
    }

    public void setNumeroRanking(BigDecimal numeroRanking) {
        this.numeroRanking = numeroRanking;
    }

    public Consulta4() {
    }
    
}
