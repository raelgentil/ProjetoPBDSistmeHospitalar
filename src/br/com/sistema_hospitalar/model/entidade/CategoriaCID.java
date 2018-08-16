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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rafaelgentil
 */
@Entity
@Table(name = "cid_categoria")
public class CategoriaCID implements Serializable, IEntidadeBase  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", length = 10)
    private String codigo;

    @Column(name = "descricao")
    private String descricao;
//    @Transient
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cid_categoria_subcategoria", joinColumns
            = {
                @JoinColumn(name = "categoria_id")}, inverseJoinColumns
            = {
                @JoinColumn(name = "subcategoria_id")})
    private List<CategoriaCID> subCategorias;

    public CategoriaCID() {
    }

    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<CategoriaCID> getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(List<CategoriaCID> subCategorias) {
        this.subCategorias = subCategorias;
    }

    

    
}
