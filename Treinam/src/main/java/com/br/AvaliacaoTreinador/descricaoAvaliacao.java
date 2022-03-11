/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.AvaliacaoTreinador;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author V103760
 */
@Entity
public class descricaoAvaliacao implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;

    public descricaoAvaliacao() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeAvaliacao() {
        return nomeAvaliacao;
    }

    public void setNomeAvaliacao(String nomeAvaliacao) {
        this.nomeAvaliacao = nomeAvaliacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDesc_categoria() {
        return desc_categoria;
    }

    public void setDesc_categoria(String desc_categoria) {
        this.desc_categoria = desc_categoria;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "descricaoAvalicao{" + "codigo=" + codigo + ", descricao=" + descricao + ", nomeAvaliacao=" + nomeAvaliacao + ", categoria=" + categoria + ", desc_categoria=" + desc_categoria + ", unidade=" + unidade + '}';
    }

    public descricaoAvaliacao(int codigo, String descricao, String nomeAvaliacao, String categoria, String desc_categoria, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.nomeAvaliacao = nomeAvaliacao;
        this.categoria = categoria;
        this.desc_categoria = desc_categoria;
        this.unidade = unidade;
    }
    private String descricao;
    private String nomeAvaliacao;
    private String categoria;
    private String desc_categoria;
    private String unidade;
}
