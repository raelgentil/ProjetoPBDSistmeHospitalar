/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.InsumoDAO;
import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class InsumoBEANS {
    DAO<Insumo> dao;
    InsumoDAO daoI;

    public InsumoBEANS() {
        dao = new DAO<>();
        daoI = new InsumoDAO();
        
    }
    
    public boolean salvarOuAtualizar(EntityManagerFactory factory, Insumo insumo) {
        if (insumo.getId() ==null) {
                return dao.salvarOuAtualizar(factory, insumo);
        }else{
            return dao.salvarOuAtualizar(factory, insumo);
        }
    }

    public boolean remover(EntityManagerFactory factory, Insumo insumo) {
        return dao.remover(factory, Insumo.class, insumo);
    }

    public Insumo getPorId(EntityManagerFactory factory,  Insumo insumo) {
        
       return dao.getPorId(factory, Insumo.class, insumo.getId());
    }
    public List<Insumo> buscarDescricao(EntityManagerFactory factory, String descricao){
        return daoI.buscarDescricao(factory, descricao);
    }
    
            
    
}
