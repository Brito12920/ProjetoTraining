package com.br.ControleTreinamento;

import com.br.model.database.ConnectControle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author v103760
 */
@Named
@ApplicationScoped
public class ListaRegistro {

    private List<ControleCurso> countries;

    public List<ControleCurso> getCountries() throws SQLException {
        
          ConnectControle con = new ConnectControle();
         countries = con.carregarControle();
        
        return Collections.unmodifiableList(countries);
    }

    public void setCountries(List<ControleCurso> countries){
         
        this.countries = countries;
    }
    

    @PostConstruct
    public void init() {
        countries = new ArrayList<>();
     //   locales = new ArrayList<>();

      

    }
}