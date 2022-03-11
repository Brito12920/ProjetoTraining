package com.br.Tipo;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author v103760
 */
public class Tipo implements Serializable {

    private static final long serialVersionUID = 1L;
     private String codigo;
     @NotEmpty(message="Campo Tipo não pode ficar em branco")
     private String tipo;

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
    
}
