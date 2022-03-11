package com.br.Departamento;

/**
 *
 * @author v103760
 */
public class Departamento{

   
   
    private String codigo;
//    @NotEmpty(message="Campo Departamento não pode ficar em branco")
    private String departamento;
//    @NotEmpty(message="Campo Unidade não pode ficar em branco")
    private String unidade;
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    

    

    
}
