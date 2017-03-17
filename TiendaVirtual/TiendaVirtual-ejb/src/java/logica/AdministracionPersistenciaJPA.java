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
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Estudiante
 */
@Stateless
public class AdministracionPersistenciaJPA implements AdministracionPersistenciaJPALocal {
    
    @PersistenceContext
    EntityManager em;
    
    @Resource
    private TimerService timerService;
    
    @Override
    public Producto consultarProducto(int idProducto) {
        return em.find(Producto.class, idProducto);
    }

    @Override
    public Integer crearOrden(Orden orden) {
        em.persist(orden);
        timerService.createTimer(15000, orden);
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
        for (Producto producto: productos) {
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
        Query query = em.createNamedQuery("findAllProducts");
        List<Producto> productos = query.getResultList();
        return productos;
    }

    @Override
    public Integer crearBitacora(Bitacora bitacora) {
        em.persist(bitacora);
        return bitacora.getId();
    }

    @Override
    public List<Comprador> consultarCompradores() {
        Query query = em.createNamedQuery("findAllCompradores");
        List<Comprador> compradores = query.getResultList();
        return compradores;
    }

    @Timeout
    private void timerCrearOrden(Timer timer){
        Orden orden = (Orden) timer.getInfo();
        System.out.println("Se ha enviado la orden a la dirección "
        + orden.getInformacionEnvio().getDireccion());
    }
}
