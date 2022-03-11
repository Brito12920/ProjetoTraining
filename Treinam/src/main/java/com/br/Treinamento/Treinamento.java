package com.br.Treinamento;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author v103760
 */
@Entity
public class Treinamento implements Serializable {

    private static final long serialVersionUID = 1L;
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int codigo;    
 private String Nome;

    public Treinamento() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }

    public String getUnidade() {
        return Unidade;
    }

    public void setUnidade(String Unidade) {
        this.Unidade = Unidade;
    }

    @Override
    public String toString() {
        return "Treinamento{" + "codigo=" + codigo + ", Nome=" + Nome + ", Funcao=" + Funcao + ", Unidade=" + Unidade + '}';
    }

    public Treinamento(int codigo, String Nome, String Funcao, String Unidade) {
        this.codigo = codigo;
        this.Nome = Nome;
        this.Funcao = Funcao;
        this.Unidade = Unidade;
    }
 private String Funcao;
 private String Unidade;      
    
}
