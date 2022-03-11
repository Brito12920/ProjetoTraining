package com.br.Quiz;

import com.br.Imagem.Local;
import com.br.Imagem.LocalManagedBean;
import com.br.Imagem.Resizable;
import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.Obt.ObtBean;
import com.br.Video.AvaliacaoVideo;
import com.br.model.database.Connect;
import com.br.model.database.ConnectQuiz;
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
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author v103760
 */
@ManagedBean (name="SelectBooleanView")
@ViewScoped
public class SelectBooleanView implements Serializable {

    private static final long serialVersionUID = 1L;
    private static String tipoAvaliacao;
    private static String codigoObt;
    private static String NomeAvaliacao;
    private String video;
    private AvaliacaoVideo model9 = new AvaliacaoVideo();
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public static String getCodigoObt() {
        return codigoObt;
    }

    public static void setCodigoObt(String codigoObt) {
        SelectBooleanView.codigoObt = codigoObt;
    }

    public static String getNomeAvaliacao() {
        return NomeAvaliacao;
    }

    public static void setNomeAvaliacao(String NomeAvaliacao) {
        SelectBooleanView.NomeAvaliacao = NomeAvaliacao;
    }

    public static String getTreinador() {
        return treinador;
    }

    public static void setTreinador(String treinador) {
        SelectBooleanView.treinador = treinador;
    }
    private static String treinador;
    public static String getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public static void setTipoAvaliacao(String tipoAvaliacao) {
        SelectBooleanView.tipoAvaliacao = tipoAvaliacao;
    }
    private boolean value1=false;
    private boolean value2;
    private List<AlternativaQ> modelos= new ArrayList<>();
    private List<Resposta> Model= new ArrayList<>();
    private Resposta respondeu = new Resposta(); 
    private final Local local = new Local();
    private String nomeImg;
    private String revisao;

    public String getRevisao() {
        return revisao;
    }

    public void setRevisao(String revisao) {
        this.revisao = revisao;
    }
    public String getNomeImg() {
        return nomeImg;
    }

    public void setNomeImg(String nomeImg) {
        this.nomeImg = nomeImg;
    }
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
    private String nomeTreinamento;
    private boolean botaoVoltar;
    private boolean botaoInicio;
    private boolean botaoFinalizar;
    private boolean botaoAlterar;
    private boolean botaoProximo;
    private double nota;

    public boolean isBotaoProximo() {
        return botaoProximo;
    }

    public void setBotaoProximo(boolean botaoProximo) {
        this.botaoProximo = botaoProximo;
    }

    public boolean isBotaoFinalizar() {
        return botaoFinalizar;
    }

    public void setBotaoFinalizar(boolean botaoFinalizar) {
        this.botaoFinalizar = botaoFinalizar;
    }

    public boolean isBotaoAlterar() {
        return botaoAlterar;
    }

    public void setBotaoAlterar(boolean botaoAlterar) {
        this.botaoAlterar = botaoAlterar;
    }
    
    public boolean isBotaoInicio() {
        return botaoInicio;
    }

    public void setBotaoInicio(boolean botaoInicio) {
        this.botaoInicio = botaoInicio;
    }
    
    public boolean isBotaoVoltar() {
        return botaoVoltar;
    }

    public void setBotaoVoltar(boolean botaoVoltar) {
        this.botaoVoltar = botaoVoltar;
    }
    
    public String getNomeTreinamento() {
        return nomeTreinamento;
    }

    public void setNomeTreinamento(String nomeTreinamento) {
        this.nomeTreinamento = nomeTreinamento;
    }
      LocalManagedBean img = new LocalManagedBean();
    public Resposta getRespondeu() {
       
        return respondeu;
    }

    public void setRespondeu(Resposta respondeu) {
        
       
        this.respondeu = respondeu;
    }
     
    public List<Resposta> getModel() {
        return Model;
    }

    public void setModel(List<Resposta> Model) {
        this.Model = Model;
    }

   

   
    
    private AlternativaQ pergunta = new AlternativaQ();
    private  int ordem;
    private  int totalPer;

    public int getTotalPer() {
        return totalPer;
    }

    public void setTotalPer(int totalPer) {
        this.totalPer = totalPer;
    }
    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }
    public AlternativaQ getPergunta() {
        return pergunta;
    }

    public void setPergunta(AlternativaQ pergunta) {
        this.pergunta = pergunta;
    }

    
   
    public List<AlternativaQ> getModelos() {
        return modelos;
    }

    public void setModelos(List<AlternativaQ> modelos) {
        this.modelos = modelos;
    }
    public boolean isValue1() {
        return value1;
    }

    public void setValue1(boolean value1) {
        System.out.println("Aqui");
        this.value1 = value1;
    }

    public boolean isValue2() {
        return value2;
    }

    public void setValue2(boolean value2) {
        this.value2 = value2;
    }

    public void addMessage() {
		String summary = value1 ? "Alternativa A" : "Unchecked"+respondeu.isRespondeuA();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
                
                 System.out.println("Aqui"+respondeu.isRespondeuA());
                 System.out.println("Respondeu");
                  System.out.println("Aqui"+respondeu.isRespondeuA());
        
	}
    public void carregar() throws SQLException{
      nota=0;
         System.out.println("Carregar ");
        ConnectQuiz con = new ConnectQuiz();
      //  pergunta.setDescricao("Teste");
         ObtBean te = new ObtBean();
        treinador = ObtBean.getTreinador();
        modelos = con.carregarAlternativa(te.getNomeAvalicao());
        codigoObt = te.getCodObt();
     
             System.out.println("Aqui video"+video);
            this.setBotaoVoltar(true);
            this.setBotaoInicio(true);
            this.setBotaoFinalizar(true);
            this.setBotaoAlterar(true);
            this.setBotaoProximo(true);
            Inicio();
          
    }
   public void carregarProxi(){
       
System.out.println("Ordem "+ordem);
           if(modelos.size() > ordem){
     
            pergunta.setDescricao(modelos.get(ordem).getDescricao());
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaA().isEmpty()){
                
            }else{
               pergunta.setAlternativaA(modelos.get(ordem).getAlternativaA());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaA("");  
            }
         
            //---------------------------------------------------------------------------
            
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaB().isEmpty()){
                
            }else{
               pergunta.setAlternativaB(modelos.get(ordem).getAlternativaB());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaB("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaC().isEmpty()){
                
            }else{
               pergunta.setAlternativaC(modelos.get(ordem).getAlternativaC());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaC("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaD().isEmpty()){
                
            }else{
               pergunta.setAlternativaD(modelos.get(ordem).getAlternativaD());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaD("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaE().isEmpty()){
                
            }else{
               pergunta.setAlternativaE(modelos.get(ordem).getAlternativaE());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaE("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaF().isEmpty()){
                
            }else{
               pergunta.setAlternativaF(modelos.get(ordem).getAlternativaF());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaF("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaG().isEmpty()){
                
            }else{
               pergunta.setAlternativaG(modelos.get(ordem).getAlternativaG());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaG("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaH().isEmpty()){
                
            }else{
               pergunta.setAlternativaH(modelos.get(ordem).getAlternativaH());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaH("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaI().isEmpty()){
                
            }else{
               pergunta.setAlternativaI(modelos.get(ordem).getAlternativaI());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaI("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaJ().isEmpty()){
                
            }else{
               pergunta.setAlternativaJ(modelos.get(ordem).getAlternativaJ());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaJ("");  
            }
         
            pergunta.setAlternativaEscolha(modelos.get(ordem).getAlternativaEscolha());
            nomeImg = modelos.get(ordem).getImagemPerg();
            nomeImg1 = modelos.get(ordem).getImagem1();
            nomeImg2 = modelos.get(ordem).getImagem2();
            nomeImg3 = modelos.get(ordem).getImagem3();
            nomeImg4 = modelos.get(ordem).getImagem4();
            nomeImg5 = modelos.get(ordem).getImagem5();
            nomeImg6 = modelos.get(ordem).getImagem6();
            nomeImg7 = modelos.get(ordem).getImagem7();
            nomeImg8 = modelos.get(ordem).getImagem8();
            nomeImg9 = modelos.get(ordem).getImagem9();
            nomeImg10 = modelos.get(ordem).getImagem10();
            
           try{
            respondeu.setRespondeuA(Model.get(ordem).isRespondeuA());
            respondeu.setRespondeuB(Model.get(ordem).isRespondeuB());
            respondeu.setRespondeuC(Model.get(ordem).isRespondeuC());
            respondeu.setRespondeuD(Model.get(ordem).isRespondeuD());
            respondeu.setRespondeuE(Model.get(ordem).isRespondeuE());
            respondeu.setRespondeuF(Model.get(ordem).isRespondeuF());
            respondeu.setRespondeuG(Model.get(ordem).isRespondeuG());
            respondeu.setRespondeuH(Model.get(ordem).isRespondeuH());
            respondeu.setRespondeuI(Model.get(ordem).isRespondeuI());
            respondeu.setRespondeuJ(Model.get(ordem).isRespondeuJ());
          
           }catch(IndexOutOfBoundsException e){
               
           }
            
          
            
           if(ordem < modelos.size()){
               ordem++;
             //  listarAlternativa();
           }
           }else{
               
            pergunta.setDescricao("");
            pergunta.setAlternativaA("");
            pergunta.setAlternativaB("");        
            pergunta.setAlternativaC(""); 
            pergunta.setAlternativaD(""); 
            pergunta.setAlternativaE(""); 
            pergunta.setAlternativaF(""); 
            pergunta.setAlternativaG(""); 
            pergunta.setAlternativaH(""); 
            pergunta.setAlternativaI(""); 
            pergunta.setAlternativaJ("");  
           // pergunta.setAlternativaEscolha("");
            nomeImg = "";
            nomeImg1 = "";
            nomeImg2 = "";
            nomeImg3 = "";
            nomeImg4 = "";
            nomeImg5 = "";
            nomeImg6 = "";
            nomeImg7 = "";
            nomeImg8 = "";
            nomeImg9 ="";
            nomeImg10 = "";
                                             
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fim!!"));
               this.setBotaoVoltar(false);
               this.setBotaoFinalizar(false);
               this.setBotaoAlterar(false);
               this.setBotaoProximo(false);
           }
  
      
   }
    public void carregarRev() throws SQLException{
       
        
         if(ordem > 0 && ordem <= modelos.size()){
       ordem --;
   }
           
            pergunta.setDescricao(modelos.get(ordem).getDescricao());
           
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaA().isEmpty()){
                
            }else{
               pergunta.setAlternativaA(modelos.get(ordem).getAlternativaA());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaA("");  
            }
         
            //---------------------------------------------------------------------------
            
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaB().isEmpty()){
                
            }else{
               pergunta.setAlternativaB(modelos.get(ordem).getAlternativaB());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaB("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaC().isEmpty()){
                
            }else{
               pergunta.setAlternativaC(modelos.get(ordem).getAlternativaC());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaC("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaD().isEmpty()){
                
            }else{
               pergunta.setAlternativaD(modelos.get(ordem).getAlternativaD());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaD("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaE().isEmpty()){
                
            }else{
               pergunta.setAlternativaE(modelos.get(ordem).getAlternativaE());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaE("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaF().isEmpty()){
                
            }else{
               pergunta.setAlternativaF(modelos.get(ordem).getAlternativaF());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaF("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaG().isEmpty()){
                
            }else{
               pergunta.setAlternativaG(modelos.get(ordem).getAlternativaG());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaG("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaH().isEmpty()){
                
            }else{
               pergunta.setAlternativaH(modelos.get(ordem).getAlternativaH());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaH("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaI().isEmpty()){
                
            }else{
               pergunta.setAlternativaI(modelos.get(ordem).getAlternativaI());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaI("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaJ().isEmpty()){
                
            }else{
               pergunta.setAlternativaJ(modelos.get(ordem).getAlternativaJ());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaJ("");  
            }
            
            
            pergunta.setAlternativaEscolha(modelos.get(ordem).getAlternativaEscolha());
            
            nomeImg = modelos.get(ordem).getImagemPerg();
            nomeImg1 = modelos.get(ordem).getImagem1();
            nomeImg2 = modelos.get(ordem).getImagem2();
            nomeImg3 = modelos.get(ordem).getImagem3();
            nomeImg4 = modelos.get(ordem).getImagem4();
            nomeImg5 = modelos.get(ordem).getImagem5();
            nomeImg6 = modelos.get(ordem).getImagem6();
            nomeImg7 = modelos.get(ordem).getImagem7();
            nomeImg8 = modelos.get(ordem).getImagem8();
            nomeImg9 = modelos.get(ordem).getImagem9();
            nomeImg10 = modelos.get(ordem).getImagem10();
           
            respondeu.setRespondeuA(Model.get(ordem).isRespondeuA());
            respondeu.setRespondeuB(Model.get(ordem).isRespondeuB());
            respondeu.setRespondeuC(Model.get(ordem).isRespondeuC());
            respondeu.setRespondeuD(Model.get(ordem).isRespondeuD());
            respondeu.setRespondeuE(Model.get(ordem).isRespondeuE());
            respondeu.setRespondeuF(Model.get(ordem).isRespondeuF());
            respondeu.setRespondeuG(Model.get(ordem).isRespondeuG());
            respondeu.setRespondeuH(Model.get(ordem).isRespondeuH());
            respondeu.setRespondeuI(Model.get(ordem).isRespondeuI());
            respondeu.setRespondeuJ(Model.get(ordem).isRespondeuJ());
          //  System.out.println("Check "+modelos.get(ordem).isRespondeuA());
     
        
           
         
    }

    /**
     *
     */
    public void AlterarQuestao(){
         
     }
   
     public void listarAlternativa(){
          
//         for(int i=0; i < Model.size();i++){
//             System.out.println(Model.get(i).getAlternativaA()+" "+Model.get(i).isRespondeuB()+" "+Model.get(i).isRespondeuC());
//         }
           System.out.println("NUMERO DE QUESTÕES "+pergunta.getAlternativaEscolha());
           int total=1;
           int cont=0;
           if(respondeu.isRespondeuA()==true){
               cont++;
           }
            if(respondeu.isRespondeuB()==true){
               cont++;
           }
           if(respondeu.isRespondeuC()==true){
               cont++;
           }
           if(respondeu.isRespondeuD()==true){
               cont++;
           }
           if(respondeu.isRespondeuE()==true){
               cont++;
           }
           if(respondeu.isRespondeuF()==true){
               cont++;
           }
           if(respondeu.isRespondeuG()==true){
               cont++;
           }
           if(respondeu.isRespondeuH()==true){
               cont++;
           }
           if(respondeu.isRespondeuI()==true){
               cont++;
           }
           if(respondeu.isRespondeuJ()==true){
               cont++;
           }
           
           
           if(pergunta.getAlternativaEscolha()==0){
              
           }else{
               total = pergunta.getAlternativaEscolha();
           } 
           
           
           if(cont > total || cont < total){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecione: "+total+" alternativa(s) para prosseguir"));
           }else{
           
           
           Resposta dados = new Resposta();
            
           dados.setRespondeuA(respondeu.isRespondeuA());
           dados.setRespondeuB(respondeu.isRespondeuB());
           dados.setRespondeuC(respondeu.isRespondeuC());
           dados.setRespondeuD(respondeu.isRespondeuD());
           dados.setRespondeuE(respondeu.isRespondeuE());
           dados.setRespondeuF(respondeu.isRespondeuF());
           dados.setRespondeuG(respondeu.isRespondeuG());
           dados.setRespondeuH(respondeu.isRespondeuH());
           dados.setRespondeuI(respondeu.isRespondeuI());
           dados.setRespondeuJ(respondeu.isRespondeuJ());
           Model.add(dados);
           
                   for(int i=0; i < Model.size();i++){
        //     System.out.println("INDICE "+i+Model.get(i).isRespondeuA()+" "+Model.get(i).isRespondeuB()+" "+Model.get(i).isRespondeuC());
         }

         respondeu.setRespondeuA(false);
         respondeu.setRespondeuB(false);
         respondeu.setRespondeuC(false);
         respondeu.setRespondeuD(false);
         respondeu.setRespondeuE(false);
         respondeu.setRespondeuF(false);
         respondeu.setRespondeuG(false);
         respondeu.setRespondeuH(false);
         respondeu.setRespondeuI(false);
         respondeu.setRespondeuJ(false);
        carregarProxi();  
           }   
     }
      public void Inicio(){
     
            
           
            totalPer = modelos.size();
            revisao = modelos.get(ordem ).getRevisao();
            pergunta.setDescricao(modelos.get(ordem).getDescricao());
           
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaA().isEmpty()){
                
            }else{
               pergunta.setAlternativaA(modelos.get(ordem).getAlternativaA());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaA("");  
            }
         
            //---------------------------------------------------------------------------
            
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaB().isEmpty()){
                
            }else{
               pergunta.setAlternativaB(modelos.get(ordem).getAlternativaB());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaB("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaC().isEmpty()){
                
            }else{
               pergunta.setAlternativaC(modelos.get(ordem).getAlternativaC());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaC("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaD().isEmpty()){
                
            }else{
               pergunta.setAlternativaD(modelos.get(ordem).getAlternativaD());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaD("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaE().isEmpty()){
                
            }else{
               pergunta.setAlternativaE(modelos.get(ordem).getAlternativaE());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaE("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaF().isEmpty()){
                
            }else{
               pergunta.setAlternativaF(modelos.get(ordem).getAlternativaF());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaF("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaG().isEmpty()){
                
            }else{
               pergunta.setAlternativaG(modelos.get(ordem).getAlternativaG());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaG("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaH().isEmpty()){
                
            }else{
               pergunta.setAlternativaH(modelos.get(ordem).getAlternativaH());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaH("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaI().isEmpty()){
                
            }else{
               pergunta.setAlternativaI(modelos.get(ordem).getAlternativaI());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaI("");  
            }
            
            //---------------------------------------------------------------------------
            try{
            if(modelos.get(ordem).getAlternativaJ().isEmpty()){
                
            }else{
               pergunta.setAlternativaJ(modelos.get(ordem).getAlternativaJ());  
            }
            }catch(NullPointerException e){
                pergunta.setAlternativaJ("");  
            }
            
            
            pergunta.setAlternativaEscolha(modelos.get(ordem).getAlternativaEscolha());
           
            tipoAvaliacao = modelos.get(ordem).getNomeAvaliacao();
           
            NomeAvaliacao = modelos.get(ordem).getCod_obt();
            
               PesisteDadosJPA jpa = new PesisteDadosJPA();
       try{
       video = jpa.loadUsoFresa("from AvaliacaoVideo where cod_obt = '"+NomeAvaliacao+"'");
       }catch(Exception e){
           
       }  
         //   img.setNomeImagem(modelos.get(ordem).getImagem1());
         //    System.out.println("Imagem "+modelos.get(ordem).getImagem1());
            nomeImg = modelos.get(ordem).getImagemPerg();
            nomeImg1 = modelos.get(ordem).getImagem1();
            nomeImg2 = modelos.get(ordem).getImagem2();
            nomeImg3 = modelos.get(ordem).getImagem3();
            nomeImg4 = modelos.get(ordem).getImagem4();
            nomeImg5 = modelos.get(ordem).getImagem5();
            nomeImg6 = modelos.get(ordem).getImagem6();
            nomeImg7 = modelos.get(ordem).getImagem7();
            nomeImg8 = modelos.get(ordem).getImagem8();
            nomeImg9 = modelos.get(ordem).getImagem9();
            nomeImg10 = modelos.get(ordem).getImagem10();
           try{
            respondeu.setRespondeuA(Model.get(ordem).isRespondeuA());
            respondeu.setRespondeuB(Model.get(ordem).isRespondeuB());
            respondeu.setRespondeuC(Model.get(ordem).isRespondeuC());
            respondeu.setRespondeuD(Model.get(ordem).isRespondeuD());
            respondeu.setRespondeuE(Model.get(ordem).isRespondeuE());
            respondeu.setRespondeuF(Model.get(ordem).isRespondeuF());
            respondeu.setRespondeuG(Model.get(ordem).isRespondeuG());
            respondeu.setRespondeuH(Model.get(ordem).isRespondeuH());
            respondeu.setRespondeuI(Model.get(ordem).isRespondeuI());
            respondeu.setRespondeuJ(Model.get(ordem).isRespondeuJ());
           }catch(IndexOutOfBoundsException e){
               
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
         try{
          for (Local local : listaLocais) {
             
               FileOutputStream fos = new FileOutputStream(path + "/"
                + local.getNomeImagem() + ".jpg");
              //    System.out.println(fos);
                fos.write(local.getModelo());
                fos.close();
                images.add(local.getNomeImagem() + ".jpg");
                
         
          }
         }catch(NullPointerException e){
             
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
      public void finalizar() throws IOException{
          GravaQuetionario gravar = new GravaQuetionario();
          ObtBean te = new ObtBean();
          double mediaNota = 10 / modelos.size();
          String resp = null;
          String correta = null;
          System.out.println("Modelos " + modelos.size());
          System.out.println("Model " + Model.size());
          DadosAvaliacao.obtModelo = te.getNomeAvalicao();
          DadosAvaliacao.codigoObt = te.getCodObt();
          for(int i=0;i < modelos.size();i++){
                
              String cod_obt= modelos.get(i).getCod_obt();
              String desc_obt= modelos.get(i).getDesc_obt();
              String Descricao= modelos.get(i).getDescricao();
              String pesoNota= modelos.get(i).getPesoNota();
              int quantAlter = modelos.get(i).getAlternativaEscolha();
              String QuantPeguntas= modelos.get(i).getQuantPeguntas();
              String alternativaA= modelos.get(i).getAlternativaA();
              String alternativaB= modelos.get(i).getAlternativaB();
              String alternativaC= modelos.get(i).getAlternativaC();
              String alternativaD= modelos.get(i).getAlternativaD();
              String alternativaE= modelos.get(i).getAlternativaE();
              String alternativaF= modelos.get(i).getAlternativaF();
              String alternativaG= modelos.get(i).getAlternativaG();
              String alternativaH= modelos.get(i).getAlternativaH();
              String alternativaI= modelos.get(i).getAlternativaI();
              String alternativaJ= modelos.get(i).getAlternativaJ();
                     
              String corretoA = null;
              String corretoB = null;
              String corretoC = null; 
              String corretoD = null;
              String corretoE = null;
              String corretoF = null;
              String corretoG = null;
              String corretoH = null;
              String corretoI = null;
              String corretoJ = null;
               
              
              
              
              //--------------------------------------------------------------
              
              try{
              if(modelos.get(i).getCorretoA().isEmpty()){
                  corretoA = "N";
              }else{
                  corretoA= modelos.get(i).getCorretoA(); 
              }
              }catch(NullPointerException e){
                   corretoA = "N";
              }
              
             
              //---------------------------------------------------------------
              
                //--------------------------------------------------------------
              
              try{
              if(modelos.get(i).getCorretoB().isEmpty()){
                  corretoB = "N";
              }else{
                  corretoB= modelos.get(i).getCorretoB(); 
              }
              }catch(NullPointerException e){
                   corretoB = "N";
              }
              
             
              //---------------------------------------------------------------
              
                //--------------------------------------------------------------
              
              try{
              if(modelos.get(i).getCorretoC().isEmpty()){
                  corretoC = "N";
              }else{
                  corretoC= modelos.get(i).getCorretoC(); 
              }
              }catch(NullPointerException e){
                   corretoC = "N";
              }
              
             
              //---------------------------------------------------------------
                //--------------------------------------------------------------
              
              try{
              if(modelos.get(i).getCorretoD().isEmpty()){
                  corretoD = "N";
              }else{
                  corretoD= modelos.get(i).getCorretoD(); 
              }
              }catch(NullPointerException e){
                   corretoD = "N";
              }
              
             
              //---------------------------------------------------------------
                //--------------------------------------------------------------
              
              try{
              if(modelos.get(i).getCorretoE().isEmpty()){
                  corretoE = "N";
              }else{
                  corretoE= modelos.get(i).getCorretoE(); 
              }
              }catch(NullPointerException e){
                   corretoE = "N";
              }
              
             
              //---------------------------------------------------------------
                //--------------------------------------------------------------
              
              try{
              if(modelos.get(i).getCorretoF().isEmpty()){
                  corretoF = "N";
              }else{
                  corretoF= modelos.get(i).getCorretoF(); 
              }
              }catch(NullPointerException e){
                   corretoF = "N";
              }
              
             
              //---------------------------------------------------------------
               //--------------------------------------------------------------
              
              try{
              if(modelos.get(i).getCorretoG().isEmpty()){
                  corretoG = "N";
              }else{
                  corretoG= modelos.get(i).getCorretoG(); 
              }
              }catch(NullPointerException e){
                   corretoG = "N";
              }
              
             
              //---------------------------------------------------------------
                //--------------------------------------------------------------
              
              try{
              if(modelos.get(i).getCorretoH().isEmpty()){
                  corretoH = "N";
              }else{
                  corretoH= modelos.get(i).getCorretoH(); 
              }
              }catch(NullPointerException e){
                   corretoH = "N";
              }
              
             
              //---------------------------------------------------------------
                //--------------------------------------------------------------
              
              try{
              if(modelos.get(i).getCorretoI().isEmpty()){
                  corretoI = "N";
              }else{
                  corretoI= modelos.get(i).getCorretoI(); 
              }
              }catch(NullPointerException e){
                   corretoI = "N";
              }
              
             
              //---------------------------------------------------------------
                //--------------------------------------------------------------
              
              try{
              if(modelos.get(i).getCorretoJ().isEmpty()){
                  corretoJ = "N";
              }else{
                  corretoJ= modelos.get(i).getCorretoJ(); 
              }
              }catch(NullPointerException e){
                   corretoJ = "N";
              }
              
             
              //---------------------------------------------------------------
              
              
//              String corretoA= modelos.get(i).getCorretoA();
//              String corretoB= modelos.get(i).getCorretoB();
//              String corretoC= modelos.get(i).getCorretoC();
//              String corretoE= modelos.get(i).getCorretoE();
//              String corretoF= modelos.get(i).getCorretoF();
//              String corretoG= modelos.get(i).getCorretoG();
//              String corretoH= modelos.get(i).getCorretoH();
//              String corretoI= modelos.get(i).getCorretoI();
//              String corretoJ= modelos.get(i).getCorretoJ();
//             
              
              
              
              
              
              boolean respondeuA= Model.get(i).isRespondeuA();
              boolean respondeuB= Model.get(i).isRespondeuB();
              boolean respondeuC= Model.get(i).isRespondeuC();
              boolean respondeuD= Model.get(i).isRespondeuD();
              boolean respondeuE= Model.get(i).isRespondeuE();
              boolean respondeuF= Model.get(i).isRespondeuF();
              boolean respondeuG= Model.get(i).isRespondeuG();
              boolean respondeuH= Model.get(i).isRespondeuH();
              boolean respondeuI=  Model.get(i).isRespondeuI();
              boolean respondeuJ= Model.get(i).isRespondeuJ();
              
              boolean alterA = this.conferencia(corretoA, respondeuA);
              boolean alterB = this.conferencia(corretoB, respondeuB);           
              boolean alterC = this.conferencia(corretoC, respondeuC);
              boolean alterD = this.conferencia(corretoD, respondeuD);
              boolean alterE = this.conferencia(corretoE, respondeuE);
              boolean alterF = this.conferencia(corretoF, respondeuF);
              boolean alterG = this.conferencia(corretoG, respondeuG);
              boolean alterH = this.conferencia(corretoH, respondeuH);
              boolean alterI = this.conferencia(corretoI, respondeuI);
              boolean alterJ = this.conferencia(corretoJ, respondeuJ);
              System.out.println("Media"+nota);
              
              
              
              
              if(alterA==true){
                
               nota += mediaNota; 
                           
                 
              }else if(alterB==true){
                  
                 nota += mediaNota; 
              }else if(alterC==true){
                  
                 nota += mediaNota; 
              }else if(alterD==true){
                  
               nota += mediaNota; 
              }else if(alterE==true){
                  
                nota += mediaNota; 
              }else if(alterF==true){
                  
                nota += mediaNota; 
              }else if(alterG==true){
                   
               nota += mediaNota; 
              }else if(alterH==true){
                   
                nota += mediaNota; 
              }else if(alterI==true){
                   
                 nota += mediaNota; 
              }else if(alterJ==true){
                  
                nota += mediaNota; 
              }
              
              
              
              
              
              if(respondeuA==true){
                  resp="A";
              }else if(respondeuB==true){
                  resp="B"; 
              }else if(respondeuC==true){
                  resp="C"; 
              }else if(respondeuD==true){
                  resp="D";
              }else if(respondeuE==true){
                   resp="E";
              }else if(respondeuF==true){
                   resp="F";
              }else if(respondeuG==true){
                   resp="G";
              }else if(respondeuH==true){
                   resp="H";
              }else if(respondeuI==true){
                   resp="I";
              }else if(respondeuJ==true){
                   resp="J";
              }
              
              
              if(corretoA.equals("S")){
                  correta="A";
              }else if(corretoB.equals("S")){
                   correta="B";
              }else if(corretoC.equals("S")){
                   correta="C";
              }else if(corretoD.isEmpty()==false && corretoD.equals("S")){
                   correta="D";
              }else if(corretoE.equals("S")){
                   correta="E";
              }else if(corretoF.equals("S")){
                   correta="F";
              }else if(corretoG.equals("S")){
                   correta="G";
              }else if(corretoH.equals("S")){
                   correta="H";
              }else if(corretoI.equals("S")){
                   correta="J";
              }else if(corretoJ.equals("S")){
                   correta="J";
              }
              
              
              String revisao= modelos.get(i).getRevisao();
              String cod_perg1= modelos.get(i).getCod_perg1();
              String imagem1= modelos.get(i).getImagem1();
              String imagem2= modelos.get(i).getImagem2();
              String imagem3= modelos.get(i).getImagem3();
              String imagem4= modelos.get(i).getImagem4();
              String imagem5= modelos.get(i).getImagem5();
              String imagem6= modelos.get(i).getImagem6();
              String imagem7= modelos.get(i).getImagem7();
              String imagem8= modelos.get(i).getImagem8();
              String imagem9= modelos.get(i).getImagem9();
              String imagem10= modelos.get(i).getImagem10();
              String unidade= modelos.get(i).getUnidade();
              String imagemPerg= modelos.get(i).getImagemPerg();
              
              
              gravar.Gravar2(te.getCodObt(),
                             Descricao, 
                             alternativaA,
                             alternativaB, 
                             alternativaC,
                             alternativaD, 
                             alternativaE, 
                             alternativaF, 
                             alternativaG, 
                             alternativaH, 
                             alternativaI, 
                             alternativaJ, 
                             correta,
                             resp, 
                             imagem1, 
                             imagem2, 
                             imagem3, 
                             imagem4, 
                             imagem5, 
                             imagem6, 
                             imagem7, 
                             imagem8, 
                             imagem9, 
                             imagem10, 
                             imagemPerg,
                             unidade, 
                             nota);
              
              
              
//              System.out.println(cod_obt);
//              System.out.println( desc_obt);
//              System.out.println("{"+i+") "+Descricao);
//              System.out.println( pesoNota);
//              System.out.println( QuantPeguntas);
//              System.out.println( alternativaA); 
//              System.out.println( alternativaB);
//              System.out.println( alternativaC); 
//              System.out.println( alternativaD); 
//              System.out.println( alternativaE); 
//              System.out.println( alternativaF); 
//              System.out.println( alternativaG);
//              System.out.println( alternativaH); 
//              System.out.println( alternativaI); 
//              System.out.println( alternativaJ); 
//              System.out.println("corretoA "+corretoA); 
//              System.out.println("corretoB "+ corretoB); 
//              System.out.println("corretoC "+ corretoC); 
//              System.out.println("corretoD "+ corretoD); 
//              System.out.println("corretoE "+ corretoE); 
//              System.out.println("corretoF "+ corretoF); 
//              System.out.println("corretoG "+ corretoG); 
//              System.out.println("corretoH "+ corretoH); 
//              System.out.println("corretoI "+ corretoI); 
//              System.out.println("corretoJ "+corretoJ);
//              System.out.println("RespondeuA "+respondeuA);
//              System.out.println("RespondeuB "+respondeuB);
//              System.out.println("RespondeuC "+respondeuC);
//              System.out.println("RespondeuD "+respondeuD);
//              System.out.println("RespondeuE "+respondeuE);
//              System.out.println("RespondeuF "+respondeuF);
//              System.out.println("RespondeuG "+respondeuG);
//              System.out.println("RespondeuH "+respondeuH);
//              System.out.println("RespondeuI "+respondeuI);
//              System.out.println("RespondeuJ "+respondeuJ);
//              System.out.println(revisao);
//              System.out.println( cod_perg1); 
//              System.out.println( imagem1); 
//              System.out.println( imagem2); 
//              System.out.println( imagem3); 
//              System.out.println( imagem4); 
//              System.out.println( imagem5); 
//              System.out.println( imagem6); 
//              System.out.println( imagem7); 
//              System.out.println( imagem8); 
//              System.out.println( imagem9);
//              System.out.println( imagem10); 
//              System.out.println( unidade); 
//              System.out.println( imagemPerg);
          }
          if(nota > 7.5){
             System.out.println("Nota "+te.getCodObt()+" Aprovado");
          }else{
            System.out.println("Nota "+te.getCodObt()+" Reprovado");  
          }
          
         
         
          
          gravar.atualizaObt(te.getCodObt(),""+nota); // atualiza o obt
           

           
            Nota nota = new Nota();
          int total;
        try {
            total = nota.totalQuestao(te.getCodObt());
            nota.apontaNota(te.getCodObt(),total);
        } catch (SQLException ex) {
            Logger.getLogger(SelectBooleanView.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      FacesContext.getCurrentInstance().getExternalContext().redirect("Avaliacao.jsf");
      }
      public void uptade(){
           Resposta dados = new Resposta();
            
           dados.setRespondeuA(respondeu.isRespondeuA());
           dados.setRespondeuB(respondeu.isRespondeuB());
           dados.setRespondeuC(respondeu.isRespondeuC());
           dados.setRespondeuD(respondeu.isRespondeuD());
           dados.setRespondeuE(respondeu.isRespondeuE());
           dados.setRespondeuF(respondeu.isRespondeuF());
           dados.setRespondeuG(respondeu.isRespondeuG());
           dados.setRespondeuH(respondeu.isRespondeuH());
           dados.setRespondeuI(respondeu.isRespondeuI());
           dados.setRespondeuJ(respondeu.isRespondeuJ());
          Model.set(ordem, dados);
      }
      
      private boolean conferencia(String resposta, boolean respondeu){
           System.out.println("Resposta "+resposta+" respondeu"+respondeu);
          
           boolean saida=false;
          
           if(respondeu ==true){
               if(resposta.equals("S")){
                   saida = true;
               }else{
                   saida = false;
               }
           }
           return saida;
      }
     
      public String redireciona() {
        return "/avaliacoes/Avaliacao?faces-redirect=true";
    }
      
      public String redirecionaAvaliacaoT() {
        return "/avaliacoes/AvaliacaoTeste?faces-redirect=true";
    }
      public String redirecionaQuestionario() {
        return "/avaliacoes/QuestionarioTeste?faces-redirect=true";
    }
}