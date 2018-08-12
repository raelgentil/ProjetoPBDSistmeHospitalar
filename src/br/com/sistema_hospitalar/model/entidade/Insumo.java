/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rafaelgentil
 */
@Entity
public class Insumo implements Serializable, IEntidadeBase {

     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", unique = true)
    private String descricao;
    
    @Column(name = "quantidade_total")
    private int quantidadeTotal;
    
    @Column(name = "quantidade_minima")
    private int quantidadeMinima;
    
    @Column(name = "valor")
    private double valor;

    private Insumo() {
    }

    public Insumo(String descricao, int quantidadeMinima, double valor) {
        this.descricao = descricao;
        this.quantidadeMinima = quantidadeMinima;
        this.valor = valor;
    }

    public Insumo(Long id, String descricao, int quantidadeTotal, int quantidadeMinima, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeMinima = quantidadeMinima;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Insumo{" + "id=" + id + ", descricao=" + descricao + ", quantidadeTotal=" + quantidadeTotal + ", quantidadeMinima=" + quantidadeMinima + ", valor=" + valor + '}';
    }
    
    
    
    
}
