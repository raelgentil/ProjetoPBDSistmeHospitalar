/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.CategoriCIDDAO;
import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.entidade.Atendente;
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
public class CategoriCIDBEANS {
    
    CategoriCIDDAO categoriCIDDAO;
    DAO<CategoriaCID> dao;
    public CategoriCIDBEANS() {
        categoriCIDDAO = new CategoriCIDDAO();
        dao = new DAO<>();
    }
    
    public List<CategoriaCID> bucarPorCodigo(EntityManagerFactory factory, String codigo) {
        return categoriCIDDAO.bucarPorCodigo(factory, codigo);
    }
    
    public List<CategoriaCID> bucarPorDescricao(EntityManagerFactory factory, String descricao) {
        return categoriCIDDAO.bucarPorDescricao(factory, descricao);
    }
    
    public CategoriaCID getPorId(EntityManagerFactory factory, Long id) {

        return dao.getPorId(factory, CategoriaCID.class, id);
    }
}
