package com.br.Unidade;

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
public class Unidade implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;

    public Unidade() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getTotalFuncionarios() {
        return TotalFuncionarios;
    }

    public void setTotalFuncionarios(String TotalFuncionarios) {
        this.TotalFuncionarios = TotalFuncionarios;
    }

    @Override
    public String toString() {
        return "Unidade{" + "codigo=" + codigo + ", unidade=" + unidade + ", TotalFuncionarios=" + TotalFuncionarios + '}';
    }

    public Unidade(int codigo, String unidade, String TotalFuncionarios) {
        this.codigo = codigo;
        this.unidade = unidade;
        this.TotalFuncionarios = TotalFuncionarios;
    }
    private String unidade;
    private String TotalFuncionarios;

   

  

    
}
