package com.br.Departamento;

import com.br.model.database.ConnectDepartamento;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author v103760
 */
@ManagedBean (name="DepartamentoPool")
@SessionScoped
public class DepartamentoPool implements Serializable {
  private static final long serialVersionUID = 1L;
 
  private List<Departamento> currentlySelectedDepartamentos = new ArrayList<>();
 
  public List<Departamento> getCurrentlySelectedCars() {
    return currentlySelectedDepartamentos;
  }
 
  private List<Departamento> departamentoPool; // add 50 cars here
 
  public List<Departamento> getDepartamentoPool() throws SQLException {
    ConnectDepartamento con = new ConnectDepartamento();
        departamentoPool = con.carregarDepartamento();   
    return departamentoPool;
  }
 
  public void setCurrentlySelectedCars(List<Departamento> currentlySelectedDepartamentos) {
    this.currentlySelectedDepartamentos = currentlySelectedDepartamentos;
  }
 
  public void onSelect(Departamento dep, String typeOfSelection, String indexes) {
 //   System.out.println("OnSelect:" + dep + " typeOfSelection: " + typeOfSelection + " indexes: " + indexes);
    if (null != dep) {
      getCurrentlySelectedCars().add(dep);
    } else if (null != indexes) {
      String[] indexArray = indexes.split(",");
      for (String index:indexArray) {
        int i = Integer.valueOf(index);
        Departamento newDepartamanento=departamentoPool.get(i);
        if (!currentlySelectedDepartamentos.contains(newDepartamanento)) {
          getCurrentlySelectedCars().add(newDepartamanento);
        }
      }
    }
  }
 
  public void onDeselect(Departamento dep, String typeOfSelection, String indexes) {
 //   System.out.println("OnDeselect:" + dep + " typeOfSelection: " + typeOfSelection + " indexes: " + indexes);
    if (null != dep) {
      getCurrentlySelectedCars().remove(dep);
    } else if (null != indexes) {
      String[] indexArray = indexes.split(",");
      for (String index:indexArray) {
        int i = Integer.valueOf(index);
        getCurrentlySelectedCars().remove(departamentoPool.get(i));
      }
    }
  }
}
