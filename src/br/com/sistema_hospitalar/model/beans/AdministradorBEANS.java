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
            String senha = beansF.criptografar(factory, administrador.getCpf());
            String login = beansF.criarLogin(factory, administrador);
            System.out.println(login);
            administrador.setSenha(senha);
            administrador.setLogin(login);
            
            if(administrador.isSuperUsuario())
                return dao.salvarOuAtualizar(factory, administrador);

            if (login != null) {
                administrador.setLogin(login);
                return dao.salvarOuAtualizar(factory, administrador);
            } else {
                System.err.println("Erro Administrador ja existe");
            }
        } else {
            if (!(administrador.getSenha().equals(dao.getPorId(factory, Administrador.class, administrador.getId()).getSenha()))) {
                administrador.setSenha(beansF.criptografar(factory,administrador.getSenha()));
            }
            return dao.salvarOuAtualizar(factory, administrador);
        }
        return false;
    }

    public boolean remover(EntityManagerFactory factory, Administrador administrador) {
        return dao.remover(factory, Administrador.class, administrador);
    }

    public Administrador getPorId(EntityManagerFactory factory,  Long id) {
        return dao.getPorId(factory, Administrador.class, id);
    }

    public List<Administrador> buscarPorNome(EntityManagerFactory factory, String nome) {
        return daoA.buscarPorNome(factory, nome);
    }
    
    public Administrador buscarPorCpf(EntityManagerFactory factory, String cpf) {
        return daoA.buscarPorCpf(factory, cpf);
    }
    public boolean verificarSU(EntityManagerFactory factory){
        return daoA.buscarSuperUsuario(factory);
    }
    
    
}
