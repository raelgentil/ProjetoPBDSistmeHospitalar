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

    public GrupoCID(String codigoCategoriaInicial, String codigoCategoriaFinal, String descricao) {
        this.codigoCategoriaInicial = codigoCategoriaInicial;
        this.codigoCategoriaFinal = codigoCategoriaFinal;
        this.descricao = descricao;
        this.categorias = new ArrayList<>();
    }

    private GrupoCID() {
    }

//String codcatInicial;//   atributo inicial: código (codcat) da primeira categoria do grupo;
//String codcatFinal;//atributo final: código (codcat) da última categoria do grupo;
//String codgrupo;//atributo codgrupo: código do grupo, usado como identificador, montado como inicial-final;
//String nome;//elemento nome: texto com o nome do grupo;
//String nome50;//elemento nome50: texto com o nome abreviado do grupo (50 caracteres); e
//List<Categoria> categorias;//conjunto de um ou mais elementos grupo e/ou categoria (portanto, um grupo pode conter outros grupos).
//List<Grupo> subGrupos;  
    @Override
    public String toString() {
        return "\nCIDGrupo{" + "id=" + id + ", codigoCategoriaInicial=" + codigoCategoriaInicial + ", codigoCategoriaFinal=" + codigoCategoriaFinal + ", descricao=" + descricao + '}' + "\n";
    }

    public String getCodigoCategoriaInicial() {
        return codigoCategoriaInicial;
    }

    public String getCodigoCategoriaFinal() {
        return codigoCategoriaFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<CategoriaCID> getCategorias() {
        return categorias;
    }

    public void addCategoria(CategoriaCID categoria) {
        categorias.add(categoria);
    }

    public Long getId() {
        return id;
    }
    
}
