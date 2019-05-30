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
@ApplicationException(rollback = true)
public class CrearOrdenException extends Exception{
    public CrearOrdenException(){
        super();
    }
    
    public CrearOrdenException(Exception e){
        super(e);
    }
    
    public CrearOrdenException(Exception e, String msg){
        super(msg, e);
    }
}
