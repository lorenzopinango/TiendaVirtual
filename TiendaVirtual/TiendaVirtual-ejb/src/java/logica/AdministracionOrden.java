/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Comprador;
import entidades.InformacionEnvio;
import entidades.InformacionFactura;
import entidades.Producto;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Estudiante
 */
@Stateful
public class AdministracionOrden implements AdministracionOrdenLocal {
    
    @Override
    public void adicionarComprador(Comprador comprador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionarInformacionFactura(InformacionFactura informacionFactura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionarInformacionEnvio(InformacionEnvio informacionEnvio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer crearOrdenCompra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelarOrdenCompra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comprador getComprador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List consultarCarroCompras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
