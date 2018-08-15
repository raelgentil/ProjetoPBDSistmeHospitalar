/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.EstadoDAO;
import br.com.sistema_hospitalar.model.entidade.Estado;
import br.com.sistema_hospitalar.model.entidade.IEntidadeBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;

/**
 *
 * @author rafaelgentil
 */
public class EstadoBEANS {

    EstadoDAO daoE;
    DAO<Estado> dao;

    public EstadoBEANS() {
        daoE = new EstadoDAO();
        dao = new DAO<>();
    }

    public boolean salvarOuAtualizar(EntityManagerFactory factory, Estado estado) {

        if (estado.getId() == null) {

            return dao.salvarOuAtualizar(factory, estado);
        } else {
            return dao.salvarOuAtualizar(factory, estado);
        }
    }

    public boolean remover(EntityManagerFactory factory, Estado estado) {

        return dao.remover(factory, Estado.class, estado);

    }

    public Estado getPorId(EntityManagerFactory factory, Long id) {

        return dao.getPorId(factory, Estado.class, id);
    }

    public Estado buscarPorUf(EntityManagerFactory factory, String uf) {
        return daoE.buscarPorUf(factory, uf);

    }

    public List<Estado> buscarPorNome(EntityManagerFactory factory, String descricao) {
        return daoE.buscarPorDescricao(factory, descricao);
    }

    public List<String> getAllEstadosName(EntityManagerFactory factory) {
        return daoE.getgetAllEstadosName(factory);
    }

}
