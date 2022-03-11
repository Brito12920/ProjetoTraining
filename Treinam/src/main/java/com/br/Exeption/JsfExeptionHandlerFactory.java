/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.Exeption;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 *
 * @author v103760
 */
public class JsfExeptionHandlerFactory extends ExceptionHandlerFactory  {

    
    private ExceptionHandlerFactory parent;
    
    public JsfExeptionHandlerFactory(ExceptionHandlerFactory parent){
        this.parent = parent;
    }
    
    @Override
    public ExceptionHandler getExceptionHandler() {
        return new JsfExeptionHandler(parent.getExceptionHandler());
    }
    
}
