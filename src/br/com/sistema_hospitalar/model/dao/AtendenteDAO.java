/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.Atendente;
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
public class AtendenteDAO {
    
     public Atendente buscarPorCpf(EntityManagerFactory factory, String cpf) {
         EntityManager em = null;
        Atendente atendente = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Atendente> q = em.createQuery("select a from Atendente a where a.cpf = :cpf", Atendente.class);

            q.setParameter("cpf",cpf);

            atendente = q.getSingleResult();

        } catch (Exception e) {
            System.out.println("erro AtendenteDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.AtendenteDAO.buscarPorCpf()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return atendente;
    }

    public List<Atendente> buscarPorNome(EntityManagerFactory factory, String nome) {
         EntityManager em = null;
        List<Atendente> atendentes = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Atendente> q = em.createQuery("select a from Atendente a where a.nome like :nome", Atendente.class);

            q.setParameter("nome", "%" + nome + "%");

            atendentes = q.getResultList();

        } catch (Exception e) {
            System.out.println("erro AtendenteDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.AtendenteDAO.buscarPorNome()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return atendentes;
    }
    
    

}
