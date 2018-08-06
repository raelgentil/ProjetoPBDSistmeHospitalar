package br.com.sistema_hospitalar.model.dao;


import br.com.sistema_hospitalar.model.dao.interfaces.IMunicipioDAO;
import br.com.sistema_hospitalar.model.entidade.Municipio;
import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;

public class MunicipioDAO extends DAO<IEntidadeBase> implements IMunicipioDAO{


    public MunicipioDAO() {
    }

    public List<Municipio> listarPorNome(EntityManagerFactory factory, String descricao) {
        EntityManager em = null;
        List<Municipio> municipioVos = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Municipio> q = em.createQuery("select m from Municipio m where m.descricao like :descricao", Municipio.class);

            q.setParameter("descricao", "%" + descricao + "%");

            municipioVos = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.MunicipioDAO.listarPorNome()");
            System.out.println("erro MunicipioDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return municipioVos;
    }
    
//    public Municipio getEnderecos(Municipio mv, EntityManagerFactory factory) {
//        EntityManager em = null;
//       
//        try {
//            em = factory.createEntityManager();
//            em.getTransaction().begin();
//            mv = em.find(Municipio.class, mv.getId());
//            Hibernate.initialize(mv.getEnderecos());
//        } catch (Exception e) {
//            System.out.println("br.com.sistema_hospitalar.model.dao.MunicipioDAO.getEstado()");
//            System.out.println("erro MunicipioDAO: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            em.close();
//        }
//
//        return mv;
//    }
//    
    public Municipio getEstado(Municipio mv, EntityManagerFactory factory) {
        EntityManager em = null;
       
        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            mv = em.find(Municipio.class, mv.getId());
            Hibernate.initialize(mv.getEstado());
        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.MunicipioDAO.getEstado()");
            System.out.println("erro MunicipioDAO: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }

        return mv;
    }


}
