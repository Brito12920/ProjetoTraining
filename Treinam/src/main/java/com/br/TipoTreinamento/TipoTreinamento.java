package com.br.TipoTreinamento;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author v103760
 */
public class TipoTreinamento implements Serializable {

    private static final long serialVersionUID = 1L;
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoTreinamento() {
        return tipoTreinamento;
    }

    public void setTipoTreinamento(String tipoTreinamento) {
        this.tipoTreinamento = tipoTreinamento;
    }
    @NotEmpty(message="Campo Tipo de treinamento não pode ser gravado em branco")
    private String tipoTreinamento;
   
}
