package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.dao.interfaces.IEnderecoDAO;
import br.com.sistema_hospitalar.model.entidade.Endereco;
import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;

public class EnderecoDAO {

    public EnderecoDAO() {
    }

    public List<Endereco> buscarPorBairro(EntityManagerFactory factory, String bairro) {
        EntityManager em = null;
        List<Endereco> enderecoVos = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Endereco> q = em.createQuery("select e from Endereco e where e.bairro like :bairro", Endereco.class);

            q.setParameter("bairro", "%" + bairro + "%");

            enderecoVos = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.EnderecoDAO.listarPorBairro()");
            System.out.println("erro EnderecoDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return enderecoVos;
    }

    public List<Endereco> buscarPordescricao(EntityManagerFactory factory, String descricao) {
        EntityManager em = null;
        List<Endereco> enderecoVos = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Endereco> q = em.createQuery("select e from Endereco e where e.descricao like :descricao", Endereco.class);

            q.setParameter("descricao", "%" + descricao + "%");

            enderecoVos = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.EnderecoDAO.listarPordescricao()");
            System.out.println("erro EnderecoDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return enderecoVos;
    }

    public Endereco getMunicipio( EntityManagerFactory factory, Endereco enderecoVo) {
        EntityManager em = null;

        try {
            em = factory.createEntityManager();
            em.getTransaction().begin();
            enderecoVo = em.find(Endereco.class, enderecoVo.getId());
            Hibernate.initialize(enderecoVo.getMunicipio());
        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.EnderecoDAO.getMunicipio()");
            System.out.println("erro municipioDAO: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }

        return enderecoVo;
    }

}
