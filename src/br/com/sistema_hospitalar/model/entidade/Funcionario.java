/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.sistema_hospitalar.model.entidade;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author rafaelgentil
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "funcionario")
public abstract class Funcionario extends Pessoa implements Serializable {
    
    @Column(name = "login", unique = true, length = 50)
    private String login;
    
    @Column(name = "senha", length = 11)
    private String senha;
    
    @Column(name = "salario")
    private double salario;
    
    @Column(name = "carga_horaria_minima_mensal")
    private double cargaHorariaMinimaMensal;
    
    @Column(name = "hora_extra")
    private double horaextra;
    
    @Column(name = "ativo")
    private boolean ativo;
    
    private Funcionario() {
        super(null, null, null, null, null, null, null);
    }

    public Funcionario(String nome, String cpf, String email, String telefones, String sexo, Calendar dataDeNascimento, Endereco endereco, String login, double salario, double cargaHorariaMinimaMensal, double horaextra) {
        super(nome, cpf, email, telefones, sexo, dataDeNascimento, endereco);
        this.login = login;
        this.senha = cpf;
        this.salario = salario;
        this.cargaHorariaMinimaMensal = cargaHorariaMinimaMensal;
        this.horaextra = horaextra;
        this.ativo = true;
    }

    public Funcionario(Long id, String nome, String cpf, String email, String tefones, String sexo, Calendar dataDeNascimento, Endereco endereco, String login, String senha, double salario, double cargaHorariaMinimaMensal, double horaextra, boolean ativo) {
        super(id, nome, cpf, email, tefones, sexo, dataDeNascimento, endereco);
        this.login = login;
        this.senha = senha;
        this.salario = salario;
        this.cargaHorariaMinimaMensal = cargaHorariaMinimaMensal;
        this.horaextra = horaextra;
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public double getHoraextra() {
        return horaextra;
    }

    public double getCargaHorariaMinimaMensal() {
        return cargaHorariaMinimaMensal;
    }

    public double getSalario() {
        return salario;
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }
    
    
}
