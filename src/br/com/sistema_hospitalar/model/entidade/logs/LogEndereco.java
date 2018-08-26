/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade.logs;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaelgentil
 */
@Entity
@Table(name = "log_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogEndereco.findAll", query = "SELECT l FROM LogEndereco l")
    , @NamedQuery(name = "LogEndereco.findById", query = "SELECT l FROM LogEndereco l WHERE l.id = :id")
    , @NamedQuery(name = "LogEndereco.findByData", query = "SELECT l FROM LogEndereco l WHERE l.data = :data")
    , @NamedQuery(name = "LogEndereco.findByAutor", query = "SELECT l FROM LogEndereco l WHERE l.autor = :autor")
    , @NamedQuery(name = "LogEndereco.findByAlteracao", query = "SELECT l FROM LogEndereco l WHERE l.alteracao = :alteracao")
    , @NamedQuery(name = "LogEndereco.findByAntigo", query = "SELECT l FROM LogEndereco l WHERE l.antigo = :antigo")})
public class LogEndereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "autor")
    private String autor;
    @Column(name = "alteracao")
    private String alteracao;
    @Column(name = "antigo")
    private String antigo;

    public LogEndereco() {
    }

    public LogEndereco(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(String alteracao) {
        this.alteracao = alteracao;
    }

    public String getAntigo() {
        return antigo;
    }

    public void setAntigo(String antigo) {
        this.antigo = antigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogEndereco)) {
            return false;
        }
        LogEndereco other = (LogEndereco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistema_hospitalar.model.entidade.logs.LogEndereco[ id=" + id + " ]";
    }
    
}
