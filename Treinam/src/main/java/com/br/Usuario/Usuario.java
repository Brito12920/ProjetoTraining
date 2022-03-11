package com.br.Usuario;

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
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    public Usuario() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", usuario=" + usuario + ", departamento=" + departamento + ", unidade=" + unidade + ", tipo=" + tipo + ", senha=" + senha + '}';
    }

    public Usuario(int codigo, String usuario, String departamento, String unidade, String tipo, String senha) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.departamento = departamento;
        this.unidade = unidade;
        this.tipo = tipo;
        this.senha = senha;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    private String usuario;
    private String departamento;
    private String unidade;
    private String tipo;
    private String senha;
   
}
