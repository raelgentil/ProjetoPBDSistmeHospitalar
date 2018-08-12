/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.EspecializacaoDAO;
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
public class EspecializacaoBEANS {
    EspecializacaoDAO daoE;
    DAO<Especializacao> dao;

    public EspecializacaoBEANS() {
        daoE = new EspecializacaoDAO();
        dao = new DAO<>();
    }
    
    public boolean salvarOuAtualizar(EntityManagerFactory factory, Especializacao especializacao) {
         
        if (especializacao.getId() == null) {
                
//            if (daoE.buscarPorConselho(factory, especializacao.getConselho()) == null) {
                dao.salvarOuAtualizar(factory, especializacao);
            
//            } else {
//                System.err.println("Erro Especializacao ja existe");
//            }
        } else {
            return dao.salvarOuAtualizar(factory, especializacao);
        }
        return false;
    }

    public boolean remover(EntityManagerFactory factory, Especializacao especializacao) {
        return dao.remover(factory, Especializacao.class, especializacao);
    }

    public Especializacao getPorId(EntityManagerFactory factory, Especializacao especializacao) {

        return dao.getPorId(factory, Especializacao.class, especializacao.getId());
    }
    
    public List<Especializacao> buscarPorNome(EntityManagerFactory factory, String nome) {
         return daoE.buscarPorNome(factory, nome);
    }
    
    public List<Especializacao> buscarPorConselho(EntityManagerFactory factory, String conselho) {
         return  daoE.buscarPorConselho(factory, conselho);
    }
    
    
    
}
