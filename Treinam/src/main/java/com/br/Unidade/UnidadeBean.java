package com.br.Unidade;

import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectUnidade;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * @author v103760
 *
 */
@RequestScoped
@ManagedBean (name="UnidadeMB")
public class UnidadeBean implements Serializable {
   private List<Unidade> unidades= new ArrayList<>();
   private Unidade unit = new Unidade();
   private String unidade;

    public List<Unidade> getUnidades() throws SQLException {
         ConnectUnidade con = new ConnectUnidade();
        unidades = con.carregarUnidade();
        return Collections.unmodifiableList(unidades);
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }

    public Unidade getUnit() {
        return unit;
    }

    public void setUnit(Unidade unit) {
        this.unit = unit;
    }

    public String getUnidade() throws SQLException {
         ConnectUnidade con = new ConnectUnidade();
        unidades = con.carregarUnidade();
        
        return unidade;
    }

   
    private static final long serialVersionUID = 1L;
    
    
   
 public String cadastraUnidade() throws SQLException {

                
                PesisteDadosJPA jpa = new PesisteDadosJPA();

                if (jpa.Insert(unit)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Unidade cadastrado com sucesso!", "Unidade cadastrado com sucesso!"));
                     unit = new Unidade();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
              

               

          return "";
     }    
  public String alterarUnidade() throws SQLException {

                 PesisteDadosJPA jpa = new PesisteDadosJPA();


                if (jpa.updateUnidDE(unit)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Unidade alterado com sucesso!", "Unidade alterado com sucesso!"));
                      unit = new Unidade();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
             

               

          return "";
     } 
 public String excluirUnidade() throws SQLException {

                 PesisteDadosJPA jpa = new PesisteDadosJPA();


                if (jpa.deleteUnidade(unit.getCodigo())) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Unidade excluido com sucesso!", "Unidade excluido com sucesso!"));
                     unit = new Unidade();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
              

               

          return "";
     }     
}