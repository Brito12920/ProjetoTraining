/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.UploadExcel;

import com.br.Alternativa.Alternativa;
import com.br.Excel.AbreExcel;
import com.br.Excel.AbreExcelFuncionarios;
import com.br.Funcionarios.Funcionario;
import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.Usuario.Permissao;
import com.br.Video.AvaliacaoVideo;
import com.br.model.database.Connect;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author V103760
 */
@Named(value="FileUploadViewBean")
@ViewScoped
public class FileUploadView implements Serializable {
   private Integer progress1;

    public Integer getProgress1() {
        return progress1;
    }

    public void setProgress1(Integer progress1) {
        this.progress1 = progress1;
    }
    private Part file;
   List<Alternativa> listaAvaliacoes = new ArrayList<Alternativa>();
   List<AvaliacaoVideo> listaVideos = new ArrayList<AvaliacaoVideo>();
   List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }
   
    public List<Alternativa> getListaAvaliacoes() {
        return listaAvaliacoes;
    }

    public void setListaAvaliacoes(List<Alternativa> listaAvaliacoes) {
        this.listaAvaliacoes = listaAvaliacoes;
    }

   
    
    public void upload(){
     try(InputStream is = file.getInputStream()){
         String fileName = file.getSubmittedFileName();
         String name = file.getName();
         long tamanho = file.getSize();
         String type = file.getContentType();
         ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext(); 
         String diretorio = ec.getRealPath("/");
         System.out.println("FileName"+fileName);
         System.out.println("Name"+name);
         System.out.println("Tamanho"+tamanho);
         System.out.println("type"+type);
        
         this.deleteFile(diretorio+fileName);
         
         Files.copy(is, new File(diretorio,fileName).toPath());
           System.out.println("Caminho "+diretorio+fileName);
           AbreExcel ex = new AbreExcel();
           ex.Buscar(diretorio+"/"+fileName);
          
           listaAvaliacoes = ex.getListaAvaliacoes();
           listaVideos = ex.getListaVideo();
         
     }catch(IOException e){
         
     }
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

   
     
  public void salvar(){
      
  } 
  
  public void deleteFile(String nome){
     // String nome = "C:/pasta_de_teste/teste.html";  
      File f = new File(nome);  
      f.delete();
  }
 
   public void gravar(){
           PesisteDadosJPA jpa = new PesisteDadosJPA();
           String curso = null;
           int cont = 0;
           for (Alternativa alternativa : listaAvaliacoes) {
             //  Permissao.getUnidade();
               
               if(cont==0){
                   
               }else{
                   curso = alternativa.getNomeAvaliacao();
                   System.err.println(alternativa);
                   alternativa.setUnidade(Permissao.getUnidade());
                   jpa.Insert(alternativa);
               }
              
              cont++;

               
            }

            AvaliacaoVideo video = new AvaliacaoVideo();
     
            video.setCod_obt(listaVideos.get(1).getCod_obt());
            video.setVideo(listaVideos.get(1).getVideo());
            
            jpa.Insert(video);
           
           FacesContext.getCurrentInstance().addMessage("MessageLista", new FacesMessage  (FacesMessage.SEVERITY_INFO,"Sucesso!", "Avaliação gravado com Sucesso!"));
       }
   
     public void alter(String CURSO) throws SQLException{
          Connect alt = new Connect();
                    
                     alt.AlteracaoGeral("Alternativa","alternativaA", "", "alternativaA", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","alternativaB", "", "alternativaB", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","alternativaC", "", "alternativaC", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","alternativaD", "", "alternativaD", "NULL", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","alternativaE", "", "alternativaE", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","alternativaF", "", "alternativaF", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","alternativaG", "", "alternativaG", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","alternativaH", "", "alternativaH", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","alternativaI", "", "alternativaI", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","alternativaJ", "", "alternativaJ", "null", "cod_obt",CURSO);
                     
                     alt.AlteracaoGeral("Alternativa","corretoA", "", "corretoA", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","corretoB", "", "corretoB", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","corretoC", "", "corretoC", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","corretoD", "", "corretoD", "NULL", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","corretoE", "", "corretoE", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","corretoF", "", "corretoF", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","corretoG", "", "corretoG", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","corretoH", "", "corretoH", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","corretoI", "", "corretoI", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","corretoJ", "", "corretoJ", "null", "cod_obt",CURSO); 
                     
                     alt.AlteracaoGeral("Alternativa","imagem1", "", "imagem1", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","imagem2", "", "imagem2", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","imagem3", "", "imagem3", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","imagem4", "", "imagem4", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","imagem5", "", "imagem5", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","imagem6", "", "imagem6", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","imagem7", "", "imagem7", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","imagem8", "", "imagem8", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","imagem9", "", "imagem9", "null", "cod_obt",CURSO);
                     alt.AlteracaoGeral("Alternativa","imagem10", "", "imagem10", "null", "cod_obt",CURSO);
                      
     }
     
     public void uploadFuncionarios(){
     try(InputStream is = file.getInputStream()){
         String fileName = file.getSubmittedFileName();
         String name = file.getName();
         long tamanho = file.getSize();
         String type = file.getContentType();
         ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext(); 
         String diretorio = ec.getRealPath("/");
         System.out.println("FileName"+fileName);
         System.out.println("Name"+name);
         System.out.println("Tamanho"+tamanho);
         System.out.println("type"+type);
        
         this.deleteFile(diretorio+fileName);
         
         Files.copy(is, new File(diretorio,fileName).toPath());
           System.out.println("Caminho "+diretorio+fileName);
           AbreExcelFuncionarios ex = new AbreExcelFuncionarios();
           ex.Buscar(diretorio+"/"+fileName);
          
           listaFuncionarios = ex.getListaFuncionario();
           
         
     }catch(IOException e){
         
     }
    }
     
    public void gravarFuncionarios(){
           PesisteDadosJPA jpa = new PesisteDadosJPA();
           String curso = null;
           int cont = 0;
           int total = 100 / listaFuncionarios.size();
           for (Funcionario funcionario : listaFuncionarios) {
             //  Permissao.getUnidade();
               
               if(cont==0){
                   
               }else{
//                   curso = alternativa.getNomeAvaliacao();
//                   System.err.println(alternativa);
//                   alternativa.setUnidade(Permissao.getUnidade());
                 jpa.Insert(funcionario);
               }
              
              cont++;
               
              progress1 = cont * total;

            if (progress1 >= 100) {
                progress1 = 100;
            }
            }
            progress1 = 100;

           FacesContext.getCurrentInstance().addMessage("MessageLista", new FacesMessage  (FacesMessage.SEVERITY_INFO,"Sucesso!", "Avaliação gravado com Sucesso!"));
       }  
     public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Progress Completed"));
    }
}
