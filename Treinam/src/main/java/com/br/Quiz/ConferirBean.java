package com.br.Quiz;

import com.br.Imagem.Local;
import com.br.Imagem.Resizable;
import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.Obt.Obt;
import com.br.Obt.ObtBean;
import com.br.model.database.Connect;
import com.br.model.database.ConnectObt;
import com.br.model.database.ConnectQuizConsulta;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author v103760
 */
@ManagedBean (name="ConferirBean")
@ViewScoped
public class ConferirBean implements Serializable {

   private String NomeAvaliacao;
   private String video;
   private String codigoObt;

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
    private List<AlternativaConsulta> consulta= new ArrayList<>();
    private List<Obt> ListaObt= new ArrayList<>();
    private AlternativaConsulta pergunta = new AlternativaConsulta();

    public AlternativaConsulta getPergunta() {
        return pergunta;
    }

    public void setPergunta(AlternativaConsulta pergunta) {
        this.pergunta = pergunta;
    }
    private  int ordem;

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
    private String nomeImg;
    private String nomeImg1;
    private String nomeImg2;
    private String nomeImg3;
    private String nomeImg4;
    private String nomeImg5;
    private String nomeImg6;
    private String nomeImg7;
    private String nomeImg8;
    private String nomeImg9;
    private String nomeImg10;
    private String codigoOBT;
    private String treinamento;
    private String campoA;
    private String campoB;
    private String campoC;
    private double nota;
    private String status;
    private String respond;

    public String getRespond() {
        return respond;
    }

    public void setRespond(String respond) {
        this.respond = respond;
    }

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

   

    public String getCampoA() {
        return campoA;
    }

    public void setCampoA(String campoA) {
        this.campoA = campoA;
    }

    public String getCampoB() {
        return campoB;
    }

    public void setCampoB(String campoB) {
        this.campoB = campoB;
    }

    public String getCampoD() {
        return campoD;
    }

    public void setCampoD(String campoD) {
        this.campoD = campoD;
    }

    public String getCampoE() {
        return campoE;
    }

    public void setCampoE(String campoE) {
        this.campoE = campoE;
    }

    public String getCampoF() {
        return campoF;
    }

    public void setCampoF(String campoF) {
        this.campoF = campoF;
    }

    public String getCampoG() {
        return campoG;
    }

    public void setCampoG(String campoG) {
        this.campoG = campoG;
    }

    public String getCampoH() {
        return campoH;
    }

    public void setCampoH(String campoH) {
        this.campoH = campoH;
    }

    public String getCampoI() {
        return campoI;
    }

    public void setCampoI(String campoI) {
        this.campoI = campoI;
    }

    public String getCampoJ() {
        return campoJ;
    }

    public void setCampoJ(String campoJ) {
        this.campoJ = campoJ;
    }
    private String campoD;
    private String campoE;
    private String campoF;
    private String campoG;
    private String campoH;
    private String campoI;
    private String campoJ;
    
    public String getCampoC() {
        return campoC;
    }

    public void setCampoC(String campoC) {
        this.campoC = campoC;
    }

    
    
    public String getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(String treinamento) {
        this.treinamento = treinamento;
    }
    public void carregar() throws SQLException{
                   campoA = "width:90%;  color: black;background-color: white"; 
                   campoB = "width:90%;  color: black;background-color: white"; 
                   campoC = "width:90%;  color: black;background-color: white"; 
                   campoD = "width:90%;  color: black;background-color: white"; 
                   campoE = "width:90%;  color: black;background-color: white"; 
                   campoF = "width:90%;  color: black;background-color: white"; 
                   campoG = "width:90%;  color: black;background-color: white"; 
                   campoH = "width:90%;  color: black;background-color: white"; 
                   campoI = "width:90%;  color: black;background-color: white"; 
                   campoJ = "width:90%;  color: black;background-color: white";  
    
        ObtBean te = new ObtBean();

        System.out.println("NOME DO TREINAMENTO"+te.getCodObt());
       ConnectQuizConsulta ct = new ConnectQuizConsulta();
       consulta = ct.carregarAlternativa(te.getCodObt());
       codigoObt = te.getCodObt();
       treinamento = te.getNomeAvalicao();
           NomeAvaliacao = te.getNomeAvalicao();
            Inicio();
          
    }
     public void addMessage() {
		//String summary = value1 ? "Alternativa A" : "Unchecked"+respondeu.isRespondeuA();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(""));
                
               //  System.out.println("Aqui"+respondeu.isRespondeuA());
        
	}
   public void carregarProxi(){
       
System.out.println("Ordem "+ordem);
           if(consulta.size() > ordem){
     
            //   pergunta.setPergunta(consulta.get(ordem).getPergunta());
                //---------------------------------------------------------------------------
            try{
            if(consulta.get(ordem).getPergunta().isEmpty() ){
                
            }else{
               pergunta.setPergunta(consulta.get(ordem).getPergunta());  
            }
            }catch(NullPointerException e){
                pergunta.setPergunta("");  
            }
         
            //---------------------------------------------------------------------------
            
            
            
             try{
            if(consulta.get(ordem).getResposta_A().isEmpty()  || consulta.get(ordem).getResposta_A().contains("null") ){
                pergunta.setResposta_A(""); 
            }else{
               pergunta.setResposta_A(consulta.get(ordem).getResposta_A());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_A("");  
            }
         
            //---------------------------------------------------------------------------
            
               
               
             //---------------------------------------------------------------------------
            
            
            
             try{
            if(consulta.get(ordem).getResposta_B().isEmpty() || consulta.get(ordem).getResposta_B().contains("null") ){
                pergunta.setResposta_B(""); 
            }else{
               pergunta.setResposta_B(consulta.get(ordem).getResposta_B());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_B("");  
            }
         
            //---------------------------------------------------------------------------
            
             //---------------------------------------------------------------------------
            
            
            
             try{
            if(consulta.get(ordem).getResposta_C().isEmpty()  || consulta.get(ordem).getResposta_C().contains("null") ){
                pergunta.setResposta_C(""); 
            }else{
               pergunta.setResposta_C(consulta.get(ordem).getResposta_C());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_C("");  
            }
         
            //---------------------------------------------------------------------------
            
             //---------------------------------------------------------------------------
            
            
            
             try{
            if(consulta.get(ordem).getResposta_D().isEmpty()  || consulta.get(ordem).getResposta_D().contains("null") ){
                pergunta.setResposta_D(""); 
            }else{
               pergunta.setResposta_D(consulta.get(ordem).getResposta_D());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_D("");  
            }
         
            //---------------------------------------------------------------------------
            
             //---------------------------------------------------------------------------
            
            
            
             try{
            if(consulta.get(ordem).getResposta_E().isEmpty() || consulta.get(ordem).getResposta_E().contains("null") ){
                pergunta.setResposta_E(""); 
            }else{
               pergunta.setResposta_E(consulta.get(ordem).getResposta_E());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_E("");  
            }
         
            //---------------------------------------------------------------------------
            
             //---------------------------------------------------------------------------
            
            
            
             try{
            if(consulta.get(ordem).getResposta_F().isEmpty()  || consulta.get(ordem).getResposta_F().contains("null") ){
                pergunta.setResposta_F(""); 
            }else{
               pergunta.setResposta_F(consulta.get(ordem).getResposta_F());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_F("");  
            }
         
            //---------------------------------------------------------------------------
            
             //---------------------------------------------------------------------------
            
            
            
             try{
            if(consulta.get(ordem).getResposta_G().isEmpty()  || consulta.get(ordem).getResposta_G().contains("null") ){
                pergunta.setResposta_G(""); 
            }else{
               pergunta.setResposta_G(consulta.get(ordem).getResposta_G());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_G("");  
            }
         
            //---------------------------------------------------------------------------
            
             //---------------------------------------------------------------------------
            
            
            
             try{
            if(consulta.get(ordem).getResposta_H().isEmpty()  || consulta.get(ordem).getResposta_H().contains("null") ){
                pergunta.setResposta_H(""); 
            }else{
               pergunta.setResposta_H(consulta.get(ordem).getResposta_H());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_H("");  
            }
         
            //---------------------------------------------------------------------------
            
             //---------------------------------------------------------------------------
            
            
            
             try{
            if(consulta.get(ordem).getResposta_I().isEmpty()  || consulta.get(ordem).getResposta_I().contains("null") ){
                pergunta.setResposta_I(""); 
            }else{
               pergunta.setResposta_I(consulta.get(ordem).getResposta_I());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_I("");  
            }
         
            //---------------------------------------------------------------------------
            
             //---------------------------------------------------------------------------
            
            
            
             try{
            if(consulta.get(ordem).getResposta_J().isEmpty()  || consulta.get(ordem).getResposta_J().contains("null") ){
                pergunta.setResposta_J(""); 
            }else{
               pergunta.setResposta_J(consulta.get(ordem).getResposta_J());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_J("");  
            }
         
            //---------------------------------------------------------------------------
            
//               pergunta.setResposta_A(consulta.get(ordem).getResposta_A());
//               pergunta.setResposta_B(consulta.get(ordem).getResposta_B());
//               pergunta.setResposta_C(consulta.get(ordem).getResposta_C());
//               pergunta.setResposta_D(consulta.get(ordem).getResposta_D());
//               pergunta.setResposta_E(consulta.get(ordem).getResposta_E());
//               pergunta.setResposta_F(consulta.get(ordem).getResposta_F());
//               pergunta.setResposta_G(consulta.get(ordem).getResposta_G());
//               pergunta.setResposta_H(consulta.get(ordem).getResposta_H());
//               pergunta.setResposta_I(consulta.get(ordem).getResposta_I());
//               pergunta.setResposta_J(consulta.get(ordem).getResposta_J());


              
               pergunta.setRespA(consulta.get(ordem).isRespA());
               pergunta.setRespB(consulta.get(ordem).isRespB());
               pergunta.setRespC(consulta.get(ordem).isRespC());
               pergunta.setRespD(consulta.get(ordem).isRespD());
               pergunta.setRespE(consulta.get(ordem).isRespE());
               pergunta.setRespF(consulta.get(ordem).isRespF());
               pergunta.setRespG(consulta.get(ordem).isRespG());
               pergunta.setRespH(consulta.get(ordem).isRespH());
               pergunta.setRespI(consulta.get(ordem).isRespI());
               pergunta.setRespJ(consulta.get(ordem).isRespJ());

               nomeImg = consulta.get(ordem).getImagemPerg();
               nomeImg1 = consulta.get(ordem).getImagem1();
               nomeImg2 = consulta.get(ordem).getImagem2();
               nomeImg3 = consulta.get(ordem).getImagem3();
               nomeImg4 = consulta.get(ordem).getImagem4();
               nomeImg5 = consulta.get(ordem).getImagem5();
               nomeImg6 = consulta.get(ordem).getImagem6();
               nomeImg7 = consulta.get(ordem).getImagem7();
               nomeImg8 = consulta.get(ordem).getImagem8();
               nomeImg9 = consulta.get(ordem).getImagem9();
               nomeImg10 = consulta.get(ordem).getImagem10();
            
               
               
            
            coresRep(consulta.get(ordem ).getRespostaCorreta(),consulta.get(ordem ).getRespondeu());
            
           if(ordem < consulta.size()){
               ordem++;
             //  listarAlternativa();
           }
          
           }
      
   }
    public void carregarRev() throws SQLException{
       
        
         if(ordem > 0 && ordem <= consulta.size()){
       ordem --;
   }
           

//         pergunta.setPergunta(consulta.get(ordem).getPergunta());
//            pergunta.setResposta_A(consulta.get(ordem ).getResposta_A());
//            pergunta.setResposta_B(consulta.get(ordem ).getResposta_B());    
//            pergunta.setResposta_C(consulta.get(ordem ).getResposta_C()); 
//            pergunta.setResposta_D(consulta.get(ordem ).getResposta_D()); 
//            pergunta.setResposta_E(consulta.get(ordem ).getResposta_E()); 
//            pergunta.setResposta_F(consulta.get(ordem ).getResposta_F());
//            pergunta.setResposta_G(consulta.get(ordem ).getResposta_G()); 
//            pergunta.setResposta_H(consulta.get(ordem ).getResposta_H()); 
//            pergunta.setResposta_I(consulta.get(ordem ).getResposta_I()); 
//            pergunta.setResposta_J(consulta.get(ordem ).getResposta_J());  
            
             try{
            if(consulta.get(ordem).getResposta_A().isEmpty()  || consulta.get(ordem).getResposta_A().contains("null") ){
                 pergunta.setResposta_A("");  
            }else{
               pergunta.setResposta_A(consulta.get(ordem).getResposta_A());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_A("");  
            }
           // --/////////////////////////////////////////////////////////////
            
             try{
            if(consulta.get(ordem).getResposta_B().isEmpty()  || consulta.get(ordem).getResposta_B().contains("null") ){
                 pergunta.setResposta_B("");  
            }else{
               pergunta.setResposta_B(consulta.get(ordem).getResposta_B());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_B("");  
            }
           // --/////////////////////////////////////////////////////////////
            try{
            if(consulta.get(ordem).getResposta_C().isEmpty() || consulta.get(ordem).getResposta_C().contains("null") ){
                 pergunta.setResposta_C("");  
            }else{
               pergunta.setResposta_C(consulta.get(ordem).getResposta_C() );  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_C("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_D().isEmpty() || consulta.get(ordem).getResposta_D().contains("null") ){
                 pergunta.setResposta_D("");  
            }else{
               pergunta.setResposta_D(consulta.get(ordem).getResposta_D());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_D("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_E().isEmpty()  || consulta.get(ordem).getResposta_E().contains("null") ){
                 pergunta.setResposta_E("");  
            }else{
               pergunta.setResposta_E(consulta.get(ordem).getResposta_E());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_E("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_F().isEmpty() || consulta.get(ordem).getResposta_F().contains("null") ){
                 pergunta.setResposta_F("");  
            }else{
               pergunta.setResposta_F(consulta.get(ordem).getResposta_F());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_F("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_G().isEmpty() || consulta.get(ordem).getResposta_G().contains("null") ){
                 pergunta.setResposta_G("");  
            }else{
               pergunta.setResposta_G(consulta.get(ordem).getResposta_G());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_G("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_H().isEmpty() || consulta.get(ordem).getResposta_H().contains("null") ){
                 pergunta.setResposta_H("");  
            }else{
               pergunta.setResposta_H(consulta.get(ordem).getResposta_H());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_H("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_I().isEmpty() || consulta.get(ordem).getResposta_I().contains("null") ){
                 pergunta.setResposta_I("");  
            }else{
               pergunta.setResposta_I(consulta.get(ordem).getResposta_I());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_I("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_J().isEmpty() || consulta.get(ordem).getResposta_J().contains("null") ){
                 pergunta.setResposta_J("");  
            }else{
               pergunta.setResposta_J(consulta.get(ordem).getResposta_J());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_J("");  
            }
           // --/////////////////////////////////////////////////////////////
            
            
            pergunta.setRespA(consulta.get(ordem ).isRespA());   
            pergunta.setRespB(consulta.get(ordem ).isRespB());  
            pergunta.setRespC(consulta.get(ordem ).isRespC());  
            pergunta.setRespD(consulta.get(ordem ).isRespD());  
            pergunta.setRespE(consulta.get(ordem ).isRespE());  
            pergunta.setRespF(consulta.get(ordem ).isRespF());  
            pergunta.setRespG(consulta.get(ordem ).isRespG());  
            pergunta.setRespH(consulta.get(ordem ).isRespH());  
            pergunta.setRespI(consulta.get(ordem ).isRespI());  
            pergunta.setRespJ(consulta.get(ordem ).isRespJ());  
            
            nomeImg =  consulta.get(ordem).getImagemPerg();
            nomeImg1 = consulta.get(ordem).getImagem1();
            nomeImg2 = consulta.get(ordem).getImagem2();
            nomeImg3 = consulta.get(ordem).getImagem3();
            nomeImg4 = consulta.get(ordem).getImagem4();
            nomeImg5 = consulta.get(ordem).getImagem5();
            nomeImg6 = consulta.get(ordem).getImagem6();
            nomeImg7 = consulta.get(ordem).getImagem7();
            nomeImg8 = consulta.get(ordem).getImagem8();
            nomeImg9 = consulta.get(ordem).getImagem9();
            nomeImg10 = consulta.get(ordem).getImagem10();
          
          //  System.out.println("Check "+modelos.get(ordem).isRespondeuA());
     
            coresRep(consulta.get(ordem ).getRespostaCorreta(),consulta.get(ordem ).getRespondeu());
           
         
    }

    /**
     *
     */
    public void AlterarQuestao(){
         
     }
   
     
      public void Inicio(){
     
          
          
           System.out.println("Inicio");
     
            pergunta.setPergunta(consulta.get(ordem).getPergunta());
        
            
            try{
            if(consulta.get(ordem).getResposta_A().isEmpty()  || consulta.get(ordem).getResposta_A().contains("null") ){
                  pergunta.setResposta_A("");  
            }else{
               pergunta.setResposta_A(consulta.get(ordem).getResposta_A());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_A("");  
            }
           // --/////////////////////////////////////////////////////////////
            
             try{
            if(consulta.get(ordem).getResposta_B().isEmpty()  || consulta.get(ordem).getResposta_B().contains("null") ){
                 pergunta.setResposta_B("");  
            }else{
               pergunta.setResposta_B(consulta.get(ordem).getResposta_B());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_B("");  
            }
           // --/////////////////////////////////////////////////////////////
            try{
            if(consulta.get(ordem).getResposta_C().isEmpty() || consulta.get(ordem).getResposta_C().contains("null") ){
                 pergunta.setResposta_C("");  
            }else{
               pergunta.setResposta_C(consulta.get(ordem).getResposta_C() );  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_C("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_D().isEmpty() || consulta.get(ordem).getResposta_D().contains("null") ){
                 pergunta.setResposta_D("");  
            }else{
               pergunta.setResposta_D(consulta.get(ordem).getResposta_D());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_D("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_E().isEmpty()  || consulta.get(ordem).getResposta_E().contains("null") ){
                 pergunta.setResposta_E("");  
            }else{
               pergunta.setResposta_E(consulta.get(ordem).getResposta_E());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_E("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_F().isEmpty() || consulta.get(ordem).getResposta_F().contains("null") ){
                 pergunta.setResposta_F("");  
            }else{
               pergunta.setResposta_F(consulta.get(ordem).getResposta_F());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_F("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_G().isEmpty() || consulta.get(ordem).getResposta_G().contains("null") ){
                 pergunta.setResposta_G("");  
            }else{
               pergunta.setResposta_G(consulta.get(ordem).getResposta_G());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_G("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_H().isEmpty() || consulta.get(ordem).getResposta_H().contains("null") ){
                 pergunta.setResposta_H("");  
            }else{
               pergunta.setResposta_H(consulta.get(ordem).getResposta_H());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_H("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_I().isEmpty() || consulta.get(ordem).getResposta_I().contains("null") ){
                 pergunta.setResposta_I("");  
            }else{
               pergunta.setResposta_I(consulta.get(ordem).getResposta_I());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_I("");  
            }
           // --/////////////////////////////////////////////////////////////
           
            try{
            if(consulta.get(ordem).getResposta_J().isEmpty() || consulta.get(ordem).getResposta_J().contains("null") ){
                 pergunta.setResposta_J("");  
            }else{
               pergunta.setResposta_J(consulta.get(ordem).getResposta_J());  
            }
            }catch(NullPointerException e){
                pergunta.setResposta_J("");  
            }
           // --/////////////////////////////////////////////////////////////
            
            
            
//            pergunta.setResposta_A(consulta.get(ordem ).getResposta_A());
//            pergunta.setResposta_B(consulta.get(ordem ).getResposta_B());    
//            pergunta.setResposta_C(consulta.get(ordem ).getResposta_C()); 
//            pergunta.setResposta_D(consulta.get(ordem ).getResposta_D()); 
//            pergunta.setResposta_E(consulta.get(ordem ).getResposta_E()); 
//            pergunta.setResposta_F(consulta.get(ordem ).getResposta_F());
//            pergunta.setResposta_G(consulta.get(ordem ).getResposta_G()); 
//            pergunta.setResposta_H(consulta.get(ordem ).getResposta_H()); 
//            pergunta.setResposta_I(consulta.get(ordem ).getResposta_I()); 
//            pergunta.setResposta_J(consulta.get(ordem ).getResposta_J());  
           
            PesisteDadosJPA jpa = new PesisteDadosJPA();
       try{
       video = jpa.loadUsoFresa("from AvaliacaoVideo where cod_obt = '"+NomeAvaliacao+"'");
       }catch(Exception e){
           
       }              

            pergunta.setRespA(consulta.get(ordem ).isRespA());   
            pergunta.setRespB(consulta.get(ordem ).isRespB());  
            pergunta.setRespC(consulta.get(ordem ).isRespC());  
            pergunta.setRespD(consulta.get(ordem ).isRespD());  
            pergunta.setRespE(consulta.get(ordem ).isRespE());  
            pergunta.setRespF(consulta.get(ordem ).isRespF());  
            pergunta.setRespG(consulta.get(ordem ).isRespG());  
            pergunta.setRespH(consulta.get(ordem ).isRespH());  
            pergunta.setRespI(consulta.get(ordem ).isRespI());  
            pergunta.setRespJ(consulta.get(ordem ).isRespJ());  
            
            nomeImg =  consulta.get(ordem).getImagemPerg();
            nomeImg1 = consulta.get(ordem).getImagem1();
            nomeImg2 = consulta.get(ordem).getImagem2();
            nomeImg3 = consulta.get(ordem).getImagem3();
            nomeImg4 = consulta.get(ordem).getImagem4();
            nomeImg5 = consulta.get(ordem).getImagem5();
            nomeImg6 = consulta.get(ordem).getImagem6();
            nomeImg7 = consulta.get(ordem).getImagem7();
            nomeImg8 = consulta.get(ordem).getImagem8();
            nomeImg9 = consulta.get(ordem).getImagem9();
            nomeImg10 = consulta.get(ordem).getImagem10();
            
            System.out.println("Pergunta A "+consulta.get(ordem).getPergunta());
            
         //  listarAlternativa();
       
       
         coresRep(consulta.get(ordem ).getRespostaCorreta(),consulta.get(ordem ).getRespondeu());
       try {
           Nota();
       } catch (SQLException ex) {
           Logger.getLogger(ConferirBean.class.getName()).log(Level.SEVERE, null, ex);
       }
         
          ordem=1;
           
  
      
   }
    public List<String> getImages(String nome) throws SQLException, IOException {
      
           
          Connect con = new Connect();
     //     System.out.println("nomeImagem "+nome);
         
          List<Local> listaLocais = con.listaImagem(nome);
          List<String> images = new ArrayList<String>();

          String path = FacesContext.getCurrentInstance()
          .getExternalContext().getRealPath("");
        //  System.out.println(path);
         
          for (Local local : listaLocais) {
             try{
               FileOutputStream fos = new FileOutputStream(path + "/"
                + local.getNomeImagem() + ".jpg");
              //    System.out.println(fos);
                fos.write(local.getModelo());
                fos.close();
                images.add(local.getNomeImagem() + ".jpg");
             }catch(NullPointerException e){
                 
             }
         
          }
          return images;
     }   
  public List<String> getImage() throws SQLException, IOException {
      
           Resizable res = new Resizable();
           res.ImagemANormal();
           List<String> images = new ArrayList<String>();
             images = getImages(nomeImg);
         
        
          return images;
     }   
   public List<String> getImage1() throws SQLException, IOException {
      
           Resizable res = new Resizable();
           res.ImagemANormal();
           List<String> images = new ArrayList<String>();
             images = getImages(nomeImg1);
         
        
          return images;
     }   
    public List<String> getImage2() throws SQLException, IOException {
      
           Resizable res = new Resizable();
           res.ImagemANormal();
           List<String> images = new ArrayList<String>();
             images = getImages(nomeImg2);
         
        
          return images;
     } 
     public List<String> getImage3() throws SQLException, IOException {
      
           Resizable res = new Resizable();
           res.ImagemANormal();
           List<String> images = new ArrayList<String>();
             images = getImages(nomeImg3);
         
        
          return images;
     }   
      public List<String> getImage4() throws SQLException, IOException {
      
           Resizable res = new Resizable();
           res.ImagemANormal();
           List<String> images = new ArrayList<String>();
             images = getImages(nomeImg4);
         
        
          return images;
     }   
       public List<String> getImage5() throws SQLException, IOException {
      
           Resizable res = new Resizable();
           res.ImagemANormal();
           List<String> images = new ArrayList<String>();
             images = getImages(nomeImg5);
         
        
          return images;
     }   
      public List<String> getImage6() throws SQLException, IOException {
      
           Resizable res = new Resizable();
           res.ImagemANormal();
           List<String> images = new ArrayList<String>();
             images = getImages(nomeImg6);
         
        
          return images;
     }     
       public List<String> getImage7() throws SQLException, IOException {
      
           Resizable res = new Resizable();
           res.ImagemANormal();
           List<String> images = new ArrayList<String>();
             images = getImages(nomeImg6);
         
        
          return images;
     }
      public List<String> getImage8() throws SQLException, IOException {
      
           Resizable res = new Resizable();
           res.ImagemANormal();
           List<String> images = new ArrayList<String>();
             images = getImages(nomeImg8);
         
        
          return images;
     }     
      public List<String> getImage9() throws SQLException, IOException {
      
           Resizable res = new Resizable();
           res.ImagemANormal();
           List<String> images = new ArrayList<String>();
             images = getImages(nomeImg9);
         
        
          return images;
     }    
      public List<String> getImage10() throws SQLException, IOException {
      
           Resizable res = new Resizable();
           res.ImagemANormal();
           List<String> images = new ArrayList<String>();
             images = getImages(nomeImg10);
         
        
          return images;
     }
     public void coresRep(String resp,String respondeu){
         
         if(resp.equals(respondeu)){
             respond="ACERTOU";
         }else{
             respond="ERROU";
         }
         
         
         
         if(resp.equals("A")){
             campoA = "width:90%;  color: white;background-color: green";
         }else{
             campoA = "width:90%;  color: black;background-color: red"; 
         }
         
          if(resp.equals("B")){
             campoB = "width:90%;  color: white;background-color: green";
         }else{
             campoB = "width:90%;  color: black;background-color: red"; 
         }
         
           if(resp.equals("C")){
             campoC = "width:90%;  color: white;background-color: green";
         }else{
             campoC = "width:90%;  color: black;background-color: red"; 
         }
           
          if(resp.equals("D")){
             campoD = "width:90%;  color: white;background-color: green";
         }else{
             campoD = "width:90%;  color: black;background-color: red"; 
         }  
           
          if(resp.equals("E")){
             campoE = "width:90%;  color: white;background-color: green";
         }else{
             campoE = "width:90%;  color: black;background-color: red"; 
         } 
          
           if(resp.equals("F")){
             campoF = "width:90%;  color: white;background-color: green";
         }else{
             campoF = "width:90%;  color: black;background-color: red"; 
         }
          
          
            if(resp.equals("G")){
             campoG = "width:90%;  color: white;background-color: green";
         }else{
             campoG = "width:90%;  color: black;background-color: red"; 
         }
          
          if(resp.equals("H")){
             campoH = "width:90%;  color: white;background-color: green";
         }else{
             campoH = "width:90%;  color: black;background-color: red"; 
         }   
            
          if(resp.equals("I")){
             campoI = "width:90%;  color: white;background-color: green";
         }else{
             campoI = "width:90%;  color: black;background-color: red"; 
         }   
          
           if(resp.equals("J")){
             campoJ = "width:90%;  color: white;background-color: green";
         }else{
             campoJ = "width:90%;  color: black;background-color: red"; 
         }
          
     }
     public void Nota() throws SQLException{
//         
//         for(int i=0;i < consulta.size();i++){
//              nota = Double.parseDouble(consulta.get(0).getNota());
//              System.out.println("Nota"+Double.parseDouble(consulta.get(i).getNota()));

//         DecimalFormat formato = new DecimalFormat("#.##");      
//         nota = Double.valueOf(formato.format(nota));
//     }

        ConnectObt con = new ConnectObt();
      
       
           nota = Double.parseDouble(con.findObt(codigoObt));
       
                
         if(nota >= 7.5){
             status = "APROVADO";
         }else if(nota < 7.5){
             status = "REPROVADO";
         }
      
     }
    
}