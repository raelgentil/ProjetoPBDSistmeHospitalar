/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.MunicipioDAO;
import br.com.sistema_hospitalar.model.entidade.Estado;
import br.com.sistema_hospitalar.model.entidade.Municipio;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rafaelgentil
 */
public class MunicipioBEANS {

    MunicipioDAO daoM;
    DAO<Municipio> dao;

    public MunicipioBEANS() {
        daoM = new MunicipioDAO();
        dao = new DAO<>();
    }

    public boolean salvarOuAtualizar(EntityManagerFactory factory, Municipio municipio) {
        if (municipio.getId() == null) {
            if (buscarPorDescricao(factory, municipio.getDescricao()).isEmpty()) {
                return dao.salvarOuAtualizar(factory, municipio);
            }
        } else {
            return dao.salvarOuAtualizar(factory, municipio);
        }
        return false;
    }

    public boolean remover(EntityManagerFactory factory, Municipio municipio) {
        return dao.remover(factory, Municipio.class, municipio);

    }

    public Municipio getPorId(EntityManagerFactory factory, Long id) {

        return dao.getPorId(factory, Municipio.class, id);
    }

    public List<Municipio> buscarPorDescricao(EntityManagerFactory factory, String descricao) {
        return daoM.buscarPorDescricao(factory, descricao);
    }

//    @Override
//    public MunicipioVo getEstado(MunicipioVo mv, EntityManagerFactory factory) {
//        return daoM.getEstado(mv, factory);
//    }
}
