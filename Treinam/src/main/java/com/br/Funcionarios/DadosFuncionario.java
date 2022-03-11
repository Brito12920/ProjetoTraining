package com.br.Funcionarios;
   


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
   
  public class DadosFuncionario {

private static String REGISTRO;
private static String NOME;
private static String FUNCAO;
private static String DEPARTAMENTO;
private static String UNIDADE;
   

    public DadosFuncionario() {
        this.listaFuncionario = new ArrayList<ListaFuncionario>();
    }

  


@SuppressWarnings({"Convert2Diamond", "PublicField"})
 private List<ListaFuncionario> listaFuncionario;

    public List<ListaFuncionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<ListaFuncionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

         
       
    // private static final String BancoArquivo = "C:/Trenamento/Funcionarios.xls";
        
    

   
   
         public void main(String[] args) throws IOException {
          //   buscar();
         }

   public  void buscar(String caminho) throws IOException{

    
               try {
                   
                   try (FileInputStream arquivo = new FileInputStream(new File(
                           caminho))) {
                       HSSFWorkbook workbook = new HSSFWorkbook(arquivo);
                       
                       HSSFSheet sheetAlunos = workbook.getSheetAt(0); //primeira planilha
                       
                       Iterator<Row> rowIterator = sheetAlunos.iterator();
                       
                       while (rowIterator.hasNext()) {                         //ler a linhas
                           Row row = rowIterator.next();
                           Iterator<Cell> cellIterator = row.cellIterator();
                           
                           ListaFuncionario dados = new ListaFuncionario();
                           listaFuncionario.add(dados);
                           while (cellIterator.hasNext()) {                     //ler a células
                               Cell cell = cellIterator.next();
                               switch (cell.getColumnIndex()) {
                                   case 0:
                                       try{ 
                                   
                                       dados.setRegistro(cell.getStringCellValue()); //coluna 1 pega valor 
                                       
                                  
                                       }catch(IllegalStateException e){
                                      
                                             int  num = (int) row.getCell(0).getNumericCellValue();

                                         dados.setRegistro(""+num);
                                       }
                                      break;
                                   case 1:
                                      try{ 
                                  
                                       dados.setNome(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                         //   dados.setOrdem(""+cell.getCellType()); //coluna 2 pega valor
                                         int  num = (int) row.getCell(1).getNumericCellValue();

                                         dados.setNome(""+num);
                                       }
                                       
                                       break;
                                    case 2:
                                      try{ 
                                  
                                       dados.setFuncao(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(2).getNumericCellValue();
                                         dados.setFuncao(""+num);
                                       }
                                       
                                       break;
                                    case 3:
                                      try{ 
                                  
                                       dados.setDepartamento(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                            int  num = (int) row.getCell(3).getNumericCellValue();
                                            dados.setDepartamento(""+num); //coluna 2 pega valor
                                       }
                                       
                                       break;  
                                     case 4:
                                      try{ 
                                  
                                       dados.setUnidade(cell.getStringCellValue()); //coluna 2 pega valor
                                       }catch(IllegalStateException e){
                                           
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