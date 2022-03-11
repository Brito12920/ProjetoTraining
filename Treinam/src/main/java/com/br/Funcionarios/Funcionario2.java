package com.br.Funcionarios;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author v103760
 */
@Entity
public class Funcionario2 implements Serializable{

    private static final long serialVersionUID = 1L;

 
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;  

    @Override
    public String toString() {
        return "Funcionario{" + "codigo=" + codigo + ", registro=" + registro + ", nome=" + nome + ", funcao=" + funcao + ", departamento=" + departamento + ", unidade=" + unidade + ", imagem=" + imagem + ", status=" + status + ", data=" + data + '}';
    }
   @NotEmpty(message="Campo registro não pode ficar em branco")
    private String registro;   
   @NotEmpty(message="Campo nome não pode ficar em branco")
    private String nome;
    private String funcao;
    private String departamento;

    private String unidade;
    private String imagem;
    private String status;

    public Funcionario2(int codigo, String registro, String nome, String funcao, String departamento, String unidade, String imagem, String status, String data) {
        this.codigo = codigo;
        this.registro = registro;
        this.nome = nome;
        this.funcao = funcao;
        this.departamento = departamento;
        this.unidade = unidade;
        this.imagem = imagem;
        this.status = status;
        this.data = data;
    }
    private String data;

    
    public Funcionario2(){
        
    }
    
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
  
   
   
}
