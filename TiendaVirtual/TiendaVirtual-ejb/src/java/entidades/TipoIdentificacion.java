/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.persistence.*;

/**
 *
 * @author Estudiante
 */
@Entity
public class TipoIdentificacion {
    @Id
    private String id;
    private String descripcion;
}
