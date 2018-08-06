/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author João Emerson
 */
@Entity
@Table(name = "especializacao")
public class Especializacao implements IEntidadeBase{ //implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double valor;
    private String conselho;
    
    @Transient
    private String codigo;

    private Especializacao() {
    }

    
    public Especializacao(String nome, double valor, String conselho) {
        this.nome = nome;
        this.valor = valor;
        this.conselho = conselho;
    }

    public Especializacao(Long id, String nome, double valor, String conselho) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.conselho = conselho;
    }

    
    public Especializacao(Long id, String nome, double valor, String conselho, String codigo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.conselho = conselho;
        this.codigo = codigo;
    }

    
    
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getConselho() {
        return conselho;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Especializacao{" + "id=" + id + ", nome=" + nome + ", valor=" + valor + ", conselho=" + conselho + ", codigo=" + codigo + '}';
    }

    
    
}