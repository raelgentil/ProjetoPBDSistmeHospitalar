package br.com.sistema_hospitalar.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.sistema_hospitalar.model.entidade.IEntidadeBase;

public class DAO<Entidade extends IEntidadeBase> {

    

    public boolean salvarOuAtualizar(EntityManagerFactory factory, Entidade entidade) {
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            if (entidade.getId() == null) {
                em.persist(entidade);
            } else {

                em.merge(entidade);
            }
            em.getTransaction().commit();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro no método");
            System.out.println("br.com.sistema_hospitalar.model.dao.DAO.salvarOuAtualizar()");
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }

    }
    

    public boolean remover(EntityManagerFactory factory, Class<Entidade> classeTipo,Entidade entidade) {
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            Object o = em.find(classeTipo, entidade.getId());

            em.remove(o);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Erro no método");
            System.out.println("br.com.sistema_hospitalar.model.dao.Dao.remover()");
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    public Entidade getPorId(EntityManagerFactory factory, Class<Entidade> classeTipo, Long id ) {
       EntityManager em = null;
       Entidade entidade = null;
        try {
            em = factory.createEntityManager();
            entidade = em.find(classeTipo, id);
        } catch (Exception e) {
            System.out.println("Erro no método");
            System.out.println("br.com.sistema_hospitalar.model.dao.DAO.getPorId()");
            e.printStackTrace();
        } finally {
            em.close();
            
        }
        return entidade;
    }

}
