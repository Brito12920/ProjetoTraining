package com.br.Departamento;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectDepartamento;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author v103760
 */

@ManagedBean (name="DepartamentoMB")
@RequestScoped
public class DepartamentoBean implements Serializable {
    private List<Departamento> departamentos= new ArrayList<>();
    private Departamento depart = new Departamento();

    public Departamento getDepart() {
        return depart;
    }

    public void setDepart(Departamento depart) {
        this.depart = depart;
    }
    private String departamento;

    public String getDepartamento() throws SQLException {
         ConnectDepartamento con = new ConnectDepartamento();
        departamentos = con.carregarDepartamento();
        
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    private static final long serialVersionUID = 1L;
    
    
    public List<Departamento> getDepartamentos() {
        return Collections.unmodifiableList(departamentos);
    }
 public String cadastraDepartamento() throws SQLException {

                ConnectDepartamento con = new ConnectDepartamento();


                if (con.inserir(depart)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Departamento cadastrado com sucesso!", "Departamento cadastrado com sucesso!"));
                     depart = new Departamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }    
  public String alterarDepartamento() throws SQLException {

                ConnectDepartamento con = new ConnectDepartamento();


                if (con.alterar(depart)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Departamento alterado com sucesso!", "Departamento alterado com sucesso!"));
                      depart = new Departamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 public String excluirDepartamento() throws SQLException {

                 ConnectDepartamento con = new ConnectDepartamento();


                if (con.remover(depart)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Departamento excluido com sucesso!", "Departamento excluido com sucesso!"));
                     depart = new Departamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }     
}
