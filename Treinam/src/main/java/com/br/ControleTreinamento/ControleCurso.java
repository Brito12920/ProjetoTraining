package com.br.ControleTreinamento;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author v103760
 */
@Entity
public class ControleCurso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int codigo;
    
    private String CodigoObt;

    public ControleCurso() {
    }

    @Override
    public String toString() {
        return "Controle{" + "codigo=" + codigo + ", CodigoObt=" + CodigoObt + ", RegistroTreinamento=" + RegistroTreinamento + ", Registro=" + Registro + ", Nome=" + Nome + ", Data_inclusao=" + Data_inclusao + ", hora_inclusao=" + hora_inclusao + ", Data_curso=" + Data_curso + ", hora_curso=" + hora_curso + ", Tempo=" + Tempo + ", dataValidade=" + dataValidade + ", obtModelo=" + obtModelo + ", obtModeloSub=" + obtModeloSub + ", Cargo=" + Cargo + ", Departamento=" + Departamento + ", Unidade=" + Unidade + ", mapaProcesso=" + mapaProcesso + ", subProcesso=" + subProcesso + ", status=" + status + ", gestor=" + gestor + ", treinamento=" + treinamento + ", centroCusto=" + centroCusto + ", TipoTreinamento=" + TipoTreinamento + ", NomeTrainamento=" + NomeTrainamento + ", desc_treinamento=" + desc_treinamento + ", tema=" + tema + ", obs=" + obs + ", Tipo=" + Tipo + ", CustoTreinamento=" + CustoTreinamento + ", Fornecedor=" + Fornecedor + ", Ch=" + Ch + ", AvaliacaoReacao=" + AvaliacaoReacao + ", Criterio_kpi_avalicao_eficacia=" + Criterio_kpi_avalicao_eficacia + ", avalicaoEficacia=" + avalicaoEficacia + ", dataAvaliaEficacia=" + dataAvaliaEficacia + ", certificado=" + certificado + ", numeroDocumento=" + numeroDocumento + ", revisao=" + revisao + ", anexo=" + anexo + ", statusAvaliacao=" + statusAvaliacao + '}';
    }

    public ControleCurso(int codigo, String CodigoObt, String RegistroTreinamento, String Registro, String Nome, String Data_inclusao, String hora_inclusao, String Data_curso, String hora_curso, String Tempo, String dataValidade, String obtModelo, String obtModeloSub, String Cargo, String Departamento, String Unidade, String mapaProcesso, String subProcesso, String status, String gestor, String treinamento, String centroCusto, String TipoTreinamento, String NomeTrainamento, String desc_treinamento, String tema, String obs, String Tipo, String CustoTreinamento, String Fornecedor, String Ch, String AvaliacaoReacao, String Criterio_kpi_avalicao_eficacia, String avalicaoEficacia, String dataAvaliaEficacia, String certificado, String numeroDocumento, String revisao, String anexo, boolean statusAvaliacao) {
        this.codigo = codigo;
        this.CodigoObt = CodigoObt;
        this.RegistroTreinamento = RegistroTreinamento;
        this.Registro = Registro;
        this.Nome = Nome;
        this.Data_inclusao = Data_inclusao;
        this.hora_inclusao = hora_inclusao;
        this.Data_curso = Data_curso;
        this.hora_curso = hora_curso;
        this.Tempo = Tempo;
        this.dataValidade = dataValidade;
        this.obtModelo = obtModelo;
        this.obtModeloSub = obtModeloSub;
        this.Cargo = Cargo;
        this.Departamento = Departamento;
        this.Unidade = Unidade;
        this.mapaProcesso = mapaProcesso;
        this.subProcesso = subProcesso;
        this.status = status;
        this.gestor = gestor;
        this.treinamento = treinamento;
        this.centroCusto = centroCusto;
        this.TipoTreinamento = TipoTreinamento;
        this.NomeTrainamento = NomeTrainamento;
        this.desc_treinamento = desc_treinamento;
        this.tema = tema;
        this.obs = obs;
        this.Tipo = Tipo;
        this.CustoTreinamento = CustoTreinamento;
        this.Fornecedor = Fornecedor;
        this.Ch = Ch;
        this.AvaliacaoReacao = AvaliacaoReacao;
        this.Criterio_kpi_avalicao_eficacia = Criterio_kpi_avalicao_eficacia;
        this.avalicaoEficacia = avalicaoEficacia;
        this.dataAvaliaEficacia = dataAvaliaEficacia;
        this.certificado = certificado;
        this.numeroDocumento = numeroDocumento;
        this.revisao = revisao;
        this.anexo = anexo;
        this.statusAvaliacao = statusAvaliacao;
    }
    private String RegistroTreinamento;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCodigoObt() {
        return CodigoObt;
    }

    public void setCodigoObt(String CodigoObt) {
        this.CodigoObt = CodigoObt;
    }

    public String getRegistroTreinamento() {
        return RegistroTreinamento;
    }

    public void setRegistroTreinamento(String RegistroTreinamento) {
        this.RegistroTreinamento = RegistroTreinamento;
    }

    public String getRegistro() {
        return Registro;
    }

    public void setRegistro(String Registro) {
        this.Registro = Registro;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

   

    public String getHora_inclusao() {
        return hora_inclusao;
    }

    public void setHora_inclusao(String hora_inclusao) {
        this.hora_inclusao = hora_inclusao;
    }

    public String getData_curso() {
        return Data_curso;
    }

    public void setData_curso(String Data_curso) {
        this.Data_curso = Data_curso;
    }

    public String getHora_curso() {
        return hora_curso;
    }

    public void setHora_curso(String hora_curso) {
        this.hora_curso = hora_curso;
    }

    public String getTempo() {
        return Tempo;
    }

    public void setTempo(String Tempo) {
        this.Tempo = Tempo;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getObtModelo() {
        return obtModelo;
    }

    public void setObtModelo(String obtModelo) {
        this.obtModelo = obtModelo;
    }

    public String getObtModeloSub() {
        return obtModeloSub;
    }

    public void setObtModeloSub(String obtModeloSub) {
        this.obtModeloSub = obtModeloSub;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getUnidade() {
        return Unidade;
    }

    public void setUnidade(String Unidade) {
        this.Unidade = Unidade;
    }

    public String getMapaProcesso() {
        return mapaProcesso;
    }

    public void setMapaProcesso(String mapaProcesso) {
        this.mapaProcesso = mapaProcesso;
    }

    public String getSubProcesso() {
        return subProcesso;
    }

    public void setSubProcesso(String subProcesso) {
        this.subProcesso = subProcesso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public String getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(String treinamento) {
        this.treinamento = treinamento;
    }

    public String getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(String centroCusto) {
        this.centroCusto = centroCusto;
    }

    public String getTipoTreinamento() {
        return TipoTreinamento;
    }

    public void setTipoTreinamento(String TipoTreinamento) {
        this.TipoTreinamento = TipoTreinamento;
    }

    public String getNomeTrainamento() {
        return NomeTrainamento;
    }

    public void setNomeTrainamento(String NomeTrainamento) {
        this.NomeTrainamento = NomeTrainamento;
    }

    public String getDesc_treinamento() {
        return desc_treinamento;
    }

    public void setDesc_treinamento(String desc_treinamento) {
        this.desc_treinamento = desc_treinamento;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getCustoTreinamento() {
        return CustoTreinamento;
    }

    public void setCustoTreinamento(String CustoTreinamento) {
        this.CustoTreinamento = CustoTreinamento;
    }

    public String getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(String Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

    public String getCh() {
        return Ch;
    }

    public void setCh(String Ch) {
        this.Ch = Ch;
    }

    public String getAvaliacaoReacao() {
        return AvaliacaoReacao;
    }

    public void setAvaliacaoReacao(String AvaliacaoReacao) {
        this.AvaliacaoReacao = AvaliacaoReacao;
    }

    public String getCriterio_kpi_avalicao_eficacia() {
        return Criterio_kpi_avalicao_eficacia;
    }

    public void setCriterio_kpi_avalicao_eficacia(String Criterio_kpi_avalicao_eficacia) {
        this.Criterio_kpi_avalicao_eficacia = Criterio_kpi_avalicao_eficacia;
    }

    public String getAvalicaoEficacia() {
        return avalicaoEficacia;
    }

    public void setAvalicaoEficacia(String avalicaoEficacia) {
        this.avalicaoEficacia = avalicaoEficacia;
    }

    public String getDataAvaliaEficacia() {
        return dataAvaliaEficacia;
    }

    public void setDataAvaliaEficacia(String dataAvaliaEficacia) {
        this.dataAvaliaEficacia = dataAvaliaEficacia;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    private String Registro;
    private String Nome;
    @NotEmpty(message="Campo Data não pode ficar em branco")
   
    private String Data_inclusao;

    public String getData_inclusao() {
        return Data_inclusao;
    }

    public void setData_inclusao(String Data_inclusao) {
        this.Data_inclusao = Data_inclusao;
    }

   
    private String hora_inclusao;
    private String Data_curso;
    private String hora_curso;
    @NotEmpty(message="Campo Tempo não pode ficar em branco")
    private String Tempo;
    private String dataValidade;
    private String obtModelo;
    private String obtModeloSub;
    private String Cargo;
    private String Departamento;
    private String Unidade;
    private String mapaProcesso;
    private String subProcesso;
    private String status;
    private String gestor;
    private String treinamento;
    private String centroCusto;
    private String TipoTreinamento;
    private String NomeTrainamento;
    private String desc_treinamento;
    private String tema;
    private String obs;
    private String Tipo;
    private String CustoTreinamento;
    private String Fornecedor;
    private String Ch;
    private String AvaliacaoReacao;
    private String Criterio_kpi_avalicao_eficacia;
    private String avalicaoEficacia;
    private String dataAvaliaEficacia;
    private String certificado;
    private String numeroDocumento;
    private String revisao;
    private String anexo;

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getRevisao() {
        return revisao;
    }

    public void setRevisao(String revisao) {
        this.revisao = revisao;
    }
    private boolean statusAvaliacao;

    public boolean isStatusAvaliacao() {
        return statusAvaliacao;
    }

    public void setStatusAvaliacao(boolean statusAvaliacao) {
        this.statusAvaliacao = true;
    }
}
