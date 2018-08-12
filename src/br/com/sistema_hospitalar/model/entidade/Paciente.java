/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.util.Calendar;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author rafaelgentil
 */
@Entity
@Table(name = "paciente")
public class Paciente extends Pessoa implements Serializable {

    @Column(name = "tipo_sanguinio", length = 2)
    private String tipoSanguinio;

    @Column(name = "fator_rh")
    private boolean fatorRh;

    @Column(name = "limitacoes", length = 255)
    private String limitacoes;

    @Column(name = "alergias", length = 255)
    private String alergias;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data_falecimento")
    private Calendar dataDeFalecimento;

    @Column(name = "doador_orgaos")
    private boolean doadorDeOrgaos;
    
    @ManyToMany()
    @JoinTable(name = "paciente_dependente", joinColumns
            = {
                @JoinColumn(name = "paciente_id")}, inverseJoinColumns
            = {
                @JoinColumn(name = "dependente_id")})
    private List<Pessoa> dependentes;
    
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "paciente")
//    private List<Prontuario> prontuarios;
    
    private Paciente() {
        super(null, null, null, null, null, null, null);
    }
    
    public Paciente(String nome, String cpf, String email, String telefones, String sexo, Calendar dataDeNascimento, Endereco endereco, String tipoSanguinio, boolean fatorRh, String limitacoes, String alergias, Calendar dataDeFalecimento, boolean doadorDeOrgaos) {
        super(nome, cpf, email, telefones, sexo, dataDeNascimento, endereco);
        this.tipoSanguinio = tipoSanguinio;
        this.fatorRh = fatorRh;
        this.limitacoes = limitacoes;
        this.alergias = alergias;
        this.dataDeFalecimento = dataDeFalecimento;
        this.doadorDeOrgaos = doadorDeOrgaos;
//        this.prontuarios = prontuarios;
        
    }

    public Paciente(String nome, String cpf, String email, String telefones, String sexo, Calendar dataDeNascimento, Endereco endereco, String tipoSanguinio, boolean fatorRh, String limitacoes, String alergias, Calendar dataDeFalecimento, boolean doadorDeOrgaos, List<Pessoa> dependentes) {
        super(nome, cpf, email, telefones, sexo, dataDeNascimento, endereco);
        this.tipoSanguinio = tipoSanguinio;
        this.fatorRh = fatorRh;
        this.limitacoes = limitacoes;
        this.alergias = alergias;
        this.dataDeFalecimento = dataDeFalecimento;
        this.doadorDeOrgaos = doadorDeOrgaos;
        this.dependentes = dependentes;
    }
    
    public Paciente(Long id,String nome, String cpf, String email, String telefones, String sexo, Calendar dataDeNascimento, Endereco endereco, String tipoSanguinio, boolean fatorRh, String limitacoes, String alergias, Calendar dataDeFalecimento, boolean doadorDeOrgaos, List<Pessoa> dependentes) {
        super(id, nome, cpf, email, telefones, sexo, dataDeNascimento, endereco);
        this.tipoSanguinio = tipoSanguinio;
        this.fatorRh = fatorRh;
        this.limitacoes = limitacoes;
        this.alergias = alergias;
        this.dataDeFalecimento = dataDeFalecimento;
        this.doadorDeOrgaos = doadorDeOrgaos;
        this.dependentes = dependentes;
    }
    
    public String getTipoSanguinio() {
        return tipoSanguinio;
    }

    public boolean isFatorRh() {
        return fatorRh;
    }

    public String getLimitacoes() {
        return limitacoes;
    }

    public String getAlergias() {
        return alergias;
    }

    public Calendar getDataDeFalecimento() {
        return dataDeFalecimento;
    }

    public boolean getDoadorDeOrgaos() {
        return doadorDeOrgaos;
    }

    @Override
    public String toString() {
        return "Paciente{" + "tipoSanguinio=" + tipoSanguinio + ", fatorRh=" + fatorRh + ", limitacoes=" + limitacoes + ", alergias=" + alergias + ", dataDeFalecimento=" + dataDeFalecimento + ", doadorDeOrgaos=" + doadorDeOrgaos + '}';
    }

    public boolean isDoadorDeOrgaos() {
        return doadorDeOrgaos;
    }

    public List<Pessoa> getDependentes() {
        return dependentes;
    }

    


    

    

}
