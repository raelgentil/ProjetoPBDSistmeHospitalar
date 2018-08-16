/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.Especializacao;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class EspecializacaoDAO {
    
    public List<Especializacao> buscarPorNome(EntityManagerFactory factory, String nome) {
         EntityManager em = null;
        List<Especializacao> especializacoes = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Especializacao> q = em.createQuery("select e from Especializacao e where e.nome like :nome", Especializacao.class);

            q.setParameter("nome", "%" + nome + "%");

            especializacoes = q.getResultList();

        } catch (Exception e) {
            System.out.println("erro EspecializacaoDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.EspecializacaoDAO.buscarPorNome()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return especializacoes;
    }
    
    public List<Especializacao> buscarPorConselho(EntityManagerFactory factory, String conselho) {
         EntityManager em = null;
        List<Especializacao> especializacoes = null;
        try {

            em = factory.createEntityManager();

            TypedQuery<Especializacao> q = em.createQuery("select e from Especializacao e where e.conselho like :conselho", Especializacao.class);

            q.setParameter("conselho", "%" + conselho + "%");

            especializacoes = q.getResultList();

        } catch (Exception e) {
            System.out.println("erro EspecializacaoDAO: " + e.getMessage());
            System.out.println("br.com.sistema_hospitalar.model.dao.EspecializacaoDAO.buscarPorConselho()");
            e.printStackTrace();

        } finally {
            em.close();
        }
        return especializacoes;
    }
    
}
