/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.Excel;

/**
 *
 * @author V103760
 */
import com.br.Funcionarios.Funcionario;
import com.br.Utilitarios.RequestScoped;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


@RequestScoped
@ManagedBean (name="AbreExcelFuncBean")
public class AbreExcelFuncionarios {
      List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();

    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

   
       private static String fileName;

       public void Buscar(String arquivoT) throws IOException {

           fileName = arquivoT;
           System.out.println("Caminho do arquivio "+arquivoT);

             try {
                    FileInputStream arquivo = new FileInputStream(new File(
                                  AbreExcelFuncionarios.fileName));

                    HSSFWorkbook workbook = new HSSFWorkbook(arquivo);

                    HSSFSheet sheetAlunos = workbook.getSheetAt(0);

                    Iterator<Row> rowIterator = sheetAlunos.iterator();

                    while (rowIterator.hasNext()) {
                           Row row = rowIterator.next();
                           Iterator<Cell> cellIterator = row.cellIterator();

                          Funcionario funcionario = new Funcionario();
                           listaFuncionario.add(funcionario);
                           while (cellIterator.hasNext()) {
                                  Cell cell = cellIterator.next();
                                  switch (cell.getColumnIndex()) {
                                  case 0:
                                        try{
                                        funcionario.setRegistro(cell.getStringCellValue());
                                       
                                        }catch(IllegalStateException e){
                                           int num = (int) row.getCell(0).getNumericCellValue();
                                          funcionario.setRegistro(""+num);
                                        }
                                        break;
                                  case 1:
                                        try{
                                        funcionario.setNome(cell.getStringCellValue());
                                        }catch(IllegalStateException e){
                                           int num = (int) row.getCell(2).getNumericCellValue();
                                           funcionario.setNome(""+num);
                                        }
                                        break;
                                  case 2:
                                        try{ 
                                        funcionario.setDepartamento(cell.getStringCellValue());
                                        }catch(IllegalStateException e){
                                           int num = (int) row.getCell(3).getNumericCellValue();
                                           funcionario.setDepartamento(""+num);
                                        }
                                      break;
                                      case 3:
                                        try {
                                          funcionario.setFuncao(cell.getStringCellValue());
                                      } catch (IllegalStateException e) {
                                          int num = (int) row.getCell(4).getNumericCellValue();
                                          funcionario.setFuncao("" + num);
                                      }
                                      break;
                                      case 4:
                                        try {
                                          funcionario.setUnidade(cell.getStringCellValue());
                                      } catch (IllegalStateException e) {
                                          int num = (int) row.getCell(5).getNumericCellValue();
                                          funcionario.setUnidade("" + num);
                                      }
                                      break;
                                      case 5:
                                       try {
                                          funcionario.setStatus(cell.getStringCellValue());
                                      } catch (IllegalStateException e) {
                                          int num = (int) row.getCell(6).getNumericCellValue();
                                          funcionario.setStatus("" + num);
                                      }
                                      break;

                                      case 6:
                                       try {
                                          funcionario.setImagem(cell.getStringCellValue());
                                      } catch (IllegalStateException e) {
                                          int num = (int) row.getCell(7).getNumericCellValue();
                                          funcionario.setImagem("" + num);
                                      }
                                      break;

                                      
                 //--------------------------------------------------------------------------
                      
                    }
                }
            }
            arquivo.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo Excel não encontrado!");
        }

        if (listaFuncionario.size() == 0) {
            System.out.println("Nenhum aluno encontrado!");
        } else {

            for (Funcionario funcionario : listaFuncionario) {
        //        System.out.println("Aluno: " + alternativa.getCod_obt() + " Média: ");

            }

        }

    }
       
      
}
