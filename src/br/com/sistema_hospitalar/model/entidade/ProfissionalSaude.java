/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade;

import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author João Emerson
 */
@Entity
@Table(name = "profissional_saude")
public class ProfissionalSaude extends Funcionario implements Serializable {
    
    @Column(name = "apelido", unique = true, length = 10)
    private String apelido;
    
    /**
     * utilizar um separador com um conselho e o codigo de cada especialização
     */
    @Column(name = "especializacao", length = 50)
    private String especializacoes;
    
    @Transient
    private List<Especializacao> especializacoess;
    
    private String pacientesMarcados;

    @Transient
    private List<Consulta> consultas;

    private ProfissionalSaude() {
        super(null, null, null, null, null, null, null, null, 0, 0, 0);
    }

    public ProfissionalSaude(String nome, String cpf, String email, String telefones, String sexo, Calendar dataDeNascimento, Endereco endereco, String login, double salario, double cargaHorariaMinimaMensal, double horaextra, String apelido, List<Especializacao> especializacoes) {
        super(nome, cpf, email, telefones, sexo, dataDeNascimento, endereco, login, salario, cargaHorariaMinimaMensal, horaextra);
        this.apelido = apelido;
        this.especializacoess = especializacoes;
    }

    public ProfissionalSaude(Long id, String nome, String cpf, String email, String tefones, String sexo, Calendar dataDeNascimento, Endereco endereco, String login, String senha, double salario, double cargaHorariaMinimaMensal, double horaextra, boolean ativo, String apelido, String especializacoes, String pacientesMarcados) {
        super(id, nome, cpf, email, tefones, sexo, dataDeNascimento, endereco, login, senha, salario, cargaHorariaMinimaMensal, horaextra, ativo);
        this.apelido = apelido;
        this.especializacoes = especializacoes;
        this.pacientesMarcados = pacientesMarcados;
    }

    public ProfissionalSaude(Long id, String nome, String cpf, String email, String tefones, String sexo, Calendar dataDeNascimento, Endereco endereco, String login, String senha, double salario, double cargaHorariaMinimaMensal, double horaextra, boolean ativo, String apelido, List<Especializacao> especializacoess, String pacientesMarcados) {
        super(id, nome, cpf, email, tefones, sexo, dataDeNascimento, endereco, login, senha, salario, cargaHorariaMinimaMensal, horaextra, ativo);
        this.apelido = apelido;
        this.especializacoess = especializacoess;
        this.pacientesMarcados = pacientesMarcados;
    }
    
    @Override
    public String toString() {
        return "ProfissionalSaude{" + "id=" + getId()+ "apelido=" + apelido + ", especializacoes=" + especializacoes + ", especializacoess=" + especializacoess + ", pacientesMarcados=" + pacientesMarcados + ", consultas=" + consultas + '}';
    }

    public String getApelido() {
        return apelido;
    }

    public String getEspecializacoes() {
        return especializacoes;
    }

    public List<Especializacao> getEspecializacoess() {
        return especializacoess;
    }

    public String getPacientesMarcados() {
        return pacientesMarcados;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    
    
    
    
    
    

    

    
   

    
}
