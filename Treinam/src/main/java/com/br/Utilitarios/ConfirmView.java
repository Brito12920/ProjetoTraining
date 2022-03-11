package com.br.Utilitarios;

import com.br.Funcionarios.ListaFuncionario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author v103760
 */
@Named
@RequestScoped
public class ConfirmView {
  private final List<ListaFuncionario> employeeList = new ArrayList<>();
    public void confirm() {
        addMessage("Confirmed", "You have accepted");
         System.out.println("ENTROU AQUI");
        for(int i=0;employeeList.size() <=i;i++){
            System.out.println(employeeList.get(i).getNome());
        }
      
  
    }

    public void delete() {
        addMessage("Confirmed", "Record deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
