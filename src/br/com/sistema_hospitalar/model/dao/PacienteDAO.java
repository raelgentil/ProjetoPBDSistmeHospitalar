/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
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
public class PacienteDAO {
    
     public Paciente buscarPorCpf(EntityManagerFactory factory, String cpf) {
         EntityManager em = null;
        Paciente paciente = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Paciente> q = em.createQuery("select p from Paciente p where p.cpf = :cpf", Paciente.class);

            q.setParameter("cpf",cpf);

            paciente = q.getSingleResult();

        } catch (Exception e) {
            System.out.println("erro PessoaDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.PessoaDAO.buscarPorCpf()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return paciente;
    }

    public List<Paciente> buscarPorNome(EntityManagerFactory factory, String nome) {
         EntityManager em = null;
        List<Paciente> pessoas = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Paciente> q = em.createQuery("select p from Paciente p where p.nome like :nome", Paciente.class);

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
    public List<Paciente> buscarPorDoido(EntityManagerFactory factory, String nome) {
         EntityManager em = null;
        List<Paciente> pessoas = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Paciente> q = em.createQuery("select p from Paciente p where p.nome like :nome", Paciente.class);

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

    public List<Paciente> buscarPorTipoSanguinio(EntityManagerFactory factory, String tipoSanguinio) {
        EntityManager em = null;
        List<Paciente> pacientes = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Paciente> q = em.createQuery("select p from Paciente p where p.tipoSanguinio like :tipoSanguinio", Paciente.class);

            q.setParameter("tipoSanguinio",tipoSanguinio);

            pacientes = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.PacienteDAO.buscarPorTipoSanguinio()");
            System.out.println("erro PacienteDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return pacientes;
    }
    public List<Paciente> buscarPorFatoRH(EntityManagerFactory factory, boolean fatorRh) {
        EntityManager em = null;
        List<Paciente> pacientes = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Paciente> q = em.createQuery("select p from Paciente p where p.fatorRh is :fatorRh", Paciente.class);

            q.setParameter("fatorRh",fatorRh);

            pacientes = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.PacienteDAO.buscarPorAlergias()");
            System.out.println("erro PacienteDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return pacientes;
    }
//
//    public List<Paciente> buscarPorFatoRH(EntityManagerFactory factory, String fatorRh) {
//        EntityManager em = null;
//        List<Paciente> pacientes = null;
//        try {
//
//            em = factory.createEntityManager();
//
//            TypedQuery<Paciente> q = em.createQuery("select p from Paciente p where p.fatorRh = :atorRh", Paciente.class);
//
//            q.setParameter("fatorRh",fatorRh);
//
//            pacientes = q.getResultList();
//
//        } catch (Exception e) {
//            System.out.println("br.com.sistema_hospitalar.model.dao.PacienteDAO.buscarPorFatoRH()");
//            System.out.println("erro PacienteDAO: " + e.getMessage());
//            e.printStackTrace();
//
//        } finally {
//            em.close();
//        }
//        return pacientes;
//    }

    public List<Paciente> buscarPorLimitacoes(EntityManagerFactory factory, String limitacao) {
        EntityManager em = null;
        List<Paciente> pacientes = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Paciente> q = em.createQuery("select p from Paciente p where p.limitacoes like :limitacoes", Paciente.class);

            q.setParameter("limitacoes", "%" + limitacao + "%");

            pacientes = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.PacienteDAO.buscarPorLimitacoes()");
            System.out.println("erro PacienteDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return pacientes;
    }

    public List<Paciente> buscarPorAlergias(EntityManagerFactory factory, String alergia) {
        EntityManager em = null;
        List<Paciente> pacientes = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Paciente> q = em.createQuery("select p from Paciente p where p.alergias like :alergias", Paciente.class);

            q.setParameter("alergias", "%" + alergia + "%");

            pacientes = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.PacienteDAO.buscarPorAlergias()");
            System.out.println("erro PacienteDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return pacientes;
    }

    public List<Paciente> buscarPorDataDeFalecimento(EntityManagerFactory factory, Calendar date) {
        EntityManager em = null;
        List<Paciente> pacientes = null;
        try {

            em = factory.createEntityManager();
            TypedQuery<Paciente> q = em.createQuery("select p from Paciente p where p.dataDeFalecimento = :data", Paciente.class);
            q.setParameter("data", date);
            pacientes = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.PacienteDAO.buscarPorDataDeFalecimento()");
            System.out.println("erro semestreDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return pacientes;
    }
    
    public List<Paciente> buscarPorDoadorDeOrgaos(EntityManagerFactory factory, boolean doador) {
        EntityManager em = null;
        List<Paciente> pacientes = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Paciente> q = em.createQuery("select p from Paciente p where p.doadorDeOrgaos is :doadorDeOrgaos", Paciente.class);

            q.setParameter("doadorDeOrgaos",doador);

            pacientes = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.PacienteDAO.buscarPorAlergias()");
            System.out.println("erro PacienteDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return pacientes;
    }
    
//    public String buscarPorCodigoMedicoPaciente(EntityManagerFactory factory, boolean doador) {
//        EntityManager em = null;
//        Paciente paciente;
//        try {
//
//            em = factory.createEntityManager();
//
//            TypedQuery<Paciente> q = em.createQuery("select p from Paciente p where p.doadorDeOrgaos is :doadorDeOrgaos", Paciente.class);
//
//            q.setParameter("doadorDeOrgaos",doador);
//
//            paciente = q.getSingleResult();
//
//        } catch (Exception e) {
//            System.out.println("br.com.sistema_hospitalar.model.dao.PacienteDAO.buscarPorAlergias()");
//            System.out.println("erro PacienteDAO: " + e.getMessage());
//            e.printStackTrace();
//
//        } finally {
//            em.close();
//        }
//        return paciente.get;
//    }
    
//    public Paciente getProntuarios(EntityManagerFactory factory, Paciente paciente) {
//        EntityManager em = null;
//       
//        try {
//            em = factory.createEntityManager();
//            em.getTransaction().begin();
//            paciente = em.find(Paciente.class, paciente.getId());
//            Hibernate.initialize(paciente.getProntuarios());
//        } catch (Exception e) {
//            System.out.println("br.com.sistema_hospitalar.model.dao.PacienteDAO.getProntuarios()");
//            System.out.println("erro PacienteDAO: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//
//        return paciente;
//    }

}
