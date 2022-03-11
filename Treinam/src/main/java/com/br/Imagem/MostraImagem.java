
package com.br.Imagem;

import com.br.model.database.Connect;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.sql.rowset.serial.SerialBlob;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author v103760
 */
@ManagedBean(name = "MostraImagemMB")
@ViewScoped
public class MostraImagem implements Serializable {

    private static final long serialVersionUID = 1L;
    DefaultStreamedContent myImage;
    private StreamedContent imagem;
    public StreamedContent getImagem() throws SQLException {
         Connect im = new Connect();
       try{
     System.out.println("Exibir imagem");
 
 ByteArrayInputStream img = new ByteArrayInputStream(im.imagem());
 imagem = (StreamedContent) img;
 }catch(NullPointerException e){
     
 }
 return imagem;
 }
 
public void setImagem(StreamedContent imagem) {
 this.imagem = imagem;
 }
    public DefaultStreamedContent getMyImage() {
        return myImage;
    }

    public void setMyImage(DefaultStreamedContent myImage) {
        this.myImage = myImage;
    }
     
    public DefaultStreamedContent mostrarImagem(String codigo) throws SQLException{
         Connect im = new Connect();
                
//                InputStream is = im.imagem();
//                myImage = new DefaultStreamedContent(is, "image/png");
//                System.out.println("Imagem"+myImage);
                byte[] imageBlob = null;
                imageBlob = im.imagem();
                Blob imageBlob1 = new SerialBlob(imageBlob);
               InputStream stream = imageBlob1.getBinaryStream();
               
            //    myImage = new DefaultStreamedContent(stream, "image/jpg");
           
                
           return myImage;
    }
   public void blobToStreamedContentConvertor() throws SQLException{
     Connect im = new Connect();
//    try{
   byte[] imageBlob = null;
                imageBlob = im.imagem();
//                Blob imageBlob1 = new SerialBlob(imageBlob);
//    InputStream stream = imageBlob1.getBinaryStream();
//    System.out.println("IMAGEMMMM"+stream);
//    myImage = new DefaultStreamedContent(stream, "image/png");
//    InputStream is = new ByteArrayInputStream(imageBlob);
//     myImage = new DefaultStreamedContent(is, "image/png");
//    }
//    catch(Exception e){
//        System.err.println("e = "+e);
//    }
    
 //myImage = new DefaultStreamedContent(event.getFile().getInputstream());
 byte[] foto = im.imagem();
 try{
     System.out.println("Exibir imagem");
// imagem = new DefaultStreamedContent(new ByteArrayInputStream(im.imagem()));
 }catch(NullPointerException e){
     
 }
}
}
