package br.com.sistema_hospitalar.model.dao;


import br.com.sistema_hospitalar.model.entidade.Municipio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;

public class MunicipioDAO{


    public MunicipioDAO() {
    }

    public List<Municipio> buscarPorDescricao(EntityManagerFactory factory, String descricao) {
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



}
