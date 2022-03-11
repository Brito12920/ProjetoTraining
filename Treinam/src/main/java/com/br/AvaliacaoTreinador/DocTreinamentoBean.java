package com.br.AvaliacaoTreinador;

import com.br.Dashboard.JobMarketBeanAvaliacaoCat;
import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectAvaliacao;
import com.br.model.database.ConnectDoc_treinamento;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author v103760
 */

@ManagedBean (name="DocTreinamentoMB")
@RequestScoped
public class DocTreinamentoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Doc_treinamento> doc_treinamentos= new ArrayList<>();
    private List<MedidasTreinamento> medTreinamentos= new ArrayList<>();
    private List<Avaliacao> avaliacao= new ArrayList<>();
    private List<Avaliacao> avaliacao2= new ArrayList<>();
    private String texto1Buscar;

    public String getTexto1Buscar() {
        return texto1Buscar;
    }

    public void setTexto1Buscar(String texto1Buscar) {
        this.texto1Buscar = texto1Buscar;
    }
    public List<Avaliacao> getAvaliacao2() {
        return avaliacao2;
    }

    public void setAvaliacao2(List<Avaliacao> avaliacao2) {
        this.avaliacao2 = avaliacao2;
    }
    ArrayList<String> ListaAvaliacao = new ArrayList<>();

    public List<Avaliacao> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Avaliacao> avaliacao) {
        this.avaliacao = avaliacao;
    }

    public ArrayList<String> getListaAvaliacao() {
        return ListaAvaliacao;
    }

    public void setListaAvaliacao(ArrayList<String> ListaAvaliacao) {
        this.ListaAvaliacao = ListaAvaliacao;
    }
    public List<MedidasTreinamento> getMedTreinamentos() {
        return medTreinamentos;
    }

    public void setMedTreinamentos(List<MedidasTreinamento> medTreinamentos) {
        this.medTreinamentos = medTreinamentos;
    }

    public List<ProcessoQualificacao> getProcessoQualificacao() {
        return processoQualificacao;
    }

    public void setProcessoQualificacao(List<ProcessoQualificacao> processoQualificacao) {
        this.processoQualificacao = processoQualificacao;
    }
    private List<ProcessoQualificacao> processoQualificacao= new ArrayList<>();
    private Doc_treinamento docTreinamento = new Doc_treinamento();
    private int media;
    private int media2;
    private int media3;

    public int getMedia2() {
        return media2;
    }

    public void setMedia2(int media2) {
        this.media2 = media2;
    }

    public int getMedia3() {
        return media3;
    }

    public void setMedia3(int media3) {
        this.media3 = media3;
    }
    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }
    public List<Doc_treinamento> getDoc_treinamentos() throws SQLException {
        
        return doc_treinamentos;
    }

    public void setDoc_treinamentos(List<Doc_treinamento> doc_treinamentos) {
        this.doc_treinamentos = doc_treinamentos;
    }

    public Doc_treinamento getDocTreinamento() {
        return docTreinamento;
    }

    public void setDocTreinamento(Doc_treinamento docTreinamento) {
        this.docTreinamento = docTreinamento;
    }

    
   

    
 public String cadastraDoc_treinamento() throws SQLException {

                ConnectDoc_treinamento con = new ConnectDoc_treinamento();


                if (con.insertDocTreinamento(docTreinamento)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Departamento cadastrado com sucesso!", "Departamento cadastrado com sucesso!"));
                     docTreinamento = new Doc_treinamento();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }  
 
   public void buscarDocumentos() throws SQLException{
      carregar();
//        ConnectAvaliacao con;
//     
//            con = new ConnectAvaliacao();
//       
     
          List<Avaliacao> doc = new ArrayList<>();
       
    int mediaT=0;
         for(Avaliacao lista : avaliacao2){
           
          mediaT += buscarMedidasTreinamento(lista.getDescricao());
          
         }
       
      media = mediaT;
   }
   public int buscarMedidasTreinamento(String desc) throws SQLException{
      
         ConnectAvaliacao con;
     
            con = new ConnectAvaliacao();
       
       
     
       List<Avaliacao> doc = new ArrayList<>();
       
         doc = con.carregarAvaliacaoNota(texto1Buscar, desc);
         int cont=0;
         int med=0;
         for(Avaliacao lista : doc){
           
              med += lista.getNota();
          
           
              cont++;
          }
       //  media2 = (med / 10) / cont;
         return (med / cont);
   }
   public void carregar(){
          try {
     
        ConnectAvaliacao con;
     
            con = new ConnectAvaliacao();
            avaliacao2 = con.carregarAvaliacao2(this.getTexto1Buscar());
      
            
            
//             List<Avaliacao> doc = new ArrayList<>();
//            
//             
//            avaliacao2 = new ArrayList<>(new HashSet<>(avaliacao));
 
     } catch (SQLException ex) {
            Logger.getLogger(JobMarketBeanAvaliacaoCat.class.getName()).log(Level.SEVERE, null, ex);
        }   
   }
  
   
 }
