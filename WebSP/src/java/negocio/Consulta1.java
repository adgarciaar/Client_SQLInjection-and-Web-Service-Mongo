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
public class Consulta1 {
    
    private String hemisferio;
    private String continente;
    private BigDecimal cantidadEnviada;

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

    public BigDecimal getCantidadEnviada() {
        return cantidadEnviada;
    }

    public void setCantidadEnviada(BigDecimal cantidadEnviada) {
        this.cantidadEnviada = cantidadEnviada;
    }

    public Consulta1() {
    }   
    
}