package com.br.Resposansavel;

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
public class Responsavel implements Serializable {

    private static final long serialVersionUID = 1L;
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int codigo;    

    public Responsavel() {
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

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getUnidade() {
        return Unidade;
    }

    public void setUnidade(String Unidade) {
        this.Unidade = Unidade;
    }

    @Override
    public String toString() {
        return "Responsavel{" + "codigo=" + codigo + ", Nome=" + Nome + ", Cargo=" + Cargo + ", Unidade=" + Unidade + '}';
    }

    public Responsavel(int codigo, String Nome, String Cargo, String Unidade) {
        this.codigo = codigo;
        this.Nome = Nome;
        this.Cargo = Cargo;
        this.Unidade = Unidade;
    }
 private String Nome;
 private String Cargo;
 private String Unidade; 
 
}
