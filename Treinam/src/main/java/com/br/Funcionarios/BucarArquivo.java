package com.br.Funcionarios;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.prefs.Preferences;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JFileChooser;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author v103760
 */
public class BucarArquivo {
    
    
    public void cria(){  
          
 
     Preferences pref = Preferences.userRoot();

// Retrieve the selected path or use
// an empty string if no path has
// previously been selected
      String path = pref.get("DEFAULT_PATH", "");       
            
      JFileChooser chooser = new JFileChooser();  
      chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);     
      chooser.setCurrentDirectory(new File(path));  
//       int returnVal = chooser.showOpenDialog(null);  
     
          //System.out.println("You chose to open this file: " +  
            //   chooser.getSelectedFile().getAbsolutePath());  
            File arq = chooser.getSelectedFile().getAbsoluteFile();  
            chooser.setCurrentDirectory(arq);
             pref.put("DEFAULT_PATH", arq.getAbsolutePath());  
        String caminho = arq.getPath();  
            // >=> Só isso
          //  jTextField.setText(caminho);
           
          //   BancoArquivo =  arq.getAbsolutePath();
      //    BancoArquivo = caminho;
          //   System.out.println(caminho);
        
    
        Caminho.setBancoArquivo(caminho);
      
         
   } 
     
   public void AdicionarArquivo(FileUploadEvent event) throws FileNotFoundException, SQLException {
         UploadedFile file = event.getFile();
         String nome_anexo = event.getFile().getFileName();
        if (incluirArquivo(file)) {
            FacesMessage msg = new FacesMessage("Arquivo", event.getFile().getFileName() + " Anexado com sucesso.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
}  

    private boolean incluirArquivo(UploadedFile file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
