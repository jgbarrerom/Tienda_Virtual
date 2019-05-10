/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author jeisson
 */
@Entity(name = "GRUPO_PERSONA")
public class GrupoPersona implements Serializable{

    @EmbeddedId
    private GrupoPersonaPK id;
    @ManyToOne
    @MapsId("login")//REFERENCIAR AL LOGIN DE LA LLAVE COMPUESTA GENERADA EN LA OTRA CLASE PARA NO REPETIR CAMPO
    @JoinColumn(referencedColumnName = "login", nullable = false, name = "LOGIN")
    private Persona persona;

    public GrupoPersonaPK getId() {
        return id;
    }

    public void setId(GrupoPersonaPK id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
