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

    public Funcionario() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getCargaHorariaMinimaMensal() {
        return cargaHorariaMinimaMensal;
    }

    public void setCargaHorariaMinimaMensal(double cargaHorariaMinimaMensal) {
        this.cargaHorariaMinimaMensal = cargaHorariaMinimaMensal;
    }

    public double getHoraextra() {
        return horaextra;
    }

    public void setHoraextra(double horaextra) {
        this.horaextra = horaextra;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    
    
    
}
