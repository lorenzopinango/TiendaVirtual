/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import entidades.Comprador;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import logica.AdministracionOrdenLocal;
import logica.AdministracionPersistenciaJPALocal;

/**
 *
 * @author Estudiante
 */
@Named(value = "ordenCompraBean")
@SessionScoped
public class OrdenCompraBean implements Serializable {
    
    @EJB
    AdministracionPersistenciaJPALocal administracionPersistencia;
    
    @EJB
    AdministracionOrdenLocal administracionOrden;
    
    /**
     * Creates a new instance of OrdenCompraBean
     */
    public OrdenCompraBean() {
    }
    
    public List<Comprador> getCompradores(){
        return administracionPersistencia.consultarCompradores();
    }
    
    public void compradoresListener(ValueChangeEvent vce){
        String login = vce.getNewValue().toString();
        if(!login.equals("-1")){
            Comprador comprador = administracionPersistencia.consultarComprador(login);
            administracionOrden.adicionarComprador(comprador);
        }
    }
}
