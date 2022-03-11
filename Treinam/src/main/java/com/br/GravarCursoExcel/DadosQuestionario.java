package com.br.GravarCursoExcel;
   


 import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
   
  import org.apache.poi.hssf.usermodel.HSSFSheet;
  import org.apache.poi.hssf.usermodel.HSSFWorkbook;
  import org.apache.poi.ss.usermodel.Cell;
  import org.apache.poi.ss.usermodel.Row;
   
  public class DadosQuestionario {


   

    public DadosQuestionario() {
        this.listaTreinamento = new ArrayList<ListaTreinamento>();
    }

  


@SuppressWarnings({"Convert2Diamond", "PublicField"})
 private List<ListaTreinamento> listaTreinamento;

    public List<ListaTreinamento> getListaTreinamento() {
        return listaTreinamento;
    }

    public void setListaFuncionario(List<ListaTreinamento> listaTreinamento) {
        this.listaTreinamento = listaTreinamento;
    }

         
       
    // private static final String BancoArquivo = "C:/Trenamento/Funcionarios.xls";
        
    

   
   
         public void main(String[] args) throws IOException {
          //   buscar();
         }

@SuppressWarnings("fallthrough")
   public  void buscar(String caminho) throws IOException{

    
               try {
                   
                   try (FileInputStream arquivo = new FileInputStream(new File(
                           caminho))) {
                       HSSFWorkbook workbook = new HSSFWorkbook(arquivo);
                       
                   //    System.out.println("Nome do arquivo Dados"+caminho);
                       HSSFSheet sheetAlunos = workbook.getSheetAt(0); //primeira planilha
                       
                       Iterator<Row> rowIterator = sheetAlunos.iterator();
                       
                       while (rowIterator.hasNext()) {                         //ler a linhas
                           Row row = rowIterator.next();
                           Iterator<Cell> cellIterator = row.cellIterator();
                           
                           ListaTreinamento dados = new ListaTreinamento();
                           listaTreinamento.add(dados);
                           while (cellIterator.hasNext()) {                     //ler a células
                               Cell cell = cellIterator.next();
                               switch (cell.getColumnIndex()) {
                                   case 0:
                                       try{ 
                                   
                                       dados.setCod_obt(cell.getStringCellValue()); //coluna 1 pega valor 
                                       
                                  
                                       }catch(IllegalStateException e){
                                      
                                             int  num = (int) row.getCell(0).getNumericCellValue();

                                         dados.setCod_obt(""+num);
                                       }
                                      break;
                                   case 2:
                                      try{ 
                                  
                                       dados.setQuantPeguntas(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                         //   dados.setOrdem(""+cell.getCellType()); //coluna 2 pega valor
                                         int  num = (int) row.getCell(2).getNumericCellValue();

                                         dados.setQuantPeguntas(""+num);
                                       }
                                       
                                       break;
                                    case 3:
                                      try{ 
                                  
                                       dados.setDescricao(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(3).getNumericCellValue();
                                         dados.setDescricao(""+num);
                                       }
                                       
                                       break;
                                    case 4:
                                      try{ 
                                  
                                       dados.setImagemPerg(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(4).getNumericCellValue();
                                            dados.setImagemPerg(""+num); //coluna 2 pega valor
                                       }
                                       break;  
                                       case 5:
                                            
                                      try{ 
                                  
                                       dados.setRevisao(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(5).getNumericCellValue();
                                            dados.setRevisao(""+num); //coluna 2 pega valor
                                       }
                                      break;  
                                        case 6:
                                      try{ 
                                  
                                       dados.setDesc_obt(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(6).getNumericCellValue();
                                            dados.setDesc_obt(""+num); //coluna 2 pega valor
                                       }
                                      break;  
                                      
                                          case 7:
                                                                             
                                          
                                           
                                           try{ 
                                  
                                        dados.setAlternativaEscolha(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(7).getNumericCellValue();
                                            dados.setAlternativaEscolha(""+num); //coluna 2 pega valor
                                          //  System.out.println("Tabela "+num);
                                       } 
                                      break;  
                                        
                                        
                                        case 8:
                                     
                                           
                                          
                                           
                                           try{ 
                                  
                                       dados.setAlternativaA(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(7).getNumericCellValue();
                                            dados.setAlternativaA(""+num); //coluna 2 pega valor
                                       } 
                                      break;  
                                       case 9:
                                      try{ 
                                  
                                       dados.setCorretoA(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(8).getNumericCellValue();
                                         dados.setCorretoA(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                                       case 10:
                                      try{ 
                                  
                                       dados.setImagem1(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(9).getNumericCellValue();
                                        dados.setImagem1(""+num); //coluna 2 pega valor
                                       }   
                                      break;  
                                         case 11:
                                      try{ 
                                  
                                       dados.setAlternativaB(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(10).getNumericCellValue();
                                            dados.setAlternativaB(""+num); //coluna 2 pega valor
                                       } 
                                      break;  
                                       case 12:
                                      try{ 
                                  
                                       dados.setCorretoB(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(11).getNumericCellValue();
                                         dados.setCorretoB(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                                       case 13:
                                      try{ 
                                  
                                       dados.setImagem2(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(12).getNumericCellValue();
                                        dados.setImagem2(""+num); //coluna 2 pega valor
                                       }   
                                      break;  
                                         case 14:
                                      try{ 
                                  
                                       dados.setAlternativaC(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(13).getNumericCellValue();
                                            dados.setAlternativaC(""+num); //coluna 2 pega valor
                                       } 
                                      break;  
                                       case 15:
                                      try{ 
                                  
                                       dados.setCorretoC(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(14).getNumericCellValue();
                                         dados.setCorretoC(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                                       case 16:
                                      try{ 
                                  
                                       dados.setImagem3(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(15).getNumericCellValue();
                                        dados.setImagem3(""+num); //coluna 2 pega valor
                                       }   
                                      break;  
                                         case 17:
                                      try{ 
                                  
                                       dados.setAlternativaD(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(16).getNumericCellValue();
                                            dados.setAlternativaD(""+num); //coluna 2 pega valor
                                       } 
                                      break;  
                                       case 18:
                                      try{ 
                                  
                                       dados.setCorretoD(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(17).getNumericCellValue();
                                         dados.setCorretoD(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                                       case 19:
                                      try{ 
                                  
                                       dados.setImagem4(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(18).getNumericCellValue();
                                        dados.setImagem4(""+num); //coluna 2 pega valor
                                       }   
                                      break;  
                                         case 20:
                                      try{ 
                                  
                                       dados.setAlternativaE(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(19).getNumericCellValue();
                                            dados.setAlternativaE(""+num); //coluna 2 pega valor
                                       } 
                                      break;  
                                       case 21:
                                      try{ 
                                  
                                       dados.setCorretoE(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(20).getNumericCellValue();
                                         dados.setCorretoE(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                                       case 22:
                                      try{ 
                                  
                                       dados.setImagem5(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(21).getNumericCellValue();
                                        dados.setImagem5(""+num); //coluna 2 pega valor
                                       }
                                      break;  
                                         case 23:
                                      try{ 
                                  
                                       dados.setAlternativaF(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(22).getNumericCellValue();
                                            dados.setAlternativaF(""+num); //coluna 2 pega valor
                                       } 
                                      break;  
                                       case 24:
                                      try{ 
                                  
                                       dados.setCorretoF(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(23).getNumericCellValue();
                                         dados.setCorretoF(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                                       case 25:
                                      try{ 
                                  
                                       dados.setImagem6(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(24).getNumericCellValue();
                                        dados.setImagem6(""+num); //coluna 2 pega valor
                                       }
                                      break;  
                                         case 26:
                                      try{ 
                                  
                                       dados.setAlternativaG(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(25).getNumericCellValue();
                                            dados.setAlternativaG(""+num); //coluna 2 pega valor
                                       } 
                                      break;  
                                       case 27:
                                      try{ 
                                  
                                       dados.setCorretoG(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(26).getNumericCellValue();
                                         dados.setCorretoG(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                                       case 28:
                                      try{ 
                                  
                                       dados.setImagem7(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(27).getNumericCellValue();
                                        dados.setImagem7(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                                         case 29:
                                      try{ 
                                  
                                       dados.setAlternativaH(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(28).getNumericCellValue();
                                            dados.setAlternativaH(""+num); //coluna 2 pega valor
                                       } 
                                      break;  
                                       case 30:
                                      try{ 
                                  
                                       dados.setCorretoH(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(29).getNumericCellValue();
                                         dados.setCorretoH(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                                       case 31:
                                      try{ 
                                  
                                       dados.setImagem8(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(30).getNumericCellValue();
                                        dados.setImagem8(""+num); //coluna 2 pega valor
                                       }   
                                      break;  
                                         case 32:
                                      try{ 
                                  
                                       dados.setAlternativaI(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(31).getNumericCellValue();
                                            dados.setAlternativaI(""+num); //coluna 2 pega valor
                                       } 
                                      break;  
                                       case 33:
                                      try{ 
                                  
                                       dados.setCorretoI(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(32).getNumericCellValue();
                                         dados.setCorretoI(""+num); //coluna 2 pega valor
                                       } 
                                      break;  
                                       case 34:
                                      try{ 
                                  
                                       dados.setImagem1(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(33).getNumericCellValue();
                                        dados.setImagem9(""+num); //coluna 2 pega valor
                                       }   
                                      break;  
                                         case 35:
                                      try{ 
                                  
                                       dados.setAlternativaJ(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(34).getNumericCellValue();
                                            dados.setAlternativaJ(""+num); //coluna 2 pega valor
                                       } 
                                      break;  
                                       case 36:
                                      try{ 
                                  
                                       dados.setCorretoJ(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(35).getNumericCellValue();
                                         dados.setCorretoJ(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                                       case 37:
                                      try{ 
                                  
                                       dados.setImagem10(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(36).getNumericCellValue();
                                        dados.setImagem10(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                                        case 38:
                                      try{ 
                                  
                                       dados.setUnidade(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(37).getNumericCellValue();
                                        dados.setUnidade(""+num); //coluna 2 pega valor
                                       }  
                                      break;  
                               }
                           }
                       }
                   }
   
               } catch (FileNotFoundException | NullPointerException e) {
                  FacesMessage message = new FacesMessage("Arquivo Excel não encontrado!", ""+caminho+" is uploaded.");
                      FacesContext.getCurrentInstance().addMessage(null, message);
               }
   
          
         }

  

    

   
       
  }