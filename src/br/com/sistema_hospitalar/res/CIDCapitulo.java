/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.res;

import br.com.sistema_hospitalar.model.entidade.IEntidadeBase;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rafaelgentil
 */
@Entity
@Table(name = "cid_capitulo")
class CIDCapitulo implements Serializable, IEntidadeBase {

//int numCap;//atributo numcap: número do capítulo em arábico; se igual a 0, indica que o capítulo contém classificações extras;
//String numRomano;//atributo romano: número do capítulo em romano; vazio se numcap = 0;
//String codcatInicial;//atributo inicial: código (codcat) da primeira categoria do capítulo;
//String codcatFinal;//atributo final: código (codcat) da última categoria do capítulo; e
//String codcap;//atributo codcap: código do capítulo, usado como identificador, montado como inicial-final;
//String nome;//elemento nome: texto com o nome do capítulo;
//String nome50;//elemento nome50: texto com o nome abreviado do capítulo (50 caracteres); e
//List<Grupo> grupos; ;//conjunto de um ou mais elementos grupo e/ou categoria.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    int numeroCapitulo;

    @Column(name = "codigo_categoria_inicial", length = 10)
    String codigoCategoriaInicial;

    @Column(name = "codigo_categoria_final", length = 10)
    String codigoCategoriaFinal;

    @Column(name = "descricao")
    String descricao;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid_capitulo_id")
//    @JoinTable(name = "trabalhos_pessoas")
    List<CIDGrupo> grupos;

    public CIDCapitulo(int numeroCapitulo, String codigoCategoriaInicial, String codigoCategoriaFinal, String descricao) {
        this.numeroCapitulo = numeroCapitulo;
        this.codigoCategoriaInicial = codigoCategoriaInicial;
        this.codigoCategoriaFinal = codigoCategoriaFinal;
        this.descricao = descricao;
        this.grupos = new ArrayList<>();
    }

    public int getNumeroCapitulo() {
        return numeroCapitulo;
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

    public List<CIDGrupo> getGrupos() {
        return grupos;
    }

    @Override
    public String toString() {
        return "\n\nCIDCapitulo{" + "id=" + id + ", numeroCapitulo=" + numeroCapitulo + ", codigoCategoriaInicial=" + codigoCategoriaInicial + ", codigoCategoriaFinal=" + codigoCategoriaFinal + ", descricao=" + descricao + ", grupos=" + grupos + '}';
    }

   public void addGrupos(CIDGrupo grupo){
       grupos.add(grupo);
   }

    public Long getId() {
        return id;
    }

}
