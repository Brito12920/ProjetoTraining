/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.Video;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author V103760
 */
@Entity
public class AvaliacaoVideo implements Serializable {
    private static final long serialVersionUID = 1L;

    public AvaliacaoVideo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod_obt() {
        return cod_obt;
    }

    public void setCod_obt(String cod_obt) {
        this.cod_obt = cod_obt;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "AvaliacaoVideo{" + "id=" + id + ", cod_obt=" + cod_obt + ", video=" + video + '}';
    }

    public AvaliacaoVideo(int id, String cod_obt, String video) {
        this.id = id;
        this.cod_obt = cod_obt;
        this.video = video;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String cod_obt;
    private String video;
    
}
