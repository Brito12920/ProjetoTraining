package com.br.Modelo;

import java.io.Serializable;

/**
 *
 * @author v103760
 */
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;
     private String codigo; 

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
     private String tipo;
    
   
}
