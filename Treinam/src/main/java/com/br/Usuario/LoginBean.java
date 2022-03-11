package com.br.Usuario;

import com.br.model.database.ConnectUsuario;
import java.io.Serializable;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author v103760
 */
@Named("LoginBeanMB")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    private String senha;
   
    
     public String logIn() throws SQLException {
      
          ConnectUsuario user = new ConnectUsuario(); 
           System.out.println("Permissão "+user.getPermissao());
          user.buscarUsuario(login);
         
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            if (!user.getPassword().equals(senha)) {
            //    session.setAttribute("usuario", usuarioLogado);
             FacesContext.getCurrentInstance().addMessage("MessageLista", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário não existe ou senha errada!!", "Atênção senha errada!"));
            return null;
            }
            
           
            if(user.getPermissao().equals("Super")){
                 return "/PrincipalAdmin?faces-redirect=true";
            }else{
                  System.out.println("Permissão "+user.getPermissao());
                 return "/Principal?faces-redirect=true";
                 
            }
           
        
    }
    public String logOff() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "/seguranca/login?faces-redirect=true";
    }
}