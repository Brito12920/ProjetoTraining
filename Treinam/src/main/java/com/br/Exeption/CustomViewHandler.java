/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.Exeption;

/**
 *
 * @author v103760
 */
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;

import javax.faces.application.ViewHandler;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.sun.facelets.FaceletViewHandler;

public class CustomViewHandler extends FaceletViewHandler {

    public CustomViewHandler(ViewHandler parent) {
		super(parent);
    }

    @Override
    protected void handleRenderException(FacesContext context, Exception ex) {
        try {
        	log.log(Level.SEVERE, ex.toString());
        	ex.printStackTrace();
        	getSessionMap().put("GLOBAL_ERROR", ex);
        	String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
            getHttpResponseObject().sendRedirect(contextPath+"/app/error-404.html");
        } catch (IOException e) {
            log.log(Level.SEVERE,"Couldn't redirect to error page", e);
        }
    }

    private HttpServletResponse getHttpResponseObject() {
        return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }

    private Map<String, Object> getSessionMap() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    }
}
