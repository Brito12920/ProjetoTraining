package com.br.Alternativa;

import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectAlternativa;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author v103760
 */

@RequestScoped
@ManagedBean (name="AlternativaMB")
public class AlternativaBean implements Serializable {
    private List<Alternativa> alternativas= new ArrayList<>();
    private Alternativa alternativa = new Alternativa();

    private Alternativa selectedAlt;

    public Alternativa getSelectedAlt() {
      
        return selectedAlt;
    }

    public void setSelectedAlt(Alternativa selectedAlt) {
        
        this.selectedAlt = selectedAlt;
    }
  
    public List<Alternativa> getAlternativas() throws SQLException {
        ConnectAlternativa alter = new ConnectAlternativa();
        alternativas = alter.carregarAlternativa();
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public Alternativa getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }
 
    private static final long serialVersionUID = 1L;
    
    
   
 
}
