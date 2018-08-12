package br.com.sistema_hospitalar.model.dao;



import br.com.sistema_hospitalar.model.dao.interfaces.IEstadoDAO;
import br.com.sistema_hospitalar.model.entidade.Estado;
import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;
public class EstadoDAO {

    public EstadoDAO() {
    }
       

    public Estado buscarPorUf(EntityManagerFactory factory, String uf) {
        EntityManager em = null;
        Estado estadoVo = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Estado> q = em.createQuery("select e from Estado e where e.uf = :uf", Estado.class);

            q.setParameter("uf", uf);

            estadoVo = q.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("br.com.sistema_hospitalar.model.dao.EstadoDAO.encontrarPorUf()");
            System.out.println("erro EstadoDAO: " + e.getMessage());
//            e.printStackTrace();

        } finally {
            em.close();
        }
        return estadoVo;
    }

    public List<Estado> buscarPorDescricao(EntityManagerFactory factory, String descricao) {
        EntityManager em = null;
        List<Estado> estadoVos = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Estado> q = em.createQuery("select e from Estado e where e.descricao like :descricao", Estado.class);

            q.setParameter("descricao", "%" + descricao + "%");

            estadoVos = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.EstadoDAO.buscarPorNome()");
            System.out.println("erro estadoDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return estadoVos;
    }


}
