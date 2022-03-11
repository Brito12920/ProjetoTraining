package com.br.Imagem;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author v103760
 */
@ManagedBean (name="Resizable")
@ViewScoped
public class Resizable implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int WidthImagemA;

    public int getWidthImagemA() {
        return WidthImagemA;
    }

    public void setWidthImagemA(int WidthImagemA) {
        this.WidthImagemA = WidthImagemA;
    }
    private int HeightImagemA;

    public int getHeightImagemA() {
        return HeightImagemA;
    }

    public void setHeightImagemA(int HeightImagemA) {
        this.HeightImagemA = HeightImagemA;
    }
    
    public void ImagemAzoom(){
        WidthImagemA = 420;
        HeightImagemA = 250;
        
    }
    public void ImagemANormal(){
    this.setWidthImagemA(150);   
    this.setHeightImagemA(263);
        
    }
}
