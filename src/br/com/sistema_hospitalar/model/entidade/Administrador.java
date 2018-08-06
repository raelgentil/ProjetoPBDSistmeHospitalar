/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author João Emerson
 */
@Entity
@Table(name = "administrador")
public class Administrador extends Funcionario implements Serializable, IEntidadeBase {
    
    private boolean superUsuario;

    private Administrador() {
        super(null, null, null, null, null, null, null, null, 0, 0, 0);
    }

    public boolean isSuperUsuario() {
        return superUsuario;
    }

    


    
}
