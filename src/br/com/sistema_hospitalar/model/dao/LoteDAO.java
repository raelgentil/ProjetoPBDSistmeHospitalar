/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Lote;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class LoteDAO {
    
    public Lote buscarPorCodigo(EntityManagerFactory factory, Long codigo){
        EntityManager em = null;
       Lote lote = null;
        try {
            
            em = factory.createEntityManager();
            TypedQuery<Lote> q = em.createQuery("select l from Lote l where l.codigo = :codigo", Lote.class);
            q.setParameter("codigo",codigo);
            lote = q.getSingleResult();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.InsumoDAO.buscarDescricao()");
            System.out.println("erro InsumoDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return lote;
    }
    
    public Lote buscarPorInsumo(EntityManagerFactory factory, Insumo insumo){
        EntityManager em = null;
       Lote lote = null;
        try {
            
            em = factory.createEntityManager();
            TypedQuery<Lote> q = em.createQuery("select l from Lote l where l.insumo.id = :insumo_id", Lote.class);
            q.setParameter("insumo_id",insumo.getId());
            lote = q.getSingleResult();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.LoteDAO.buscarInsumo()");
            System.out.println("erro InsumoDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return lote;
    }
    
}
