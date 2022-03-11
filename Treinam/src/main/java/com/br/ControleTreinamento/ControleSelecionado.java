package com.br.ControleTreinamento;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author v103760
 */
public class ControleSelecionado implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigo;
    private String CodigoObt;
    private String RegistroTreinamento;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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
    @NotEmpty(message="Campo Tipo de treinamento não pode ficar em branco")
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
    private boolean statusAvaliacao;

    public boolean isStatusAvaliacao() {
        return statusAvaliacao;
    }

    public void setStatusAvaliacao(boolean statusAvaliacao) {
        this.statusAvaliacao = true;
    }
}
