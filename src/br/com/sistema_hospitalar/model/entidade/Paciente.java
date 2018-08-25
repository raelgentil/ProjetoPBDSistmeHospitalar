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

    public Paciente() {
    }

    public String getTipoSanguinio() {
        return tipoSanguinio;
    }

    public void setTipoSanguinio(String tipoSanguinio) {
        this.tipoSanguinio = tipoSanguinio;
    }

    public boolean isFatorRh() {
        return fatorRh;
    }

    public void setFatorRh(boolean fatorRh) {
        this.fatorRh = fatorRh;
    }

    public String getLimitacoes() {
        return limitacoes;
    }

    public void setLimitacoes(String limitacoes) {
        this.limitacoes = limitacoes;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Calendar getDataDeFalecimento() {
        return dataDeFalecimento;
    }

    public void setDataDeFalecimento(Calendar dataDeFalecimento) {
        this.dataDeFalecimento = dataDeFalecimento;
    }

    public boolean isDoadorDeOrgaos() {
        return doadorDeOrgaos;
    }

    public void setDoadorDeOrgaos(boolean doadorDeOrgaos) {
        this.doadorDeOrgaos = doadorDeOrgaos;
    }

    public List<Pessoa> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Pessoa> dependentes) {
        this.dependentes = dependentes;
    }
@Override
    public String toString() {
        return getNome();
    }
    
    
    

    

}
