/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafaelgentil
 */
@Entity
@Table(name = "reset_senha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResetSenha.findAll", query = "SELECT r FROM ResetSenha r")
    , @NamedQuery(name = "ResetSenha.findByNome", query = "SELECT r FROM ResetSenha r WHERE r.nome = :nome")
    , @NamedQuery(name = "ResetSenha.findById", query = "SELECT r FROM ResetSenha r WHERE r.id = :id")})
public class FuncionarioResetSenha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nome")
    private String nome;
    @Column(name = "id")
    @Id
    private Long id;

    public FuncionarioResetSenha() {
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    

   
    
}
