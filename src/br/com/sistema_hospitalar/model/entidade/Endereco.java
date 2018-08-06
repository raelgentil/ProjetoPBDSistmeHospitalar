/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import br.com.sistema_hospitalar.model.entidade.interfaces.IEndereco;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafaelgentil
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable, IEndereco{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cep", nullable = false)
    private int cep;
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "bairro", nullable = false, length = 255)
    private String bairro;
    @Column(name = "complemento", nullable = false, length = 255)
    private String complemento;
    
    @ManyToOne()
//    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "municipio_id", referencedColumnName = "id", nullable = false)
    private Municipio municipio;

    private Endereco() {
    }

    

    public Endereco(int cep, String descricao, String numero, String bairro, String complemento, Municipio municipio) {
        this.cep = cep;
        this.descricao = descricao;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.municipio = municipio;
    }

    public Endereco(Long id, int cep, String descricao, String numero, String bairro, String complemento, Municipio municipio) {
        this.id = id;
        this.cep = cep;
        this.descricao = descricao;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + getId() + ", cep=" + getCep() + ", descricao=" + getDescricao() + ", numero=" + getNumero() + ", bairro=" + getBairro() + ", complemento=" + getComplemento() + ", municipio=" + getMunicipio() + '}';
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the cep
     */
    public int getCep() {
        return cep;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @return the municipio
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    
}
