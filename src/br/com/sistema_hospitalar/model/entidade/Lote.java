/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rafaelgentil
 */
@Entity
public class Lote implements Serializable,IEntidadeBase{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private Long codigo;
    
    @Column(name = "quantidade_insumo")
    private int quantidadeInsumo;

    @Column(name = "data_validade")
    @Temporal(TemporalType.DATE)
    private Calendar dataValidade;

    @Column(name = "data_fabricacao")
    @Temporal(TemporalType.DATE)
    private Calendar dataFabricacao;

    @Column(name = "generico")
    private boolean generico;
    
    @ManyToOne
    @JoinColumn(name = "insumo_id", referencedColumnName = "id", nullable = false)
    private Insumo insumo;

    private Lote() {
    }

    public Lote(Long codigo, int quantidadeInsumo, Calendar dataValidade, Calendar dataFabricacao, boolean generico, Insumo insumo) {
        this.codigo = codigo;
        this.quantidadeInsumo = quantidadeInsumo;
        this.dataValidade = dataValidade;
        this.dataFabricacao = dataFabricacao;
        this.generico = generico;
        this.insumo = insumo;
    }

    public Lote(Long id, Long codigo, int quantidadeInsumo, Calendar dataValidade, Calendar dataFabricacao, boolean generico, Insumo insumo) {
        this.id = id;
        this.codigo = codigo;
        this.quantidadeInsumo = quantidadeInsumo;
        this.dataValidade = dataValidade;
        this.dataFabricacao = dataFabricacao;
        this.generico = generico;
        this.insumo = insumo;
    }

    public Long getId() {
        return id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public int getQuantidadeInsumo() {
        return quantidadeInsumo;
    }

    public Calendar getDataValidade() {
        return dataValidade;
    }

    public Calendar getDataFabricacao() {
        return dataFabricacao;
    }

    public boolean isGenerico() {
        return generico;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    @Override
    public String toString() {
        return "Lote{" + "id=" + id + ", codigo=" + codigo + ", quantidadeInsumo=" + quantidadeInsumo + ", dataValidade=" + dataValidade + ", dataFabricacao=" + dataFabricacao + ", generico=" + generico + ", insumo=" + insumo + '}';
    }

    

    
    
    

    
    
}
