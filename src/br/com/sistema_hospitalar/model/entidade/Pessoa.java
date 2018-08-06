/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import java.util.Calendar;

/**
 *
 * @author rafaelgentil
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Pessoa implements Serializable, IEntidadeBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome", length = 255)
    private String nome;
    
    @Column(name = "cpf", unique = true, length = 11)
    private String cpf;
    
    @Column(name = "email",length = 50)
    private String email;
    
    @Column(name = "tefeones", length = 25)
    private String telefones;
    
    @Column(name = "sexo", length = 2)
    private String sexo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data_nasciemnto")
    private Calendar dataDeNascimento;
    
    @ManyToOne()
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String email, String telefones, String sexo, Calendar dataDeNascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefones = telefones;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
    }

    public Pessoa(Long id, String nome, String cpf, String email, String tefones, String sexo, Calendar dataDeNascimento, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefones = tefones;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
        
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the telefones
     */
    public String getTelefones() {    
        return telefones;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @return the dataDeNascimento
     */
    public Calendar getDataDeNascimento() {
        return dataDeNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", tefones=" + telefones + ", sexo=" + sexo + ", dataDeNascimento=" + dataDeNascimento + ", endereco=" + endereco + '}';
    }

    public Endereco getEndereco() {
        return endereco;
    }

    



    
}
