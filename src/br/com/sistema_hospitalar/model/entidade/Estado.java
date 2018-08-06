package br.com.sistema_hospitalar.model.entidade;

import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import br.com.sistema_hospitalar.model.entidade.interfaces.IEstado;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafaelgentil
 *
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable , IEntidadeBase{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uf", length = 2, unique = true)
    private String uf;
    @Column(name = "descricao", length = 20)
    private String descricao;

    private Estado() {
    }


    
    public Estado(String uf, String descricao) {
        this.uf = uf;
        this.descricao = descricao;
    }

    public Estado(Long id, String uf, String descricao) {
        this.id = id;
        this.uf = uf;
        this.descricao = descricao;
    }
    
    
    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", uf=" + uf + ", descricao=" + descricao + '}';
    }

   

    
}
