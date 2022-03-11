package com.br.AvaliacaoTreinador;

/**
 *
 * @author v103760
 */
public class ProcessoQualificacao {
 
private int id;
private String data;
private String codigoObt;
private String obtModelo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCodigoObt() {
        return codigoObt;
    }

    public void setCodigoObt(String codigoObt) {
        this.codigoObt = codigoObt;
    }

    public String getObtModelo() {
        return obtModelo;
    }

    public void setObtModelo(String obtModelo) {
        this.obtModelo = obtModelo;
    }

    public int getApresentaPreRequisitosMch() {
        return apresentaPreRequisitosMch;
    }

    public void setApresentaPreRequisitosMch(int apresentaPreRequisitosMch) {
        this.apresentaPreRequisitosMch = apresentaPreRequisitosMch;
    }

    public int getRespeitoTempoEtapaApresent() {
        return respeitoTempoEtapaApresent;
    }

    public void setRespeitoTempoEtapaApresent(int respeitoTempoEtapaApresent) {
        this.respeitoTempoEtapaApresent = respeitoTempoEtapaApresent;
    }

    public int getLiberacaoEtapasTreinamentos() {
        return liberacaoEtapasTreinamentos;
    }

    public void setLiberacaoEtapasTreinamentos(int liberacaoEtapasTreinamentos) {
        this.liberacaoEtapasTreinamentos = liberacaoEtapasTreinamentos;
    }

    public int getNivelAptidaoTreinSegQualiProdutividade() {
        return nivelAptidaoTreinSegQualiProdutividade;
    }

    public void setNivelAptidaoTreinSegQualiProdutividade(int nivelAptidaoTreinSegQualiProdutividade) {
        this.nivelAptidaoTreinSegQualiProdutividade = nivelAptidaoTreinSegQualiProdutividade;
    }

    public int getLiberacaoOperacaoTodasEtapas() {
        return liberacaoOperacaoTodasEtapas;
    }

    public void setLiberacaoOperacaoTodasEtapas(int liberacaoOperacaoTodasEtapas) {
        this.liberacaoOperacaoTodasEtapas = liberacaoOperacaoTodasEtapas;
    }
private int apresentaPreRequisitosMch;
private int respeitoTempoEtapaApresent;
private int liberacaoEtapasTreinamentos;
private int nivelAptidaoTreinSegQualiProdutividade;
private int liberacaoOperacaoTodasEtapas;
    
}
