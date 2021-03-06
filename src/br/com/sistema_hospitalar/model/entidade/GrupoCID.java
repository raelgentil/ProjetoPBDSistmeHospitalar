/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author rafaelgentil
 */
@Entity
@Table(name = "cid_grupo")
public class GrupoCID implements Serializable, IEntidadeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_categoria_inicial", length = 10)
    private String codigoCategoriaInicial;

    @Column(name = "codigo_categoria_final", length = 10)
    private String codigoCategoriaFinal;

    @Column(name = "descricao")
    private String descricao;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cid_grupo_categoria", joinColumns
            = {
                @JoinColumn(name = "grupo_id")}, inverseJoinColumns
            = {
                @JoinColumn(name = "categoria_id")})
    private List<CategoriaCID> categorias;

    public GrupoCID() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoCategoriaInicial() {
        return codigoCategoriaInicial;
    }

    public void setCodigoCategoriaInicial(String codigoCategoriaInicial) {
        this.codigoCategoriaInicial = codigoCategoriaInicial;
    }

    public String getCodigoCategoriaFinal() {
        return codigoCategoriaFinal;
    }

    public void setCodigoCategoriaFinal(String codigoCategoriaFinal) {
        this.codigoCategoriaFinal = codigoCategoriaFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<CategoriaCID> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaCID> categorias) {
        this.categorias = categorias;
    }

    
    
}
