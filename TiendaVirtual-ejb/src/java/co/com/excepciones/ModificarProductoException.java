/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.excepciones;

import javax.ejb.ApplicationException;

/**
 *
 * @author jeisson
 */
@ApplicationException(rollback = true)//HACE ROLLBACK CUANDO SE LANZA LA EXCEPCION
public class ModificarProductoException extends Exception {

    public ModificarProductoException() {
        super();
    }

    public ModificarProductoException(Exception e) {
        super(e);
    }

    public ModificarProductoException(String msg) {
        super(msg);
    }

    public ModificarProductoException(String msg, Exception e) {
        super(msg, e);
    }
}
