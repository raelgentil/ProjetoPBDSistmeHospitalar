/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import br.com.sistema_hospitalar.model.entidade.interfaces.IMunicipio;


/**
 *
 * @author rafaelgentil
 */
@Entity
@Table(name = "municipio")
public class Municipio implements Serializable, IEntidadeBase{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
    
    @ManyToOne()
//    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
    private Estado estado;

    private Municipio() {
    }
    
    
       public Municipio(String descricao, Estado estado) {
        this.descricao = descricao;
        this.estado = estado;
    }

    public Municipio(Long id, String descricao, Estado estado) {
        this.id = id;
        this.descricao = descricao;
        this.estado = estado;
    }
    
    
    


    @Override
    public String toString() {
        return "Municipio{" + "id=" + getId() + ", cep="  + ", descricao=" + getDescricao() + ", estado=" + getEstado() + '}';
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }


    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

//    public List<Endereco> getEnderecos() {
//        return enderecos;
//    }


}
