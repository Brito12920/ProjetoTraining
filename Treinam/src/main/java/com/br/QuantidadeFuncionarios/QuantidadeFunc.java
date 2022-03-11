package com.br.QuantidadeFuncionarios;

import java.io.Serializable;

/**
 *
 * @author v103760
 */
public class QuantidadeFunc implements Serializable {

    private static final long serialVersionUID = 1L;
      private String codigo;
      private String unidade;
      private String Departamento;
      private String data;
      private String quantidade;
      private String TotalCh;
      private String mes;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getTotalCh() {
        return TotalCh;
    }

    public void setTotalCh(String TotalCh) {
        this.TotalCh = TotalCh;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
