
package com.br.PDF;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pdf implements Serializable{
 
     private static final long serialVersionUID = 1L;  

    public Pdf() {
    }

    public int getCodigo() {
        return codigo; 
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public String getRegistroTreinamento() {
        return registroTreinamento;
    }

    public void setRegistroTreinamento(String registroTreinamento) {
        this.registroTreinamento = registroTreinamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pdf{" + "codigo=" + codigo + ", arquivo=" + arquivo + ", registroTreinamento=" + registroTreinamento + ", nome=" + nome + '}';
    }

    public Pdf(int codigo, byte[] arquivo, String registroTreinamento, String nome) {
        this.codigo = codigo;
        this.arquivo = arquivo;
        this.registroTreinamento = registroTreinamento;
        this.nome = nome;
    }
             
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)     
     private int codigo;
     private byte[] arquivo;
     private String registroTreinamento;
     private String nome;

     
   }