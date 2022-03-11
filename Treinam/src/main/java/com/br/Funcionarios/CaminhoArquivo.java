package com.br.Funcionarios;

import com.br.Utilitarios.Named;

import javax.faces.bean.SessionScoped;

/**
 *
 * @author v103760
 */
@Named
@SessionScoped
public class CaminhoArquivo {
    
    private String nomeArquivo;

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
}
