/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.AtendenteDAO;
import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.ProficionalSaudeDAO;
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
public class AtendenteBEANS {
    DAO<Atendente> dao;
    AtendenteDAO daoA;
    FuncionarioBEANS beansF;
    public AtendenteBEANS(FuncionarioBEANS funcionarioBEANS) {
        this.dao = new DAO<>();
        daoA = new AtendenteDAO();
        this.beansF = funcionarioBEANS;
    }
    
     public boolean salvarOuAtualizar(EntityManagerFactory factory, Atendente atendente) {
         
        if (atendente.getId() == null) {
                String login = beansF.criarLogin(factory, atendente);
                
            if (login !=null) {
                atendente.setLogin(login);
                return dao.salvarOuAtualizar(factory, atendente);
            } else {
                System.err.println("Erro Atendente ja existe");
            }
        } else {
            return dao.salvarOuAtualizar(factory, atendente);
        }
        return false;
    }

    public boolean remover(EntityManagerFactory factory, Atendente atendente) {
        return dao.remover(factory, Atendente.class, atendente);
    }

    public Atendente getPorId(EntityManagerFactory factory, Long id) {

        return dao.getPorId(factory, Atendente.class, id);
    }

    public List<Atendente> buscarPorNome(EntityManagerFactory factory, String nome) {
        return daoA.buscarPorNome(factory, nome);
    }

    public Atendente buscarPorCpf(EntityManagerFactory factory, String cpf) {
        return daoA.buscarPorCpf(factory, cpf);
    }
    
    
}
