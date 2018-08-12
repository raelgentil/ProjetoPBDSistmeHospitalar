/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author João Emerson
 */
@Entity
@Table(name = "administrador")
public class Administrador extends Funcionario implements Serializable, IEntidadeBase {
    
    private boolean superUsuario;

    public Administrador() {
    }

    public boolean isSuperUsuario() {
        return superUsuario;
    }

    public void setSuperUsuario(boolean superUsuario) {
        this.superUsuario = superUsuario;
    }

   
    

    


    
}
