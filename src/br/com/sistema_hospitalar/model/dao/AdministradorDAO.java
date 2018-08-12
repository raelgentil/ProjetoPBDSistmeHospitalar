/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.Administrador;
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
public class AdministradorDAO {
    
     public Administrador buscarPorCpf(EntityManagerFactory factory, String cpf) {
         EntityManager em = null;
        Administrador administrador = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Administrador> q = em.createQuery("select a from Administrador a where a.cpf = :cpf", Administrador.class);

            q.setParameter("cpf",cpf);

            administrador = q.getSingleResult();

        } catch (Exception e) {
            System.out.println("erro AdministradorDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.AtendenteDAO.buscarPorCpf()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return administrador;
    }

    public List<Administrador> buscarPorNome(EntityManagerFactory factory, String nome) {
         EntityManager em = null;
        List<Administrador> administradors = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Administrador> q = em.createQuery("select a from Administrador a where a.nome like :nome", Administrador.class);

            q.setParameter("nome", "%" + nome + "%");

            administradors = q.getResultList();

        } catch (Exception e) {
            System.out.println("erro AdministradorDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.AdministradorDAO.buscarPorNome()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return administradors;
    }
    
    public boolean buscarSuperUsuario(EntityManagerFactory factory) {
         EntityManager em = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Administrador> q = em.createQuery("select a from Administrador a where a.superUsuario = :superUsuario", Administrador.class);

            q.setParameter("superUsuario",true);

            q.getSingleResult();
            return true;
        } catch (Exception e) {
            System.out.println("erro AdministradorDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.AdministradorDAO.buscarSuperUsuario()");
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
    
    

}
