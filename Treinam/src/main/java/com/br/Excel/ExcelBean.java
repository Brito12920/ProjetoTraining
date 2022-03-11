package com.br.Excel;

import com.br.Alternativa.Alternativa;
import com.br.Utilitarios.RequestScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author v103760
 */

@RequestScoped
@ManagedBean (name="ExcelBeanMB")
public class ExcelBean implements Serializable {
       private static final long serialVersionUID = 1L;
       
       List<Alternativa> listaAvaliacoes = new ArrayList<Alternativa>();

    public List<Alternativa> getListaAvaliacoes() {
        return listaAvaliacoes;
    }

    public void setListaAvaliacoes(List<Alternativa> listaAvaliacoes) {
        this.listaAvaliacoes = listaAvaliacoes;
    }
    
 
       public void buscarPlanilha() throws IOException{
//           AbreExcel ex = new AbreExcel();
//           ex.Buscar();
//            listaAvaliacoes = ex.getListaAvaliacoes();
       }
       
    public void gravarDados(){
         AbreExcel ex = new AbreExcel();
    }
       
 
}
