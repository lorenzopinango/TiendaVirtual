/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificaciones;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;

/**
 *
 * @author Estudiante
 */
public class NotificacionInterceptor {
    
    @Inject
    @JMSConnectionFactory("jms/CreacionOrdenTopicFactory")
    private JMSContext context;
    
    @Resource(name="jms/CreacionOrdenTopic")
    private Destination destination;
    
    @AroundInvoke
    public Object notificarCreacionOrden(InvocationContext ic) throws Exception{
        
        
        return ic.proceed();
    }
}
