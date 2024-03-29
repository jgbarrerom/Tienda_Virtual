/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jeisson
 */
@Embeddable
public class GrupoPersonaPK implements Serializable{

    @Column(nullable = false, length = 12)
    private String login;

    @Column(nullable = false, length = 12, name = "GRUPO_PERSONA")
    private String grupoPersona;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getGrupoPersona() {
        return grupoPersona;
    }

    public void setGrupoPersona(String grupoPersona) {
        this.grupoPersona = grupoPersona;
    }
}
