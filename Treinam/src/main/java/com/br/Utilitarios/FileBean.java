package com.br.Utilitarios;

/**
 *
 * @author v103760
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;
import org.primefaces.shaded.commons.io.IOUtils;


    @ManagedBean

@RequestScoped
public class FileBean {
private UploadedFile uploadedFile;
    private UploadedFile file;

    public FileBean() {
    }

    public UploadedFile getFile() {
        File myTempFile = new File(System.getProperty("java.io.tmpdir"),""+(File) file);
        System.out.println("Dir "+myTempFile);
        return (UploadedFile) myTempFile;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
         File myTempFile = new File(System.getProperty("java.io.tmpdir"),"temporary");
        System.out.println("Dir "+myTempFile);
    }
    public void save() throws IOException {
    String filename = FilenameUtils.getName(file.getFileName());
    InputStream input = file.getInputStream();
    OutputStream output = new FileOutputStream(new File("/path/to/uploads", filename));
    System.out.println("Dir "+output);
    try {
        IOUtils.copy(input, output);
    } finally {
        IOUtils.closeQuietly(input);
        IOUtils.closeQuietly(output);
    }
}
}
