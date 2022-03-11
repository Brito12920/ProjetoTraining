package com.br.Imagem;

/**
 *
 * @author v103760
 */
import com.br.Usuario.Permissao;
import com.br.model.database.Connect;
import com.br.model.database.ConnectImagem;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DefaultStreamedContent;


@ManagedBean(name = "LocalMB")
@ViewScoped
public class LocalManagedBean {

     private Local local = new Local();

     private List<String> imagens;
     private String NomeImagem;
     private String nomeImg;
     private String nomeExibido;
     private String unidade;
     boolean botaoGravar;

    public boolean isBotaoGravar() {
    
        return botaoGravar;
    }

    public void setBotaoGravar(boolean botaoGravar) {
        this.botaoGravar = botaoGravar;
    }

    
     boolean botaoExcluir;

    public boolean isBotaoExcluir() {
      
        return botaoExcluir;
    }

    public void setBotaoExcluir(boolean botaoExcluir) {
        this.botaoExcluir = botaoExcluir;
    }

    public String getNomeExibido() {
        return nomeExibido;
    }

    public void setNomeExibido(String nomeExibido) {
        this.nomeExibido = nomeExibido;
    }

    public String getUnidade() {
        unidade = Permissao.getUnidade();
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
     private List<Imagem> ima= new ArrayList<>();
     private List<Local> imagemTabela= new ArrayList<>();
     DefaultStreamedContent myImage;
     private Local selectedImagem; 

    public Local getSelectedImagem() {
        return selectedImagem;
    }

    public void setSelectedImagem(Local selectedImagem) {
        this.selectedImagem = selectedImagem;
    }
    public DefaultStreamedContent getMyImage() throws SQLException {
        MostraImagem img2 = new MostraImagem();
        img2.blobToStreamedContentConvertor();
        myImage = img2.getMyImage();
        return myImage;
    }

    public void setMyImage(DefaultStreamedContent myImage) {
        this.myImage = myImage;
    }
     
    public List<Local> getImagemTabela() throws SQLException, IOException {
        
       
//        carregarImagem();
        return imagemTabela;
    }

    public void setImagemTabela(List<Local> imagemTabela) {
        this.imagemTabela = imagemTabela;
    }

  
    private Imagem img = new Imagem();

    public Imagem getImg() {
        return img;
    }

    public void setImg(Imagem img) {
        this.img = img;
    }

    
    public List<Imagem> getIma() {
        
        return ima;
    }

    public void setIma(List<Imagem> ima) {
        this.ima = ima;
    }
    public String getNomeImg() {
        return nomeImg;
    }

    public void setNomeImg(String nomeImg) {
        this.nomeImg = nomeImg;
    }

    public String getNomeImagem() {
        return NomeImagem;
    }

    public void setNomeImagem(String NomeImagem) {
        this.NomeImagem = NomeImagem;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }
     private String caminho;
     
     
    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
  
  
    public void handleFileUpload(FileUploadEvent event) {

      
     local.setModelo(event.getFile().getContent());

        FacesMessage message = new FacesMessage("Succesful",
                event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        botaoGravar = true; 
        System.out.println(botaoGravar);
    }

     public String cadastraLocal() throws SQLException {

          Connect con = new Connect();

          if (con.insertLocal(local)) {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
                  "Imagem cadastrada com sucesso!"));
          } else {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",
                  "Erro no cadastro de local!"));

          }
          con.closeConnection();

          return "";
     }

     public List<String> getImages() throws SQLException, IOException {
      
           
          Connect con = new Connect();
          System.out.println("nomeImagem "+NomeImagem);
          List<Local> listaLocais = con.listaImagemGeral();
          List<String> images = new ArrayList<String>();

          String path = FacesContext.getCurrentInstance()
          .getExternalContext().getRealPath("");
          System.out.println(path);
         
          for (Local local : listaLocais) {
             try{
               FileOutputStream fos = new FileOutputStream(path + "/"
                + local.getNomeImagem() + ".jpg");
                  System.out.println(fos);
                fos.write(local.getModelo());
                fos.close();
                images.add(local.getNomeImagem() + ".jpg");
             }catch(NullPointerException e){
                 
             }
         
          }
          return images;
     }

    
     public Local getLocal() {
          return local;
     }

     public void setLocal(Local local) {
          this.local = local;
     }
public List<String> getImage() throws SQLException, IOException {
      
           
          Connect con = new Connect();
     //     System.out.println("nomeImagem "+nome);
         
          List<Local> listaLocais = con.listaImagem(nomeImg);
          List<String> images = new ArrayList<String>();

          String path = FacesContext.getCurrentInstance()
          .getExternalContext().getRealPath("");
        //  System.out.println(path);
         
          for (Local local : listaLocais) {
        
               FileOutputStream fos = new FileOutputStream(path + "/"
                + local.getNomeImagem() + ".jpg");
                
                fos.write(local.getModelo());
                 System.out.println(local.getNomeImagem() + ".jpg");
                fos.close();
                images.add(local.getNomeImagem() + ".jpg");
                nomeImg = ""+local.getNomeImagem() + ".jpg";
         
          }
          return images;
     }   
//public List<String> getCarregar() throws SQLException, IOException {
//      System.out.println("Nome"+nomeImg);
//           Resizable res = new Resizable();
//           res.ImagemANormal();
//           List<String> images = new ArrayList<String>();
//             images = getImages2("Teste");
//         
//         
//          return images;
//     }  
public List<String> completarImagem(String consulta) throws SQLException{
      
      ConnectImagem con = new ConnectImagem();
      ima = con.carregarImagem();
      
      List<String> resultado = new ArrayList<String>();
 
      for(Imagem resultados:ima){
           resultado.add(resultados.getNomeImagem());
      }
     
     return resultado;
  }
public void carregarImagem() throws SQLException, FileNotFoundException, IOException{
        
         Connect con = new Connect();
          System.out.println("nomeImagem "+NomeImagem);
          List<Local> listaLocais = con.listaImagemGeral();
          List<String> images = new ArrayList<String>();

          String path = FacesContext.getCurrentInstance()
          .getExternalContext().getRealPath("");
          System.out.println(path);
         
          for (Local local : listaLocais) {
             try{
               FileOutputStream fos = new FileOutputStream(path + "/"
                + local.getNomeImagem() + ".jpg");
                  System.out.println(fos);
                fos.write(local.getModelo());
                fos.close();
                images.add(local.getNomeImagem() + ".jpg");
             }catch(NullPointerException e){
                 
             }
      
}
}
public void carregarImagemUnica(String imagem) throws SQLException, FileNotFoundException, IOException{
        
         Connect con = new Connect();
          System.out.println("nomeImagem "+nomeImg);
          List<Local> listaLocais = con.listaImagemUnica(imagem);
          List<String> images = new ArrayList<String>();

          String path = FacesContext.getCurrentInstance()
          .getExternalContext().getRealPath("");
          System.out.println(path);
         
          for (Local local : listaLocais) {
             try{
               FileOutputStream fos = new FileOutputStream(path + "/"
                + local.getNomeImagem() + ".jpg");
                  System.out.println(fos);
                fos.write(local.getModelo());
                fos.close();
                images.add(local.getNomeImagem() + ".jpg");
             }catch(NullPointerException e){
                 
             }
      
}
}
 public String excluirModelo() throws SQLException {

               Connect con = new Connect();
               

                if (con.remover(local)) {
                     FacesContext.getCurrentInstance().addMessage(
                      "messages", new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo excluido com sucesso!", "Mapa de processo excluido com sucesso!"));
                      local = new Local();  //limpa a tela
                      nomeExibido = null; 
                       imagemTabela = con.listaImagemGeral();
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     }  
 
 public void teste(){
       System.out.println(nomeImg);
 }
 public void carregarTabela() throws SQLException{
        Connect con = new Connect();
        imagemTabela = con.listaImagemGeral();
 }
 public void onRowSelect(SelectEvent<Local> event) throws SQLException, IOException {
        FacesMessage msg = new FacesMessage("Image Selected", String.valueOf(event.getObject().getNomeImagem())+" Click on the <button> for show ");
        FacesContext.getCurrentInstance().addMessage("messages", msg);
        System.out.println("Nome 1"+event.getObject().getNomeImagem());
        nomeImg = event.getObject().getNomeImagem();
        carregarImagemUnica(event.getObject().getNomeImagem());
        System.out.println("Nome 2"+event.getObject().getNomeImagem());
        nomeExibido = event.getObject().getNomeImagem()+".jpg";
        System.out.println("Nome 2"+nomeExibido);
        local.setCodigo(event.getObject().getCodigo());
    }

    public void onRowUnselect(UnselectEvent<Local> event) {
        FacesMessage msg = new FacesMessage("Product Unselected", String.valueOf(event.getObject().getNomeImagem()));
        FacesContext.getCurrentInstance().addMessage("messages", msg);
    }
}