/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author rafaelgentil
 */

@Entity
public class Reserva implements Serializable, IEntidadeBase{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Lote lote;
    
    private boolean liberado = true;
    
    /**
     * Esse atributo será usado pra saber quando cliente levou ou não o insumo e tb na hora de saber se adm liberou ou não o insumo pra
     */
    @Transient
    private boolean pegou;
    
    @Column(name = "id_prontuario")
    private Long idProntuario;
    
    @Column(name = "id_paciente")
    private Long idPacientes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public boolean isLiberado() {
        return liberado;
    }

    public void setLiberado(boolean liberado) {
        this.liberado = liberado;
    }

    public Long getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(Long idProntuario) {
        this.idProntuario = idProntuario;
    }

    public Long getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(Long idPacientes) {
        this.idPacientes = idPacientes;
    }

   

     

    
    
}
