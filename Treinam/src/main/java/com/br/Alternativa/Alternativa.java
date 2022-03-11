package com.br.Alternativa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author v103760
 */
@Entity
public class Alternativa implements Serializable{

    private static final long serialVersionUID = 1L;

    public Alternativa() {
    }

    public Alternativa(int codigo, String cod_obt, String desc_obt, String Descricao, String pesoNota, String QuantPeguntas, String alternativaA, String alternativaB, String alternativaC, String alternativaD, String alternativaE, String alternativaF, String alternativaG, String alternativaH, String alternativaI, String alternativaJ, String alternativaK, String alternativaL, String alternativaM, String alternativaN, String alternativaO, String alternativaP, String alternativaQ, String alternativaR, String alternativaS, String alternativaT, String corretoA, String corretoB, String corretoC, String corretoD, String corretoE, String corretoF, String corretoG, String corretoH, String corretoI, String corretoJ, String corretoK, String corretoL, String corretoM, String corretoN, String corretoO, String corretoP, String corretoQ, String corretoR, String corretoS, String corretoT, String revisao, String cod_perg1, String imagemPerg, String imagem1, String imagem2, String imagem3, String imagem4, String imagem5, String imagem6, String imagem7, String imagem8, String imagem9, String imagem10, String unidade, String nomeAvaliacao, int AlternativaEscolha) {
        this.codigo = codigo;
        this.cod_obt = cod_obt;
        this.desc_obt = desc_obt;
        this.Descricao = Descricao;
        this.pesoNota = pesoNota;
        this.QuantPeguntas = QuantPeguntas;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.alternativaE = alternativaE;
        this.alternativaF = alternativaF;
        this.alternativaG = alternativaG;
        this.alternativaH = alternativaH;
        this.alternativaI = alternativaI;
        this.alternativaJ = alternativaJ;
        this.alternativaK = alternativaK;
        this.alternativaL = alternativaL;
        this.alternativaM = alternativaM;
        this.alternativaN = alternativaN;
        this.alternativaO = alternativaO;
        this.alternativaP = alternativaP;
        this.alternativaQ = alternativaQ;
        this.alternativaR = alternativaR;
        this.alternativaS = alternativaS;
        this.alternativaT = alternativaT;
        this.corretoA = corretoA;
        this.corretoB = corretoB;
        this.corretoC = corretoC;
        this.corretoD = corretoD;
        this.corretoE = corretoE;
        this.corretoF = corretoF;
        this.corretoG = corretoG;
        this.corretoH = corretoH;
        this.corretoI = corretoI;
        this.corretoJ = corretoJ;
        this.corretoK = corretoK;
        this.corretoL = corretoL;
        this.corretoM = corretoM;
        this.corretoN = corretoN;
        this.corretoO = corretoO;
        this.corretoP = corretoP;
        this.corretoQ = corretoQ;
        this.corretoR = corretoR;
        this.corretoS = corretoS;
        this.corretoT = corretoT;
        this.revisao = revisao;
        this.cod_perg1 = cod_perg1;
        this.imagemPerg = imagemPerg;
        this.imagem1 = imagem1;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.imagem4 = imagem4;
        this.imagem5 = imagem5;
        this.imagem6 = imagem6;
        this.imagem7 = imagem7;
        this.imagem8 = imagem8;
        this.imagem9 = imagem9;
        this.imagem10 = imagem10;
        this.unidade = unidade;
        this.nomeAvaliacao = nomeAvaliacao;
        this.AlternativaEscolha = AlternativaEscolha;
    }

    @Override
    public String toString() {
        return "Alternativa{" + "codigo=" + codigo + ", cod_obt=" + cod_obt + ", desc_obt=" + desc_obt + ", Descricao=" + Descricao + ", pesoNota=" + pesoNota + ", QuantPeguntas=" + QuantPeguntas + ", alternativaA=" + alternativaA + ", alternativaB=" + alternativaB + ", alternativaC=" + alternativaC + ", alternativaD=" + alternativaD + ", alternativaE=" + alternativaE + ", alternativaF=" + alternativaF + ", alternativaG=" + alternativaG + ", alternativaH=" + alternativaH + ", alternativaI=" + alternativaI + ", alternativaJ=" + alternativaJ + ", alternativaK=" + alternativaK + ", alternativaL=" + alternativaL + ", alternativaM=" + alternativaM + ", alternativaN=" + alternativaN + ", alternativaO=" + alternativaO + ", alternativaP=" + alternativaP + ", alternativaQ=" + alternativaQ + ", alternativaR=" + alternativaR + ", alternativaS=" + alternativaS + ", alternativaT=" + alternativaT + ", corretoA=" + corretoA + ", corretoB=" + corretoB + ", corretoC=" + corretoC + ", corretoD=" + corretoD + ", corretoE=" + corretoE + ", corretoF=" + corretoF + ", corretoG=" + corretoG + ", corretoH=" + corretoH + ", corretoI=" + corretoI + ", corretoJ=" + corretoJ + ", corretoK=" + corretoK + ", corretoL=" + corretoL + ", corretoM=" + corretoM + ", corretoN=" + corretoN + ", corretoO=" + corretoO + ", corretoP=" + corretoP + ", corretoQ=" + corretoQ + ", corretoR=" + corretoR + ", corretoS=" + corretoS + ", corretoT=" + corretoT + ", revisao=" + revisao + ", cod_perg1=" + cod_perg1 + ", imagemPerg=" + imagemPerg + ", imagem1=" + imagem1 + ", imagem2=" + imagem2 + ", imagem3=" + imagem3 + ", imagem4=" + imagem4 + ", imagem5=" + imagem5 + ", imagem6=" + imagem6 + ", imagem7=" + imagem7 + ", imagem8=" + imagem8 + ", imagem9=" + imagem9 + ", imagem10=" + imagem10 + ", unidade=" + unidade + ", nomeAvaliacao=" + nomeAvaliacao + ", AlternativaEscolha=" + AlternativaEscolha + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCod_obt() {
        return cod_obt;
    }

    public void setCod_obt(String cod_obt) {
        this.cod_obt = cod_obt;
    }

    public String getDesc_obt() {
        return desc_obt;
    }

    public void setDesc_obt(String desc_obt) {
        this.desc_obt = desc_obt;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getPesoNota() {
        return pesoNota;
    }

    public void setPesoNota(String pesoNota) {
        this.pesoNota = pesoNota;
    }

    public String getQuantPeguntas() {
        return QuantPeguntas;
    }

    public void setQuantPeguntas(String QuantPeguntas) {
        this.QuantPeguntas = QuantPeguntas;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    public String getAlternativaF() {
        return alternativaF;
    }

    public void setAlternativaF(String alternativaF) {
        this.alternativaF = alternativaF;
    }

    public String getAlternativaG() {
        return alternativaG;
    }

    public void setAlternativaG(String alternativaG) {
        this.alternativaG = alternativaG;
    }

    public String getAlternativaH() {
        return alternativaH;
    }

    public void setAlternativaH(String alternativaH) {
        this.alternativaH = alternativaH;
    }

    public String getAlternativaI() {
        return alternativaI;
    }

    public void setAlternativaI(String alternativaI) {
        this.alternativaI = alternativaI;
    }

    public String getAlternativaJ() {
        return alternativaJ;
    }

    public void setAlternativaJ(String alternativaJ) {
        this.alternativaJ = alternativaJ;
    }

    public String getAlternativaK() {
        return alternativaK;
    }

    public void setAlternativaK(String alternativaK) {
        this.alternativaK = alternativaK;
    }

    public String getAlternativaL() {
        return alternativaL;
    }

    public void setAlternativaL(String alternativaL) {
        this.alternativaL = alternativaL;
    }

    public String getAlternativaM() {
        return alternativaM;
    }

    public void setAlternativaM(String alternativaM) {
        this.alternativaM = alternativaM;
    }

    public String getAlternativaN() {
        return alternativaN;
    }

    public void setAlternativaN(String alternativaN) {
        this.alternativaN = alternativaN;
    }

    public String getAlternativaO() {
        return alternativaO;
    }

    public void setAlternativaO(String alternativaO) {
        this.alternativaO = alternativaO;
    }

    public String getAlternativaP() {
        return alternativaP;
    }

    public void setAlternativaP(String alternativaP) {
        this.alternativaP = alternativaP;
    }

    public String getAlternativaQ() {
        return alternativaQ;
    }

    public void setAlternativaQ(String alternativaQ) {
        this.alternativaQ = alternativaQ;
    }

    public String getAlternativaR() {
        return alternativaR;
    }

    public void setAlternativaR(String alternativaR) {
        this.alternativaR = alternativaR;
    }

    public String getAlternativaS() {
        return alternativaS;
    }

    public void setAlternativaS(String alternativaS) {
        this.alternativaS = alternativaS;
    }

    public String getAlternativaT() {
        return alternativaT;
    }

    public void setAlternativaT(String alternativaT) {
        this.alternativaT = alternativaT;
    }

    public String getCorretoA() {
        return corretoA;
    }

    public void setCorretoA(String corretoA) {
        this.corretoA = corretoA;
    }

    public String getCorretoB() {
        return corretoB;
    }

    public void setCorretoB(String corretoB) {
        this.corretoB = corretoB;
    }

    public String getCorretoC() {
        return corretoC;
    }

    public void setCorretoC(String corretoC) {
        this.corretoC = corretoC;
    }

    public String getCorretoD() {
        return corretoD;
    }

    public void setCorretoD(String corretoD) {
        this.corretoD = corretoD;
    }

    public String getCorretoE() {
        return corretoE;
    }

    public void setCorretoE(String corretoE) {
        this.corretoE = corretoE;
    }

    public String getCorretoF() {
        return corretoF;
    }

    public void setCorretoF(String corretoF) {
        this.corretoF = corretoF;
    }

    public String getCorretoG() {
        return corretoG;
    }

    public void setCorretoG(String corretoG) {
        this.corretoG = corretoG;
    }

    public String getCorretoH() {
        return corretoH;
    }

    public void setCorretoH(String corretoH) {
        this.corretoH = corretoH;
    }

    public String getCorretoI() {
        return corretoI;
    }

    public void setCorretoI(String corretoI) {
        this.corretoI = corretoI;
    }

    public String getCorretoJ() {
        return corretoJ;
    }

    public void setCorretoJ(String corretoJ) {
        this.corretoJ = corretoJ;
    }

    public String getCorretoK() {
        return corretoK;
    }

    public void setCorretoK(String corretoK) {
        this.corretoK = corretoK;
    }

    public String getCorretoL() {
        return corretoL;
    }

    public void setCorretoL(String corretoL) {
        this.corretoL = corretoL;
    }

    public String getCorretoM() {
        return corretoM;
    }

    public void setCorretoM(String corretoM) {
        this.corretoM = corretoM;
    }

    public String getCorretoN() {
        return corretoN;
    }

    public void setCorretoN(String corretoN) {
        this.corretoN = corretoN;
    }

    public String getCorretoO() {
        return corretoO;
    }

    public void setCorretoO(String corretoO) {
        this.corretoO = corretoO;
    }

    public String getCorretoP() {
        return corretoP;
    }

    public void setCorretoP(String corretoP) {
        this.corretoP = corretoP;
    }

    public String getCorretoQ() {
        return corretoQ;
    }

    public void setCorretoQ(String corretoQ) {
        this.corretoQ = corretoQ;
    }

    public String getCorretoR() {
        return corretoR;
    }

    public void setCorretoR(String corretoR) {
        this.corretoR = corretoR;
    }

    public String getCorretoS() {
        return corretoS;
    }

    public void setCorretoS(String corretoS) {
        this.corretoS = corretoS;
    }

    public String getCorretoT() {
        return corretoT;
    }

    public void setCorretoT(String corretoT) {
        this.corretoT = corretoT;
    }

    public String getRevisao() {
        return revisao;
    }

    public void setRevisao(String revisao) {
        this.revisao = revisao;
    }

    public String getCod_perg1() {
        return cod_perg1;
    }

    public void setCod_perg1(String cod_perg1) {
        this.cod_perg1 = cod_perg1;
    }

    public String getImagemPerg() {
        return imagemPerg;
    }

    public void setImagemPerg(String imagemPerg) {
        this.imagemPerg = imagemPerg;
    }

    public String getImagem1() {
        return imagem1;
    }

    public void setImagem1(String imagem1) {
        this.imagem1 = imagem1;
    }

    public String getImagem2() {
        return imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getImagem3() {
        return imagem3;
    }

    public void setImagem3(String imagem3) {
        this.imagem3 = imagem3;
    }

    public String getImagem4() {
        return imagem4;
    }

    public void setImagem4(String imagem4) {
        this.imagem4 = imagem4;
    }

    public String getImagem5() {
        return imagem5;
    }

    public void setImagem5(String imagem5) {
        this.imagem5 = imagem5;
    }

    public String getImagem6() {
        return imagem6;
    }

    public void setImagem6(String imagem6) {
        this.imagem6 = imagem6;
    }

    public String getImagem7() {
        return imagem7;
    }

    public void setImagem7(String imagem7) {
        this.imagem7 = imagem7;
    }

    public String getImagem8() {
        return imagem8;
    }

    public void setImagem8(String imagem8) {
        this.imagem8 = imagem8;
    }

    public String getImagem9() {
        return imagem9;
    }

    public void setImagem9(String imagem9) {
        this.imagem9 = imagem9;
    }

    public String getImagem10() {
        return imagem10;
    }

    public void setImagem10(String imagem10) {
        this.imagem10 = imagem10;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getNomeAvaliacao() {
        return nomeAvaliacao;
    }

    public void setNomeAvaliacao(String nomeAvaliacao) {
        this.nomeAvaliacao = nomeAvaliacao;
    }

    public int getAlternativaEscolha() {
        return AlternativaEscolha;
    }

    public void setAlternativaEscolha(int AlternativaEscolha) {
        this.AlternativaEscolha = AlternativaEscolha;
    }

   

       
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
      private int codigo;
      private String cod_obt;
      private String desc_obt;
      private String Descricao;
      private String pesoNota;
      private String QuantPeguntas;
      private String alternativaA;
      private String alternativaB;
      private String alternativaC;
      private String alternativaD;
      private String alternativaE;
      private String alternativaF;
      private String alternativaG;
      private String alternativaH;
      private String alternativaI;
      private String alternativaJ;
      private String alternativaK;
      private String alternativaL;
      private String alternativaM;
      private String alternativaN;
      private String alternativaO;
      private String alternativaP;
      private String alternativaQ;
      private String alternativaR;
      private String alternativaS;
      private String alternativaT;
      private String corretoA;
      private String corretoB;
      private String corretoC;
      private String corretoD;
      private String corretoE;
      private String corretoF;
      private String corretoG;
      private String corretoH;
      private String corretoI;
      private String corretoJ;
      private String corretoK;
      private String corretoL;
      private String corretoM;
      private String corretoN;
      private String corretoO;
      private String corretoP;
      private String corretoQ;
      private String corretoR;
      private String corretoS;
      private String corretoT;
      private String revisao;
      private String cod_perg1;
      private String imagemPerg;
      private String imagem1;
      private String imagem2;
      private String imagem3;
      private String imagem4;
      private String imagem5;
      private String imagem6;
      private String imagem7;
      private String imagem8;
      private String imagem9;
      private String imagem10;
      private String unidade;
      private String nomeAvaliacao;
      private int AlternativaEscolha;

   
}
