package com.br.PDF;

/**
 *
 * @author v103760
 */
import com.br.ControleTreinamento.NomeTreinamento;
import com.br.Imagem.*;
import com.br.model.database.Connect;
import com.br.model.database.ConnectImagem;
import com.br.model.database.ConnectPdf;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.FileUploadEvent;


@ManagedBean(name = "LocalPdfMB")
@ViewScoped
public class LocalPdfBean {

    Date data = new Date();
    private static final String src = "ListaPresenca.pdf";
    private static final String dest = "out.pdf";
    private static final int linha=600;
    private static final int linha2=597;
    private static final int linha3=609;
    private static final int linha4=598;
    private String nomeTreinamento;

    public String getNomeTreinamento() {
        return nomeTreinamento;
    }

    public void setNomeTreinamento(String nomeTreinamento) {
        this.nomeTreinamento = nomeTreinamento;
    }
     private Pdf local = new Pdf();
     private final List<Controle> control= new ArrayList<>();

    public Pdf getLocal() {
        return local;
    }

    public void setLocal(Pdf local) {
        System.out.println("Teste"+local.getRegistroTreinamento());
        this.local = local;
    }

     private List<String> imagens;
     private String NomePdf;

    public String getNomePdf() {
        return NomePdf;
    }

    public void setNomePdf(String NomePdf) {
        this.NomePdf = NomePdf;
    }
     private String nomeImg;
     private List<Pdf> ima= new ArrayList<>();

    public List<Pdf> getIma() throws SQLException {
//        ConnectPdf pd = new ConnectPdf();
//        ima = pd.carregarPdf();
        return ima;
    }

    public void setIma(List<Pdf> ima) {
        this.ima = ima;
    }
    private Imagem img = new Imagem();

    public Imagem getImg() {
        return img;
    }

    public void setImg(Imagem img) {
        this.img = img;
    }

    
   
    public String getNomeImg() {
        return nomeImg;
    }

    public void setNomeImg(String nomeImg) {
        this.nomeImg = nomeImg;
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
   
     local.setArquivo(event.getFile().getContent());
     System.out.println("Camigo "+local.getRegistroTreinamento());
     FacesMessage message = new FacesMessage("Load Succesful",
     event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
       
    }

     public String cadastraLocal() throws SQLException {

          ConnectPdf con = new ConnectPdf();

          if (con.insertLocal(local,NomeTreinamento.getNumeroTreinamento(),NomePdf)) {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
                  "Imagem cadastrada com sucesso!"));
          } else {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Erro ao gravar"));

          }
          con.closeConnection();

          return "";
     }

     public List<String> getImages() throws SQLException, IOException {
      
           
          Connect con = new Connect();
       //   System.out.println("nomeImagem "+NomeImagem);
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
                + local.getNomeImagem() + ".pdf");
                
                fos.write(local.getModelo());
                 System.out.println(local.getNomeImagem() + ".pdf");
                fos.close();
                images.add(local.getNomeImagem() + ".pdf");
                nomeImg = ""+local.getNomeImagem() + ".pdf";
         
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
      
      ConnectPdf con = new ConnectPdf();
//      ima = con.carregarPdf();
      String queryLowerCase = consulta.toLowerCase();
      List<String> resultado = new ArrayList<String>();
      
//        for(int i=0;i < controles.size();i++){
//         resultados.add(controles.get(i).getRegistroTreinamento());
//        
//  }
      System.out.println("AutoCompletar "+consulta);
      for(Pdf resultados:ima){
          
              resultado.add(resultados.getRegistroTreinamento());
          
      }
        
        
     return resultado.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
  }
public void carregarImagem() throws SQLException, FileNotFoundException, IOException{
          ConnectPdf con = new ConnectPdf();
    //      System.out.println("nomeImagem "+NomeImagem);
          List<Pdf> listaLocais = con.listaImagemGeral();
          List<String> images = new ArrayList<String>();

          String path = FacesContext.getCurrentInstance()
          .getExternalContext().getRealPath("");
          System.out.println(path);
         
          for (Pdf local : listaLocais) {
             try{
                if(local.getNome().isEmpty()){
                    
                }else{
                 FileOutputStream fos = new FileOutputStream(path + "/"
                + local.getNome()+ ".pdf");
              //    System.out.println(fos);
                fos.write(local.getArquivo());
                fos.close();
                images.add(local.getNome() + ".pdf");
                }
             }catch(NullPointerException e){
                 
             }
    
}
}
 public String excluirModelo() throws SQLException {

                ConnectImagem con = new ConnectImagem();
                img.setNomeImagem(nomeImg);

                if (con.remover(img)) {
                     FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Modelo de processo excluido com sucesso!", "Mapa de processo excluido com sucesso!"));
                      img = new Imagem();  //limpa a tela
                       
                } else {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!","Erro no cadastr de usuário!"));

                }
                con.closeConnection();

               

          return "";
     } 
 
  public void gerarRelatorio(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException{
              
       Document documento = new Document();
       
       try {
           response.setContentType("apllication/pdf");
           //nome do documento
           response.addHeader("Content-Disposition", "inline; filename="+"contatos.pdf");
           PdfWriter.getInstance(documento, response.getOutputStream());
           documento.open();
           documento.add(new Paragraph("Lista de contatos"));
           documento.close();
       } catch (Exception e) {
           documento.close();
       }
  
   }
 public void createPdf1() throws FileNotFoundException, DocumentException, IOException {
   
     
        com.itextpdf.text.Font f2 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER, 14, com.itextpdf.text.Font.BOLD); //fonte
        com.itextpdf.text.Font f = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER, 13, com.itextpdf.text.Font.BOLD ,com.itextpdf.text.BaseColor.BLUE);
        com.itextpdf.text.Font f3 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 8, com.itextpdf.text.Font.ITALIC);
        com.itextpdf.text.Font f4 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER, 11, com.itextpdf.text.Font.BOLD,com.itextpdf.text.BaseColor.BLUE);
        com.itextpdf.text.Font f8 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER, 11, com.itextpdf.text.Font.BOLD,com.itextpdf.text.BaseColor.RED);
        com.itextpdf.text.Font f5 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 9, com.itextpdf.text.Font.BOLD);
        com.itextpdf.text.Font f6 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,8, com.itextpdf.text.Font.BOLD);      
        com.itextpdf.text.Font f7 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN,8, com.itextpdf.text.Font.BOLD);  
     
    	        Document doc = null;
	        OutputStream os = null;

     
            try {
	            //cria o documento tamanho A4, margens de 2,54cm
	            doc = new Document(PageSize.A4, 72, 72, 72, 72);
	       
	            //cria a stream de saída
	            os = new FileOutputStream("c:/Treinamento/out.pdf");
	       
	            //associa a stream de saída ao
	            PdfWriter.getInstance(doc, os);
	       
	            //abre o documento
	            doc.open();
	 
	            //adiciona o texto ao PDF
                PdfPTable table = new PdfPTable(3);
                table.setWidthPercentage(100f);
                PdfPCell cell = new PdfPCell(new Phrase("LISTA DE PRESENÇA",f2));
                cell.setColspan(2);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase("Continental",f));
                cell.setRowspan(3);
                cell.setVerticalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);
                cell.addElement(new Phrase("Cell 1.2"));
                table.addCell(cell);
                cell.addElement(new Phrase("Cell 1.4"));
                table.addCell(cell);
                cell.addElement(new Phrase("Cell 1.4"));;
                cell.setPadding(5);
                cell.setUseAscender(true);
                cell.setUseDescender(true);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell();
                cell.setPadding(5);
                cell.setUseAscender(true);
                cell.setUseDescender(true);
                Paragraph p = new Paragraph("Cell 2.2");
                p.setAlignment(Element.ALIGN_CENTER);
                cell.addElement(p);
                table.addCell(cell);
                doc.add(table);

                    
	 
	        } finally {
	            if (doc != null) {
	                //fechamento do documento
	                doc.close();
	            }
	            if (os != null) {
	               //fechamento da stream de saída
	               os.close();
	            }
	        }
	    
	

}
public void gerarRelatorio() throws IOException {
     Document documento = new Document();
		try {
			System.out.println("entrou no visualizar relatorio");

			InputStream is = getClass().getResourceAsStream("RelatorioCategoriaPorNome.jasper");

			Map<String, Object> parametro = new HashMap<String, Object>();
			parametro.put("nomeCategoria", "bar");

			
			HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			res.setContentType("application/pdf");
			//Código abaixo gerar o relatório e disponibiliza diretamente na página   
			res.setHeader("Content-disposition", "attachment;filename=c:/Treinamento/out.pdf");
			 documento.open();
                        documento.add(new Paragraph("Lista de contatos"));
                        documento.close();
			FacesContext.getCurrentInstance().responseComplete();
			System.out.println("saiu do visualizar relatorio");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} 
 
}