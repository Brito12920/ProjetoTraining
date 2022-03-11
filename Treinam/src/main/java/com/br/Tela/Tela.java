package com.br.Tela;

import com.br.Usuario.Permissao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author v103760
 */
@ManagedBean (name="TelaMB")
public class Tela implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
   private String tela;

    public String getTela() {
        
        if(Permissao.getPermissao().equals("Super")){
          tela = "PrincipalAdmin.jsf";  
        }else{
          tela = "Principal.jsf";  
        }
        
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }
    
}
