/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.Exeption;

/**
 *
 * @author v103760
 */
public class NegocioExeption extends RuntimeException {

    public NegocioExeption(String msg) {
        super(msg);
    }
    
    private static final long serialVersionUID = 1L;
    
    
}
