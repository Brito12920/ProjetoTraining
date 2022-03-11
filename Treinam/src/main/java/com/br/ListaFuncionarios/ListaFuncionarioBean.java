/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.ListaFuncionarios;

import com.br.Funcionarios.Funcionario;
import com.br.model.database.ConnectFuncionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author v103760
 */

@ManagedBean (name="ListaFuncionarioMB")
@ViewScoped
public class ListaFuncionarioBean {
   
    private List<Funcionario> funcionario=new ArrayList<>();
    ArrayList<String> ListaFuncionario = new ArrayList<>();
    private  List lista = new ArrayList<>();
    private String valorSelecionado;

    public String getValorSelecionado() {
        return valorSelecionado;
    }

    public void setValorSelecionado(String valorSelecionado) {
        this.valorSelecionado = valorSelecionado;
    }
    
    public ArrayList<String> getListaGestor() throws SQLException {
        
          ConnectFuncionario con = new ConnectFuncionario();
          funcionario = con.listFuncionario();
      
            for(Funcionario resultados:funcionario){
         
         ListaFuncionario.add(resultados.getRegistro() +" - "+resultados.getNome());
      }
        return ListaFuncionario;
    }

        
    public void addSelecionado(){
        
       lista.add(valorSelecionado);
       System.out.println(lista.size());
       listarSelecionado();
    }
    
    public void listarSelecionado(){
      
        for(int i=0;i < lista.size();i++){
            try{    
            System.out.println(lista.get(i));
            }catch(NullPointerException e){
                
            }
        }
      
    }
}
