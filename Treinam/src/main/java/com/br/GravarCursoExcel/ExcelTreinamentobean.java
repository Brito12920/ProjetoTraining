package com.br.GravarCursoExcel;

import com.br.Funcionarios.CaminhoArquivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.swing.JFileChooser;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import java.net.InetAddress;
/**
 *
 * @author v103760
 */

@ManagedBean (name="ExcelTreinamentoMB")
public class ExcelTreinamentobean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Treinamento> listaTreinamento = new ArrayList<>();
    private List<ListaTreinamento> listar = new ArrayList<>();

    public List<ListaTreinamento> getListar() {
        return listar;
    }

    public void setListar(List<ListaTreinamento> listar) {
        this.listar = listar;
    }

   
    private String nomeDoArquivo;
    private static String Arq;
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    public List<Treinamento> getListaTreinamento() {
        return listaTreinamento;
    }

    public void setListaTreinamento(List<Treinamento> listaTreinamento) {
        this.listaTreinamento = listaTreinamento;
    }

    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }

    public void setNomeDoArquivo(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }
    
    public List<ListaTreinamento> getFuncExcel() throws SQLException, IOException {
         
          CaminhoArquivo cam = new CaminhoArquivo();
          cam.setNomeArquivo("C:/Treinamento/"+ExcelTreinamentobean.Arq);
          System.out.println("Nome do arquivo "+ExcelTreinamentobean.Arq);
          DadosQuestionario dados = new  DadosQuestionario();
          dados.buscar(cam.getNomeArquivo());
          List<ListaTreinamento> listaTreinamento = dados.getListaTreinamento();
          listar = listaTreinamento;
          return listaTreinamento;
     }
  
  public void carregarArquivo(FileUploadEvent event) // metodo chamado quando o arquivo acaba de carregar no serverSide
			throws FileNotFoundException, IOException {
		
		FacesMessage msg = new FacesMessage("Sucesso "+event.getFile().getFileName()+" foi carregado.", event.getFile()
				.getFileName() + " foi carregado."); // mensagem pra saber se ouve sucesso
		
		
		UploadedFile uploadedFile = event.getFile();
                InputStream inputStream = uploadedFile.getInputStream();

                 File file = new File(uploadedFile.getFileName());
                 System.out.println("AbsolutePath "+file.getAbsolutePath());
		 System.out.println("CanonicalPath "+file.getCanonicalPath());
                 System.out.println("Name "+file.getName());
                 System.out.println("Parent "+file.getParent());
                 System.out.println("Path "+file.getPath());
                 System.out.println("Path "+file.toString());
                 System.out.println("ParentFile "+file.getParentFile());
                 System.out.println("AbsoluteFile "+file.getAbsoluteFile());
                 System.out.println("Path "+file.toPath());
                 System.out.println("Path "+file.toURI());
              
                 
                 
//                this.setNomeDoArquivo(arquivo);
		System.out.println(inputStream);
		String caminho = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
                System.out.println("Caminho "+caminho);
		Arq = file.getAbsolutePath();
		
                
		

	}  
  public void limpar() throws SQLException, IOException{
      for(int i=0; i < getFuncExcel().size();i++){
          getFuncExcel().remove(i);
          Arq = "";
      }
  }
  public void salvar() throws IOException, SQLException{
   
          GravarAlternativa gravar = new GravarAlternativa();

       
         for(int i=0;i < getFuncExcel().size();i++){
        
  
             if(getFuncExcel().get(i).getCod_obt().equals("NOME TREINAMENTO")){
                 
             }else{
               
             String cod_obt = getFuncExcel().get(i).getCod_obt();
             String desc_obt = getFuncExcel().get(i).getDesc_obt();
             String Descricao = getFuncExcel().get(i).getDescricao();
             String pesoNota = getFuncExcel().get(i).getPesoNota();
             String QuantPeguntas = getFuncExcel().get(i).getQuantPeguntas();
          
             String alternativaEscolha = getFuncExcel().get(i).getAlternativaEscolha();
             
             String alternativaA = getFuncExcel().get(i).getAlternativaA();
             String alternativaB = getFuncExcel().get(i).getAlternativaB();
             String alternativaC = getFuncExcel().get(i).getAlternativaC();
             String alternativaD = getFuncExcel().get(i).getAlternativaD();
             String alternativaE = getFuncExcel().get(i).getAlternativaE();
             String alternativaF = getFuncExcel().get(i).getAlternativaF();
             String alternativaG = getFuncExcel().get(i).getAlternativaG();
             String alternativaH = getFuncExcel().get(i).getAlternativaH();
             String alternativaI = getFuncExcel().get(i).getAlternativaI();
             String alternativaJ = getFuncExcel().get(i).getAlternativaJ();
             String corretoA = getFuncExcel().get(i).getCorretoA();
             String corretoB = getFuncExcel().get(i).getCorretoB();
             String corretoC = getFuncExcel().get(i).getCorretoC();
             String corretoD = getFuncExcel().get(i).getCorretoD();
             String corretoE = getFuncExcel().get(i).getCorretoE();
             String corretoF = getFuncExcel().get(i).getCorretoF();
             String corretoG = getFuncExcel().get(i).getCorretoG();
             String corretoH = getFuncExcel().get(i).getCorretoH();
             String corretoI = getFuncExcel().get(i).getCorretoI();
             String corretoJ = getFuncExcel().get(i).getCorretoJ();
             String revisao = getFuncExcel().get(i).getRevisao();
             String cod_perg1 = getFuncExcel().get(i).getCod_perg1();
             String imagemPerg = getFuncExcel().get(i).getImagemPerg();
             String imagem1 = getFuncExcel().get(i).getImagem1();
             String imagem2 = getFuncExcel().get(i).getImagem2();
             String imagem3 = getFuncExcel().get(i).getImagem3();
             String imagem4 = getFuncExcel().get(i).getImagem4();
             String imagem5 = getFuncExcel().get(i).getImagem5();
             String imagem6 = getFuncExcel().get(i).getImagem6();
             String imagem7 = getFuncExcel().get(i).getImagem7();
             String imagem8 = getFuncExcel().get(i).getImagem8();
             String imagem9 = getFuncExcel().get(i).getImagem9();
             String imagem10 = getFuncExcel().get(i).getImagem10();
             String unidade = getFuncExcel().get(i).getUnidade();

             System.out.println(desc_obt);
             System.out.println(Descricao);
             System.out.println(pesoNota);
             System.out.println(QuantPeguntas);
             System.out.println(alternativaEscolha);
             System.out.println(alternativaA);
             System.out.println(alternativaB);
             System.out.println(alternativaC);
             System.out.println(alternativaD);
             System.out.println(alternativaE);
             System.out.println(alternativaF);
             System.out.println(alternativaG);
             System.out.println(alternativaH);
             System.out.println(alternativaI);
             System.out.println(alternativaJ);

             System.out.println(corretoA);
             System.out.println(corretoB);
             System.out.println(corretoC);
             System.out.println(corretoD);
             System.out.println(corretoE);
             System.out.println(corretoF);
             System.out.println(corretoG);
             System.out.println(corretoH);
             System.out.println(corretoI);
             System.out.println(corretoJ);

             System.out.println(revisao);
             System.out.println(cod_perg1);
             System.out.println(imagemPerg);
             System.out.println(imagem1);
             System.out.println(imagem2);
             System.out.println(imagem3);
             System.out.println(imagem4);
             System.out.println(imagem5);
             System.out.println(imagem6);
             System.out.println(imagem7);
             System.out.println(imagem8);
             System.out.println(imagem9);
             System.out.println(imagem10);
             System.out.println(unidade);
             
             
             gravar.Gravar(cod_obt, desc_obt, Descricao, revisao, QuantPeguntas, alternativaEscolha, alternativaA, alternativaB, alternativaC, alternativaD, alternativaE, alternativaF, alternativaG, alternativaH, alternativaI, alternativaJ, corretoA, corretoB, corretoC, corretoD, corretoE, corretoF, corretoG, corretoH, corretoI, corretoJ, imagem1, imagem2, imagem3, imagem4, imagem5, imagem6, imagem7, imagem8, imagem9, imagem10,imagemPerg,cod_perg1, unidade);
             
             
             AlteraPessoa alt = new AlteraPessoa();
                    
                     alt.AlteracaoGeral("Alternativa","alternativaA", "", "alternativaA", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","alternativaB", "", "alternativaB", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","alternativaC", "", "alternativaC", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","alternativaD", "", "alternativaD", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","alternativaE", "", "alternativaE", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","alternativaF", "", "alternativaF", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","alternativaG", "", "alternativaG", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","alternativaH", "", "alternativaH", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","alternativaI", "", "alternativaI", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","alternativaJ", "", "alternativaJ", "null", "cod_obt",cod_obt);
                     
                     alt.AlteracaoGeral("Alternativa","corretoA", "", "corretoA", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","corretoB", "", "corretoB", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","corretoC", "", "corretoC", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","corretoD", "", "corretoD", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","corretoE", "", "corretoE", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","corretoF", "", "corretoF", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","corretoG", "", "corretoG", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","corretoH", "", "corretoH", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","corretoI", "", "corretoI", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","corretoJ", "", "corretoJ", "null", "cod_obt",cod_obt); 
                     
                     alt.AlteracaoGeral("Alternativa","imagem1", "", "imagem1", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","imagem2", "", "imagem2", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","imagem3", "", "imagem3", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","imagem4", "", "imagem4", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","imagem5", "", "imagem5", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","imagem6", "", "imagem6", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","imagem7", "", "imagem7", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","imagem8", "", "imagem8", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","imagem9", "", "imagem9", "null", "cod_obt",cod_obt);
                     alt.AlteracaoGeral("Alternativa","imagem10", "", "imagem10", "null", "cod_obt",cod_obt);
                     
             
             
             }
                                        
// 
//                    if(NOME.equals("NOME FUNCIONARIO")){
//                        
//                    }else{
//                          gravar.Gravar(REGISTRO, NOME,FUNCAO, DEPARTAMENTO, UNIDADE,""); 
//                          alt.AlteracaoGeral("Funcionario","imagem", "", "imagem", "null", "registro",REGISTRO);
//                    }
         
         
         }
        FacesContext.getCurrentInstance().addMessage(
                      null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                      "Lista carregada com sucesso!", "Lista carregada com sucesso!"));
}
  public void carregaAvalicao() throws IOException{
          CaminhoArquivo cam = new CaminhoArquivo();
          cam.setNomeArquivo("\\\\"+InetAddress.getLocalHost().getHostAddress()+"\\\\c:\\temp\\\\1Questionario Sistema OBT.xls");
          System.out.println("Nome do arquivo "+"////"+InetAddress.getLocalHost().getHostAddress()+"\\\\c:/temp/1Questionario Sistema OBT.xls");
          DadosQuestionario dados = new  DadosQuestionario();
          dados.buscar(cam.getNomeArquivo());
          List<ListaTreinamento> listaTreinamento = dados.getListaTreinamento();
          listar = listaTreinamento;
  }
  public void caminho(){
     
   String returnFileName = "No file selected.";

        JFileChooser getFile = new JFileChooser();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(getFile);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            returnFileName = selectedFile.getAbsolutePath();
        }
      
  }
  
}
