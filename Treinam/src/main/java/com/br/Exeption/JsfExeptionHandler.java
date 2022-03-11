/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.Exeption;

import java.io.IOException;
import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author v103760
 */
public class JsfExeptionHandler extends ExceptionHandlerWrapper {

    private static Log log = LogFactory.getLog(JsfExeptionHandler.class);


    
    private ExceptionHandler wrapperd;
    
    public JsfExeptionHandler(ExceptionHandler wrapper){
        this.wrapperd = wrapper;
    }
    
    
    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapperd;
    }
    
    @Override
    public void handle() throws FacesException {
        Iterator<ExceptionQueuedEvent> events = getHandledExceptionQueuedEvents().iterator();
        
        while(events.hasNext()){
            ExceptionQueuedEvent event = events.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
            Throwable exception = context.getException();
          
            boolean handle = false;
            
            try{
             if(exception instanceof ViewExpiredException){
                 handle = true;
                 redirect("/app/error-404.html");
             }else{
                 handle = true;
                 log.error("Erro do sistema "+exception.getMessage(), exception);
                 redirect("/app/error-404.html");
             }
            } finally{
                if(handle){
                   events.remove();
                }
                
            }
        }
        getWrapped().handle();
    }
    private void redirect(String page){
           
          try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            String contextPath = externalContext.getRequestContextPath();
            
            externalContext.redirect(contextPath + page);
            facesContext.responseComplete();
          }catch(IOException e){
              throw new FacesException(e);
          }
        }
}
