/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.InsumoDAO;
import br.com.sistema_hospitalar.model.dao.LoteDAO;
import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Lote;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class LoteBEANS {
    private DAO<Lote> dao;
    private LoteDAO daoL;
    private InsumoBEANS insumoBEANS;

    public LoteBEANS(InsumoBEANS insumoBEANS) {
        dao = new DAO<>();
        daoL = new LoteDAO();
        this.insumoBEANS = insumoBEANS;
        
    }
    
    public boolean salvarOuAtualizar(EntityManagerFactory factory, Lote lote) {
        boolean salvou = false;
        int quantidadeAntigadeInsumo = 0;
        if (lote.getId() ==null) {
                salvou = dao.salvarOuAtualizar(factory, lote);
        }else{
           quantidadeAntigadeInsumo =  buscarPorId(factory, lote.getId()).getQuantidadeInsumo();
            salvou = dao.salvarOuAtualizar(factory, lote);
        }
        if (salvou) {
            atualizarInsumo(factory, lote, quantidadeAntigadeInsumo);
        }
        return salvou;
    }

    public boolean remover(EntityManagerFactory factory, Lote lote) {
        if (dao.remover(factory, Lote.class, lote)) {
            atualizarInsumo(factory, lote, lote.getQuantidadeInsumo()*2);
            return true;
        }else{
            return false;
        }
      
        
    }

    public Lote buscarPorId(EntityManagerFactory factory,  Long id) {
        
       return dao.getPorId(factory, Lote.class, id);
    }
    public Lote buscarPorCodigo(EntityManagerFactory factory, Long codigo){
       return daoL.buscarPorCodigo(factory, codigo);
    }
    
    public List<Lote> buscarPorInsumo(EntityManagerFactory factory, Insumo insumo){
       return daoL.buscarPorInsumo(factory, insumo);
    }
    
    private void atualizarInsumo(EntityManagerFactory factory, Lote  lote, int quantidadeAntigadeInsumo){
        
        Insumo insumo = insumoBEANS.getPorId(factory, lote.getInsumo().getId());
            insumo.setQuantidadeTotal(((insumo.getQuantidadeTotal() + lote.getQuantidadeInsumo()) - quantidadeAntigadeInsumo));
            insumoBEANS.salvarOuAtualizar(factory, insumo);
    }
    
            
    
}
