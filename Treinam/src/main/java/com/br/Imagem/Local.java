package com.br.Imagem;

/**
 *
 * @author v103760
 */
public class Local {

     private int codigo;
     private byte[] modelo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

     @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public byte[] getModelo() {
        return modelo;
    }

     @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setModelo(byte[] modelo) {
        this.modelo = modelo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
     private String imagem;
     private String nomeImagem;
     private String unidade;
      
    

    
}