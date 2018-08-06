/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
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

    private CategoriaCID() {
    }

    public CategoriaCID(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.subCategorias = new ArrayList<>();
    }

    public CategoriaCID(Long id, String codigo, String descricao, List<CategoriaCID> subCategorias) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.subCategorias = subCategorias;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<CategoriaCID> getSubCategorias() {
        return subCategorias;
    }

    public void addSubCategoria(CategoriaCID subCategoria) {
        subCategorias.add(subCategoria);
    }

    @Override
    public String toString() {
        return "\nCIDCategoria{" + "id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + '}' + "\n";
    }

    public String getCodigo() {
        return codigo;
    }
    
}
