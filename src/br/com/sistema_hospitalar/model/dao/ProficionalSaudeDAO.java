/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;

/**
 *
 * @author rafaelgentil
 */
public class ProficionalSaudeDAO {
    
     public ProfissionalSaude buscarPorCpf(EntityManagerFactory factory, String cpf) {
         EntityManager em = null;
        ProfissionalSaude profissionalSaude = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<ProfissionalSaude> q = em.createQuery("select p from ProfissionalSaude p where p.cpf = :cpf", ProfissionalSaude.class);

            q.setParameter("cpf",cpf);

            profissionalSaude = q.getSingleResult();

        } catch (Exception e) {
            System.out.println("erro ProfissionalSaudeDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.ProficionalSaudeDAO.buscarPorCpf()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return profissionalSaude;
    }

    public List<ProfissionalSaude> buscarPorNome(EntityManagerFactory factory, String nome) {
         EntityManager em = null;
        List<ProfissionalSaude> profissionalSaudes = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<ProfissionalSaude> q = em.createQuery("select p from ProfissionalSaude p where p.nome like :nome", ProfissionalSaude.class);

            q.setParameter("nome", "%" + nome + "%");

            profissionalSaudes = q.getResultList();

        } catch (Exception e) {
            System.out.println("erro PessoaDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.ProfissionalSaudeDAO.buscarPorNome()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return profissionalSaudes;
    }
    
    public ProfissionalSaude buscarPorApelido(EntityManagerFactory factory, String apelido) {
         EntityManager em = null;
        ProfissionalSaude profissionalSaude = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<ProfissionalSaude> q = em.createQuery("select p from ProfissionalSaude p where p.apelido like :apelido", ProfissionalSaude.class);

            q.setParameter("apelido",apelido);

            profissionalSaude = q.getSingleResult();

        } catch (Exception e) {
            System.out.println("erro PessoaDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.ProfissionalSaudeDAO.buscarPorNome()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return profissionalSaude;
    }
    
    public List<ProfissionalSaude> buscarPorEspecializacao(EntityManagerFactory factory, String especializacao) {
         EntityManager em = null;
        List<ProfissionalSaude> profissionalSaudes = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<ProfissionalSaude> q = em.createQuery("select p from ProfissionalSaude p where p.especializacoes like :especializacoes", ProfissionalSaude.class);

            q.setParameter("especializacoes", "%" + especializacao + "%");

            profissionalSaudes = q.getResultList();

        } catch (Exception e) {
            System.out.println("erro PessoaDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.ProfissionalSaudeDAO.buscarPorNome()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return profissionalSaudes;
    }
    

}
