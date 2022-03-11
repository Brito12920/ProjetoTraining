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
import com.br.Alternativa.Alternativa;
import com.br.JpaPersistence.PesisteDadosJPA;
import com.br.Utilitarios.RequestScoped;
import com.br.Video.AvaliacaoVideo;
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
@ManagedBean (name="AbreExcelBean")
public class AbreExcel {
      List<Alternativa> listaAvaliacoes = new ArrayList<Alternativa>();

      List<AvaliacaoVideo> listaVideo = new ArrayList<AvaliacaoVideo>();

    public List<AvaliacaoVideo> getListaVideo() {
        return listaVideo;
    }

    public void setListaVideo(List<AvaliacaoVideo> listaVideo) {
        this.listaVideo = listaVideo;
    }
    public List<Alternativa> getListaAvaliacoes() {
        return listaAvaliacoes;
    }

    public void setListaAvaliacoes(List<Alternativa> listaAvaliacoes) {
        this.listaAvaliacoes = listaAvaliacoes;
    }
       private static String fileName;

       public void Buscar(String arquivoT) throws IOException {

           fileName = arquivoT;
           System.out.println("Caminho do arquivio "+arquivoT);

             try {
                    FileInputStream arquivo = new FileInputStream(new File(
                                  AbreExcel.fileName));

                    HSSFWorkbook workbook = new HSSFWorkbook(arquivo);

                    HSSFSheet sheetAlunos = workbook.getSheetAt(0);

                    Iterator<Row> rowIterator = sheetAlunos.iterator();

                    while (rowIterator.hasNext()) {
                           Row row = rowIterator.next();
                           Iterator<Cell> cellIterator = row.cellIterator();

                           Alternativa alternativa = new Alternativa();
                           listaAvaliacoes.add(alternativa);
                         
                           AvaliacaoVideo video = new AvaliacaoVideo();
                           listaVideo.add(video);
                           
                           while (cellIterator.hasNext()) {
                                  Cell cell = cellIterator.next();
                                  switch (cell.getColumnIndex()) {
                                  case 0:
                                        try{
                                        video.setCod_obt(cell.getStringCellValue());
                                        alternativa.setCod_obt(cell.getStringCellValue());
                                        }catch(IllegalStateException e){
                                           int num = (int) row.getCell(0).getNumericCellValue();
                                           alternativa.setCod_obt(""+num);
                                           
                                        }
                                        break;
                                  case 2:
                                        try{
                                        alternativa.setQuantPeguntas(cell.getStringCellValue());
                                        }catch(IllegalStateException e){
                                           int num = (int) row.getCell(2).getNumericCellValue();
                                           alternativa.setQuantPeguntas(""+num);
                                        }
                                        break;
                                  case 3:
                                        try{ 
                                        alternativa.setDescricao(cell.getStringCellValue());
                                        }catch(IllegalStateException e){
                                           int num = (int) row.getCell(3).getNumericCellValue();
                                           alternativa.setDescricao(""+num);
                                        }
                                        break;
                                 case 4:
                                        try {
                            alternativa.setRevisao(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(4).getNumericCellValue();
                            alternativa.setRevisao("" + num);
                        }
                        break;
                        case 5:
                                        try {
                            alternativa.setDesc_obt(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(5).getNumericCellValue();
                            alternativa.setDesc_obt("" + num);
                        }
                        break;
                        case 6:
                                       try {
                            alternativa.setAlternativaA(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(6).getNumericCellValue();
                            alternativa.setAlternativaA("" + num);
                        }
                        break;

                        case 7:
                                       try {
                            alternativa.setCorretoA(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(7).getNumericCellValue();
                            alternativa.setCorretoA("" + num);
                        }
                        break;

                        case 8:
                                       try {
                            alternativa.setImagem1(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(8).getNumericCellValue();
                            alternativa.setImagem1("" + num);
                        }
                        break;

                        //--------------------------------------------------------------------------
                        case 9:
                                       try {
                            alternativa.setAlternativaB(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(9).getNumericCellValue();
                            alternativa.setAlternativaB("" + num);
                        }
                        break;

                        case 10:
                                       try {
                            alternativa.setCorretoB(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(10).getNumericCellValue();
                            alternativa.setCorretoB("" + num);
                        }
                        break;

                        case 11:
                                       try {
                            alternativa.setImagem2(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(11).getNumericCellValue();
                            alternativa.setImagem2("" + num);
                        }
                        break;

                        //-------------------------------------------------------------------------- 
                        case 12:
                                       try {
                            alternativa.setAlternativaC(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(12).getNumericCellValue();
                            alternativa.setAlternativaC("" + num);
                        }
                        break;

                        case 13:
                                       try {
                            alternativa.setCorretoC(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(13).getNumericCellValue();
                            alternativa.setCorretoC("" + num);
                        }
                        break;

                        case 14:
                                       try {
                            alternativa.setImagem3(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(14).getNumericCellValue();
                            alternativa.setImagem3("" + num);
                        }
                        break;

                        //--------------------------------------------------------------------------
                        case 15:
                                       try {
                            alternativa.setAlternativaD(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(15).getNumericCellValue();
                            alternativa.setAlternativaD("" + num);
                        }
                        break;

                        case 16:
                                       try {
                            alternativa.setCorretoD(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(16).getNumericCellValue();
                            alternativa.setCorretoD("" + num);
                        }
                        break;

                        case 17:
                                       try {
                            alternativa.setImagem4(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(17).getNumericCellValue();
                            alternativa.setImagem4("" + num);
                        }
                        break;

                        //--------------------------------------------------------------------------
                        case 18:
                                       try {
                            alternativa.setAlternativaE(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(18).getNumericCellValue();
                            alternativa.setAlternativaE("" + num);
                        }
                        break;

                        case 19:
                                       try {
                            alternativa.setCorretoE(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(19).getNumericCellValue();
                            alternativa.setCorretoE("" + num);
                        }
                        break;

                        case 20:
                                       try {
                            alternativa.setImagem5(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(20).getNumericCellValue();
                            alternativa.setImagem5("" + num);
                        }
                        break;

                        //--------------------------------------------------------------------------
                        case 21:
                                       try {
                            alternativa.setAlternativaF(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(21).getNumericCellValue();
                            alternativa.setAlternativaF("" + num);
                        }
                        break;

                        case 22:
                                       try {
                            alternativa.setCorretoF(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(22).getNumericCellValue();
                            alternativa.setCorretoF("" + num);
                        }
                        break;

                        case 23:
                                       try {
                            alternativa.setImagem6(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(23).getNumericCellValue();
                            alternativa.setImagem6("" + num);
                        }
                        break;

                        //-------------------------------------------------------------------------- 
                        case 24:
                                       try {
                            alternativa.setAlternativaG(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(24).getNumericCellValue();
                            alternativa.setAlternativaG("" + num);
                        }
                        break;

                        case 25:
                                       try {
                            alternativa.setCorretoG(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(25).getNumericCellValue();
                            alternativa.setCorretoG("" + num);
                        }
                        break;

                        case 26:
                                       try {
                            alternativa.setImagem7(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(26).getNumericCellValue();
                            alternativa.setImagem7("" + num);
                        }
                        break;

                        //--------------------------------------------------------------------------
                        case 27:
                                       try {
                            alternativa.setAlternativaH(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(27).getNumericCellValue();
                            alternativa.setAlternativaH("" + num);
                        }
                        break;

                        case 28:
                                       try {
                            alternativa.setCorretoH(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(28).getNumericCellValue();
                            alternativa.setCorretoH("" + num);
                        }
                        break;

                        case 29:
                                       try {
                            alternativa.setImagem8(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(29).getNumericCellValue();
                            alternativa.setImagem8("" + num);
                        }
                        break;

                        //--------------------------------------------------------------------------
                        case 30:
                                       try {
                            alternativa.setAlternativaI(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(30).getNumericCellValue();
                            alternativa.setAlternativaI("" + num);
                        }
                        break;

                        case 31:
                                       try {
                            alternativa.setCorretoI(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(31).getNumericCellValue();
                            alternativa.setCorretoI("" + num);
                        }
                        break;

                        case 32:
                                       try {
                            alternativa.setImagem9(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(32).getNumericCellValue();
                            alternativa.setImagem9("" + num);
                        }
                        break;

                        //--------------------------------------------------------------------------
                        case 33:
                                       try {
                            alternativa.setAlternativaJ(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(33).getNumericCellValue();
                            alternativa.setAlternativaJ("" + num);
                        }
                        break;

                        case 34:
                                       try {
                            alternativa.setCorretoJ(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(34).getNumericCellValue();
                            alternativa.setCorretoJ("" + num);
                        }
                        break;

                        case 35:
                                       try {
                            alternativa.setImagem10(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(35).getNumericCellValue();
                            alternativa.setImagem10("" + num);
                        }
                        break;
                        
                         case 36:
                                       try {
                            alternativa.setNomeAvaliacao(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(36).getNumericCellValue();
                            alternativa.setImagem10("" + num);
                        }
                        break;
                        
                         case 37:
                                       try {
                            video.setVideo(cell.getStringCellValue());
                        } catch (IllegalStateException e) {
                            int num = (int) row.getCell(37).getNumericCellValue();
                            video.setVideo("" + num);
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

        if (listaAvaliacoes.size() == 0) {
            System.out.println("Nenhum aluno encontrado!");
        } else {

            for (Alternativa alternativa : listaAvaliacoes) {
        //        System.out.println("Aluno: " + alternativa.getCod_obt() + " Média: ");

            }

        }

    }
       
      
}
