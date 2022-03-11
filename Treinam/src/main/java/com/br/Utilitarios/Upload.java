package com.br.Utilitarios;

import java.io.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.swing.JFileChooser;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;


@ManagedBean(name = "upload")
@RequestScoped
public class Upload {

    private JFileChooser chooser;
    private Arquivo arquivo;
    public void fileUploadAction(FileUploadEvent event) throws IOException {
        try {
            UploadedFile arq = event.getFile();
            InputStream in = new BufferedInputStream(arq.getInputStream());
            File file = new File("/home/ifrs/img/" + arq.getFileName());//o diretório onde será guardado o arquivo  
            arquivo.setArquivo(file.getAbsolutePath());//é um atributo meu que chamei de caminho :D   
            chooser.getSelectedFile().getPath();
            System.out.println(chooser);
            FileOutputStream fout = new FileOutputStream(file);
            while (in.available() != 0) {
                fout.write(in.read());
            }
            fout.close();
            FacesMessage msg = new FacesMessage("O Arquivo ", file.getName() + " salvo.");
            FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}