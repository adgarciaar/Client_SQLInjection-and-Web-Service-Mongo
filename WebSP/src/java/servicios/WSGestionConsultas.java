/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import negocio.Consulta1;
import negocio.Consulta2;
import negocio.Consulta3;
import negocio.Consulta4;
import negocio.Consulta5;
import negocio.FacadeConsultas;

/**
 *
 * @author Santiago
 */
@WebService(serviceName = "WSGestionConsultas")
@Stateless()
public class WSGestionConsultas {

    @EJB
    private FacadeConsultas ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "totalesHemisferioContinente")
    public List<Consulta1> totalesHemisferioContinente() {
        return ejbRef.totalesHemisferioContinente();
    }

    @WebMethod(operationName = "totalesHemisferioAnio")
    public List<Consulta2> totalesHemisferioAnio() {
        return ejbRef.totalesHemisferioAnio();
    }

    @WebMethod(operationName = "participacionContinente")
    public List<Consulta3> participacionContinente() {
        return ejbRef.participacionContinente();
    }

    @WebMethod(operationName = "rankingContinentes")
    public List<Consulta4> rankingContinentes() {
        return ejbRef.rankingContinentes();
    }

    @WebMethod(operationName = "totalesPivot")
    public List<Consulta5> totalesPivot() {
        return ejbRef.totalesPivot();
    }

    @WebMethod(operationName = "loginSQLInjection")
    public int loginSQLInjection(@WebParam(name = "usuario") String usuario, @WebParam(name = "password") String password) {
        return ejbRef.loginSQLInjection(usuario, password);
    }
    
}
