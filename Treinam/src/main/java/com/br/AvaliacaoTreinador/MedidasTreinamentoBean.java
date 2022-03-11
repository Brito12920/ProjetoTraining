
package com.br.AvaliacaoTreinador;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectMedidasTreinamento;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author v103760
 */

@ManagedBean (name="MedidasTreinamentoMB")
@RequestScoped
public class MedidasTreinamentoBean implements Serializable {
    private List<MedidasTreinamento> medidasTreinamentos= new ArrayList<>();
    private MedidasTreinamento medidasTreinamento = new MedidasTreinamento();

    public List<MedidasTreinamento> getMedidasTreinamentos() {
        return medidasTreinamentos;
    }

    public void setMedidasTreinamentos(List<MedidasTreinamento> medidasTreinamentos) {
        this.medidasTreinamentos = medidasTreinamentos;
    }

    public MedidasTreinamento getMedidasTreinamento() {
        return medidasTreinamento;
    }

    public void setMedidasTreinamento(MedidasTreinamento medidasTreinamento) {
        this.medidasTreinamento = medidasTreinamento;
    }

    private static final long serialVersionUID = 1L;
    
   
   
 public String cadastraMedidasTreinamento() throws SQLException {

                ConnectMedidasTreinamento con = new ConnectMedidasTreinamento();


                if (con.insertMedidasTrein(medidasTreinamento)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Departamento cadastrado com sucesso!", "Departamento cadastrado com sucesso!"));
                     medidasTreinamento = new MedidasTreinamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }    

}
