package com.br.ControleTreinamento;

import java.io.Serializable;

/**
 *
 * @author v103760
 */
public class NumeroTreinamento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String numeroTreinamento;

    public String getNumeroTreinamento() {
        return numeroTreinamento;
    }

    public void setNumeroTreinamento(String numeroTreinamento) {
        this.numeroTreinamento = numeroTreinamento;
    }
    
}
