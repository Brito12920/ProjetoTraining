package com.br.Status;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author v103760
 */
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
     private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     @NotEmpty(message="Campo Mapa não pode ficar em branco")
     private String status;

    
}
