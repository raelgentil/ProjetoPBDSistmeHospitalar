/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.ProntuarioDAO;
import br.com.sistema_hospitalar.model.entidade.CategoriaCID;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class ProntuarioBEANS {

    DAO<Prontuario> dao;
    DAO<CategoriaCID> daoC;
    ProntuarioDAO daoP;

    public ProntuarioBEANS() {
        this.dao = new DAO<>();
        this.daoC = new DAO<>();
        this.daoP = new ProntuarioDAO();
    }

    public boolean salvarOuAtualizar(EntityManagerFactory factory, Prontuario prontuario) {
        prontuario.setCids(atualizarCIDs(prontuario.getCidss()));
        if (prontuario.getId() == null) {
            
            return dao.salvarOuAtualizar(factory, prontuario);
        } else {
            return dao.salvarOuAtualizar(factory, prontuario);
        }
    }

    public boolean remover(EntityManagerFactory factory, Prontuario prontuario) {
        return dao.remover(factory, Prontuario.class, prontuario);
    }

    public Prontuario getPorId(EntityManagerFactory factory, Long id) {
        Prontuario prontuario = dao.getPorId(factory, Prontuario.class, id);
        prontuario.setCidss(buscarCIDs(factory, prontuario.getCids()));
        return prontuario;
    }

    public String buscarCodMedicoPaciente(EntityManagerFactory factory, Long idPaciente, String codMedicoPaciente) {
        return daoP.buscarCodMedicoPaciente(factory, idPaciente, codMedicoPaciente);
    }

    public List<Prontuario> buscarPorCodMedicoPacient(EntityManagerFactory factory, Long idPaciente, String codMedicoPaciente) {
        List<Prontuario> prontuarios = daoP.buscarPorCodMedicoPacient(factory, idPaciente, codMedicoPaciente);
        for (Prontuario prontuario : prontuarios) {
            prontuario.setCidss(buscarCIDs(factory, prontuario.getCids()));
        }
        return prontuarios;
    }

    public int ultimoRegistroDeUmMedico(EntityManagerFactory factory, String codMedicoPaciente) {
        return daoP.ultimoRegistroDeUmMedico(factory, codMedicoPaciente);
    }

    private List<CategoriaCID> buscarCIDs(EntityManagerFactory factory, String cids) {
        String[] ids = cids.split(";");
        List<CategoriaCID> categorias = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            categorias.add(daoC.getPorId(factory, CategoriaCID.class, Long.parseLong(ids[i])));
        }
        return categorias;
    }
    
    private String atualizarCIDs(List<CategoriaCID> categorias){
        String cids= "";
        for (CategoriaCID cID : categorias) {
            cids += cID.getId() + ";";
        }
        return cids;
    }

}
