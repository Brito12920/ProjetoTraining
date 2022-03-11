package com.br.Obt;

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
public class Obt implements Serializable {

    
    private static final long serialVersionUID = 1L;
      
      @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
      private String codigo;

    @Override
    public String toString() {
        return "Obt{" + "codigo=" + codigo + ", obtModelo=" + obtModelo + ", RegistroTreinamento=" + RegistroTreinamento + ", data=" + data + ", hora=" + hora + ", tempo=" + tempo + ", re=" + re + ", nome=" + nome + ", cargo=" + cargo + ", departamento=" + departamento + ", Tipo=" + Tipo + ", codigoObt=" + codigoObt + ", nota=" + nota + ", media=" + media + ", quantPeguntas=" + quantPeguntas + ", quantErros=" + quantErros + ", assinturaFunc=" + assinturaFunc + ", aprovaFac=" + aprovaFac + ", revisao=" + revisao + ", unidade=" + unidade + ", status=" + status + ", assinaturaFac=" + assinaturaFac + ", assinaturaSup=" + assinaturaSup + ", botao=" + botao + '}';
    }

    public Obt(String codigo, String obtModelo, String RegistroTreinamento, String data, String hora, String tempo, String re, String nome, String cargo, String departamento, String Tipo, String codigoObt, String nota, String media, String quantPeguntas, String quantErros, String assinturaFunc, String aprovaFac, String revisao, String unidade, String status, String assinaturaFac, String assinaturaSup, boolean botao) {
        this.codigo = codigo;
        this.obtModelo = obtModelo;
        this.RegistroTreinamento = RegistroTreinamento;
        this.data = data;
        this.hora = hora;
        this.tempo = tempo;
        this.re = re;
        this.nome = nome;
        this.cargo = cargo;
        this.departamento = departamento;
        this.Tipo = Tipo;
        this.codigoObt = codigoObt;
        this.nota = nota;
        this.media = media;
        this.quantPeguntas = quantPeguntas;
        this.quantErros = quantErros;
        this.assinturaFunc = assinturaFunc;
        this.aprovaFac = aprovaFac;
        this.revisao = revisao;
        this.unidade = unidade;
        this.status = status;
        this.assinaturaFac = assinaturaFac;
        this.assinaturaSup = assinaturaSup;
        this.botao = botao;
    }
      private String obtModelo;
      private String RegistroTreinamento;

    public Obt() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getObtModelo() {
        return obtModelo;
    }

    public void setObtModelo(String obtModelo) {
        this.obtModelo = obtModelo;
    }

    public String getRegistroTreinamento() {
        return RegistroTreinamento;
    }

    public void setRegistroTreinamento(String RegistroTreinamento) {
        this.RegistroTreinamento = RegistroTreinamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getCodigoObt() {
        return codigoObt;
    }

    public void setCodigoObt(String codigoObt) {
        this.codigoObt = codigoObt;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getQuantPeguntas() {
        return quantPeguntas;
    }

    public void setQuantPeguntas(String quantPeguntas) {
        this.quantPeguntas = quantPeguntas;
    }

    public String getQuantErros() {
        return quantErros;
    }

    public void setQuantErros(String quantErros) {
        this.quantErros = quantErros;
    }

    public String getAssinturaFunc() {
        return assinturaFunc;
    }

    public void setAssinturaFunc(String assinturaFunc) {
        this.assinturaFunc = assinturaFunc;
    }

    public String getAprovaFac() {
        return aprovaFac;
    }

    public void setAprovaFac(String aprovaFac) {
        this.aprovaFac = aprovaFac;
    }

    public String getRevisao() {
        return revisao;
    }

    public void setRevisao(String revisao) {
        this.revisao = revisao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssinaturaFac() {
        return assinaturaFac;
    }

    public void setAssinaturaFac(String assinaturaFac) {
        this.assinaturaFac = assinaturaFac;
    }

    public String getAssinaturaSup() {
        return assinaturaSup;
    }

    public void setAssinaturaSup(String assinaturaSup) {
        this.assinaturaSup = assinaturaSup;
    }

    public boolean isBotao() {
        return botao;
    }

    public void setBotao(boolean botao) {
        this.botao = botao;
    }
      private String data;
      private String hora;
      private String tempo;
      private String re;
      private String nome;
      private String cargo;
      private String departamento;
      private String Tipo;
      private String codigoObt;
      private String nota;
      private String media;
      private String quantPeguntas;
      private String quantErros;
      private String assinturaFunc;
      private String aprovaFac;
      private String revisao;
      private String unidade;
      private String status;
      private String assinaturaFac;
      private String assinaturaSup; 
      private boolean botao;

  
}
