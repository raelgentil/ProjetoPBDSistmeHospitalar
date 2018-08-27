/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.res;

import br.com.sistema_hospitalar.model.entidade.IEntidadeBase;
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
import javax.persistence.Transient;

/**
 *
 * @author rafaelgentil
 */
@Entity
@Table(name = "cid_categoria")
class CIDCategoria implements IEntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", length = 10)
    private String codigo;

    @Column(name = "descricao")
    private String descricao;
//    @Transient
    @OneToMany(cascade = CascadeType.ALL)
     @JoinTable(name="cid_categoria_subcategoria", joinColumns=
    {@JoinColumn(name="categoria_id")}, inverseJoinColumns=
      {@JoinColumn(name="subcategoria_id")})
    private List<CIDCategoria> subCategorias;

    private CIDCategoria() {
    }

//String codigo;//atributo codcat: código da categoria, usada como identificador, no formato LNN, sendo L uma letra e NN um número de 01 a 99;
//boolean ehsubcat;//atributo ehsubcat: indica (sim ou nao) se a categoria é também uma subcategoria, ou seja, não tem subcategorias; o default é nao;
//String nome;//elemento nome: texto com o nome da categoria;
//String nome50;//elemento nome50: texto com o nome abreviado da categoria (50 caracteres);
//List<Categoria> subCategorias;//conjunto de uma ou mais elementos subcategoria.
    public CIDCategoria(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.subCategorias = new ArrayList<>();
    }

    public CIDCategoria(Long id, String codigo, String descricao, List<CIDCategoria> subCategorias) {
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

    public List<CIDCategoria> getSubCategorias() {
        return subCategorias;
    }

    public void addSubCategoria(CIDCategoria subCategoria) {
        subCategorias.add(subCategoria);
    }

    @Override
    public String toString() {
        return "\nCIDCategoria{" + "id=" + id + ", codigo=" + codigo + ", descricao=" + descricao  + '}' + "\n";
    }

    public String getCodigo() {
        return codigo;
    }

}
