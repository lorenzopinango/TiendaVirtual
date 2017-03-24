/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientews;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import ws.AdministracionPersistenciaJPAWS;
import ws.AdministracionPersistenciaJPAWS_Service;
import ws.Comprador;
import ws.CreacionOrdenException_Exception;
import ws.InformacionEnvio;
import ws.InformacionFactura;
import ws.ModificacionProductoException_Exception;
import ws.Orden;
import ws.Producto;

/**
 *
 * @author Estudiante
 */
public class ClienteWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdministracionPersistenciaJPAWS_Service service = new AdministracionPersistenciaJPAWS_Service();
        AdministracionPersistenciaJPAWS port = service.getAdministracionPersistenciaJPAWSPort();
               
        Date date = new Date();

        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(date);

        XMLGregorianCalendar calendar;
        try {
            calendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(
                            gregory);
            InformacionFactura informacionFactura = new InformacionFactura();
            informacionFactura.setCodigoTarjeta("0002");
            informacionFactura.setFechaExpiracion(calendar);
            informacionFactura.setNumeroTarjeta("987654321");
            informacionFactura.setId(port.crearInformacionFactura(informacionFactura));
            
            Comprador comprador = port.consultarComprador("pedro");
        
            List<Producto> productos = new ArrayList<Producto>();
            productos.add(port.consultarProducto(1));
            productos.add(port.consultarProducto(2));

            InformacionEnvio informacionEnvio = new InformacionEnvio();
            informacionEnvio.setCiudad("BOGOTA");
            informacionEnvio.setDepartamento("CUNDINAMARCA");
            informacionEnvio.setPais("COLOMBIA");
            informacionEnvio.setDireccion("CR70 N22-13");
            informacionEnvio.setId(port.crearInformacionEnvio(informacionEnvio));
            
            Orden orden = new Orden();
            orden.setComprador(comprador);
            orden.setFecha(calendar);
            orden.setInformacionEnvio(informacionEnvio);
            orden.setInformacionFactura(informacionFactura);

            try {
                port.crearOrden(orden);
            } catch (CreacionOrdenException_Exception ex) {
                System.out.println("Ocurrió un error al crear la orden de compra.");
            }
            try {
                port.modificarProductos(productos, orden);
            } catch (ModificacionProductoException_Exception ex) {
                System.out.println("Ocurrió un error al modificar los productos de la orden de compra.");
            }
        } catch (DatatypeConfigurationException ex) {
            System.out.println("Ocurrió un error con el tipo de fecha.");
        }

        
    }
    
}
