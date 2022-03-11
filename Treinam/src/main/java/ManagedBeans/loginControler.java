
package ManagedBeans;


import Model.LoginEntity;
import com.br.Usuario.Permissao;
import com.br.Usuario.UsuarioBuscar;
import com.br.Utilitarios.RequestScoped;
import com.br.model.database.ConnectObt;
import com.br.model.database.ConnectUsuario;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Valdenir
 */
@RequestScoped
@ManagedBean(name = "FuncionarioMB")
public class loginControler implements Serializable {

    private static final long serialVersionUID = 1L;
    
       
    public loginControler() {
        login =new LoginEntity();
    }
    
   private LoginEntity login;

    public LoginEntity getLogin() {
        return login;
    }

    public void setLogin(LoginEntity login) {
        this.login = login;
    }
    
    public String logarNoSistema() throws SQLException{
       
         UsuarioBuscar.setUsuario(login.getLogin());
         ConnectUsuario user = new ConnectUsuario(); 
         user.buscarUsuario(login.getLogin());
         Permissao.setUnidade(user.getUnidade());
         Permissao.setPermissao(user.getPermissao());
         System.out.println("usuario "+user.getUser());
         System.out.println("Perm "+user.getPermissao());
         System.out.println("Pass "+user.getPassword());
//          Permissao.setPermissao(user.getPermissao());
       
         
        if(login.getLogin().equals(user.getUser()) && login.getSenha().equals(user.getPassword())){
             HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
             session.setAttribute("usuario", login);
             
             switch(user.getPermissao()){
                 case "Super":
                 
                     return "/app/PrincipalAdmin?faces-redirect=true";
                 
                 case "Master":
                 
                     return "/app/Principal?faces-redirect=true";
                
                 case "Padrao":
                 
                 return "/app/Obt?faces-redirect=true";  
                 
                 default:
                   return "/app/Principal?faces-redirect=true";
             }
             
             
        }else{
       //     addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Password Invalid or User Not Found");
           FacesContext.getCurrentInstance().addMessage("messagesLogin", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não existe ou senha errada!!", "Atênção senha errada!")); 
            return "";
        }
       
    }
    public String logAut(){
       FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       return "/seguranca/login?faces-redirect=true";
    }
    public String logarNoCurso() throws SQLException{
       
         ConnectObt user = new ConnectObt(); 
         user.buscarObt(login.getLogin());
       
       
         
        if(login.getLogin().equals(user.getObtModelo())){
             HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
             session.setAttribute("usuario", login);
             return "/avaliacoes/Questionario?faces-redirect=true";
        }else{
            FacesContext.getCurrentInstance().addMessage("messagesLogin", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não existe ou senha errada!!", "Atênção senha errada!")); 
            return "";
        }
       
    }
    
   public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }    
   
}
