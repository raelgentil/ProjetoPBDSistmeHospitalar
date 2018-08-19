/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.Funcionario;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class FuncionarioDAO {
    
    
    public Funcionario buscarUsuarioPrimeiroAcesso(EntityManagerFactory factory, String senha, String SenhaC){
        EntityManager em = null;
        Funcionario funcionario = null;
        try {
            
            em = factory.createEntityManager();
            /**
             * Em tela vai funcionar como se o atendente pesquisasse o paciente e selecionasse o medico
             * q o paciente vai e depois verificava se esse paciente ja possui ou não vinculo com aquele medico
             */
            TypedQuery<Funcionario> q = em.createQuery("select f from Funcionario f where f.cpf = :senha and f.senha = :senhaC", Funcionario.class);
            q.setParameter("senha", senha);
            q.setParameter("senhaC", SenhaC);
            funcionario = q.getSingleResult();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.FuncionarioDAO.buscarUsuario()");
            System.out.println("erro FuncionarioDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return funcionario;
    }
    
    public Funcionario buscarUsuario(EntityManagerFactory factory, String login){
        EntityManager em = null;
        Funcionario funcionario = null;
        try {
            
            em = factory.createEntityManager();
            /**
             * Em tela vai funcionar como se o atendente pesquisasse o paciente e selecionasse o medico
             * q o paciente vai e depois verificava se esse paciente ja possui ou não vinculo com aquele medico
             */
            TypedQuery<Funcionario> q = em.createQuery("select f from Funcionario f where f.login = :login", Funcionario.class);
            q.setParameter("login", login);
            funcionario = q.getSingleResult();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.FuncionarioDAO.buscarUsuario()");
            System.out.println("erro FuncionarioDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return funcionario;
    }

    
    public List<Funcionario> buscarPorAtivos(EntityManagerFactory factory, boolean ativo) {
        EntityManager em = null;
        List<Funcionario> funcionarios = null;
        try {
            
            em = factory.createEntityManager();

            TypedQuery<Funcionario> q = em.createQuery("select f from Funcionario f where f.ativo is :ativo", Funcionario.class);

            q.setParameter("ativo",ativo);

            funcionarios = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.FuncionarioDAO.buscarPorAtivos()");
            System.out.println("erro FuncionarioeDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return funcionarios;
    }

    
}
