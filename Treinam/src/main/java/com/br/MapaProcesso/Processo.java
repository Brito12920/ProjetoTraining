
package com.br.MapaProcesso;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author v103760
 */
public class Processo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String codigo;
    @NotEmpty(message="Campo Mapa não pode ficar em branco")
    private String mapa;

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

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }
    @NotEmpty(message="Processo não pode ficar em branco")
    private String processo;
}
