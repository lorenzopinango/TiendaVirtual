/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Estudiante
 */
@Entity
@Table(name="TIPO_IDENTIFICACION") //Nombre con el que se mapea en la BD
public class TipoIdentificacion implements Serializable {
    @Id
    @Column(length=2)//Para definir la longitud del campo en la BD
    private String id;
    @Column(nullable=false, length = 30)
    private String descripcion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
