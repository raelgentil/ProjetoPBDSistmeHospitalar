/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.CategoriaCID;
import br.com.sistema_hospitalar.model.entidade.Endereco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class CategoriCIDDAO {

    public CategoriCIDDAO() {
    }
    
    public List<CategoriaCID> bucarPorCodigo(EntityManagerFactory factory, String codigo) {
        EntityManager em = null;
        List<CategoriaCID> categoriaCIDs = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<CategoriaCID> q = em.createQuery("select c from CategoriaCID c where c.codigo like :codigo", CategoriaCID.class);

            q.setParameter("codigo", "%" + codigo + "%");

            categoriaCIDs = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.EnderecoDAO.listarPordescricao()");
            System.out.println("erro CategoriaCIDDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return categoriaCIDs;
    }
    
    public List<CategoriaCID> bucarPorDescricao(EntityManagerFactory factory, String descricao) {
        EntityManager em = null;
        List<CategoriaCID> categoriaCIDs = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<CategoriaCID> q = em.createQuery("select c from CategoriaCID c where c.descricao like :descricao", CategoriaCID.class);

            q.setParameter("descricao", "%" + descricao + "%");

            categoriaCIDs = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.EnderecoDAO.listarPordescricao()");
            System.out.println("erro CategoriaCIDDAO: " + e.getMessage());
            e.printStackTrace();

        } finally {
            em.close();
        }
        return categoriaCIDs;
    }
    
    
}
