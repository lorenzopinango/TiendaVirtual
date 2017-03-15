/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Bitacora;
import entidades.Comprador;
import entidades.InformacionEnvio;
import entidades.InformacionFactura;
import entidades.Orden;
import entidades.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Estudiante
 */
@Stateless
public class AdministracionPersistenciaJPA implements AdministracionPersistenciaJPALocal {
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public Producto consultarProducto(int idProducto) {
        return em.find(Producto.class, idProducto);
    }

    @Override
    public Integer crearOrden(Orden orden) {
        em.persist(orden);
        return orden.getId();
    }

    @Override
    public Integer crearInformacionEnvio(InformacionEnvio ie) {
        em.persist(ie);
        return ie.getId();
    }

    @Override
    public Integer crearInformacionFactura(InformacionFactura infFac) {
        em.persist(infFac);
        return infFac.getId();
    }

    @Override
    public void modificarProductos(List<Producto> productos, Orden orden) {
        for (int i = 0; i < productos.size(); i ++){
            Producto producto = new Producto();
            producto.setOrden(orden);
            em.merge(producto);
        }
    }

    @Override
    public Comprador consultarComprador(String login) {
        return em.find(Comprador.class, login);
    }

    @Override
    public List<Producto> consultarProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer crearBitacora(Bitacora bitacora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comprador> consultarCompradores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}