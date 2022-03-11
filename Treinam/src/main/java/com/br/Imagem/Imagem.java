package com.br.Imagem;

import java.io.Serializable;




/**
 *
 * @author v103760
 */
public class Imagem implements Serializable {

    private static final long serialVersionUID = 1L;
     private String codigo;
     private Imagem Modelo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Imagem getModelo() {
        return Modelo;
    }

    public void setModelo(Imagem Modelo) {
        this.Modelo = Modelo;
    }

    public String getImagem() {
        return Imagem;
    }

    public void setImagem(String Imagem) {
        this.Imagem = Imagem;
    }

    public String getUnidade() {
        return Unidade;
    }

    public void setUnidade(String Unidade) {
        this.Unidade = Unidade;
    }

    public String getNomeImagem() {
        return NomeImagem;
    }

    public void setNomeImagem(String NomeImagem) {
        this.NomeImagem = NomeImagem;
    }
     private String Imagem;
     private String Unidade;
     private String NomeImagem;  
}
