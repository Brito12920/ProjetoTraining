package com.br.Rating;

import com.br.AvaliacaoTreinador.Doc_treinamento;
import com.br.AvaliacaoTreinador.MedidasTreinamento;
import com.br.AvaliacaoTreinador.ProcessoQualificacao;
import com.br.Quiz.DadosAvaliacao;
import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectDoc_treinamento;
import com.br.model.database.ConnectMedidasTreinamento;
import com.br.model.database.ConnectProcessoQualificacao;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.RateEvent;

/**
 *
 * @author v103760
 */
@ManagedBean (name="RatingView")
@RequestScoped
public class RatingView {

    Doc_treinamento docTreinamento = new Doc_treinamento();

    public Doc_treinamento getDocTreinamento() {
        return docTreinamento;
    }

    public void setDocTreinamento(Doc_treinamento docTreinamento) {
        this.docTreinamento = docTreinamento;
    }

    public MedidasTreinamento getMedidasTreinamento() {
        return medidasTreinamento;
    }

    public void setMedidasTreinamento(MedidasTreinamento medidasTreinamento) {
        this.medidasTreinamento = medidasTreinamento;
    }

    public ProcessoQualificacao getProcessoQualificacao() {
        return processoQualificacao;
    }

    public void setProcessoQualificacao(ProcessoQualificacao processoQualificacao) {
        this.processoQualificacao = processoQualificacao;
    }
    MedidasTreinamento  medidasTreinamento = new MedidasTreinamento();
    ProcessoQualificacao processoQualificacao = new ProcessoQualificacao();
    
    private String obtModelo;

    public String getObtModelo() {
        obtModelo = DadosAvaliacao.obtModelo;
        return obtModelo;
    }

    public void setObtModelo(String obtModelo) {
        this.obtModelo = obtModelo;
    }
    private String data;
  


    
    public String getData() {
        data = ""+java.time.LocalDate.now(); 
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String getCodigoObt() {
         codigoObt = DadosAvaliacao.codigoObt;
        return codigoObt;
    }

    public void setCodigoObt(String codigoObt) {
        this.codigoObt = codigoObt;
    }
    private String codigoObt;
     
   
    

    public void onrate(RateEvent<Integer> rateEvent) {
//        rating1 = rateEvent.getRating();
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + rateEvent.getRating());
//        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

  public String cadastraAvaliacao() throws SQLException {

                ConnectDoc_treinamento con = new ConnectDoc_treinamento();
                ConnectMedidasTreinamento con2 = new ConnectMedidasTreinamento();   
                ConnectProcessoQualificacao con3 = new ConnectProcessoQualificacao();

                docTreinamento.setCodigoObt(DadosAvaliacao.codigoObt);
                docTreinamento.setData(""+java.time.LocalDate.now());
                docTreinamento.setObtModelo(DadosAvaliacao.obtModelo);
                
                medidasTreinamento.setCodigoObt(DadosAvaliacao.codigoObt);
                medidasTreinamento.setData(""+java.time.LocalDate.now());
                medidasTreinamento.setObtModelo(DadosAvaliacao.obtModelo);
                
                processoQualificacao.setCodigoObt(DadosAvaliacao.codigoObt);
                processoQualificacao.setData(""+java.time.LocalDate.now());
                processoQualificacao.setObtModelo(DadosAvaliacao.obtModelo);
                
                
                if (con.insertDocTreinamento(docTreinamento)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Avaliação cadastrado com sucesso!", "Avaliação cadastrado com sucesso!"));
                      docTreinamento = new Doc_treinamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                
                if (con2.insertMedidasTrein(medidasTreinamento)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Avaliação cadastrado com sucesso!", "Avaliação cadastrado com sucesso!"));
                     medidasTreinamento = new MedidasTreinamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                
                if (con3.insertProcessoQualificacao(processoQualificacao)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Avaliação cadastrado com sucesso!", "Avaliação cadastrado com sucesso!"));
                     processoQualificacao = new ProcessoQualificacao();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                
                
                
                con.closeConnection();
                con2.closeConnection();
                con3.closeConnection();
               

          return "";
     }    
   
    
    
}
