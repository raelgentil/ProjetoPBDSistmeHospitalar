/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.AdministradorDAO;
import br.com.sistema_hospitalar.model.dao.AtendenteDAO;
import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.ProficionalSaudeDAO;
import br.com.sistema_hospitalar.model.entidade.Administrador;
import br.com.sistema_hospitalar.model.entidade.Atendente;
import br.com.sistema_hospitalar.model.entidade.Especializacao;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rafaelgentil
 */
public class AdministradorBEANS {
    DAO<Administrador> dao;
    AdministradorDAO daoA;
    FuncionarioBEANS beansF;
    public AdministradorBEANS(FuncionarioBEANS funcionarioBEANS) {
        this.dao = new DAO<>();
        daoA = new AdministradorDAO();
        this.beansF = funcionarioBEANS;
    }
    
     public boolean salvarOuAtualizar(EntityManagerFactory factory, Administrador administrador) {
         
        if (administrador.getId() == null) {
                String login = beansF.criarLogin(factory, administrador);
                
            if (login !=null && !daoA.buscarSuperUsuario(factory)) {
                return dao.salvarOuAtualizar(factory, new Administrador(administrador.isSuperUsuario(), administrador.getId(), administrador.getNome(), administrador.getCpf(),
                        administrador.getEmail(), administrador.getTelefones(), administrador.getSexo(), administrador.getDataDeNascimento(),
                        administrador.getEndereco(), login, administrador.getSenha(), administrador.getSalario(), administrador.getCargaHorariaMinimaMensal(),
                        administrador.getHoraextra(), administrador.isAtivo()));
            } else {
                return false;
            }
        } else {
            return dao.salvarOuAtualizar(factory, administrador);
        }
        
    }

    public boolean remover(EntityManagerFactory factory, Administrador administrador) {
        return dao.remover(factory, Administrador.class, administrador);
    }

    public Administrador getPorId(EntityManagerFactory factory, Administrador administrador) {
        return dao.getPorId(factory, Administrador.class, administrador.getId());
    }

    public List<Administrador> buscarPorNome(EntityManagerFactory factory, String nome) {
        return daoA.buscarPorNome(factory, nome);
    }

    public Administrador buscarPorCpf(EntityManagerFactory factory, String cpf) {
        return daoA.buscarPorCpf(factory, cpf);
    }
    
    
}
