package br.com.sistema_hospitalar.res;

import br.com.sistema_hospitalar.model.dao.*;
import br.com.sistema_hospitalar.model.entidade.IEntidadeBase;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAO<T extends IEntidadeBase> {

    public void salvarOuAtualizar(EntityManagerFactory factory, T o) {
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            if (o.getId() == null) {
                em.persist(o);
            } else {

                em.merge(o);
            }
            em.getTransaction().commit();
            
//            return o;
        } catch (Exception e) {
            System.out.println("Erro no método");
            System.out.println("br.com.sistema_hospitalar.model.dao.GenericDao.salvar()");
            e.printStackTrace();
//            return null;
        } finally {
            em.close();
        }

    }

    public void remover(EntityManagerFactory factory, T o) {
        EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro no método");
            System.out.println("br.com.sistema_hospitalar.model.dao.Dao.remover()");
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void getPorId(EntityManagerFactory factory, Class<T> classeTipo, int id) {
       EntityManager em = null;
        try {
            em = factory.createEntityManager();
            em.find(classeTipo, id);
        } catch (Exception e) {
            System.out.println("Erro no método");
            System.out.println("br.com.sistema_hospitalar.model.dao.Dao.remover()");
            e.printStackTrace();
        } finally {
            em.close();
            
        }
    }

//    public void flush() {
//
//    }
//    public static DAO getInstance(){
//        if(!emf.isOpen() || emf == null)
//            emf = Persistence.createEntityManagerFactory("banco");
//        return this;
//    }
}
