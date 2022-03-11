package com.br.Utilitarios;


import com.br.ControleTreinamento.ControleCurso;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorgebavaresco@ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class FabricaObjetos {

    public static List<ControleCurso> carregaControles(){
        List<ControleCurso> lista = new ArrayList<>();
        ControleCurso t = new ControleCurso();
        t.setCodigo(1);
        t.setRegistroTreinamento("Grêmio");
        t.setCodigoObt("CodigoObt");
        t.setRegistro("24244");
        t.setNome("Nome");
        t.setData_inclusao("Data_inclusao");
        t.setTempo("Tempo");
        t.setTreinamento("treinamento");
        t.setDesc_treinamento("desc_treinamento");
        t.setTema("tema");
        t.setObs("obs");
        t.setNumeroDocumento("numeroDocumento");
        t.setUnidade("Unidade");
        t.setData_curso("Data_curso");
        t.setObtModelo("obtModelo");
        t.setNomeTrainamento("NomeTrainamento");
        t.setTipoTreinamento("TipoTreinamento");
        lista.add(t);
        
        
        return lista;
    }
    
}
