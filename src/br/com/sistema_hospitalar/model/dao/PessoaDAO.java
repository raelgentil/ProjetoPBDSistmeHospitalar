/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;

/**
 *
 * @author rafaelgentil
 */
public class PessoaDAO{
     public List<Pessoa> buscarPorNome(EntityManagerFactory factory, String nome) {
         EntityManager em = null;
        List<Pessoa> pessoas = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Pessoa> q = em.createQuery("select p from Pessoa p where p.nome like :nome", Pessoa.class);

            q.setParameter("nome", "%" + nome + "%");

            pessoas = q.getResultList();

        } catch (Exception e) {
            System.out.println("erro PessoaDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.PessoaDAO.buscarPorNome()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return pessoas;
    }
    
   
    
    public Pessoa buscarPorCpf(EntityManagerFactory factory, String cpf) {
         EntityManager em = null;
        Pessoa pessoa = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Pessoa> q = em.createQuery("select p from Pessoa p where p.cpf = :cpf", Pessoa.class);

            q.setParameter("cpf",cpf);

            pessoa = q.getSingleResult();

        } catch (Exception e) {
            System.out.println("erro PessoaDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.PessoaDAO.buscarPorCpf()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return pessoa;
    }
   
    
}
