/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author João Emerson
 */
@Entity
@Table(name = "profissional_saude")
public class ProfissionalSaude extends Funcionario implements Serializable {
    
    @Column(name = "apelido", unique = true, length = 10)
    private String apelido;
    
    /**
     * utilizar um separador com um conselho e o codigo de cada especialização
     */
    @Column(name = "especializacao", length = 50)
    private String especializacoes;
    
    @Transient
    private List<Especializacao> especializacoess;
    
    private String pacientesMarcados;

    @Transient
    private List<Consulta> consultas;

    public ProfissionalSaude() {
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEspecializacoes() {
        return especializacoes;
    }

    public void setEspecializacoes(String especializacoes) {
        this.especializacoes = especializacoes;
    }

    public List<Especializacao> getEspecializacoess() {
        return especializacoess;
    }

    public void setEspecializacoess(List<Especializacao> especializacoess) {
        this.especializacoess = especializacoess;
    }

    public String getPacientesMarcados() {
        return pacientesMarcados;
    }

    public void setPacientesMarcados(String pacientesMarcados) {
        this.pacientesMarcados = pacientesMarcados;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    
    
}
