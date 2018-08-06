/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.Insumo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class InsumoDAO {
    
    public List<Insumo> buscarDescricao(EntityManagerFactory factory, String descricao){
        EntityManager em = null;
        List<Insumo> insumos = null;
        try {
            
            em = factory.createEntityManager();
            TypedQuery<Insumo> q = em.createQuery("select i from Insumo i where i.descricao like :descricao", Insumo.class);
            q.setParameter("descricao","%" + descricao + "%" );
            insumos = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.InsumoDAO.buscarDescricao()");
            System.out.println("erro InsumoDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return insumos;
    }
    
}
