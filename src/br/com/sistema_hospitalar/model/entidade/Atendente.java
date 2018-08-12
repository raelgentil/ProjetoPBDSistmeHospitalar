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
@Table(name = "atendente")
public class Atendente extends Funcionario implements Serializable,IEntidadeBase {

    private Atendente() {
        super(null, null, null, null, null, null, null, null, 0, 0, 0);
    }

    public Atendente(String nome, String cpf, String email, String telefones, String sexo, Calendar dataDeNascimento, Endereco endereco, String login, double salario, double cargaHorariaMinimaMensal, double horaextra) {
        super(nome, cpf, email, telefones, sexo, dataDeNascimento, endereco, login, salario, cargaHorariaMinimaMensal, horaextra);
    }

    public Atendente(Long id, String nome, String cpf, String email, String tefones, String sexo, Calendar dataDeNascimento, Endereco endereco, String login, String senha, double salario, double cargaHorariaMinimaMensal, double horaextra, boolean ativo) {
        super(id, nome, cpf, email, tefones, sexo, dataDeNascimento, endereco, login, senha, salario, cargaHorariaMinimaMensal, horaextra, ativo);
    }
    

    
    

    
}
