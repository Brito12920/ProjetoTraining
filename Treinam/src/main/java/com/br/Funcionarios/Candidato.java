package com.br.Funcionarios;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author v103760
 */

    public class Candidato implements Serializable{

        private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="candidato_id")
    private Integer id;
    @Column(name="candidato_nome")
    private String nome;
    @Column(name="candidato_inscricao")
    private String inscricao;

	//getters and setters


}
