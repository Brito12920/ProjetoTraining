package com.br.UploadExcel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author v103760
 */
@Named(value = "fileUploadBean")
@RequestScoped
public class FileUploadBean {

    private Part uploadedFile;

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    private String text;
    /**
     * Creates a new instance of FileUploadBean
     */
    public FileUploadBean() {
    }
    public void upload() {

        if (null != uploadedFile) {
            try {
                InputStream is = uploadedFile.getInputStream();
                text = new Scanner(is).useDelimiter("\\A").next();
            } catch (IOException ex) {
            }
        }
    }
   
}
