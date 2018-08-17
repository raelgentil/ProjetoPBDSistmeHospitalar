/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

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
import javax.persistence.Transient;

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
    
    @Transient
    private boolean insumoPego;
    
    @ManyToOne
    @JoinColumn(name = "insumo_id", referencedColumnName = "id", nullable = false)
    private Insumo insumo;

    public Lote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public int getQuantidadeInsumo() {
        return quantidadeInsumo;
    }

    public void setQuantidadeInsumo(int quantidadeInsumo) {
        this.quantidadeInsumo = quantidadeInsumo;
    }

    public Calendar getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Calendar dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Calendar getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Calendar dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public boolean isGenerico() {
        return generico;
    }

    public void setGenerico(boolean generico) {
        this.generico = generico;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    /**
     * atributo usado pra verificar se o paciente pegou o medicamento ou não passado na prescrição
     * @return boolean 
     */
    public boolean isInsumoPego() {
        return insumoPego;
    }

    /**
     * atributo usado pra verificar se o paciente pegou o medicamento ou não passado na prescrição
     * @param insumoPego 
     */
    public void setInsumoPego(boolean insumoPego) {
        this.insumoPego = insumoPego;
    }

    
    
    
    
}
