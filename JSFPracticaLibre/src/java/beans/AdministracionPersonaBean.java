/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import static com.sun.javafx.logging.PulseLogger.addMessage;
import entidades.Persona;
import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Estudiante
 */
@Named(value = "administracionPersonaBean")
@SessionScoped
public class AdministracionPersonaBean implements Serializable {
    
    List<Persona> personas = new ArrayList<Persona>();
    Persona persona = new Persona();
    /**
     * Creates a new instance of AdministracionPersonaBean
     */
    public AdministracionPersonaBean() {
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void agregarPersona() {
        persona.setId(personas.size() + 1);
        personas.add(persona);
        persona = new Persona();
        addMessage("Se registro la persona exitosamente!");
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
