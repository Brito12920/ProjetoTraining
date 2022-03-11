package com.br.MapaSubProcesso;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author v103760
 */
public class SubProcesso implements Serializable{

    private static final long serialVersionUID = 1L;
     private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getSubprocesso() {
        return subprocesso;
    }

    public void setSubprocesso(String subprocesso) {
        this.subprocesso = subprocesso;
    }
     @NotEmpty(message="Campo Mapa não pode ficar em branco")
     private String mapa;
     @NotEmpty(message="Campo Subprocesso não pode ficar em branco")
     private String subprocesso;      
   
}
