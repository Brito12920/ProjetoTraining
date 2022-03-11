package com.br.NumeroDocumento;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author v103760
 */
public class NumeroDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
     private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRevisao() {
        return revisao;
    }

    public void setRevisao(String revisao) {
        this.revisao = revisao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
     @NotEmpty(message="Campo Documento não pode ficar em branco")
     private String documento;
     @NotEmpty(message="Campo Revisão não pode ficar em branco")
     private String revisao;
     @NotEmpty(message="Campo Descrição não pode ficar em branco")
     private String descricao;
     @NotEmpty(message="Campo Unidade não pode ficar em branco")
     private String unidade;        
    
    
}
